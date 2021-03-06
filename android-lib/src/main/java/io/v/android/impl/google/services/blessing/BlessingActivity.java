// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.android.impl.google.services.blessing;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.util.Log;

import com.google.common.io.ByteStreams;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.interfaces.ECPublicKey;

import io.v.android.v23.services.blessing.BlessingService;
import io.v.android.v23.V;
import io.v.v23.security.Caveat;
import io.v.v23.verror.VException;
import io.v.v23.vom.VomUtil;

/**
 * Mints a new Vanadium blessing given the email address and the public key.
 * <p>
 * The provided email address must be already present on the phone.
 */
public class BlessingActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    public static final String TAG = "BlessingActivity";
    private static final int REQUEST_CODE_USER_APPROVAL = 1000;
    private static final int REQUEST_CODE_PICK_ACCOUNT = 1001;

    private static final String OAUTH_PROFILE = "https://www.googleapis.com/auth/userinfo.email";
    private static final String OAUTH_SCOPE = "oauth2:" + OAUTH_PROFILE;

    private static final int BASE64_FLAGS = Base64.URL_SAFE | Base64.NO_WRAP;

    private String mGoogleAccount = "";
    private ECPublicKey mPublicKey = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        V.init(this);

        Intent intent = getIntent();
        if (intent == null) {
            replyWithError("Intent not found.");
            return;
        }
        // Get the public key of the application invoking this activity.
        mPublicKey = (ECPublicKey) intent.getSerializableExtra(BlessingService.EXTRA_PUBLIC_KEY);
        if (mPublicKey == null) {
            replyWithError("Empty blesee public key.");
            return;
        }
        // Get the google email address (if any).
        mGoogleAccount = intent.getStringExtra(BlessingService.EXTRA_GOOGLE_ACCOUNT);
        if (mGoogleAccount == null || mGoogleAccount.isEmpty()) {
            // Prompt the user to choose the google account to use (if more than one).
            Intent accountIntent = AccountManager.newChooseAccountIntent(
                    null, null, new String[]{"com.google"}, false, null, null, null, null);
            startActivityForResult(accountIntent, REQUEST_CODE_PICK_ACCOUNT);
            return;
        }
        getBlessing();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE_PICK_ACCOUNT:
                if (resultCode != RESULT_OK) {
                    replyWithError("User didn't pick account.");
                    return;
                }
                mGoogleAccount = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
                if (mGoogleAccount == null || mGoogleAccount.isEmpty()) {
                    replyWithError("Empty Google email.");
                    return;
                }
                getBlessing();
                break;
            case REQUEST_CODE_USER_APPROVAL:
                if (resultCode != RESULT_OK) {
                    replyWithError("User didn't give proposed permissions.");
                    return;
                }
                getBlessing();
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permission[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_USER_APPROVAL:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getBlessing();
                    return;
                }
                replyWithError("User didn't give proposed permissions.");
                break;
        }
    }

    private void getBlessing() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS);
        if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.GET_ACCOUNTS}, REQUEST_CODE_USER_APPROVAL);
            return;
        }
        Account[] accounts = AccountManager.get(this).getAccountsByType("com.google");
        Account account = null;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].name.equals(mGoogleAccount)) {
                account = accounts[i];
            }
        }
        if (account == null) {
            replyWithError("Couldn't find Google account with name: " + mGoogleAccount);
            return;
        }
        AccountManager.get(this).getAuthToken(
                account,
                OAUTH_SCOPE,
                new Bundle(),
                false,
                new OnTokenAcquired(),
                new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {
                        replyWithError("Error getting auth token: " + msg.toString());
                        return true;
                    }
                }));
    }

    class OnTokenAcquired implements AccountManagerCallback<Bundle> {
        @Override
        public void run(AccountManagerFuture<Bundle> result) {
            try {
                Bundle bundle = result.getResult();
                Intent launch = (Intent) bundle.get(AccountManager.KEY_INTENT);
                if (launch != null) {  // Needs user approval.
                    // NOTE(spetrovic): The returned intent has the wrong flag value
                    // FLAG_ACTIVITY_NEW_TASK set, which results in the launched intent replying
                    // immediately with RESULT_CANCELED.  Hence, we clear the flag here.
                    launch.setFlags(0);
                    startActivityForResult(launch, REQUEST_CODE_USER_APPROVAL);
                    return;
                }
                String token = bundle.getString(AccountManager.KEY_AUTHTOKEN);
                (new BlessingFetcher()).execute(token);
            } catch (AuthenticatorException e) {
                replyWithError("Couldn't authorize: " + e.getMessage());
                return;
            } catch (OperationCanceledException e) {
                replyWithError("Authorization cancelled: " + e.getMessage());
                return;
            } catch (IOException e) {
                replyWithError("Unexpected error: " + e.getMessage());
                return;
            }
        }
    }

    private class BlessingFetcher extends AsyncTask<String, Void, byte[]> {
        ProgressDialog progressDialog = new ProgressDialog(BlessingActivity.this);
        String errorMsg = null;

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Fetching Vanadium Blessing...");
            progressDialog.show();
        }

        @Override
        protected byte[] doInBackground(String... tokens) {
            if (tokens.length != 1) {
                errorMsg = "Empty OAuth token.";
                return null;
            }
            try {
                String publicKey = Base64.encodeToString(mPublicKey.getEncoded(), BASE64_FLAGS);
                String token = tokens[0];
                String caveats = Base64.encodeToString(
                        VomUtil.encode(new Caveat[]{}, Caveat[].class), BASE64_FLAGS);
                String outputFormat = "base64vom";
                URL url = new URL("https://dev.v.io/auth/google/bless" +
                        "?token=" + token +
                        "&public_key=" + publicKey +
                        "&caveats=" + caveats +
                        "&output_format=" + outputFormat);
                byte[] base64EncodedBlessingVom = ByteStreams.toByteArray(
                        url.openConnection().getInputStream());
                return Base64.decode(base64EncodedBlessingVom, BASE64_FLAGS);
            } catch (MalformedURLException e) {
                errorMsg = e.getMessage();
                return null;
            } catch (IOException e) {
                errorMsg = e.getMessage();
                return null;
            } catch (VException e) {
                errorMsg = e.getMessage();
                return null;
            }
        }

        @Override
        protected void onPostExecute(byte[] blessingVom) {
            progressDialog.dismiss();
            if (blessingVom == null) {  // Indicates an error
                replyWithError("Couldn't get identity from Vanadium identity servers: " + errorMsg);
                return;
            }
            replyWithSuccess(blessingVom);
        }
    }

    private void replyWithError(String error) {
        Log.e(TAG, "Error while blessing: " + error);
        Intent intent = new Intent();
        intent.putExtra(BlessingService.EXTRA_ERROR, error);
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    private void replyWithSuccess(byte[] blessingVom) {
        Intent intent = new Intent();
        intent.putExtra(BlessingService.EXTRA_REPLY, blessingVom);
        setResult(RESULT_OK, intent);
        finish();
    }
}
