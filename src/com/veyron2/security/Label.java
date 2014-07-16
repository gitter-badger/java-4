
// This file was auto-generated by the veyron vdl tool.
// Source: types.vdl
package com.veyron2.security;


/**
 * Label is an access control right, like Read, Write, Admin, etc.
**/
public final class Label { 
		private int value;

	public Label(int value) { 
		this.value = value;
	}
	public int getValue() { return this.value; }

	public void setValue(int value) { this.value = value; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		final Label other = (Label)obj;
		if (this.value != other.value) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + value;
		return result;
	}
}
