
// This file was auto-generated by the veyron vdl tool.
// Source: profile.vdl
package com.veyron.services.mgmt.profile;


/**
 * Library describes a shared library that applications may use.
**/
public final class Library { 
	// Name is the name of the library.
	private String name;
	// MajorVersion is the major version of the library.
	private String majorVersion;
	// MinorVersion is the minor version of the library.
	private String minorVersion;

	public Library(String name, String majorVersion, String minorVersion) { 
		this.name = name;
		this.majorVersion = majorVersion;
		this.minorVersion = minorVersion;
	}
	public String getName() { return this.name; }
	public String getMajorVersion() { return this.majorVersion; }
	public String getMinorVersion() { return this.minorVersion; }

	public void setName(String name) { this.name = name; }
	public void setMajorVersion(String majorVersion) { this.majorVersion = majorVersion; }
	public void setMinorVersion(String minorVersion) { this.minorVersion = minorVersion; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (!(obj instanceof Library)) return false;
		final Library other = (Library)obj;
		if (!(this.name.equals(other.name))) return false;
		if (!(this.majorVersion.equals(other.majorVersion))) return false;
		if (!(this.minorVersion.equals(other.minorVersion))) return false;
		return true;
	}
}
