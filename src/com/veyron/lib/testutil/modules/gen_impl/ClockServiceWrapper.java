// This file was auto-generated by the veyron vdl tool.
// Source(s):  servers.vdl
package com.veyron.lib.testutil.modules.gen_impl;

import com.veyron.lib.testutil.modules.Clock;
import com.veyron.lib.testutil.modules.ClockFactory;
import com.veyron.lib.testutil.modules.ClockService;
import com.veyron.lib.testutil.modules.Echo;
import com.veyron.lib.testutil.modules.EchoFactory;
import com.veyron.lib.testutil.modules.EchoService;
import com.veyron2.ipc.ServerCall;
import com.veyron2.ipc.VeyronException;

public class ClockServiceWrapper {

	private final ClockService service;

	public ClockServiceWrapper(ClockService service) {
		this.service = service;
	}
	/**
	 * Returns all tags associated with the provided method or null if the method isn't implemented
	 * by this service.
	 */
	public Object[] getMethodTags(ServerCall call, String method) { 
		if ("time".equals(method)) {
			return new Object[]{  };
		}
		return null;
	}
	// Methods from interface Clock.
	public String time(ServerCall call, String msg) throws VeyronException { 
		return this.service.time(call, msg);
	}
}
