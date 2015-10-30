// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.impl.google.namespace;

import io.v.v23.VIterable;
import io.v.v23.rpc.Callback;
import org.joda.time.Duration;

import java.util.List;
import java.util.Map;

import io.v.v23.Options;
import io.v.v23.context.VContext;
import io.v.v23.namespace.Namespace;
import io.v.v23.naming.GlobReply;
import io.v.v23.naming.MountEntry;
import io.v.v23.security.access.Permissions;
import io.v.v23.verror.VException;

/**
 * An implementation of {@link Namespace} that calls to native code for most of its
 * functionalities.
 */
public class NamespaceImpl implements Namespace {
    private final long nativePtr;

    private static native VIterable<GlobReply> nativeGlob(
            long nativePtr, VContext context, String pattern, Options options) throws VException;

    private static native void nativeGlobAsync(long nativePtr, VContext context, String pattern,
                                               Options options, Callback<VIterable<GlobReply>>
                                                       callback) throws VException;

    private static native void nativeMount(long nativePtr, VContext context, String name,
                                           String server, Duration ttl, Options options)
            throws VException;

    private static native void nativeMountAsync(long nativePtr, VContext context, String name,
                                                String server, Duration ttl, Options options,
                                                Callback<Void> callback) throws VException;

    private static native void nativeUnmount(long nativePtr, VContext context, String name,
                                             String server, Options options) throws VException;

    private static native void nativeUnmountAsync(long nativePtr, VContext context, String name,
                                                  String server, Options options, Callback<Void>
                                                          callback) throws VException;

    private static native void nativeDelete(long nativePtr, VContext context, String name,
                                            boolean deleteSubtree, Options options)
            throws VException;

    private static native void nativeDeleteAsync(long nativePtr, VContext context, String name,
                                                 boolean deleteSubtree, Options options,
                                                 Callback<Void> callback) throws VException;

    private static native MountEntry nativeResolveToMountTable(long nativePtr, VContext context,
                                                               String name, Options options)
            throws VException;

    private static native void nativeResolveToMountTableAsync(long nativePtr, VContext context,
                                                              String name, Options options,
                                                              Callback<MountEntry> callback)
            throws VException;

    private static native MountEntry nativeResolve(long nativePtr, VContext context, String name,
                                                   Options options) throws VException;

    private static native void nativeResolveAsync(long nativePtr, VContext context, String name,
                                                  Options options, Callback<MountEntry> callback)
            throws VException;

    private static native boolean nativeFlushCacheEntry(long nativePtr, VContext context,
                                                        String name);

    private static native void nativeSetRoots(long nativePtr, List<String> roots) throws VException;

    private static native void nativeSetPermissions(long nativePtr, VContext context, String name,
                                                    Permissions permissions, String version,
                                                    Options options) throws VException;

    private static native void nativeSetPermissionsAsync(long nativePtr, VContext context, String
            name, Permissions permissions, String version, Options options, Callback<Void>
            callback) throws VException;

    private static native Map<String, Permissions> nativeGetPermissions(long nativePtr,
                                                                        VContext context,
                                                                        String name,
                                                                        Options options)
            throws VException;

    private static native void nativeGetPermissionsAsync(long nativePtr, VContext context, String
            name, Options options, Callback<Map<String, Permissions>> callback) throws VException;

    private native void nativeFinalize(long nativePtr);

    private NamespaceImpl(long nativePtr) {
        this.nativePtr = nativePtr;
    }

    @Override
    public void mount(VContext context, String name, String server, Duration ttl)
            throws VException {
        mount(context, name, server, ttl, (Options) null);
    }

    @Override
    public void mount(VContext context, String name, String server, Duration ttl, Options options)
            throws VException {
        nativeMount(nativePtr, context, name, server, ttl, options);
    }

    @Override
    public void mount(VContext context, String name, String server, Duration ttl, Callback<Void>
            callback) throws VException {
        mount(context, name, server, ttl, null, callback);
    }

    @Override
    public void mount(VContext context, String name, String server, Duration ttl, Options
            options, Callback<Void> callback) throws VException {
        nativeMountAsync(nativePtr, context, name, server, ttl, options, callback);
    }

    @Override
    public void unmount(VContext context, String name, String server) throws VException {
        unmount(context, name, server, (Options) null);
    }

    @Override
    public void unmount(VContext context, String name, String server, Options options)
            throws VException {
        nativeUnmount(nativePtr, context, name, server, options);
    }

    @Override
    public void unmount(VContext context, String name, String server, Callback<Void> callback)
            throws VException {
        unmount(context, name, server, null, callback);
    }

    @Override
    public void unmount(VContext context, String name, String server, Options options,
                        Callback<Void> callback) throws VException {
        nativeUnmountAsync(nativePtr, context, name, server, options, callback);
    }

