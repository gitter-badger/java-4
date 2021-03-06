// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.android.apps.syncslides.discovery;

import android.util.Log;

import org.joda.time.Duration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import io.v.android.apps.syncslides.misc.V23Manager;

/**
 * Repeatedly runs a task in a thread distinct from that which calls start().
 */
class PeriodicTasker {
    private static final String TAG = "PeriodicTasker";

    private static final Duration DELAY_BEFORE_FIRST_TASK =
            Duration.standardSeconds(1);

    private static final Duration WAIT_BETWEEN_TASKS =
            V23Manager.MT_TIMEOUT.plus(Duration.millis(500));

    private ScheduledExecutorService mTimer = null;

    void start(Runnable task) {
        if (mTimer != null) {
            throw new IllegalStateException("Must stop existing task first.");
        }
        Log.d(TAG, "Starting");
        mTimer = Executors.newSingleThreadScheduledExecutor();
        mTimer.scheduleAtFixedRate(
                task,
                DELAY_BEFORE_FIRST_TASK.getMillis(),
                WAIT_BETWEEN_TASKS.getMillis(),
                TimeUnit.MILLISECONDS);
        Log.d(TAG, "Done Starting");
    }

    void stop() {
        if (mTimer == null) {
            Log.d(TAG, "Nothing to stop.");
            return;
        }
        Log.d(TAG, "Stopping");
        mTimer.shutdownNow();
        mTimer = null;
    }
}
