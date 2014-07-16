
// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron2.services.mounttable;


/**
 * MountedServer represents a server mounted on a specific name.
**/
public final class MountedServer { 
	// Server is the OA that's mounted.
	private String server;
	// TTL is the remaining time (in seconds) before the mount entry expires.
	private int tTL;

	public MountedServer(String server, int tTL) { 
		this.server = server;
		this.tTL = tTL;
	}
	public String getServer() { return this.server; }
	public int getTTL() { return this.tTL; }

	public void setServer(String server) { this.server = server; }
	public void setTTL(int tTL) { this.tTL = tTL; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		final MountedServer other = (MountedServer)obj;
		if (!(this.server.equals(other.server))) return false;
		if (this.tTL != other.tTL) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + (server == null ? 0 : server.hashCode());
		result = prime * result + tTL;
		return result;
	}
}
