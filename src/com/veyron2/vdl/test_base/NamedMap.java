
// This file was auto-generated by the veyron vdl tool.
// Source: base.vdl
package com.veyron2.vdl.test_base;

import java.util.HashMap;

/**
 *NamedSet        set[string]
**/
public final class NamedMap { 
		private HashMap<String, Float> value;

	public NamedMap(HashMap<String, Float> value) { 
		this.value = value;
	}
	public HashMap<String, Float> getValue() { return this.value; }

	public void setValue(HashMap<String, Float> value) { this.value = value; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (!(obj instanceof NamedMap)) return false;
		final NamedMap other = (NamedMap)obj;
		if (!(this.value.equals(other.value))) return false;
		return true;
	}
}
