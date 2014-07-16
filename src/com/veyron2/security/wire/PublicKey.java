
// This file was auto-generated by the veyron vdl tool.
// Source: wire.vdl
package com.veyron2.security.wire;

import java.util.ArrayList;

/**
 * PublicKey represents an ECDSA PublicKey.
**/
public final class PublicKey { 
	// Curve identifies the curve of an ECDSA PublicKey.
	private KeyCurve curve;
	// XY is the marshaled form of a point on the curve using the format specified
// in section 4.3.6 of ANSI X9.62.
	private ArrayList<Byte> xY;

	public PublicKey(KeyCurve curve, ArrayList<Byte> xY) { 
		this.curve = curve;
		this.xY = xY;
	}
	public KeyCurve getCurve() { return this.curve; }
	public ArrayList<Byte> getXY() { return this.xY; }

	public void setCurve(KeyCurve curve) { this.curve = curve; }
	public void setXY(ArrayList<Byte> xY) { this.xY = xY; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		final PublicKey other = (PublicKey)obj;
		if (!(this.curve.equals(other.curve))) return false;
		if (!(this.xY.equals(other.xY))) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + (curve == null ? 0 : curve.hashCode());
		result = prime * result + (xY == null ? 0 : xY.hashCode());
		return result;
	}
}
