// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.v23.security;

import com.google.common.collect.ImmutableMap;

import junit.framework.TestCase;

import io.v.v23.V;
import io.v.v23.verror.VException;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPublicKey;
import java.util.Map;

/**
 * Tests the default {@code BlessingRoot} implementation.
 */
public class BlessingRootsTest extends TestCase {
    public void testRecognized() throws VException {
        V.init();
        final Principal principal = Security.newPrincipal();
        final BlessingRoots roots = principal.roots();
        final ECPublicKey[] keys = { mintPublicKey(), mintPublicKey(), mintPublicKey() };
        roots.add(keys[0], new BlessingPattern("veyron"));
        roots.add(keys[1], new BlessingPattern("google/foo"));
        roots.add(keys[0], new BlessingPattern("google/$"));

        final Map<ECPublicKey, String[]> recognized =
                ImmutableMap.<ECPublicKey, String[]>builder()
                .put(keys[0], new String[]{
                        "veyron", "veyron/foo", "veyron/foo/bar", "google" })
                .put(keys[1], new String[]{ "google/foo", "google/foo/bar" })
                .put(keys[2], new String[]{ })
                .build();
        final Map<ECPublicKey, String[]> notRecognized =
                ImmutableMap.<ECPublicKey, String[]>builder()
                .put(keys[0], new String[]{ "google/foo", "foo", "foo/bar" })
                .put(keys[1], new String[]{
                        "google", "google/bar", "veyron", "veyron/foo", "foo", "foo/bar" })
                .put(keys[2], new String[] { "veyron", "veyron/foo", "veyron/bar", "google",
                        "google/foo", "google/bar", "foo", "foo/bar" })
                .build();
        for (Map.Entry<ECPublicKey, String[]> entry : recognized.entrySet()) {
            final ECPublicKey key = entry.getKey();
            for (String blessing : entry.getValue()) {
                try {
                    roots.recognized(key, blessing);
                } catch (VException e) {
                    fail("Didn't recognize root: " + entry.getKey() +
                            " as an authority for blessing: " + blessing);
                }
            }
        }
        for (Map.Entry<ECPublicKey, String[]> entry : notRecognized.entrySet()) {
            final ECPublicKey key = entry.getKey();
            for (String blessing : entry.getValue()) {
                try {
                    roots.recognized(key, blessing);
                    fail("Shouldn't recognize root: " + entry.getKey() +
                            " as an authority for blessing: " + blessing);
                } catch (VException e) {
                    // OK
                }
            }
        }
    }

    private static ECPublicKey mintPublicKey() throws VException {
        try {
            final KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
            keyGen.initialize(256);
            return (ECPublicKey) keyGen.generateKeyPair().getPublic();
        } catch (NoSuchAlgorithmException e) {
            throw new VException("Couldn't mint private key: " + e.getMessage());
        }
    }
}
