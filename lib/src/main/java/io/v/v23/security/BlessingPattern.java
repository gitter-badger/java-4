// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.v23.security;

import io.v.v23.verror.VException;

/**
 * A wrapper around {@link WireBlessingPattern}, providing additional functionality.
 */
public class BlessingPattern extends WireBlessingPattern {
    private static final long serialVersionUID = 1L;
    private static native long nativeCreate(String value) throws VException;

    private final long nativePtr;
    private native boolean nativeIsMatchedBy(long nativePtr, String[] blessings) throws VException;
    private native boolean nativeIsValid(long nativePtr);
    private native BlessingPattern nativeMakeNonExtendable(long nativePtr) throws VException;
    private native void nativeFinalize(long nativePtr);

    /**
     * Constructs a new {@link BlessingPattern} from the provided string.
     *
     * @param  value blessing pattern string
     */
    public BlessingPattern(String value) {
        super(value);
        try {
            this.nativePtr = nativeCreate(value);
        } catch (VException e) {
            throw new RuntimeException("Couldn't create native BlessingPattern", e);
        }
    }

    BlessingPattern(WireBlessingPattern wire) {
        this(wire.getValue());
    }

    private BlessingPattern(long nativePtr, String value) {
        super(value);
        this.nativePtr = nativePtr;
    }

    /**
     * Returns {@code true} iff one of the presented blessings matches this pattern as per
     * the rules described in documentation for the {@link WireBlessingPattern} type.
     *
     * @param  blessings blessings compared against this pattern
     */
    public boolean isMatchedBy(String... blessings) {
        try {
            return nativeIsMatchedBy(nativePtr, blessings);
        } catch (VException e) {
            throw new RuntimeException("Couldn't check blessings match", e);
        }
    }

    /**
     * Returns {@code true} iff this pattern is well formed, i.e., does not contain any character
     * sequences that will cause the {@link BlessingPattern} to never match any valid blessings.
     */
    public boolean isValid() {
        return nativeIsValid(nativePtr);
    }

    /**
     * Returns a new pattern that is not matched by any extension of the blessing represented
     * by this pattern.
     *
     * For example:
     * <p><blockquote><pre>
     *     BlessingPattern onlyAlice =
     *             new BlessingPattern("google:alice")).makeNonExtendable();
     *     onlyAlice.isMatchedBy("google");                  // returns true
     *     onlyAlice.isMatchedBy("google:alice");            // returns true
     *     onlyAlice.isMatchedBy("google:alice:bob");        // returns false
     * </pre></blockquote><p>
     *
     * @return a pattern that is not matched by any extension of the blessings that are
     *         matched by this pattern
     */
    public BlessingPattern makeNonExtendable() {
        try {
            return nativeMakeNonExtendable(nativePtr);
        } catch (VException e) {
            throw new RuntimeException("Couldn't make blessing pattern non-extendable", e);
        }
    }

    private long nativePtr() {
        return nativePtr;
    }

    @Override
    protected void finalize() {
        nativeFinalize(nativePtr);
    }
}
