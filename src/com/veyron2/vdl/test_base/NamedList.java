
// This file was auto-generated by the veyron vdl tool.
// Source: base.vdl
package com.veyron2.vdl.test_base;

import java.util.ArrayList;

public final class NamedList { 
		private ArrayList<Integer> value;

	public NamedList(ArrayList<Integer> value) { 
		this.value = value;
	}
	public ArrayList<Integer> getValue() { return this.value; }

	public void setValue(ArrayList<Integer> value) { this.value = value; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		final NamedList other = (NamedList)obj;
		if (!(this.value.equals(other.value))) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + (value == null ? 0 : value.hashCode());
		return result;
	}
}
