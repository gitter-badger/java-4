// This file was auto-generated by the veyron vdl tool.
// Source(s):  service.vdl
package com.veyron2.services.security.access.gen_impl;

/* Client stub for interface: Object. */
public final class ObjectStub implements com.veyron2.services.security.access.Object {
    private static final java.lang.String vdlIfacePathOpt = "com.veyron2.services.security.access.Object";
    private final com.veyron2.ipc.Client client;
    private final java.lang.String veyronName;

    
    

    public ObjectStub(final com.veyron2.ipc.Client client, final java.lang.String veyronName) {
        this.client = client;
        this.veyronName = veyronName;
        
        
    }

    // Methods from interface Object.


    
    public void setACL(final com.veyron2.ipc.Context context, final com.veyron2.services.security.access.ACL acl, final java.lang.String etag) throws com.veyron2.ipc.VeyronException {
         setACL(context, acl, etag, null);
    }
    
    public void setACL(final com.veyron2.ipc.Context context, final com.veyron2.services.security.access.ACL acl, final java.lang.String etag, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
        
        // Add VDL path option.
        // NOTE(spetrovic): this option is temporary and will be removed soon after we switch
        // Java to encoding/decoding from vom.Value objects.
        if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
        if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
            veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, ObjectStub.vdlIfacePathOpt);
        }

        
        // Start the call.
        final java.lang.Object[] inArgs = new java.lang.Object[]{ acl, etag };
        final com.veyron2.ipc.Client.Call call = this.client.startCall(context, this.veyronName, "Glob", inArgs, veyronOpts);

        // Finish the call.
        
        

        
        final com.google.common.reflect.TypeToken<?>[] resultTypes = new com.google.common.reflect.TypeToken<?>[]{};
        call.finish(resultTypes);
         

        
    }

    
    public com.veyron2.services.security.access.Object.GetACLOut getACL(final com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException {
        return getACL(context, null);
    }
    
    public com.veyron2.services.security.access.Object.GetACLOut getACL(final com.veyron2.ipc.Context context, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
        
        // Add VDL path option.
        // NOTE(spetrovic): this option is temporary and will be removed soon after we switch
        // Java to encoding/decoding from vom.Value objects.
        if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
        if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
            veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, ObjectStub.vdlIfacePathOpt);
        }

        
        // Start the call.
        final java.lang.Object[] inArgs = new java.lang.Object[]{  };
        final com.veyron2.ipc.Client.Call call = this.client.startCall(context, this.veyronName, "Glob", inArgs, veyronOpts);

        // Finish the call.
        
        

         
        final com.google.common.reflect.TypeToken<?>[] resultTypes = new com.google.common.reflect.TypeToken<?>[]{
            
            new com.google.common.reflect.TypeToken<com.veyron2.services.security.access.ACL>() {
                private static final long serialVersionUID = 1L;
            },
            
            new com.google.common.reflect.TypeToken<java.lang.String>() {
                private static final long serialVersionUID = 1L;
            },
            
        };
        final java.lang.Object[] results = call.finish(resultTypes);
        
        final com.veyron2.services.security.access.Object.GetACLOut ret = new com.veyron2.services.security.access.Object.GetACLOut();
            
        ret.acl = (com.veyron2.services.security.access.ACL)results[0];
            
        ret.etag = (java.lang.String)results[1];
             
        return ret;
         

         

        
    }





}
