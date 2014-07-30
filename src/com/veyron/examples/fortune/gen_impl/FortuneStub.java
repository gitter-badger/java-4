// This file was auto-generated by the veyron vdl tool.
// Source(s):  fortune.vdl
package com.veyron.examples.fortune.gen_impl;

/* Client stub for interface: Fortune. */
public final class FortuneStub implements com.veyron.examples.fortune.Fortune {
    private static final java.lang.String vdlIfacePathOpt = "com.veyron.examples.fortune.Fortune";
    private final com.veyron2.ipc.Client client;
    private final java.lang.String veyronName;

    
    

    public FortuneStub(final com.veyron2.ipc.Client client, final java.lang.String veyronName) {
        this.client = client;
        this.veyronName = veyronName;
        
        
    }

    // Methods from interface Fortune.


    
    public java.lang.String get(final com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException {
        return get(context, null);
    }
    
    public java.lang.String get(final com.veyron2.ipc.Context context, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
        
        // Add VDL path option.
        // NOTE(spetrovic): this option is temporary and will be removed soon after we switch
        // Java to encoding/decoding from vom.Value objects.
        if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
        if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
            veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, FortuneStub.vdlIfacePathOpt);
        }

        
        // Start the call.
        final java.lang.Object[] inArgs = new java.lang.Object[]{  };
        final com.veyron2.ipc.Client.Call call = this.client.startCall(context, this.veyronName, "Glob", inArgs, veyronOpts);

        // Finish the call.
        
        

         
        final com.google.common.reflect.TypeToken<?>[] resultTypes = new com.google.common.reflect.TypeToken<?>[]{
            
            new com.google.common.reflect.TypeToken<java.lang.String>() {
                private static final long serialVersionUID = 1L;
            },
            
        };
        final java.lang.Object[] results = call.finish(resultTypes);
         
        return (java.lang.String)results[0];
         

         

        
    }

    
    public void add(final com.veyron2.ipc.Context context, final java.lang.String Fortune) throws com.veyron2.ipc.VeyronException {
         add(context, Fortune, null);
    }
    
    public void add(final com.veyron2.ipc.Context context, final java.lang.String Fortune, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
        
        // Add VDL path option.
        // NOTE(spetrovic): this option is temporary and will be removed soon after we switch
        // Java to encoding/decoding from vom.Value objects.
        if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
        if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
            veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, FortuneStub.vdlIfacePathOpt);
        }

        
        // Start the call.
        final java.lang.Object[] inArgs = new java.lang.Object[]{ Fortune };
        final com.veyron2.ipc.Client.Call call = this.client.startCall(context, this.veyronName, "Glob", inArgs, veyronOpts);

        // Finish the call.
        
        

        
        final com.google.common.reflect.TypeToken<?>[] resultTypes = new com.google.common.reflect.TypeToken<?>[]{};
        call.finish(resultTypes);
         

        
    }





}
