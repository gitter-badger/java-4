// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron2.services.watch;

/**
 * QueryWatcher allows a client to receive updates for changes to objects
 * that match a query.  See the package comments for details.
 */

public interface QueryWatcher  {

    
    

    
    // WatchQuery returns a stream of changes that satisy a query.

    public com.veyron2.vdl.ClientStream<java.lang.Void,com.veyron2.services.watch.ChangeBatch, java.lang.Void> watchQuery(final com.veyron2.ipc.Context context, final com.veyron2.services.watch.QueryRequest Req) throws com.veyron2.ipc.VeyronException;
    public com.veyron2.vdl.ClientStream<java.lang.Void,com.veyron2.services.watch.ChangeBatch, java.lang.Void> watchQuery(final com.veyron2.ipc.Context context, final com.veyron2.services.watch.QueryRequest Req, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

}
