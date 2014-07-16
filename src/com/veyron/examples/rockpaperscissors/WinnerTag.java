
// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron.examples.rockpaperscissors;


/**
 * WinnerTag is a type used to indicate whether a round or a game was a draw,
 * was won by player 1 or was won by player 2.
**/
public final class WinnerTag { 
		private byte value;

	public WinnerTag(byte value) { 
		this.value = value;
	}
	public byte getValue() { return this.value; }

	public void setValue(byte value) { this.value = value; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		final WinnerTag other = (WinnerTag)obj;
		if (this.value != other.value) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + (int)value;
		return result;
	}
}
