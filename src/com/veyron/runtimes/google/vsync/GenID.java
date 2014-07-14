
// This file was auto-generated by the veyron vdl tool.
// Source: vsync.vdl
package com.veyron.runtimes.google.vsync;


/**
 * GenID is the unique ID per generation per device.
**/
public final class GenID { 
		private long value;

	public GenID(long value) { 
		this.value = value;
	}
	public long getValue() { return this.value; }

	public void setValue(long value) { this.value = value; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (!(obj instanceof GenID)) return false;
		final GenID other = (GenID)obj;
		if (this.value != other.value) return false;
		return true;
	}
}
