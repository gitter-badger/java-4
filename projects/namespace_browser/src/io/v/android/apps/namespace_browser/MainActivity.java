package io.v.android.apps.namespace_browser;

import com.google.common.collect.ImmutableList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcel;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import io.v.android.libs.security.BlessingsManager;
import io.v.core.veyron2.VeyronException;
import io.v.core.veyron2.android.V;
import io.v.core.veyron2.context.VContext;
import io.v.core.veyron2.naming.VDLMountEntry;
import io.v.core.veyron2.naming.VDLMountedServer;
import io.v.core.veyron2.security.Blessings;
import io.v.core.veyron2.security.Principal;
import io.v.core.veyron2.security.Security;
import io.v.core.veyron2.security.WireBlessings;

import java.util.List;
import java.util.Set;

public class MainActivity extends Activity {
	private static final String TAG = "io.v.android.apps.namespace_browser";
	private static final String PREF_NAMESPACE_GLOB_ROOT = "pref_namespace_glob_root";
	private static final String DEFAULT_NAMESPACE_GLOB_ROOT = "";
	private static final String SAVED_VIEW_STATE_KEY = "browser_viewstate";

	private static final int BLESSING_REQUEST = 1;

	VContext mBaseContext = null;
	BlessingsManager mBlessingsManager = null;
	String mSelectedBlessing = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final String root = PreferenceManager.getDefaultSharedPreferences(this).getString(
				PREF_NAMESPACE_GLOB_ROOT, DEFAULT_NAMESPACE_GLOB_ROOT);
		final View dirView = findViewById(R.id.directory);
		dirView.setPadding(  // remove left padding for the root.
				0, dirView.getPaddingTop(), dirView.getPaddingRight(), dirView.getPaddingBottom());
		dirView.setTag(new VDLMountEntry(root, ImmutableList.<VDLMountedServer>of(), true));
		final TextView nameView = (TextView) dirView.findViewById(R.id.name);
		nameView.setText("/");

	    mBaseContext = V.init(this);
	    mBlessingsManager = new BlessingsManager(getPreferences(MODE_PRIVATE));
		mSelectedBlessing = null;

