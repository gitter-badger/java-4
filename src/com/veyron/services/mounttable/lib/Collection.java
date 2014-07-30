// This file was auto-generated by the veyron vdl tool.
// Source: collection_test.vdl
package com.veyron.services.mounttable.lib;


public interface Collection  {

    
    

    
    // Export sets the value for a name.  Overwrite controls the behavior when
// an entry exists, if Overwrite is true, then the binding is replaced,
// otherwise the call fails with an error.  The Val must be no larger than
// MaxSize bytes.

    public void export(final com.veyron2.ipc.Context context, final java.lang.String Val, final boolean Overwrite) throws com.veyron2.ipc.VeyronException;
    public void export(final com.veyron2.ipc.Context context, final java.lang.String Val, final boolean Overwrite, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    // Lookup retrieves the value associated with a name.  Returns an error if
// there is no such binding.

    public java.util.ArrayList<java.lang.Byte> lookup(final com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException;
    public java.util.ArrayList<java.lang.Byte> lookup(final com.veyron2.ipc.Context context, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

}
