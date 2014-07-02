// This file was auto-generated by the veyron vdl tool.
// Source: advanced.vdl
package com.veyron2.vdl.test_arith;

import com.veyron2.ipc.ServerContext;
import com.veyron2.ipc.VeyronException;
import com.veyron2.vdl.VeyronService;
import com.veyron2.vdl.test_arith.gen_impl.TrigonometryServiceWrapper;

/**
 * Trigonometry is an interface that specifies a couple trigonometric functions.
**/
@VeyronService(stubWrapper=TrigonometryServiceWrapper.class)
public interface TrigonometryService { 
		public double sine(ServerContext context, double angle) throws VeyronException;
		public double cosine(ServerContext context, double angle) throws VeyronException;
}
