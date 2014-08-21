// This file was auto-generated by the veyron vdl tool.
// Source(s):  service.vdl
package com.veyron.services.store.raw.gen_impl;

public final class StoreServiceWrapper {

    private final com.veyron.services.store.raw.StoreService service;




    public StoreServiceWrapper(final com.veyron.services.store.raw.StoreService service) {
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
        
        if ("putMutations".equals(method)) {
            return new java.lang.Object[] {
                
            };
        }
        
        if ("watch".equals(method)) {
            return new java.lang.Object[] {
                
            };
        }
        
        
        throw new com.veyron2.ipc.VeyronException("method: " + method + " not found");
    }

     
    
    public void watch(final com.veyron2.ipc.ServerCall call, final com.veyron.services.store.raw.Request Req) throws com.veyron2.ipc.VeyronException {
        
        final com.veyron2.vdl.Stream<java.lang.Void, com.veyron2.services.watch.types.ChangeBatch> stream = new com.veyron2.vdl.Stream<java.lang.Void, com.veyron2.services.watch.types.ChangeBatch>() {
            @Override
            public void send(java.lang.Void item) throws com.veyron2.ipc.VeyronException {
                call.send(item);
            }
            @Override
            public com.veyron2.services.watch.types.ChangeBatch recv() throws java.io.EOFException, com.veyron2.ipc.VeyronException {
                final com.google.common.reflect.TypeToken<?> type = new com.google.common.reflect.TypeToken< com.veyron2.services.watch.types.ChangeBatch >() {
                    private static final long serialVersionUID = 1L;
                };
                final java.lang.Object result = call.recv(type);
                try {
                    return (com.veyron2.services.watch.types.ChangeBatch)result;
                } catch (java.lang.ClassCastException e) {
                    throw new com.veyron2.ipc.VeyronException("Unexpected result type: " + result.getClass().getCanonicalName());
                }
            }
        };
         
         this.service.watch( call , Req  ,stream  );
    }

    public void putMutations(final com.veyron2.ipc.ServerCall call) throws com.veyron2.ipc.VeyronException {
        
        final com.veyron2.vdl.Stream<com.veyron.services.store.raw.Mutation, java.lang.Void> stream = new com.veyron2.vdl.Stream<com.veyron.services.store.raw.Mutation, java.lang.Void>() {
            @Override
            public void send(com.veyron.services.store.raw.Mutation item) throws com.veyron2.ipc.VeyronException {
                call.send(item);
            }
            @Override
            public java.lang.Void recv() throws java.io.EOFException, com.veyron2.ipc.VeyronException {
                final com.google.common.reflect.TypeToken<?> type = new com.google.common.reflect.TypeToken< java.lang.Void >() {
                    private static final long serialVersionUID = 1L;
                };
                final java.lang.Object result = call.recv(type);
                try {
                    return (java.lang.Void)result;
                } catch (java.lang.ClassCastException e) {
                    throw new com.veyron2.ipc.VeyronException("Unexpected result type: " + result.getClass().getCanonicalName());
                }
            }
        };
         
         this.service.putMutations( call   ,stream  );
    }



 

}
