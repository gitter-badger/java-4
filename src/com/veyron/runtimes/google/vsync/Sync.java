// This file was auto-generated by the veyron vdl tool.
// Source: vsync.vdl
package com.veyron.runtimes.google.vsync;

/**
 * Sync allows a device to GetDeltas from another device.
 */

public interface Sync  {

    
    

    
    // GetDeltas returns a device's current generation vector and all the missing log records
// when compared to the incoming generation vector.

    public com.veyron2.vdl.ClientStream<java.lang.Void,com.veyron.runtimes.google.vsync.LogRec, com.veyron.runtimes.google.vsync.GenVector> getDeltas(final com.veyron2.ipc.Context context, final com.veyron.runtimes.google.vsync.GenVector In, final com.veyron.runtimes.google.vsync.DeviceID ClientID) throws com.veyron2.ipc.VeyronException;
    public com.veyron2.vdl.ClientStream<java.lang.Void,com.veyron.runtimes.google.vsync.LogRec, com.veyron.runtimes.google.vsync.GenVector> getDeltas(final com.veyron2.ipc.Context context, final com.veyron.runtimes.google.vsync.GenVector In, final com.veyron.runtimes.google.vsync.DeviceID ClientID, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

}
