// This file was auto-generated by the veyron vdl tool.
// Source(s):  service.vdl
package com.veyron.examples.rockpaperscissors.gen_impl;

/* Client stub for interface: Player. */
public final class PlayerStub implements com.veyron.examples.rockpaperscissors.Player {
    private static final java.lang.String vdlIfacePathOpt = "com.veyron.examples.rockpaperscissors.Player";
    private final com.veyron2.ipc.Client client;
    private final java.lang.String veyronName;

    
    

    public PlayerStub(final com.veyron2.ipc.Client client, final java.lang.String veyronName) {
        this.client = client;
        this.veyronName = veyronName;
        
        
    }

    // Methods from interface Player.


    
    public void challenge(final com.veyron2.ipc.Context context, final java.lang.String Address, final com.veyron.examples.rockpaperscissors.GameID ID, final com.veyron.examples.rockpaperscissors.GameOptions Opts) throws com.veyron2.ipc.VeyronException {
         challenge(context, Address, ID, Opts, null);
    }
    
    public void challenge(final com.veyron2.ipc.Context context, final java.lang.String Address, final com.veyron.examples.rockpaperscissors.GameID ID, final com.veyron.examples.rockpaperscissors.GameOptions Opts, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
        
        // Add VDL path option.
        // NOTE(spetrovic): this option is temporary and will be removed soon after we switch
        // Java to encoding/decoding from vom.Value objects.
        if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
        if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
            veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, PlayerStub.vdlIfacePathOpt);
        }

        
        // Start the call.
        final java.lang.Object[] inArgs = new java.lang.Object[]{ Address, ID, Opts };
        final com.veyron2.ipc.Client.Call call = this.client.startCall(context, this.veyronName, "challenge", inArgs, veyronOpts);

        // Finish the call.
        
        

        
        final com.google.common.reflect.TypeToken<?>[] resultTypes = new com.google.common.reflect.TypeToken<?>[]{};
        call.finish(resultTypes);
         

        
    }





}
