// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.v23.security;

import io.v.v23.verror.VException;

/**
 * BlessingPattern is a wrapper around WireBlessingPattern, providing additional functionality.
 */
public class BlessingPattern extends WireBlessingPattern {
    private static final long serialVersionUID = 1L;

    private final long nativePtr;

    private native long nativeCreate() throws VException;
    private native boolean nativeIsMatchedBy(long nativePtr, String[] blessings);
    private native boolean nativeIsValid(long nativePtr);
    private native BlessingPattern nativeMakeNonExtendable(long nativePtr) throws VException;
    private native void nativeFinalize(long nativePtr);

    public BlessingPattern(String value) {
        super(value);
        try {
            this.nativePtr = nativeCreate();
        } catch (VException e) {
            throw new RuntimeException("Couldn't create native BlessingPattern", e);
        }
    }

    BlessingPattern(WireBlessingPattern wire) {
        this(wire.getValue());
    }

    /**
     * Returns {@code true} iff one of the presented blessings matches this pattern as per
     * the rules described in documentation for the {@code WireBlessingPattern} type.
     *
     * @param  blessings blessings compared against this pattern.
     * @return           true iff one of the presented blessings matches this pattern.
     */
    public boolean isMatchedBy(String... blessings) {
        return nativeIsMatchedBy(this.nativePtr, blessings);
    }

    /**
     * Returns {@code true} iff this pattern is well formed, i.e., does not contain any character
     * sequences that will cause the BlessingPattern to never match any valid blessings.
     *
     * @return true iff the pattern is well formed.
     */
    public boolean isValid() {
        return nativeIsValid(this.nativePtr);
    }

    /**
     * Returns a new pattern that is not matched by any extension of the blessing represented
     * by this pattern.
     *
     * For example:
     * <code>
     *     final BlessingPattern onlyAlice =
     *             new BlessingPattern("google/alice")).makeNonExtendable();
     *     onlyAlice.isMatchedBy("google");                  // returns true
     *     onlyAlice.isMatchedBy("google/alice");            // returns true
     *     onlyAlice.isMatchedBy("google/alice/bob");        // returns false
     * </code>
     *
     * @return a pattern that matches all extensions of the blessings that are matched by this
     *         pattern.
     */
    public BlessingPattern makeNonExtendable() {
        try {
            return nativeMakeNonExtendable(this.nativePtr);
        } catch (VException e) {
            throw new RuntimeException("Couldn't make blessing pattern non-extendable", e);
        }
    }

    @Override
    protected void finalize() {
        nativeFinalize(this.nativePtr);
    }
}