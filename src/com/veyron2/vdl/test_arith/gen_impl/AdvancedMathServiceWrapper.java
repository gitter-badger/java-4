// This file was auto-generated by the veyron vdl tool.
// Source(s):  advanced.vdl arith.vdl
package com.veyron2.vdl.test_arith.gen_impl;

import com.veyron2.ipc.ServerCall;
import com.veyron2.ipc.VeyronException;
import com.veyron2.vdl.test_arith.AdvancedMath;
import com.veyron2.vdl.test_arith.AdvancedMathFactory;
import com.veyron2.vdl.test_arith.AdvancedMathService;
import com.veyron2.vdl.test_arith.Arith;
import com.veyron2.vdl.test_arith.ArithFactory;
import com.veyron2.vdl.test_arith.ArithService;
import com.veyron2.vdl.test_arith.Calculator;
import com.veyron2.vdl.test_arith.CalculatorFactory;
import com.veyron2.vdl.test_arith.CalculatorService;
import com.veyron2.vdl.test_arith.Trigonometry;
import com.veyron2.vdl.test_arith.TrigonometryFactory;
import com.veyron2.vdl.test_arith.TrigonometryService;
import com.veyron2.vdl.test_arith.VeyronConsts;
import com.veyron2.vdl.test_arith.exp.ExpService;
import com.veyron2.vdl.test_arith.exp.gen_impl.ExpServiceWrapper;

public class AdvancedMathServiceWrapper {

	private final AdvancedMathService service;
	private final TrigonometryServiceWrapper trigonometry;
	private final ExpServiceWrapper exp;

	public AdvancedMathServiceWrapper(AdvancedMathService service) {
		this.trigonometry = new TrigonometryServiceWrapper(service);
		this.exp = new ExpServiceWrapper(service);
		this.service = service;
	}
	/**
	 * Returns all tags associated with the provided method or null if the method isn't implemented
	 * by this service.
	 */
	public Object[] getMethodTags(ServerCall call, String method) { 
		{
			final Object[] tags = this.trigonometry.getMethodTags(call, method);
			if (tags != null) return tags;
		}
		{
			final Object[] tags = this.exp.getMethodTags(call, method);
			if (tags != null) return tags;
		}
		return null;
	}
	// Methods from interface AdvancedMath.
	// Methods from sub-interface Trigonometry.
	public double sine(ServerCall call, double angle) throws VeyronException {
		return this.trigonometry.sine(call, angle);
	}
	public double cosine(ServerCall call, double angle) throws VeyronException {
		return this.trigonometry.cosine(call, angle);
	}
	// Methods from sub-interface Exp.
	public double exp(ServerCall call, double x) throws VeyronException {
		return this.exp.exp(call, x);
	}
}
