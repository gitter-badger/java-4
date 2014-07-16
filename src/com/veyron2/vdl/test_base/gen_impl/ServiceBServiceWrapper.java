// This file was auto-generated by the veyron vdl tool.
// Source(s):  base.vdl
package com.veyron2.vdl.test_base.gen_impl;

import com.veyron2.ipc.ServerCall;
import com.veyron2.ipc.VeyronException;
import com.veyron2.vdl.Stream;
import com.veyron2.vdl.test_base.Args;
import com.veyron2.vdl.test_base.CompComp;
import com.veyron2.vdl.test_base.Composites;
import com.veyron2.vdl.test_base.NamedStruct;
import com.veyron2.vdl.test_base.NestedArgs;
import com.veyron2.vdl.test_base.Scalars;
import com.veyron2.vdl.test_base.ServiceA;
import com.veyron2.vdl.test_base.ServiceAFactory;
import com.veyron2.vdl.test_base.ServiceAService;
import com.veyron2.vdl.test_base.ServiceB;
import com.veyron2.vdl.test_base.ServiceBFactory;
import com.veyron2.vdl.test_base.ServiceBService;
import com.veyron2.vdl.test_base.VeyronConsts;

public class ServiceBServiceWrapper {

	private final ServiceBService service;
	private final ServiceAServiceWrapper serviceA;

	public ServiceBServiceWrapper(ServiceBService service) {
		this.serviceA = new ServiceAServiceWrapper(service);
		this.service = service;
	}
	/**
	 * Returns all tags associated with the provided method or null if the method isn't implemented
	 * by this service.
	 */
	public Object[] getMethodTags(ServerCall call, String method) { 
		{
			final Object[] tags = this.serviceA.getMethodTags(call, method);
			if (tags != null) return tags;
		}
		if ("methodB1".equals(method)) {
			return new Object[]{  };
		}
		return null;
	}
	// Methods from interface ServiceB.
	public CompComp methodB1(ServerCall call, Scalars a, Composites b) throws VeyronException { 
		return this.service.methodB1(call, a, b);
	}
	// Methods from sub-interface ServiceA.
	public void methodA1(ServerCall call) throws VeyronException {
		this.serviceA.methodA1(call);
	}
	public String methodA2(ServerCall call, int a, String b) throws VeyronException {
		return this.serviceA.methodA2(call, a, b);
	}
	public String methodA3(ServerCall call, int a) throws VeyronException {
		return this.serviceA.methodA3(call, a);
	}
	public void methodA4(ServerCall call, int a) throws VeyronException {
		this.serviceA.methodA4(call, a);
	}
}
