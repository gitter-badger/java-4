// This file was auto-generated by the veyron vdl tool.
// Source(s):  build.vdl
package com.veyron2.services.mgmt.build.gen_impl;

import com.veyron2.services.mgmt.build.BinaryDescription;
import com.veyron2.services.mgmt.build.Build;
import com.veyron2.services.mgmt.build.BuildFactory;
import com.veyron2.services.mgmt.build.BuildService;

/* Client stub for interface: Build. */
public final class BuildStub implements Build {
	private static final java.lang.String vdlIfacePathOpt = "com.veyron2.services.mgmt.build.gen_impl.Build";
	private final com.veyron2.ipc.Client client;
	private final java.lang.String name;

	public BuildStub(com.veyron2.ipc.Client client, java.lang.String name) {
		this.client = client;
		this.name = name;
	}
	// Methods from interface Build.
	@Override
	public BinaryDescription describe(com.veyron2.ipc.Context context, java.lang.String Name) throws com.veyron2.ipc.VeyronException {
		return describe(context, Name, null);
	}
	@Override
	public BinaryDescription describe(com.veyron2.ipc.Context context, java.lang.String Name, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Prepare input arguments.
		final java.lang.Object[] inArgs = new java.lang.Object[]{ Name };

		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
		// Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, BuildStub.vdlIfacePathOpt);
		}

		// Start the call.
		final com.veyron2.ipc.Client.Call call = this.client.startCall(context, this.name, "Describe", inArgs, veyronOpts);

		// Prepare output argument and finish the call.
			final com.google.common.reflect.TypeToken<?>[] resultTypes = new com.google.common.reflect.TypeToken<?>[]{ new com.google.common.reflect.TypeToken<BinaryDescription>() {} };
			return (BinaryDescription)call.finish(resultTypes)[0];

	}
}
