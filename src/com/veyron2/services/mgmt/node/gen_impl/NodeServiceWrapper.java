// This file was auto-generated by the veyron vdl tool.
// Source(s):  node.vdl
package com.veyron2.services.mgmt.node.gen_impl;

public final class NodeServiceWrapper {

    private final com.veyron2.services.mgmt.node.NodeService service;



    
    private final com.veyron2.services.mgmt.node.gen_impl.ApplicationServiceWrapper applicationWrapper;
    

    public NodeServiceWrapper(final com.veyron2.services.mgmt.node.NodeService service) {
        this.service = service;
        
        
        this.applicationWrapper = new com.veyron2.services.mgmt.node.gen_impl.ApplicationServiceWrapper(service);
        
    }

    /**
     * Returns all tags associated with the provided method or null if the method isn't implemented
     * by this service.
     */
    public java.lang.Object[] getMethodTags(final com.veyron2.ipc.ServerCall call, final java.lang.String method) throws com.veyron2.ipc.VeyronException {
        
        if ("describe".equals(method)) {
            return new java.lang.Object[] {
                
            };
        }
        
        if ("getMethodTags".equals(method)) {
            return new java.lang.Object[] {
                
            };
        }
        
        if ("isRunnable".equals(method)) {
            return new java.lang.Object[] {
                
            };
        }
        
        if ("reset".equals(method)) {
            return new java.lang.Object[] {
                
            };
        }
        
        
        try {
            return this.applicationWrapper.getMethodTags(call, method);
        } catch (com.veyron2.ipc.VeyronException e) {}  // method not found.
        
        throw new com.veyron2.ipc.VeyronException("method: " + method + " not found");
    }

     
    
    public com.veyron2.services.mgmt.node.Description describe(final com.veyron2.ipc.ServerCall call) throws com.veyron2.ipc.VeyronException {
         
         return  this.service.describe( call   );
    }

    public boolean isRunnable(final com.veyron2.ipc.ServerCall call, final com.veyron2.services.mgmt.binary.Description Description) throws com.veyron2.ipc.VeyronException {
         
         return  this.service.isRunnable( call , Description  );
    }

    public void reset(final com.veyron2.ipc.ServerCall call, final long Deadline) throws com.veyron2.ipc.VeyronException {
         
         this.service.reset( call , Deadline  );
    }




    public void refresh(final com.veyron2.ipc.ServerCall call) throws com.veyron2.ipc.VeyronException {
        
          this.applicationWrapper.refresh(call);
    }

    public java.util.ArrayList<java.lang.String> start(final com.veyron2.ipc.ServerCall call) throws com.veyron2.ipc.VeyronException {
        
        return  this.applicationWrapper.start(call);
    }

    public void stop(final com.veyron2.ipc.ServerCall call, final long Deadline) throws com.veyron2.ipc.VeyronException {
        
          this.applicationWrapper.stop(call, Deadline);
    }

    public void update(final com.veyron2.ipc.ServerCall call) throws com.veyron2.ipc.VeyronException {
        
          this.applicationWrapper.update(call);
    }

    public java.lang.String install(final com.veyron2.ipc.ServerCall call, final java.lang.String Name) throws com.veyron2.ipc.VeyronException {
        
        return  this.applicationWrapper.install(call, Name);
    }

    public void resume(final com.veyron2.ipc.ServerCall call) throws com.veyron2.ipc.VeyronException {
        
          this.applicationWrapper.resume(call);
    }

    public void revert(final com.veyron2.ipc.ServerCall call) throws com.veyron2.ipc.VeyronException {
        
          this.applicationWrapper.revert(call);
    }

    public void suspend(final com.veyron2.ipc.ServerCall call) throws com.veyron2.ipc.VeyronException {
        
          this.applicationWrapper.suspend(call);
    }

    public void uninstall(final com.veyron2.ipc.ServerCall call) throws com.veyron2.ipc.VeyronException {
        
          this.applicationWrapper.uninstall(call);
    }

    public void updateTo(final com.veyron2.ipc.ServerCall call, final java.lang.String Name) throws com.veyron2.ipc.VeyronException {
        
          this.applicationWrapper.updateTo(call, Name);
    }

    public void restart(final com.veyron2.ipc.ServerCall call) throws com.veyron2.ipc.VeyronException {
        
          this.applicationWrapper.restart(call);
    }
 

}
