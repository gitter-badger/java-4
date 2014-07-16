
// This file was auto-generated by the veyron vdl tool.
// Source: base.vdl
package com.veyron2.vdl.test_base;


public final class NamedFloat32 { 
		private float value;

	public NamedFloat32(float value) { 
		this.value = value;
	}
	public float getValue() { return this.value; }

	public void setValue(float value) { this.value = value; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		final NamedFloat32 other = (NamedFloat32)obj;
		if (this.value != other.value) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + Float.valueOf(value).hashCode();
		return result;
	}
}
