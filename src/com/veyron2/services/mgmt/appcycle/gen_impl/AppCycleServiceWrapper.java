// This file was auto-generated by the veyron vdl tool.
// Source(s):  appcycle.vdl
package com.veyron2.services.mgmt.appcycle.gen_impl;

import com.google.common.reflect.TypeToken;
import com.veyron2.ipc.ServerCall;
import com.veyron2.ipc.VeyronException;
import com.veyron2.services.mgmt.appcycle.AppCycle;
import com.veyron2.services.mgmt.appcycle.AppCycleFactory;
import com.veyron2.services.mgmt.appcycle.AppCycleService;
import com.veyron2.services.mgmt.appcycle.Task;
import com.veyron2.vdl.Stream;

public class AppCycleServiceWrapper {

	private final AppCycleService service;

	public AppCycleServiceWrapper(AppCycleService service) {
		this.service = service;
	}
	/**
	 * Returns all tags associated with the provided method or null if the method isn't implemented
	 * by this service.
	 */
	public Object[] getMethodTags(ServerCall call, String method) { 
		if ("stop".equals(method)) {
			return new Object[]{  };
		}
		if ("forceStop".equals(method)) {
			return new Object[]{  };
		}
		return null;
	}
	// Methods from interface AppCycle.
	public void stop(ServerCall call) throws VeyronException { 
		final ServerCall serverCall = call;
		final Stream<Task,Void> stream = new Stream<Task,Void>() {
			@Override
			public void send(Task item) throws VeyronException {
				serverCall.send(item);
			}
			@Override
			public Void recv() throws java.io.EOFException, VeyronException {
				final TypeToken<?> type = new TypeToken<Void>() {};
				final Object result = serverCall.recv(type);
				try {
					return (Void)result;
				} catch (java.lang.ClassCastException e) {
					throw new VeyronException("Unexpected result type: " + result.getClass().getCanonicalName());
				}
			}
		};
		this.service.stop(call, stream);
	}
	public void forceStop(ServerCall call) throws VeyronException { 
		this.service.forceStop(call);
	}
}
