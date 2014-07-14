// This file was auto-generated by the veyron vdl tool.
// Source(s):  node.vdl
package com.veyron2.services.mgmt.node.gen_impl;

import com.veyron2.services.mgmt.node.Application;
import com.veyron2.services.mgmt.node.ApplicationFactory;
import com.veyron2.services.mgmt.node.ApplicationService;
import com.veyron2.services.mgmt.node.Description;
import com.veyron2.services.mgmt.node.Node;
import com.veyron2.services.mgmt.node.NodeFactory;
import com.veyron2.services.mgmt.node.NodeService;

/* Client stub for interface: Node. */
public final class NodeStub implements Node {
	private static final java.lang.String vdlIfacePathOpt = "com.veyron2.services.mgmt.node.Node";
	private final com.veyron2.ipc.Client client;
	private final java.lang.String name;
	private final Application application;

	public NodeStub(com.veyron2.ipc.Client client, java.lang.String name) {
		this.client = client;
		this.name = name;
		this.application = new com.veyron2.services.mgmt.node.gen_impl.ApplicationStub(client, name);
	}
	// Methods from interface Node.
	@Override
	public Description describe(com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException {
		return describe(context, null);
	}
	@Override
	public Description describe(com.veyron2.ipc.Context context, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Prepare input arguments.
		final java.lang.Object[] inArgs = new java.lang.Object[]{  };

		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
		// Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, NodeStub.vdlIfacePathOpt);
		}

		// Start the call.
		final com.veyron2.ipc.Client.Call call = this.client.startCall(context, this.name, "Describe", inArgs, veyronOpts);

		// Prepare output argument and finish the call.
			final com.google.common.reflect.TypeToken<?>[] resultTypes = new com.google.common.reflect.TypeToken<?>[]{ new com.google.common.reflect.TypeToken<Description>() {} };
			return (Description)call.finish(resultTypes)[0];

	}
	@Override
	public boolean isRunnable(com.veyron2.ipc.Context context, com.veyron2.services.mgmt.build.BinaryDescription Binary) throws com.veyron2.ipc.VeyronException {
		return isRunnable(context, Binary, null);
	}
	@Override
	public boolean isRunnable(com.veyron2.ipc.Context context, com.veyron2.services.mgmt.build.BinaryDescription Binary, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Prepare input arguments.
		final java.lang.Object[] inArgs = new java.lang.Object[]{ Binary };

		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
		// Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, NodeStub.vdlIfacePathOpt);
		}

		// Start the call.
		final com.veyron2.ipc.Client.Call call = this.client.startCall(context, this.name, "IsRunnable", inArgs, veyronOpts);

		// Prepare output argument and finish the call.
			final com.google.common.reflect.TypeToken<?>[] resultTypes = new com.google.common.reflect.TypeToken<?>[]{ new com.google.common.reflect.TypeToken<java.lang.Boolean>() {} };
			return (java.lang.Boolean)call.finish(resultTypes)[0];

	}
	@Override
	public void reset(com.veyron2.ipc.Context context, long Deadline) throws com.veyron2.ipc.VeyronException {
		reset(context, Deadline, null);
	}
	@Override
	public void reset(com.veyron2.ipc.Context context, long Deadline, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Prepare input arguments.
		final java.lang.Object[] inArgs = new java.lang.Object[]{ new java.lang.Long(Deadline) };

		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
		// Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, NodeStub.vdlIfacePathOpt);
		}

		// Start the call.
		final com.veyron2.ipc.Client.Call call = this.client.startCall(context, this.name, "Reset", inArgs, veyronOpts);

		// Prepare output argument and finish the call.
			final com.google.common.reflect.TypeToken<?>[] resultTypes = new com.google.common.reflect.TypeToken<?>[]{  };
			call.finish(resultTypes);

	}
	// Methods from sub-interface Application.
	@Override
	public java.lang.String install(com.veyron2.ipc.Context context, java.lang.String Name) throws com.veyron2.ipc.VeyronException {
		return install(context, Name, null);
	}
	@Override
	public java.lang.String install(com.veyron2.ipc.Context context, java.lang.String Name, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
	    // Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, NodeStub.vdlIfacePathOpt);
		}
		return this.application.install(context, Name, veyronOpts);
	}
	@Override
	public void refresh(com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException {
		refresh(context, null);
	}
	@Override
	public void refresh(com.veyron2.ipc.Context context, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
	    // Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, NodeStub.vdlIfacePathOpt);
		}
		this.application.refresh(context, veyronOpts);
	}
	@Override
	public void restart(com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException {
		restart(context, null);
	}
	@Override
	public void restart(com.veyron2.ipc.Context context, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
	    // Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, NodeStub.vdlIfacePathOpt);
		}
		this.application.restart(context, veyronOpts);
	}
	@Override
	public void resume(com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException {
		resume(context, null);
	}
	@Override
	public void resume(com.veyron2.ipc.Context context, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
	    // Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, NodeStub.vdlIfacePathOpt);
		}
		this.application.resume(context, veyronOpts);
	}
	@Override
	public void revert(com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException {
		revert(context, null);
	}
	@Override
	public void revert(com.veyron2.ipc.Context context, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
	    // Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, NodeStub.vdlIfacePathOpt);
		}
		this.application.revert(context, veyronOpts);
	}
	@Override
	public java.util.ArrayList<java.lang.String> start(com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException {
		return start(context, null);
	}
	@Override
	public java.util.ArrayList<java.lang.String> start(com.veyron2.ipc.Context context, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
	    // Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, NodeStub.vdlIfacePathOpt);
		}
		return this.application.start(context, veyronOpts);
	}
	@Override
	public void stop(com.veyron2.ipc.Context context, long Deadline) throws com.veyron2.ipc.VeyronException {
		stop(context, Deadline, null);
	}
	@Override
	public void stop(com.veyron2.ipc.Context context, long Deadline, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
	    // Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, NodeStub.vdlIfacePathOpt);
		}
		this.application.stop(context, Deadline, veyronOpts);
	}
	@Override
	public void suspend(com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException {
		suspend(context, null);
	}
	@Override
	public void suspend(com.veyron2.ipc.Context context, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
	    // Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, NodeStub.vdlIfacePathOpt);
		}
		this.application.suspend(context, veyronOpts);
	}
	@Override
	public void uninstall(com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException {
		uninstall(context, null);
	}
	@Override
	public void uninstall(com.veyron2.ipc.Context context, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
	    // Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, NodeStub.vdlIfacePathOpt);
		}
		this.application.uninstall(context, veyronOpts);
	}
	@Override
	public void update(com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException {
		update(context, null);
	}
	@Override
	public void update(com.veyron2.ipc.Context context, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
	    // Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, NodeStub.vdlIfacePathOpt);
		}
		this.application.update(context, veyronOpts);
	}
	@Override
	public void updateTo(com.veyron2.ipc.Context context, java.lang.String Name) throws com.veyron2.ipc.VeyronException {
		updateTo(context, Name, null);
	}
	@Override
	public void updateTo(com.veyron2.ipc.Context context, java.lang.String Name, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
	    // Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, NodeStub.vdlIfacePathOpt);
		}
		this.application.updateTo(context, Name, veyronOpts);
	}
}
