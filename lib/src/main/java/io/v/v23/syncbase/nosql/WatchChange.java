// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.v23.syncbase.nosql;

import io.v.v23.services.watch.ResumeMarker;

/**
 * Represents a new value for an entity watched using {@link Database#watch}.
 */
public class WatchChange {
    private final String tableName;
    private final String rowName;
    private final ChangeType changeType;
    private final byte[] vomValue;
    private final ResumeMarker resumeMarker;
    private final boolean fromSync;
    private final boolean continued;

    public WatchChange(String tableName, String rowName, ChangeType changeType, byte[] vomValue,
                       ResumeMarker resumeMarker, boolean fromSync, boolean continued) {
        this.tableName = tableName;
        this.rowName = rowName;
        this.changeType = changeType;
        this.vomValue = vomValue;
        this.resumeMarker = resumeMarker;
        this.fromSync = fromSync;
        this.continued = continued;
    }

    /**
     * Returns the (relative) name of the table that contains the changed row.
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Returns the name (i.e., key) of the changed row.
     */
    public String getRowName() {
        return rowName;
    }

    /**
     * Returns the type of the change.
     * <p>
     * If {@link ChangeType#PUT_CHANGE}, the row exists in the table and {@link #getVomValue()}
     * will return the new value for the row.
     * <p>
     * If {@link ChangeType#DELETE_CHANGE}, the row was removed from the table and
     * {@link #getVomValue()} will return {@code null}.
     */
    public ChangeType getChangeType() {
        return changeType;
    }

    /**
     * Returns the new VOM-encoded value for the row, if the {@link ChangeType} is
     * {@link ChangeType#PUT_CHANGE}; returns {@code null} otherwise.
     */
    public byte[] getVomValue() {
        return vomValue;
    }

    /**
     * Returns a {@link ResumeMarker} that can be used to resume the change stream from the point
     * right after this change.
     */
    public ResumeMarker getResumeMarker() {
        return resumeMarker;
    }

    /**
     * Indicates whether the change came from sync or from the local device.
     */
    public boolean isFromSync() {
        return fromSync;
    }

    /**
     * If {@code true}, this change is followed by more changes that are in the same batch
     * as this change.
     */
    public boolean isContinued() {
        return continued;
    }
}