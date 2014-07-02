// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron2.services.watch;

import com.veyron2.ipc.ServerContext;
import com.veyron2.ipc.VeyronException;
import com.veyron2.services.watch.gen_impl.GlobWatcherServiceWrapper;
import com.veyron2.vdl.Stream;
import com.veyron2.vdl.VeyronService;

/**
 * GlobWatcher allows a client to receive updates for changes to objects
 * that match a pattern.  See the package comments for details.
**/
@VeyronService(stubWrapper=GlobWatcherServiceWrapper.class)
public interface GlobWatcherService { 
	// WatchGlob returns a stream of changes that match a pattern.
	public void watchGlob(ServerContext context, GlobRequest req, Stream<ChangeBatch,Void> stream) throws VeyronException;
}
