// This file was auto-generated by the veyron vdl tool.
// Source: p2b.vdl
package com.veyron.examples.pipetobrowser;

/**
 * Viewer allows clients to stream data to it and to request a particular viewer to format and display the data.
 */

@com.veyron2.vdl.VeyronService(serviceWrapper=com.veyron.examples.pipetobrowser.gen_impl.ViewerServiceWrapper.class)
public interface ViewerService  {

    
    // Pipe creates a bidirectional pipe between client and viewer service, returns total number of bytes received by the service after streaming ends

    public java.lang.Object pipe(final com.veyron2.ipc.ServerContext context, com.veyron2.vdl.Stream<java.util.ArrayList<java.lang.Byte>, java.lang.Void> stream) throws com.veyron2.ipc.VeyronException;

}
