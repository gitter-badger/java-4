
// This file was auto-generated by the veyron vdl tool.
// Source: build.vdl
package com.veyron2.services.mgmt.build;

import java.util.ArrayList;

public final class File { 
		private String name;
		private ArrayList<Byte> contents;

	public File(String name, ArrayList<Byte> contents) { 
		this.name = name;
		this.contents = contents;
	}
	public String getName() { return this.name; }
	public ArrayList<Byte> getContents() { return this.contents; }

	public void setName(String name) { this.name = name; }
	public void setContents(ArrayList<Byte> contents) { this.contents = contents; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		final File other = (File)obj;
		if (!(this.name.equals(other.name))) return false;
		if (!(this.contents.equals(other.contents))) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + (contents == null ? 0 : contents.hashCode());
		return result;
	}
}
