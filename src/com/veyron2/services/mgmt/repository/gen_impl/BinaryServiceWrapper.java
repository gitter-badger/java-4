// This file was auto-generated by the veyron vdl tool.
// Source(s):  repository.vdl
package com.veyron2.services.mgmt.repository.gen_impl;

import com.google.common.reflect.TypeToken;
import com.veyron2.ipc.ServerCall;
import com.veyron2.ipc.VeyronException;
import com.veyron2.services.mgmt.binary.PartInfo;
import com.veyron2.services.mgmt.repository.Application;
import com.veyron2.services.mgmt.repository.ApplicationFactory;
import com.veyron2.services.mgmt.repository.ApplicationService;
import com.veyron2.services.mgmt.repository.Binary;
import com.veyron2.services.mgmt.repository.BinaryFactory;
import com.veyron2.services.mgmt.repository.BinaryService;
import com.veyron2.services.mgmt.repository.Profile;
import com.veyron2.services.mgmt.repository.ProfileFactory;
import com.veyron2.services.mgmt.repository.ProfileService;
import com.veyron2.vdl.Stream;
import java.util.ArrayList;

public class BinaryServiceWrapper {

	private final BinaryService service;

	public BinaryServiceWrapper(BinaryService service) {
		this.service = service;
	}
	/**
	 * Returns all tags associated with the provided method or null if the method isn't implemented
	 * by this service.
	 */
	public Object[] getMethodTags(ServerCall call, String method) { 
		if (method == "Create") {
			return new Object[]{ 2 };
		}
		if (method == "Delete") {
			return new Object[]{ 2 };
		}
		if (method == "Download") {
			return new Object[]{ 1 };
		}
		if (method == "DownloadURL") {
			return new Object[]{ 1 };
		}
		if (method == "Stat") {
			return new Object[]{ 1 };
		}
		if (method == "Upload") {
			return new Object[]{ 2 };
		}
		return null;
	}
	// Methods from interface Binary.
	public void create(ServerCall call, int nparts) throws VeyronException { 
		this.service.create(call, nparts);
	}
	public void delete(ServerCall call) throws VeyronException { 
		this.service.delete(call);
	}
	public void download(ServerCall call, int part) throws VeyronException { 
		final ServerCall serverCall = call;
		final Stream<ArrayList<Byte>,Void> stream = new Stream<ArrayList<Byte>,Void>() {
			@Override
			public void send(ArrayList<Byte> item) throws VeyronException {
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
		this.service.download(call, part, stream);
	}
	public BinaryService.DownloadURLOut downloadURL(ServerCall call) throws VeyronException { 
		return this.service.downloadURL(call);
	}
	public ArrayList<PartInfo> stat(ServerCall call) throws VeyronException { 
		return this.service.stat(call);
	}
	public void upload(ServerCall call, int part) throws VeyronException { 
		final ServerCall serverCall = call;
		final Stream<Void,ArrayList<Byte>> stream = new Stream<Void,ArrayList<Byte>>() {
			@Override
			public void send(Void item) throws VeyronException {
				serverCall.send(item);
			}
			@Override
			public ArrayList<Byte> recv() throws java.io.EOFException, VeyronException {
				final TypeToken<?> type = new TypeToken<ArrayList<Byte>>() {};
				final Object result = serverCall.recv(type);
				try {
					return (ArrayList<Byte>)result;
				} catch (java.lang.ClassCastException e) {
					throw new VeyronException("Unexpected result type: " + result.getClass().getCanonicalName());
				}
			}
		};
		this.service.upload(call, part, stream);
	}
}
