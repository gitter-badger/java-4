// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.impl.google.rpc;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

import io.v.impl.google.ListenableFutureCallback;
import io.v.v23.rpc.Callback;
import io.v.v23.rpc.ClientCall;
import io.v.v23.rpc.Stream;
import io.v.v23.verror.VException;
import io.v.v23.vom.VomUtil;

import java.lang.reflect.Type;

public class ClientCallImpl implements ClientCall {
    private final long nativePtr;
    private final Stream stream;

    private native void nativeCloseSend(long nativePtr, Callback<Void> callback);
    private native void nativeFinish(long nativePtr, int numResults, Callback<byte[][]> callback);
    private native void nativeFinalize(long nativePtr);

    private ClientCallImpl(long nativePtr, Stream stream) {
        this.nativePtr = nativePtr;
        this.stream = stream;
    }

    @Override
    public ListenableFuture<Void> send(Object item, Type type) {
        return stream.send(item, type);
    }
    @Override
    public ListenableFuture<Object> recv(Type type) {
        return stream.recv(type);
    }
    @Override
    public ListenableFuture<Void> closeSend() {
        ListenableFutureCallback<Void> callback = new ListenableFutureCallback<>();
        nativeCloseSend(nativePtr, callback);
        return callback.getFuture();
    }
    @Override
    public ListenableFuture<Object[]> finish(final Type[] types) {
        final SettableFuture<Object[]> future = SettableFuture.create();
        nativeFinish(nativePtr, types.length, new Callback<byte[][]>() {
            @Override
            public void onSuccess(byte[][] vomResults) {
                if (vomResults.length != types.length) {
                    future.setException(new VException(String.format(
                            "Mismatch in number of results, want %s, have %s",
                            types.length, vomResults.length)));
                    return;
                }
                // VOM-decode results.
                Object[] ret = new Object[types.length];
                for (int i = 0; i < types.length; i++) {
                    try {
                        ret[i] = VomUtil.decode(vomResults[i], types[i]);
                    } catch (VException e) {
                        future.setException(e);
                        return;
                    }
                }
                future.set(ret);
            }

            @Override
            public void onFailure(VException error) {
                future.setException(error);
            }
        });
        return future;
    }
    @Override
    protected void finalize() {
        nativeFinalize(nativePtr);
    }
}
