// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron.examples.rockpaperscissors;

import com.veyron.examples.rockpaperscissors.gen_impl.JudgeServiceWrapper;
import com.veyron2.ipc.ServerContext;
import com.veyron2.ipc.VeyronException;
import com.veyron2.vdl.Stream;
import com.veyron2.vdl.VeyronService;

@VeyronService(stubWrapper=JudgeServiceWrapper.class)
public interface JudgeService { 
	// CreateGame creates a new game with the given game options and returns a game
// identifier that can be used by the players to join the game.
	public GameID createGame(ServerContext context, GameOptions opts) throws VeyronException;
	// Play lets a player join an existing game and play.
	public PlayResult play(ServerContext context, GameID iD, Stream<JudgeAction,PlayerAction> stream) throws VeyronException;
}
