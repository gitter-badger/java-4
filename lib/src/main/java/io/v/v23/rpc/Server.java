// Copyright 2015 The Vanadium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package io.v.v23.rpc;

import io.v.v23.verror.VException;

/**
 * The interface for managing a collection of services.
 */
public interface Server {
    /**
     * Adds the specified name to the mount table for the object or {@link Dispatcher} served by
     * this server.
     *
     * @param  name            name to be added to the mount table
     * @throws VException      if the name couldn't be added to the mount table
     */
    void addName(String name) throws VException;

    /**
     * Removes the specified name from the mount table.
     *
     * @param name name to be removed from the mount table
     */
    void removeName(String name);

    /**
     * Returns the current {@link ServerStatus} of the server.
     */
    ServerStatus getStatus();

    /**
     * Gracefully stops all services on this server.  New calls are rejected, but any in-flight
     * calls are allowed to complete.  All published mountpoints are unmounted.  This call waits for
     * this process to complete and returns once the server has been shut down.
     *
     * @throws VException      if there was an error stopping the server
     */
    void stop() throws VException;
}
