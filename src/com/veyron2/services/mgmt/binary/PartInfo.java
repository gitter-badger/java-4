
// This file was auto-generated by the veyron vdl tool.
// Source: binary.vdl
package com.veyron2.services.mgmt.binary;


/**
 * Info holds information describing a binary part.
**/
public final class PartInfo { 
	// Checksum holds the hex-encoded MD5 checksum of the binary part.
	private String checksum;
	// Size holds the binary part size in bytes.
	private long size;

	public PartInfo(String checksum, long size) { 
		this.checksum = checksum;
		this.size = size;
	}
	public String getChecksum() { return this.checksum; }
	public long getSize() { return this.size; }

	public void setChecksum(String checksum) { this.checksum = checksum; }
	public void setSize(long size) { this.size = size; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (!(obj instanceof PartInfo)) return false;
		final PartInfo other = (PartInfo)obj;
		if (!(this.checksum.equals(other.checksum))) return false;
		if (this.size != other.size) return false;
		return true;
	}
}