		updateBlessingsView();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		final Parcel parcel = Parcel.obtain();
		ViewUtil.serializeView(findViewById(R.id.directory), parcel);
		savedInstanceState.putByteArray(SAVED_VIEW_STATE_KEY, parcel.marshall());
		parcel.recycle();
		super.onSaveInstanceState(savedInstanceState);
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		final byte[] data = savedInstanceState.getByteArray(SAVED_VIEW_STATE_KEY);
		final Parcel parcel = Parcel.obtain();
		parcel.unmarshall(data, 0, data.length);
		parcel.setDataPosition(0);
		final LinearLayout dirView =
				(LinearLayout) ViewUtil.deserializeView(parcel, getLayoutInflater());
		parcel.recycle();
		// Replace old directory view with the new one.
		final LinearLayout oldDirView = (LinearLayout) findViewById(R.id.directory);
		final ViewGroup parent = (ViewGroup) oldDirView.getParent();
		final int index = parent.indexOfChild(oldDirView);
		parent.removeView(oldDirView);
		parent.addView(dirView, index);
		super.onRestoreInstanceState(savedInstanceState);
	}

	public void onItemClick(View view) {
		switch (view.getId()) {
			case R.id.directory:
				handleDirectoryClick(view);
				break;
			case R.id.object:
				handleObjectClick(view);
				break;
			case R.id.method:
				handleMethodClick(view);
				break;
			default:
				android.util.Log.e(
						TAG, String.format("Click on an illegal view with id: %d", view.getId()));
		}
	}

	private void handleDirectoryClick(View view) {
		final LinearLayout dirView = (LinearLayout)view;
		if (!dirView.isActivated()) {
			// Add new views.
			new NameFetcher(dirView).execute();
			// dirView will be updated only when the NameFetcher completes.
		} else {
			// Remove all but the first view.
			if (dirView.getChildCount() > 1) {
				dirView.removeViews(1, dirView.getChildCount() - 1);
			}
			ViewUtil.updateDirectoryView(dirView, false);
		}
	}

	private void handleObjectClick(View view) {
		final LinearLayout objView = (LinearLayout)view;
		if (!objView.isActivated()) {
			// Add new views.
			new MethodFetcher(objView).execute();
			// objView will be updated only when the NameFetcher completes.
		} else {
			// Remove all but the first view.
			if (objView.getChildCount() > 1) {
				objView.removeViews(1, objView.getChildCount() - 1);
			}
			ViewUtil.updateObjectView(objView, false);
		}
	}

	private void handleMethodClick(View view) {
		final LinearLayout methodView = (LinearLayout)view;
		// Add claiming logic here.
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		final MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_settings:
				final Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
				startActivity(intent);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
			case BLESSING_REQUEST:
				try {
					final WireBlessings blessings = BlessingsManager.processReply(resultCode, data); 
					mBlessingsManager.add(blessings);
					Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
					updateBlessingsView();
				} catch (VeyronException e) {
					final String msg = "Couldn't derive blessing: " + e.getMessage();
					Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
				}
				return;
		}
	}

	private void createDeriveAndAddBlessing() {
		final Intent intent = BlessingsManager.createIntent(this);
		startActivityForResult(intent, BLESSING_REQUEST);
	}

	private void updateBlessingsView() {
		final LinearLayout blessingView =
				(LinearLayout) getLayoutInflater().inflate(R.layout.action_account, null);
		final Set<String> blessingNames = mBlessingsManager.getNames();
		if (blessingNames.isEmpty()) {  // No blessings for this app.
			blessingView.addView(getLayoutInflater().inflate(R.layout.action_account_add, null));
			blessingView.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						createDeriveAndAddBlessing();
					}
			});
		} else {
			if (mSelectedBlessing == null) {
				updateSelectedBlessing(blessingNames.iterator().next());
			}
			final LinearLayout view = (LinearLayout) getLayoutInflater().inflate(
					R.layout.action_account_existing, null);
			((TextView)view.findViewById(R.id.blessing_name)).setText(mSelectedBlessing);
			blessingView.addView(view);
			blessingView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					showBlessingsPopup(v);
				}
			});
		}
		getActionBar().setCustomView(blessingView);
	}

	private void updateSelectedBlessing(String blessingName) {
		try {
			final WireBlessings wire = mBlessingsManager.get(blessingName);
			final Blessings blessings = Security.newBlessings(wire);
			final Principal p = V.getPrincipal(mBaseContext);
			p.blessingStore().setDefaultBlessings(blessings);
			mSelectedBlessing = blessingName;
		} catch (VeyronException e) {
			final String msg = String.format(
			        "Couldn't set blessing %s: %s", blessingName, e.getMessage());
			Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
		}
	}

	private void showBlessingsPopup(View v) {
		final PopupMenu popup = new PopupMenu(this, v);
		final Set<String> blessingNames = mBlessingsManager.getNames();
		for (final String blessingName : blessingNames) {
			final MenuItem item = popup.getMenu().add(blessingName);
			item.setOnMenuItemClickListener(new OnMenuItemClickListener(){
				@Override
				public boolean onMenuItemClick(MenuItem item) {
					updateSelectedBlessing(blessingName);
					updateBlessingsView();
					return true;
				}
			});
		}
		final MenuItem item =
				popup.getMenu().add(getResources().getString(R.string.action_account_add));
		item.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				createDeriveAndAddBlessing();
				return true;
			}
		});
		popup.show();
	}

	private class NameFetcher extends AsyncTask<Void, Void, List<VDLMountEntry>> {
		final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
		final LinearLayout dirView;
		String errorMsg = "";

		NameFetcher(LinearLayout dirView) {
			this.dirView = dirView;
		}
		@Override
		protected void onPreExecute() {
			progressDialog.setMessage("Fetching Names...");
			progressDialog.show();
		}
		@Override
		protected List<VDLMountEntry> doInBackground(Void... args) {
			final VDLMountEntry entry = (VDLMountEntry)dirView.getTag();
			try {
				return Namespace.glob(entry.getName(), mBaseContext);
			} catch (VeyronException e) {
				errorMsg = "Error fetching names: " + e.getMessage();
				return null;
			}
		}
		@Override
		protected void onPostExecute(List<VDLMountEntry> entries) {
			progressDialog.dismiss();
			ViewUtil.updateDirectoryView(dirView, true);
			if (entries == null) {
				Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_LONG).show();
				return;
			}
			final VDLMountEntry parentEntry = (VDLMountEntry)dirView.getTag();
			for (VDLMountEntry entry : entries) {
				String text = "";
				if (parentEntry.getName().isEmpty()) {
					text = entry.getName();
				} else {
					if (!entry.getName().startsWith(parentEntry.getName() + "/")) {
						android.util.Log.e(TAG, String.format(
								"Entry %s doesn't start with parent prefix %s",
								entry.getName(), parentEntry.getName() + "/"));
						continue;
					}
					text = entry.getName().substring(parentEntry.getName().length() + 1);
				}
				final LinearLayout childView =
						(entry.getServers() == null || entry.getServers().size() <= 0)
						? ViewUtil.createDirectoryView(text, entry, getLayoutInflater()) // sub-dir
						: ViewUtil.createObjectView(text, entry, getLayoutInflater());   // object
				dirView.addView(childView);
			}
		}
	}

	private class MethodFetcher extends AsyncTask<Void, Void, List<String>> {
		final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
		final LinearLayout objView;
		String errorMsg = "";
		MethodFetcher(LinearLayout objView) {
			this.objView = objView;
		}
		@Override
		protected void onPreExecute() {
			progressDialog.setMessage("Fetching Methods...");
			progressDialog.show();
		}
		@Override
		protected List<String> doInBackground(Void... args) {
			final VDLMountEntry entry = (VDLMountEntry)objView.getTag();
			try {
				return Methods.get(entry.getName(), mBaseContext);
			} catch (VeyronException e) {
				errorMsg = "Error fetching methods: " + e.getMessage();
				return null;
			}
		}
		@Override
		protected void onPostExecute(List<String> methods) {
			progressDialog.dismiss();
			ViewUtil.updateObjectView(objView, true);
			if (methods == null) {
				Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_LONG).show();
				return;
			}
			final VDLMountEntry entry = (VDLMountEntry)objView.getTag();
			for (String method : methods) {
				final LinearLayout childView =
						ViewUtil.createMethodView(method, entry, getLayoutInflater());
				objView.addView(childView);
			}
		}
	}
}