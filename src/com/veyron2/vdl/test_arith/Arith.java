// This file was auto-generated by the veyron vdl tool.
// Source: arith.vdl
package com.veyron2.vdl.test_arith;

import com.veyron2.Options;
import com.veyron2.ipc.Context;
import com.veyron2.ipc.VeyronException;
import com.veyron2.vdl.ClientStream;
import com.veyron2.vdl.test_base.Args;
import com.veyron2.vdl.test_base.NestedArgs;

/**
 * Arith is an example of an interface definition for an arithmetic service.
 * Things to note:
 *   * There must be at least 1 out-arg, and the last out-arg must be error.
**/
public interface Arith { 
	// Add is a typical method with multiple input and output arguments.
	public int add(Context context, int a, int b) throws VeyronException;
	public int add(Context context, int a, int b, Options veyronOpts) throws VeyronException;
	// DivModOut packages output arguments for method DivMod.
	public static class DivModOut { 
		public int quot;
		public int rem;
	}
	// DivMod shows that runs of args with the same type can use the short form,
// just like Go.
	public Arith.DivModOut divMod(Context context, int a, int b) throws VeyronException;
	public Arith.DivModOut divMod(Context context, int a, int b, Options veyronOpts) throws VeyronException;
	// Sub shows that you can use data types defined in other packages.
	public int sub(Context context, Args args) throws VeyronException;
	public int sub(Context context, Args args, Options veyronOpts) throws VeyronException;
	// Mul tries another data type defined in another package.
	public int mul(Context context, NestedArgs nested) throws VeyronException;
	public int mul(Context context, NestedArgs nested, Options veyronOpts) throws VeyronException;
	// GenError shows that it's fine to have no in args, and no out args other
// than "error".  In addition GenError shows the usage of tags.  Tags are a
// sequence of constants.  There's no requirement on uniqueness of types or
// values, and regular const expressions may also be used.
	public void genError(Context context) throws VeyronException;
	public void genError(Context context, Options veyronOpts) throws VeyronException;
	// Count shows using only an int32 out-stream type, with no in-stream type.
	public ClientStream<Void,Integer,Void> count(Context context, int start) throws VeyronException;
	public ClientStream<Void,Integer,Void> count(Context context, int start, Options veyronOpts) throws VeyronException;
	// StreamingAdd shows a bidirectional stream.
	public ClientStream<Integer,Integer,Integer> streamingAdd(Context context) throws VeyronException;
	public ClientStream<Integer,Integer,Integer> streamingAdd(Context context, Options veyronOpts) throws VeyronException;
	// QuoteAny shows the any built-in type, representing a value of any type.
	public Object quoteAny(Context context, Object a) throws VeyronException;
	public Object quoteAny(Context context, Object a, Options veyronOpts) throws VeyronException;
}
