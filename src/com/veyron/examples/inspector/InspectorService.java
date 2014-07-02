// This file was auto-generated by the veyron vdl tool.
// Source: inspector.vdl
package com.veyron.examples.inspector;

import com.veyron.examples.inspector.gen_impl.InspectorServiceWrapper;
import com.veyron2.ipc.ServerContext;
import com.veyron2.ipc.VeyronException;
import com.veyron2.vdl.Stream;
import com.veyron2.vdl.VeyronService;

@VeyronService(stubWrapper=InspectorServiceWrapper.class)
public interface InspectorService { 
		public void ls(ServerContext context, String glob, Stream<String,Void> stream) throws VeyronException;
		public void lsDetails(ServerContext context, String glob, Stream<Details,Void> stream) throws VeyronException;
}
