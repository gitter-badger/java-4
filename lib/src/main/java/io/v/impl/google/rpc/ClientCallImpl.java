// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.impl.google.rpc;

import com.google.common.util.concurrent.Uninterruptibles;
import io.v.v23.rpc.Callback;
import io.v.v23.rpc.ClientCall;
import io.v.v23.rpc.Stream;
import io.v.v23.verror.VException;
import io.v.v23.vom.VomUtil;

import java.io.EOFException;
import java.lang.reflect.Type;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class ClientCallImpl implements ClientCall {
    private final long nativePtr;
    private final Stream stream;

    private native void nativeCloseSend() throws VException;
    private native byte[][] nativeFinish(long nativePtr, int numResults);
    private native void nativeFinishAsync(long nativePtr, int numResults, Callback<byte[][]> callback);
    private native void nativeFinalize(long nativePtr);

    private ClientCallImpl(long nativePtr, Stream stream) {
        this.nativePtr = nativePtr;
        this.stream = stream;
    }

    // Implements io.v.v23.rpc.ClientCall.
    @Override
    public void closeSend() throws VException {
        nativeCloseSend();
    }
    @Override
    public Object[] finish(Type[] types) throws VException {
        byte[][] vomResults = nativeFinish(nativePtr, types.length);
        if (vomResults.length != types.length) {
            throw new VException(String.format(
                    "Mismatch in number of results, want %s, have %s",
                    types.length, vomResults.length));
        }
        // VOM-decode results.
        Object[] ret = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            ret[i] = VomUtil.decode(vomResults[i], types[i]);
        }
        return ret;
    }
    @Override
    public void finish(final Type[] types, final Callback<Object[]> callback) {
        nativeFinishAsync(nativePtr, types.length, new Callback<byte[][]>() {
            @Override
            public void onSuccess(byte[][] vomResults) {
                if (vomResults.length != types.length) {
                    callback.onFailure(new VException(String.format(
                            "Mismatch in number of results, want %s, have %s",
                            types.length, vomResults.length)));
                }
                // VOM-decode results.
                Object[] ret = new Object[types.length];
                for (int i = 0; i < types.length; i++) {
                    try {
                        ret[i] = VomUtil.decode(vomResults[i], types[i]);
                    } catch (VException e) {
                        callback.onFailure(e);
                        return;
                    }
                }
                callback.onSuccess(ret);
            }

            @Override
            public void onFailure(VException error) {
                callback.onFailure(error);
            }
        });
    }
    // Implements io.v.v23.rpc.Stream.
    @Override
    public void send(Object item, Type type) throws VException {
        this.stream.send(item, type);
    }
    @Override
    public Object recv(Type type) throws EOFException, VException {
        return this.stream.recv(type);
    }
    // Implements java.lang.Object.
    @Override
    protected void finalize() {
        nativeFinalize(this.nativePtr);
    }
}