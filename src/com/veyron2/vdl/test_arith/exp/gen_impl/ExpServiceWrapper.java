// This file was auto-generated by the veyron vdl tool.
// Source(s):  exp.vdl
package com.veyron2.vdl.test_arith.exp.gen_impl;

public final class ExpServiceWrapper {

    private final com.veyron2.vdl.test_arith.exp.ExpService service;




    public ExpServiceWrapper(final com.veyron2.vdl.test_arith.exp.ExpService service) {
        this.service = service;
        
        
    }

    /**
     * Returns all tags associated with the provided method or null if the method isn't implemented
     * by this service.
     */
    public java.lang.Object[] getMethodTags(final com.veyron2.ipc.ServerCall call, final java.lang.String method) throws com.veyron2.ipc.VeyronException {
        
        if ("exp".equals(method)) {
            return new java.lang.Object[] {
                
            };
        }
        
        if ("getMethodTags".equals(method)) {
            return new java.lang.Object[] {
                
            };
        }
        
        
        throw new com.veyron2.ipc.VeyronException("method: " + method + " not found");
    }

     
    
    public double exp(final com.veyron2.ipc.ServerCall call, final double x) throws com.veyron2.ipc.VeyronException {
         
         return  this.service.exp( call , x  );
    }



 

}
