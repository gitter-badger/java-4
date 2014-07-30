// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron.runtimes.google.ipc.benchmarks;


@com.veyron2.vdl.VeyronService(serviceWrapper=com.veyron.runtimes.google.ipc.benchmarks.gen_impl.BenchmarkServiceWrapper.class)
public interface BenchmarkService  {

    
    // Echo returns the payload that it receives.

    public java.util.ArrayList<java.lang.Byte> echo(final com.veyron2.ipc.ServerContext context, final java.util.ArrayList<java.lang.Byte> Payload) throws com.veyron2.ipc.VeyronException;

    
    // EchoStream returns the payload that it receives via the stream.

    public void echoStream(final com.veyron2.ipc.ServerContext context, com.veyron2.vdl.Stream<java.util.ArrayList<java.lang.Byte>, java.util.ArrayList<java.lang.Byte>> stream) throws com.veyron2.ipc.VeyronException;

}
