// This file was auto-generated by the veyron vdl tool.
// Source(s):  root.vdl
package com.veyron.services.mgmt.root.gen_impl;

public final class RootServiceWrapper {

    private final com.veyron.services.mgmt.root.RootService service;




    public RootServiceWrapper(final com.veyron.services.mgmt.root.RootService service) {
        this.service = service;
        
        
    }

    /**
     * Returns all tags associated with the provided method or null if the method isn't implemented
     * by this service.
     */
    public java.lang.Object[] getMethodTags(final com.veyron2.ipc.ServerCall call, final java.lang.String method) throws com.veyron2.ipc.VeyronException {
        
        if ("getMethodTags".equals(method)) {
            return new java.lang.Object[] {
                
            };
        }
        
        if ("reset".equals(method)) {
            return new java.lang.Object[] {
                
            };
        }
        
        
        throw new com.veyron2.ipc.VeyronException("method: " + method + " not found");
    }

     
    
    public void reset(final com.veyron2.ipc.ServerCall call, final long Deadline) throws com.veyron2.ipc.VeyronException {
         
         this.service.reset( call , Deadline  );
    }



 

}
