
// This file was auto-generated by the veyron vdl tool.
// Source: types.vdl
package com.veyron2.storage;

import java.util.ArrayList;

/**
 * TagList is a labeled list of tags.  Each value in the store can be labeled with
 * a TagList to specify permissions.
**/
public final class TagList { 
		private ArrayList<Tag> value;

	public TagList(ArrayList<Tag> value) { 
		this.value = value;
	}
	public ArrayList<Tag> getValue() { return this.value; }

	public void setValue(ArrayList<Tag> value) { this.value = value; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		final TagList other = (TagList)obj;
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
