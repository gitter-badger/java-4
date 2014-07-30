// This file was auto-generated by the veyron vdl tool.
// Source: arith.vdl
package com.veyron2.vdl.test_arith;

/**
 * Arith is an example of an interface definition for an arithmetic service.
 * Things to note:
 * * There must be at least 1 out-arg, and the last out-arg must be error.
 */

public interface Arith  {

    
    

    
    // Add is a typical method with multiple input and output arguments.

    public int add(final com.veyron2.ipc.Context context, final int a, final int b) throws com.veyron2.ipc.VeyronException;
    public int add(final com.veyron2.ipc.Context context, final int a, final int b, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    
    public static class DivModOut {
        
        public int quot;
        
        public int rem;
        
    }
    

    
    // DivMod shows that runs of args with the same type can use the short form,
// just like Go.

    public com.veyron2.vdl.test_arith.Arith.DivModOut divMod(final com.veyron2.ipc.Context context, final int a, final int b) throws com.veyron2.ipc.VeyronException;
    public com.veyron2.vdl.test_arith.Arith.DivModOut divMod(final com.veyron2.ipc.Context context, final int a, final int b, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    // Sub shows that you can use data types defined in other packages.

    public int sub(final com.veyron2.ipc.Context context, final com.veyron2.vdl.test_base.Args args) throws com.veyron2.ipc.VeyronException;
    public int sub(final com.veyron2.ipc.Context context, final com.veyron2.vdl.test_base.Args args, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    // Mul tries another data type defined in another package.

    public int mul(final com.veyron2.ipc.Context context, final com.veyron2.vdl.test_base.NestedArgs nested) throws com.veyron2.ipc.VeyronException;
    public int mul(final com.veyron2.ipc.Context context, final com.veyron2.vdl.test_base.NestedArgs nested, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    // GenError shows that it's fine to have no in args, and no out args other
// than "error".  In addition GenError shows the usage of tags.  Tags are a
// sequence of constants.  There's no requirement on uniqueness of types or
// values, and regular const expressions may also be used.

    public void genError(final com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException;
    public void genError(final com.veyron2.ipc.Context context, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    // Count shows using only an int32 out-stream type, with no in-stream type.

    public com.veyron2.vdl.ClientStream<java.lang.Void,java.lang.Integer, java.lang.Void> count(final com.veyron2.ipc.Context context, final int Start) throws com.veyron2.ipc.VeyronException;
    public com.veyron2.vdl.ClientStream<java.lang.Void,java.lang.Integer, java.lang.Void> count(final com.veyron2.ipc.Context context, final int Start, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    // StreamingAdd shows a bidirectional stream.

    public com.veyron2.vdl.ClientStream<java.lang.Integer,java.lang.Integer, java.lang.Integer> streamingAdd(final com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException;
    public com.veyron2.vdl.ClientStream<java.lang.Integer,java.lang.Integer, java.lang.Integer> streamingAdd(final com.veyron2.ipc.Context context, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    // QuoteAny shows the any built-in type, representing a value of any type.

    public java.lang.Object quoteAny(final com.veyron2.ipc.Context context, final java.lang.Object a) throws com.veyron2.ipc.VeyronException;
    public java.lang.Object quoteAny(final com.veyron2.ipc.Context context, final java.lang.Object a, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

}
