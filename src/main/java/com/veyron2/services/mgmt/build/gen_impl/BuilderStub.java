// This file was auto-generated by the veyron vdl tool.
// Source(s):  build.vdl
package com.veyron2.services.mgmt.build.gen_impl;

/* Client stub for interface: Builder. */
public final class BuilderStub implements com.veyron2.services.mgmt.build.Builder {
    private static final java.lang.String vdlIfacePathOpt = "com.veyron2.services.mgmt.build.Builder";
    private final com.veyron2.ipc.Client client;
    private final java.lang.String veyronName;

    
    

    public BuilderStub(final com.veyron2.ipc.Client client, final java.lang.String veyronName) {
        this.client = client;
        this.veyronName = veyronName;
        
        
    }

    // Methods from interface Builder.


    
    public com.veyron2.vdl.ClientStream<com.veyron2.services.mgmt.build.File,com.veyron2.services.mgmt.build.File, java.util.ArrayList<java.lang.Byte>> build(final com.veyron2.ipc.Context context, final com.veyron2.services.mgmt.build.Architecture Arch, final com.veyron2.services.mgmt.build.OperatingSystem OS) throws com.veyron2.ipc.VeyronException {
        return build(context, Arch, OS, null);
    }
    
    public com.veyron2.vdl.ClientStream<com.veyron2.services.mgmt.build.File,com.veyron2.services.mgmt.build.File, java.util.ArrayList<java.lang.Byte>> build(final com.veyron2.ipc.Context context, final com.veyron2.services.mgmt.build.Architecture Arch, final com.veyron2.services.mgmt.build.OperatingSystem OS, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
        
        // Add VDL path option.
        // NOTE(spetrovic): this option is temporary and will be removed soon after we switch
        // Java to encoding/decoding from vom.Value objects.
        if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
        if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
            veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, BuilderStub.vdlIfacePathOpt);
        }

        
        // Start the call.
        final java.lang.Object[] inArgs = new java.lang.Object[]{ Arch, OS };
        final com.veyron2.ipc.Client.Call call = this.client.startCall(context, this.veyronName, "build", inArgs, veyronOpts);

        // Finish the call.
        
         
        return new com.veyron2.vdl.ClientStream<com.veyron2.services.mgmt.build.File, com.veyron2.services.mgmt.build.File, java.util.ArrayList<java.lang.Byte>>() {
            @Override
            public void send(final com.veyron2.services.mgmt.build.File item) throws com.veyron2.ipc.VeyronException {
                call.send(item);
            }
            @Override
            public com.veyron2.services.mgmt.build.File recv() throws java.io.EOFException, com.veyron2.ipc.VeyronException {
                final com.google.common.reflect.TypeToken<?> type = new com.google.common.reflect.TypeToken<com.veyron2.services.mgmt.build.File>() {
                    private static final long serialVersionUID = 1L;
                };
                final java.lang.Object result = call.recv(type);
                try {
                    return (com.veyron2.services.mgmt.build.File)result;
                } catch (java.lang.ClassCastException e) {
                    throw new com.veyron2.ipc.VeyronException("Unexpected result type: " + result.getClass().getCanonicalName());
                }
            }
            @Override
            public java.util.ArrayList<java.lang.Byte> finish() throws com.veyron2.ipc.VeyronException {
                 
                final com.google.common.reflect.TypeToken<?>[] resultTypes = new com.google.common.reflect.TypeToken<?>[]{
                    new com.google.common.reflect.TypeToken<java.util.ArrayList<java.lang.Byte>>() {
                        private static final long serialVersionUID = 1L;
                    }
                };
                return (java.util.ArrayList<java.lang.Byte>)call.finish(resultTypes)[0];
                 
            }
        };
        
    }

    
    public com.veyron2.services.mgmt.binary.Description describe(final com.veyron2.ipc.Context context, final java.lang.String Name) throws com.veyron2.ipc.VeyronException {
        return describe(context, Name, null);
    }
    
    public com.veyron2.services.mgmt.binary.Description describe(final com.veyron2.ipc.Context context, final java.lang.String Name, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
        
        // Add VDL path option.
        // NOTE(spetrovic): this option is temporary and will be removed soon after we switch
        // Java to encoding/decoding from vom.Value objects.
        if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
        if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
            veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, BuilderStub.vdlIfacePathOpt);
        }

        
        // Start the call.
        final java.lang.Object[] inArgs = new java.lang.Object[]{ Name };
        final com.veyron2.ipc.Client.Call call = this.client.startCall(context, this.veyronName, "describe", inArgs, veyronOpts);

        // Finish the call.
        
        

         
        final com.google.common.reflect.TypeToken<?>[] resultTypes = new com.google.common.reflect.TypeToken<?>[]{
            
            new com.google.common.reflect.TypeToken<com.veyron2.services.mgmt.binary.Description>() {
                private static final long serialVersionUID = 1L;
            },
            
        };
        final java.lang.Object[] results = call.finish(resultTypes);
         
        return (com.veyron2.services.mgmt.binary.Description)results[0];
         

         

        
    }





}
