// This file was auto-generated by the veyron vdl tool.
// Source(s):  build.vdl
package com.veyron2.services.mgmt.build.gen_impl;

public final class BuildServiceWrapper {

    private final com.veyron2.services.mgmt.build.BuildService service;




    public BuildServiceWrapper(final com.veyron2.services.mgmt.build.BuildService service) {
        this.service = service;
        
        
    }

    /**
     * Returns all tags associated with the provided method or null if the method isn't implemented
     * by this service.
     */
    public java.lang.Object[] getMethodTags(final com.veyron2.ipc.ServerCall call, final java.lang.String method) throws com.veyron2.ipc.VeyronException {
        
        if ("build".equals(method)) {
            return new java.lang.Object[] {
                
            };
        }
        
        if ("describe".equals(method)) {
            return new java.lang.Object[] {
                
            };
        }
        
        if ("getMethodTags".equals(method)) {
            return new java.lang.Object[] {
                
            };
        }
        
        
        throw new com.veyron2.ipc.VeyronException("method: " + method + " not found");
    }

     
    
    public java.util.ArrayList<java.lang.Byte> build(final com.veyron2.ipc.ServerCall call) throws com.veyron2.ipc.VeyronException {
        
        final com.veyron2.vdl.Stream<com.veyron2.services.mgmt.build.File, com.veyron2.services.mgmt.build.File> stream = new com.veyron2.vdl.Stream<com.veyron2.services.mgmt.build.File, com.veyron2.services.mgmt.build.File>() {
            @Override
            public void send(com.veyron2.services.mgmt.build.File item) throws com.veyron2.ipc.VeyronException {
                call.send(item);
            }
            @Override
            public com.veyron2.services.mgmt.build.File recv() throws java.io.EOFException, com.veyron2.ipc.VeyronException {
                final com.google.common.reflect.TypeToken<?> type = new com.google.common.reflect.TypeToken< com.veyron2.services.mgmt.build.File >() {
                    private static final long serialVersionUID = 1L;
                };
                final java.lang.Object result = call.recv(type);
                try {
                    return (com.veyron2.services.mgmt.build.File)result;
                } catch (java.lang.ClassCastException e) {
                    throw new com.veyron2.ipc.VeyronException("Unexpected result type: " + result.getClass().getCanonicalName());
                }
            }
        };
         
         return  this.service.build( call   ,stream  );
    }

    public com.veyron2.services.mgmt.binary.Description describe(final com.veyron2.ipc.ServerCall call, final java.lang.String Name) throws com.veyron2.ipc.VeyronException {
         
         return  this.service.describe( call , Name  );
    }



 

}
