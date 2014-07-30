// This file was auto-generated by the veyron vdl tool.
// Source: node.vdl
package com.veyron.services.mgmt.node;

/**
 * Config is an RPC API to the config service.
 */

public interface Config  {

    
    

    
    // Set sets the value for key.

    public void set(final com.veyron2.ipc.Context context, final java.lang.String key, final java.lang.String value) throws com.veyron2.ipc.VeyronException;
    public void set(final com.veyron2.ipc.Context context, final java.lang.String key, final java.lang.String value, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

}
