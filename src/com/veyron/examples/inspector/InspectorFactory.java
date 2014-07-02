// This file was auto-generated by the veyron vdl tool.
// Source(s):  inspector.vdl
package com.veyron.examples.inspector;

import com.google.common.reflect.TypeToken;
import com.veyron.examples.inspector.gen_impl.InspectorStub;
import com.veyron2.OptionDefs;
import com.veyron2.Options;
import com.veyron2.RuntimeFactory;
import com.veyron2.ipc.Client;
import com.veyron2.ipc.Context;
import com.veyron2.ipc.VeyronException;
import com.veyron2.vdl.ClientStream;

/* Factory for binding to Inspector interfaces. */
public class InspectorFactory {
	public static Inspector bind(String name) throws VeyronException {
		return bind(name, null);
	}
	public static Inspector bind(String name, Options veyronOpts) throws VeyronException {
		Client client = null;
		if (veyronOpts != null && veyronOpts.get(OptionDefs.CLIENT) != null) {
			client = veyronOpts.get(OptionDefs.CLIENT, Client.class);
		} else if (veyronOpts != null && veyronOpts.get(OptionDefs.RUNTIME) != null) {
			client = veyronOpts.get(OptionDefs.RUNTIME, com.veyron2.Runtime.class).getClient();
		} else {
			client = RuntimeFactory.getRuntime().getClient();
		}
		return new InspectorStub(client, name);
	}
}
