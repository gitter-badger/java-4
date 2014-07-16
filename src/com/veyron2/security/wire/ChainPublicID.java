
// This file was auto-generated by the veyron vdl tool.
// Source: wire.vdl
package com.veyron2.security.wire;

import java.util.ArrayList;

/**
 * ChainPublicID represents the chain implementation of PublicIDs from veyron/runtimes/google/security.
 * It consists of a chain of certificates such that each certificate is signed using the private key
 * of the previous certificate (i.e., issuer). The certificate's signature is over its contents along
 * with the signature of the issuer certificate (this is done to bind this certificate to the issuer
 * chain). The first certificate of the chain is "self signed". The last certificate's public key is
 * considered the PublicID's public key. The chain of certificates, if valid, effectively binds a chain
 * of names to the PublicID's public key.
**/
public final class ChainPublicID { 
	// Certificates specifies the chain of certificates for the PublicID.
	private ArrayList<Certificate> certificates;

	public ChainPublicID(ArrayList<Certificate> certificates) { 
		this.certificates = certificates;
	}
	public ArrayList<Certificate> getCertificates() { return this.certificates; }

	public void setCertificates(ArrayList<Certificate> certificates) { this.certificates = certificates; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		final ChainPublicID other = (ChainPublicID)obj;
		if (!(this.certificates.equals(other.certificates))) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + (certificates == null ? 0 : certificates.hashCode());
		return result;
	}
}
