
// This file was auto-generated by the veyron vdl tool.
// Source: wire.vdl
package com.veyron2.security.wire;

import java.util.ArrayList;

/**
 * Certificate is a signed assertion binding a name to a public key under a certain set
 * of caveats. The issuer of a Certificate is the principal that possesses the private key
 * under which the Certificate was signed. The Certificate's signature is over the contents
 * of the Certificate along with the Signature of the issuer.
**/
public final class Certificate { 
	// Name specified in the certificate, e.g., Alice, Bob. Name must not have the
// character "/".
	private String name;
	// PublicKey is the ECDSA public key associated with the Certificate.
	private PublicKey publicKey;
	// Caveats under which the certificate is valid.
	private ArrayList<Caveat> caveats;
	// Signature of the contents of the certificate.
	private Signature signature;

	public Certificate(String name, PublicKey publicKey, ArrayList<Caveat> caveats, Signature signature) { 
		this.name = name;
		this.publicKey = publicKey;
		this.caveats = caveats;
		this.signature = signature;
	}
	public String getName() { return this.name; }
	public PublicKey getPublicKey() { return this.publicKey; }
	public ArrayList<Caveat> getCaveats() { return this.caveats; }
	public Signature getSignature() { return this.signature; }

	public void setName(String name) { this.name = name; }
	public void setPublicKey(PublicKey publicKey) { this.publicKey = publicKey; }
	public void setCaveats(ArrayList<Caveat> caveats) { this.caveats = caveats; }
	public void setSignature(Signature signature) { this.signature = signature; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (!(obj instanceof Certificate)) return false;
		final Certificate other = (Certificate)obj;
		if (!(this.name.equals(other.name))) return false;
		if (!(this.publicKey.equals(other.publicKey))) return false;
		if (!(this.caveats.equals(other.caveats))) return false;
		if (!(this.signature.equals(other.signature))) return false;
		return true;
	}
}
