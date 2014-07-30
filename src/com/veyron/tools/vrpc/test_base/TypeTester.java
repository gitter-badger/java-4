// This file was auto-generated by the veyron vdl tool.
// Source: test_base.vdl
package com.veyron.tools.vrpc.test_base;


public interface TypeTester  {

    
    

    
    // Methods to test support for generic types.

    public boolean echoBool(final com.veyron2.ipc.Context context, final boolean I1) throws com.veyron2.ipc.VeyronException;
    public boolean echoBool(final com.veyron2.ipc.Context context, final boolean I1, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public float echoFloat32(final com.veyron2.ipc.Context context, final float I1) throws com.veyron2.ipc.VeyronException;
    public float echoFloat32(final com.veyron2.ipc.Context context, final float I1, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public double echoFloat64(final com.veyron2.ipc.Context context, final double I1) throws com.veyron2.ipc.VeyronException;
    public double echoFloat64(final com.veyron2.ipc.Context context, final double I1, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public int echoInt32(final com.veyron2.ipc.Context context, final int I1) throws com.veyron2.ipc.VeyronException;
    public int echoInt32(final com.veyron2.ipc.Context context, final int I1, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public long echoInt64(final com.veyron2.ipc.Context context, final long I1) throws com.veyron2.ipc.VeyronException;
    public long echoInt64(final com.veyron2.ipc.Context context, final long I1, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public java.lang.String echoString(final com.veyron2.ipc.Context context, final java.lang.String I1) throws com.veyron2.ipc.VeyronException;
    public java.lang.String echoString(final com.veyron2.ipc.Context context, final java.lang.String I1, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public byte echoByte(final com.veyron2.ipc.Context context, final byte I1) throws com.veyron2.ipc.VeyronException;
    public byte echoByte(final com.veyron2.ipc.Context context, final byte I1, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public int echoUInt32(final com.veyron2.ipc.Context context, final int I1) throws com.veyron2.ipc.VeyronException;
    public int echoUInt32(final com.veyron2.ipc.Context context, final int I1, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public long echoUInt64(final com.veyron2.ipc.Context context, final long I1) throws com.veyron2.ipc.VeyronException;
    public long echoUInt64(final com.veyron2.ipc.Context context, final long I1, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    // Methods to test support for composite types.

    public void inputArray(final com.veyron2.ipc.Context context, final byte[] I1) throws com.veyron2.ipc.VeyronException;
    public void inputArray(final com.veyron2.ipc.Context context, final byte[] I1, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public void inputMap(final com.veyron2.ipc.Context context, final java.util.HashMap<java.lang.Byte, java.lang.Byte> I1) throws com.veyron2.ipc.VeyronException;
    public void inputMap(final com.veyron2.ipc.Context context, final java.util.HashMap<java.lang.Byte, java.lang.Byte> I1, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public void inputSlice(final com.veyron2.ipc.Context context, final java.util.ArrayList<java.lang.Byte> I1) throws com.veyron2.ipc.VeyronException;
    public void inputSlice(final com.veyron2.ipc.Context context, final java.util.ArrayList<java.lang.Byte> I1, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public void inputStruct(final com.veyron2.ipc.Context context, final com.veyron.tools.vrpc.test_base.Struct I1) throws com.veyron2.ipc.VeyronException;
    public void inputStruct(final com.veyron2.ipc.Context context, final com.veyron.tools.vrpc.test_base.Struct I1, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public byte[] outputArray(final com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException;
    public byte[] outputArray(final com.veyron2.ipc.Context context, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public java.util.HashMap<java.lang.Byte, java.lang.Byte> outputMap(final com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException;
    public java.util.HashMap<java.lang.Byte, java.lang.Byte> outputMap(final com.veyron2.ipc.Context context, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public java.util.ArrayList<java.lang.Byte> outputSlice(final com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException;
    public java.util.ArrayList<java.lang.Byte> outputSlice(final com.veyron2.ipc.Context context, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    
    public com.veyron.tools.vrpc.test_base.Struct outputStruct(final com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException;
    public com.veyron.tools.vrpc.test_base.Struct outputStruct(final com.veyron2.ipc.Context context, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    // Methods to test support for different number of arguments.

    public void noArguments(final com.veyron2.ipc.Context context) throws com.veyron2.ipc.VeyronException;
    public void noArguments(final com.veyron2.ipc.Context context, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    
    public static class MultipleArgumentsOut {
        
        public int o1;
        
        public int o2;
        
    }
    

    
    
    public com.veyron.tools.vrpc.test_base.TypeTester.MultipleArgumentsOut multipleArguments(final com.veyron2.ipc.Context context, final int I1, final int I2) throws com.veyron2.ipc.VeyronException;
    public com.veyron.tools.vrpc.test_base.TypeTester.MultipleArgumentsOut multipleArguments(final com.veyron2.ipc.Context context, final int I1, final int I2, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

    
    

    
    // Methods to test support for streaming.

    public com.veyron2.vdl.ClientStream<java.lang.Void,java.lang.Boolean, java.lang.Void> streamingOutput(final com.veyron2.ipc.Context context, final int NumStreamItems, final boolean StreamItem) throws com.veyron2.ipc.VeyronException;
    public com.veyron2.vdl.ClientStream<java.lang.Void,java.lang.Boolean, java.lang.Void> streamingOutput(final com.veyron2.ipc.Context context, final int NumStreamItems, final boolean StreamItem, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

}
