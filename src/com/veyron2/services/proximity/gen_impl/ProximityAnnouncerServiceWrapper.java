// This file was auto-generated by the veyron vdl tool.
// Source(s):  proximity.vdl
package com.veyron2.services.proximity.gen_impl;

import com.veyron2.ipc.ServerCall;
import com.veyron2.ipc.VeyronException;
import com.veyron2.services.proximity.Device;
import com.veyron2.services.proximity.Proximity;
import com.veyron2.services.proximity.ProximityAnnouncer;
import com.veyron2.services.proximity.ProximityAnnouncerFactory;
import com.veyron2.services.proximity.ProximityAnnouncerService;
import com.veyron2.services.proximity.ProximityFactory;
import com.veyron2.services.proximity.ProximityScanner;
import com.veyron2.services.proximity.ProximityScannerFactory;
import com.veyron2.services.proximity.ProximityScannerService;
import com.veyron2.services.proximity.ProximityService;

public class ProximityAnnouncerServiceWrapper {

	private final ProximityAnnouncerService service;

	public ProximityAnnouncerServiceWrapper(ProximityAnnouncerService service) {
		this.service = service;
	}
	/**
	 * Returns all tags associated with the provided method or null if the method isn't implemented
	 * by this service.
	 */
	public Object[] getMethodTags(ServerCall call, String method) { 
		if (method == "RegisterName") {
			return new Object[]{ new com.veyron2.security.Label(2) };
		}
		if (method == "UnregisterName") {
			return new Object[]{ new com.veyron2.security.Label(2) };
		}
		return null;
	}
	// Methods from interface ProximityAnnouncer.
	public void registerName(ServerCall call, String Name) throws VeyronException { 
		this.service.registerName(call, Name);
	}
	public void unregisterName(ServerCall call, String Name) throws VeyronException { 
		this.service.unregisterName(call, Name);
	}
}
