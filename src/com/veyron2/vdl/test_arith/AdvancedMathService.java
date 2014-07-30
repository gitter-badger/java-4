// This file was auto-generated by the veyron vdl tool.
// Source: advanced.vdl
package com.veyron2.vdl.test_arith;

/**
 * AdvancedMath is an interface for more advanced math than arith.  It embeds
 * interfaces defined both in the same file and in an external package; and in
 * turn it is embedded by arith.Calculator (which is in the same package but
 * different file) to verify that embedding works in all these scenarios.
 */

@com.veyron2.vdl.VeyronService(serviceWrapper=com.veyron2.vdl.test_arith.gen_impl.AdvancedMathServiceWrapper.class)
public interface AdvancedMathService extends com.veyron2.vdl.test_arith.TrigonometryService, com.veyron2.vdl.test_arith.exp.ExpService {

}
