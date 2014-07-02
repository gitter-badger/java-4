
// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron.examples.rockpaperscissors;


/**
 * Round represents the state of a round.
**/
public class Round { 
	public String[] moves; // Each player's move.
	public String comment; // A text comment from judge about the round.
	public byte winner; // Who won the round.
	public long startTimeNS; // The time at which the round started.
	public long endTimeNS; // The time at which the round ended.
}
