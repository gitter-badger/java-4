// This file was auto-generated by the veyron vdl tool.
// Source(s):  build.vdl
package com.veyron2.services.mgmt.build.gen_impl;

import com.veyron2.ipc.ServerCall;
import com.veyron2.ipc.VeyronException;
import com.veyron2.services.mgmt.build.BinaryDescription;
import com.veyron2.services.mgmt.build.Build;
import com.veyron2.services.mgmt.build.BuildFactory;
import com.veyron2.services.mgmt.build.BuildService;

public class BuildServiceWrapper {

	private final BuildService service;

	public BuildServiceWrapper(BuildService service) {
		this.service = service;
	}
	/**
	 * Returns all tags associated with the provided method or null if the method isn't implemented
	 * by this service.
	 */
	public Object[] getMethodTags(ServerCall call, String method) { 
		if (method == "Describe") {
			return new Object[]{  };
		}
		return null;
	}
	// Methods from interface Build.
	public BinaryDescription describe(ServerCall call, String Name) throws VeyronException { 
		return this.service.describe(call, Name);
	}
}
