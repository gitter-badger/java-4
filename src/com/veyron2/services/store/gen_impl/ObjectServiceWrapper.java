// This file was auto-generated by the veyron vdl tool.
// Source(s):  service.vdl
package com.veyron2.services.store.gen_impl;

import com.google.common.reflect.TypeToken;
import com.veyron2.ipc.ServerCall;
import com.veyron2.ipc.VeyronException;
import com.veyron2.query.Query;
import com.veyron2.services.mounttable.GlobableService;
import com.veyron2.services.mounttable.MountEntry;
import com.veyron2.services.mounttable.gen_impl.GlobableServiceWrapper;
import com.veyron2.services.store.Conflict;
import com.veyron2.services.store.Entry;
import com.veyron2.services.store.ObjectFactory;
import com.veyron2.services.store.ObjectService;
import com.veyron2.services.store.QueryResult;
import com.veyron2.services.store.Stat;
import com.veyron2.services.store.Store;
import com.veyron2.services.store.StoreFactory;
import com.veyron2.services.store.StoreService;
import com.veyron2.services.store.TransactionID;
import com.veyron2.services.store.VeyronConsts;
import com.veyron2.services.watch.ChangeBatch;
import com.veyron2.services.watch.GlobRequest;
import com.veyron2.services.watch.GlobWatcherService;
import com.veyron2.services.watch.QueryRequest;
import com.veyron2.services.watch.QueryWatcherService;
import com.veyron2.services.watch.gen_impl.GlobWatcherServiceWrapper;
import com.veyron2.services.watch.gen_impl.QueryWatcherServiceWrapper;
import com.veyron2.vdl.Stream;
import java.util.ArrayList;

public class ObjectServiceWrapper {

	private final ObjectService service;
	private final GlobableServiceWrapper globable;
	private final GlobWatcherServiceWrapper globWatcher;
	private final QueryWatcherServiceWrapper queryWatcher;

	public ObjectServiceWrapper(ObjectService service) {
		this.globable = new GlobableServiceWrapper(service);
		this.globWatcher = new GlobWatcherServiceWrapper(service);
		this.queryWatcher = new QueryWatcherServiceWrapper(service);
		this.service = service;
	}
	/**
	 * Returns all tags associated with the provided method or null if the method isn't implemented
	 * by this service.
	 */
	public Object[] getMethodTags(ServerCall call, String method) { 
		{
			final Object[] tags = this.globable.getMethodTags(call, method);
			if (tags != null) return tags;
		}
		{
			final Object[] tags = this.globWatcher.getMethodTags(call, method);
			if (tags != null) return tags;
		}
		{
			final Object[] tags = this.queryWatcher.getMethodTags(call, method);
			if (tags != null) return tags;
		}
		if (method == "Exists") {
			return new Object[]{  };
		}
		if (method == "Get") {
			return new Object[]{  };
		}
		if (method == "Put") {
			return new Object[]{  };
		}
		if (method == "Remove") {
			return new Object[]{  };
		}
		if (method == "SetAttr") {
			return new Object[]{  };
		}
		if (method == "Stat") {
			return new Object[]{  };
		}
		if (method == "Query") {
			return new Object[]{  };
		}
		if (method == "GlobT") {
			return new Object[]{  };
		}
		return null;
	}
	// Methods from interface Object.
	public boolean exists(ServerCall call, TransactionID TID) throws VeyronException { 
		return this.service.exists(call, TID);
	}
	public Entry get(ServerCall call, TransactionID TID) throws VeyronException { 
		return this.service.get(call, TID);
	}
	public Stat put(ServerCall call, TransactionID TID, Object V) throws VeyronException { 
		return this.service.put(call, TID, V);
	}
	public void remove(ServerCall call, TransactionID TID) throws VeyronException { 
		this.service.remove(call, TID);
	}
	public void setAttr(ServerCall call, TransactionID TID, ArrayList<Object> Attrs) throws VeyronException { 
		this.service.setAttr(call, TID, Attrs);
	}
	public Stat stat(ServerCall call, TransactionID TID) throws VeyronException { 
		return this.service.stat(call, TID);
	}
	public void query(ServerCall call, TransactionID TID, Query Q) throws VeyronException { 
		final ServerCall serverCall = call;
		final Stream<QueryResult,Void> stream = new Stream<QueryResult,Void>() {
			@Override
			public void send(QueryResult item) throws VeyronException {
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
		this.service.query(call, TID, Q, stream);
	}
	public void globT(ServerCall call, TransactionID TID, String pattern) throws VeyronException { 
		final ServerCall serverCall = call;
		final Stream<String,Void> stream = new Stream<String,Void>() {
			@Override
			public void send(String item) throws VeyronException {
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
		this.service.globT(call, TID, pattern, stream);
	}
	// Methods from sub-interface Globable.
	public void glob(ServerCall call, String pattern) throws VeyronException {
		this.globable.glob(call, pattern);
	}
	// Methods from sub-interface GlobWatcher.
	public void watchGlob(ServerCall call, GlobRequest Req) throws VeyronException {
		this.globWatcher.watchGlob(call, Req);
	}
	// Methods from sub-interface QueryWatcher.
	public void watchQuery(ServerCall call, QueryRequest Req) throws VeyronException {
		this.queryWatcher.watchQuery(call, Req);
	}
}
