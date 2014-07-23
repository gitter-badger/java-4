// This file was auto-generated by the veyron vdl tool.
// Source(s):  service.vdl
package com.veyron2.services.mounttable.gen_impl;

public final class MountTableServiceWrapper {

    private final com.veyron2.services.mounttable.MountTableService service;



    
    private final com.veyron2.services.mounttable.gen_impl.GlobbableServiceWrapper globbableWrapper;
    

    public MountTableServiceWrapper(final com.veyron2.services.mounttable.MountTableService service) {
        this.service = service;
        
        
        this.globbableWrapper = new com.veyron2.services.mounttable.gen_impl.GlobbableServiceWrapper(service);
        
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
        
        if ("mount".equals(method)) {
            return new java.lang.Object[] {
                 new com.veyron2.security.Label(4), 
            };
        }
        
        if ("resolveStep".equals(method)) {
            return new java.lang.Object[] {
                 new com.veyron2.security.Label(2), 
            };
        }
        
        if ("unmount".equals(method)) {
            return new java.lang.Object[] {
                 new com.veyron2.security.Label(4), 
            };
        }
        
        
        try {
            return this.globbableWrapper.getMethodTags(call, method);
        } catch (com.veyron2.ipc.VeyronException e) {}  // method not found.
        
        throw new com.veyron2.ipc.VeyronException("method: " + method + " not found");
    }

     
    
    public void mount(final com.veyron2.ipc.ServerCall call, final java.lang.String Server, final int TTL) throws com.veyron2.ipc.VeyronException {
         
         this.service.mount( call , Server, TTL  );
    }

    public void unmount(final com.veyron2.ipc.ServerCall call, final java.lang.String Server) throws com.veyron2.ipc.VeyronException {
         
         this.service.unmount( call , Server  );
    }

    public com.veyron2.services.mounttable.MountTable.ResolveStepOut resolveStep(final com.veyron2.ipc.ServerCall call) throws com.veyron2.ipc.VeyronException {
         
         return  this.service.resolveStep( call   );
    }




    public void glob(final com.veyron2.ipc.ServerCall call, final java.lang.String pattern) throws com.veyron2.ipc.VeyronException {
        
          this.globbableWrapper.glob(call, pattern);
    }
 

}
