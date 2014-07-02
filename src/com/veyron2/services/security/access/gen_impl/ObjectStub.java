// This file was auto-generated by the veyron vdl tool.
// Source(s):  service.vdl
package com.veyron2.services.security.access.gen_impl;

import com.veyron2.services.security.access.ACL;
import com.veyron2.services.security.access.Entries;
import com.veyron2.services.security.access.Group;
import com.veyron2.services.security.access.Object;
import com.veyron2.services.security.access.ObjectFactory;
import com.veyron2.services.security.access.ObjectService;

/* Client stub for interface: Object. */
public final class ObjectStub implements Object {
	private static final java.lang.String vdlIfacePathOpt = "com.veyron2.services.security.access.gen_impl.Object";
	private final com.veyron2.ipc.Client client;
	private final java.lang.String name;

	public ObjectStub(com.veyron2.ipc.Client client, java.lang.String name) {
		this.client = client;
		this.name = name;
	}
	// Methods from interface Object.
	@Override
	public void setACL(com.veyron2.ipc.Context context, ACL acl, java.lang.String etag) throws com.veyron2.ipc.VeyronException {
		setACL(context, acl, etag, null);
	}
	@Override
	public void setACL(com.veyron2.ipc.Context context, ACL acl, java.lang.String etag, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Prepare input arguments.
		final java.lang.Object[] inArgs = new java.lang.Object[]{ acl, etag };

		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
		// Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, ObjectStub.vdlIfacePathOpt);
		}

		// Start the call.
		final com.veyron2.ipc.Client.Call call = this.client.startCall(context, this.name, "SetACL", inArgs, veyronOpts);

		// Prepare output argument and finish the call.
			final com.google.common.reflect.TypeToken<?>[] resultTypes = new com.google.common.reflect.TypeToken<?>[]{  };
			call.finish(resultTypes);

	}
	@Override
	public Object.GetACLOut getACL(com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException {
		return getACL(context, null);
	}
	@Override
	public Object.GetACLOut getACL(com.veyron2.ipc.Context context, com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException {
		// Prepare input arguments.
		final java.lang.Object[] inArgs = new java.lang.Object[]{  };

		// Add VDL path option.
		// NOTE(spetrovic): this option is temporary and will be removed soon after we switch
		// Java to encoding/decoding from vom.Value objects.
		if (veyronOpts == null) veyronOpts = new com.veyron2.Options();
		if (!veyronOpts.has(com.veyron2.OptionDefs.VDL_INTERFACE_PATH)) {
			veyronOpts.set(com.veyron2.OptionDefs.VDL_INTERFACE_PATH, ObjectStub.vdlIfacePathOpt);
		}

		// Start the call.
		final com.veyron2.ipc.Client.Call call = this.client.startCall(context, this.name, "GetACL", inArgs, veyronOpts);

		// Prepare output argument and finish the call.
			final com.google.common.reflect.TypeToken<?>[] resultTypes = new com.google.common.reflect.TypeToken<?>[]{ new com.google.common.reflect.TypeToken<ACL>() {}, new com.google.common.reflect.TypeToken<java.lang.String>() {} };
			final java.lang.Object[] results = call.finish(resultTypes);
			// Pack the results.
			final Object.GetACLOut ret = new Object.GetACLOut();
			int resultIdx = 0;
			ret.acl = (ACL)results[resultIdx++];
			ret.etag = (java.lang.String)results[resultIdx++];
			return ret;

	}
}
