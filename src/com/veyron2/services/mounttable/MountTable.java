// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron2.services.mounttable;

import com.veyron2.Options;
import com.veyron2.ipc.Context;
import com.veyron2.ipc.VeyronException;
import java.util.ArrayList;

/**
 * MountTable defines the interface to talk to a mounttable.
**/
public interface MountTable extends Globable { 
	// Mount Server (a global name) onto the receiver.
// Subsequent mounts add to the servers mounted there.  The multiple
// servers are considered equivalent and are meant solely for
// availability, i.e., no load balancing is guaranteed.
//
// TTL is the number of seconds the mount is to last unless refreshed by
// another mount of the same server.  A TTL of 0 represents an infinite
// duration.  A server with an expired TTL should never appear in the
// results nor affect the operation of any MountTable method, and should
// act as if it was never present as far as the interface is concerned.
	public void mount(Context context, String server, int tTL) throws VeyronException;
	public void mount(Context context, String server, int tTL, Options veyronOpts) throws VeyronException;
	// Unmount removes Server from the mount point.  If Server is empty, remove all
// servers mounted there.
// Returns a non-nil error iff Server remains mounted at the mount point.
	public void unmount(Context context, String server) throws VeyronException;
	public void unmount(Context context, String server, Options veyronOpts) throws VeyronException;
	// ResolveStepOut packages output arguments for method ResolveStep.
	public static class ResolveStepOut { 
		public ArrayList<MountedServer> servers;
		public String suffix;
	}
	// ResolveStep takes the next step in resolving a name.  Returns the next
// servers to query and the suffix at those servers.
	public MountTable.ResolveStepOut resolveStep(Context context) throws VeyronException;
	public MountTable.ResolveStepOut resolveStep(Context context, Options veyronOpts) throws VeyronException;
}
