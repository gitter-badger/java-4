
// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron.examples.rockpaperscissors;


public final class PlayerAction { 
		private String move; // The move that the player wants to make.
		private boolean quit; // Whether the player wants to quit the game.

	public PlayerAction(String move, boolean quit) { 
		this.move = move;
		this.quit = quit;
	}
	public String getMove() { return this.move; }
	public boolean getQuit() { return this.quit; }

	public void setMove(String move) { this.move = move; }
	public void setQuit(boolean quit) { this.quit = quit; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		final PlayerAction other = (PlayerAction)obj;
		if (!(this.move.equals(other.move))) return false;
		if (this.quit != other.quit) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + (move == null ? 0 : move.hashCode());
		result = prime * result + Boolean.valueOf(quit).hashCode();
		return result;
	}
}
