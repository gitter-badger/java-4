// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron.examples.rockpaperscissors;

/**
 * Player can receive challenges from other players.
 */

@com.veyron2.vdl.VeyronService(serviceWrapper=com.veyron.examples.rockpaperscissors.gen_impl.PlayerServiceWrapper.class)
public interface PlayerService  {

    
    // Challenge is used by other players to challenge this player to a game. If
// the challenge is accepted, the method returns nil.

    public void challenge(final com.veyron2.ipc.ServerContext context, final java.lang.String Address, final com.veyron.examples.rockpaperscissors.GameID ID, final com.veyron.examples.rockpaperscissors.GameOptions Opts) throws com.veyron2.ipc.VeyronException;

}
