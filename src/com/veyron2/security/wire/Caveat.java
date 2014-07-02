
// This file was auto-generated by the veyron vdl tool.
// Source: wire.vdl
package com.veyron2.security.wire;

import java.util.ArrayList;

/**
 * Caveat represents a veyron2/security.ServiceCaveat.
**/
public class Caveat { 
	// Service is a pattern identifying the services that the caveat encoded in Bytes
// is bound to.
public String service;
	// Bytes is a serialized representation of the embedded caveat.
public ArrayList<Byte> bytes;
}
