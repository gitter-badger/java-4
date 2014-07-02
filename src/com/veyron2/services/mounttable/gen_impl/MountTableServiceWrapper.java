// This file was auto-generated by the veyron vdl tool.
// Source(s):  service.vdl
package com.veyron2.services.mounttable.gen_impl;

import com.veyron2.ipc.ServerCall;
import com.veyron2.ipc.VeyronException;
import com.veyron2.services.mounttable.Globable;
import com.veyron2.services.mounttable.GlobableFactory;
import com.veyron2.services.mounttable.GlobableService;
import com.veyron2.services.mounttable.MountEntry;
import com.veyron2.services.mounttable.MountTable;
import com.veyron2.services.mounttable.MountTableFactory;
import com.veyron2.services.mounttable.MountTableService;
import com.veyron2.services.mounttable.MountedServer;
import com.veyron2.vdl.Stream;
import java.util.ArrayList;

public class MountTableServiceWrapper {

	private final MountTableService service;
	private final GlobableServiceWrapper globable;

	public MountTableServiceWrapper(MountTableService service) {
		this.globable = new GlobableServiceWrapper(service);
		this.service = service;
	}
	/**
	 * Returns all tags associated with the provided method or null if the method isn't implemented
	 * by this service.
	 */
	public Object[] getMethodTags(ServerCall call, String method) { 
		{
			final Object[] tags = this.globable.getMethodTags(call, method);
			if (tags != null) return tags;
		}
		if (method == "Mount") {
			return new Object[]{ 2 };
		}
		if (method == "Unmount") {
			return new Object[]{ 2 };
		}
		if (method == "ResolveStep") {
			return new Object[]{ 1 };
		}
		return null;
	}
	// Methods from interface MountTable.
	public void mount(ServerCall call, String Server, int TTL) throws VeyronException { 
		this.service.mount(call, Server, TTL);
	}
	public void unmount(ServerCall call, String Server) throws VeyronException { 
		this.service.unmount(call, Server);
	}
	public MountTableService.ResolveStepOut resolveStep(ServerCall call) throws VeyronException { 
		return this.service.resolveStep(call);
	}
	// Methods from sub-interface Globable.
	public void glob(ServerCall call, String pattern) throws VeyronException {
		this.globable.glob(call, pattern);
	}
}