    @Override
    public void delete(VContext context, String name, boolean deleteSubtree) throws VException {
        delete(context, name, deleteSubtree, (Options) null);
    }

    @Override
    public void delete(VContext context, String name, boolean deleteSubtree, Options options)
            throws VException {
        nativeDelete(nativePtr, context, name, deleteSubtree, options);
    }

    @Override
    public void delete(VContext context, String name, boolean deleteSubtree, Callback<Void>
            callback) throws VException {
        delete(context, name, deleteSubtree, null, callback);
    }

    @Override
    public void delete(VContext context, String name, boolean deleteSubtree, Options options,
                       Callback<Void> callback) throws VException {
        nativeDeleteAsync(nativePtr, context, name, deleteSubtree, options, callback);
    }

    @Override
    public MountEntry resolve(VContext context, String name) throws VException {
        return resolve(context, name, (Options) null);
    }

    @Override
    public MountEntry resolve(VContext context, String name, Options options) throws VException {
        return nativeResolve(nativePtr, context, name, options);
    }

    @Override
    public void resolve(VContext context, String name, Callback<MountEntry> callback) throws
            VException {
        resolve(context, name, null, callback);
    }

    @Override
    public void resolve(VContext context, String name, Options options, Callback<MountEntry>
            callback) throws VException {
        nativeResolveAsync(nativePtr, context, name, options, callback);
    }

    @Override
    public MountEntry resolveToMountTable(VContext context, String name) throws VException {
        return resolveToMountTable(context, name, (Options) null);
    }

    @Override
    public MountEntry resolveToMountTable(VContext context, String name, Options options)
            throws VException {
        return nativeResolveToMountTable(nativePtr, context, name, options);
    }

    @Override
    public void resolveToMountTable(VContext context, String name, Callback<MountEntry> callback)
            throws VException {
        resolveToMountTable(context, name, null, callback);
    }

    @Override
    public void resolveToMountTable(VContext context, String name, Options options,
                                    Callback<MountEntry> callback)
            throws VException {
        nativeResolveToMountTableAsync(nativePtr, context, name, options, callback);
    }

    @Override
    public boolean flushCacheEntry(VContext context, String name) {
        return nativeFlushCacheEntry(nativePtr, context, name);
    }

    @Override
    public VIterable<GlobReply> glob(VContext context, String pattern) throws VException {
        return glob(context, pattern, (Options) null);
    }

    @Override
    public VIterable<GlobReply> glob(VContext context, String pattern, Options options)
            throws VException {
        return nativeGlob(nativePtr, context, pattern, options);
    }

    @Override
    public void glob(VContext context, String pattern, Callback<VIterable<GlobReply>> callback)
            throws VException {
        glob(context, pattern, null, callback);
    }

    @Override
    public void glob(VContext context, String pattern, Options options,
                     Callback<VIterable<GlobReply>> callback) throws VException {
        nativeGlobAsync(nativePtr, context, pattern, options, callback);
    }


    @Override
    public void setRoots(List<String> roots) throws VException {
        nativeSetRoots(nativePtr, roots);
    }

    @Override
    public void setPermissions(VContext context, String name, Permissions permissions,
                               String version) throws VException {
        setPermissions(context, name, permissions, version, (Options) null);
    }

    @Override
    public void setPermissions(VContext context, String name, Permissions permissions,
                               String version, Options options) throws VException {
        nativeSetPermissions(nativePtr, context, name, permissions, version, options);
    }

    @Override
    public void setPermissions(VContext context, String name, Permissions permissions,
                               String version, Callback<Void> callback) throws VException {
        setPermissions(context, name, permissions, version, null, callback);
    }

    @Override
    public void setPermissions(VContext context, String name, Permissions permissions, String
            version, Options options, Callback<Void> callback) throws VException {
        nativeSetPermissionsAsync(nativePtr, context, name, permissions, version, options,
                callback);
    }

    @Override
    public Map<String, Permissions> getPermissions(VContext context, String name)
            throws VException {
        return getPermissions(context, name, (Options) null);
    }

    @Override
    public Map<String, Permissions> getPermissions(VContext context, String name, Options options)
            throws VException {
        return nativeGetPermissions(nativePtr, context, name, options);
    }

    @Override
    public void getPermissions(VContext context, String name, Callback<Map<String, Permissions>>
            callback) throws VException {
        getPermissions(context, name, null, callback);
    }

    @Override
    public void getPermissions(VContext context, String name, Options options,
                               Callback<Map<String, Permissions>> callback)
            throws VException {
        nativeGetPermissionsAsync(nativePtr, context, name, options, callback);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        return this.nativePtr == ((NamespaceImpl) other).nativePtr;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(this.nativePtr).hashCode();
    }

    @Override
    protected void finalize() {
        nativeFinalize(this.nativePtr);
    }
}
