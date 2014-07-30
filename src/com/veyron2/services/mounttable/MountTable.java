// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron2.services.mounttable;

/**
 * MountTable defines the interface to talk to a mounttable.
 */

public interface MountTable extends com.veyron2.services.mounttable.Globable {

    
    

    
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

    public void mount(final com.veyron2.ipc.Context context, final java.lang.String Server, final int TTL) throws com.veyron2.ipc.VeyronException;
    public void mount(final com.veyron2.ipc.Context context, final java.lang.String Server, final int TTL, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    // Unmount removes Server from the mount point.  If Server is empty, remove all
// servers mounted there.
// Returns a non-nil error iff Server remains mounted at the mount point.

    public void unmount(final com.veyron2.ipc.Context context, final java.lang.String Server) throws com.veyron2.ipc.VeyronException;
    public void unmount(final com.veyron2.ipc.Context context, final java.lang.String Server, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    
    public static class ResolveStepOut {
        
        public java.util.ArrayList<com.veyron2.services.mounttable.MountedServer> servers;
        
        public java.lang.String suffix;
        
    }
    

    
    // ResolveStep takes the next step in resolving a name.  Returns the next
// servers to query and the suffix at those servers.

    public com.veyron2.services.mounttable.MountTable.ResolveStepOut resolveStep(final com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException;
    public com.veyron2.services.mounttable.MountTable.ResolveStepOut resolveStep(final com.veyron2.ipc.Context context, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

}
