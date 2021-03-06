// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.impl.google.rpc;

import io.v.v23.naming.Endpoint;
import io.v.v23.rpc.Server;
import io.v.v23.rpc.ServerCall;
import io.v.v23.security.Blessings;
import io.v.v23.security.Call;
import io.v.v23.verror.VException;

public class ServerCallImpl implements ServerCall {
    private final long nativePtr;

    private static native Call nativeSecurity(long nativePtr);
    private static native String nativeSuffix(long nativePtr);
    private static native Endpoint nativeLocalEndpoint(long nativePtr);
    private static native Endpoint nativeRemoteEndpoint(long nativePtr);
    private static native Blessings nativeGrantedBlessings(long nativePtr) throws VException;
    private static native Server nativeServer(long nativePtr) throws VException;
    private static native void nativeFinalize(long nativePtr);

    private ServerCallImpl(long nativePtr) {
        this.nativePtr = nativePtr;
    }

    @Override
    public Call security() {
        return nativeSecurity(nativePtr);
    }

    @Override
    public String suffix() {
        return nativeSuffix(nativePtr);
    }

    @Override
    public Endpoint localEndpoint() {
        return nativeLocalEndpoint(nativePtr);
    }

    @Override
    public Endpoint remoteEndpoint() {
        return nativeRemoteEndpoint(nativePtr);
    }

    @Override
    public Blessings grantedBlessings() {
        try {
            return nativeGrantedBlessings(nativePtr);
        } catch (VException e) {
            throw new RuntimeException("Couldn't get granted blessings: ", e);
        }
    }

    @Override
    public Server server() {
        try {
            return nativeServer(nativePtr);
        } catch (VException e) {
            throw new RuntimeException("Couldn't get server: ", e);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        nativeFinalize(nativePtr);
    }
}
