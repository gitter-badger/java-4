// This file was auto-generated by the veyron vdl tool.
// Source(s):  boxes.vdl
package com.veyron.examples.boxes;

import com.google.common.reflect.TypeToken;
import com.veyron.examples.boxes.gen_impl.BoxSignallingStub;
import com.veyron2.OptionDefs;
import com.veyron2.Options;
import com.veyron2.RuntimeFactory;
import com.veyron2.ipc.Client;
import com.veyron2.ipc.Context;
import com.veyron2.ipc.VeyronException;

/* Factory for binding to BoxSignalling interfaces. */
public class BoxSignallingFactory {
	public static BoxSignalling bind(String name) throws VeyronException {
		return bind(name, null);
	}
	public static BoxSignalling bind(String name, Options veyronOpts) throws VeyronException {
		Client client = null;
		if (veyronOpts != null && veyronOpts.get(OptionDefs.CLIENT) != null) {
			client = veyronOpts.get(OptionDefs.CLIENT, Client.class);
		} else if (veyronOpts != null && veyronOpts.get(OptionDefs.RUNTIME) != null) {
			client = veyronOpts.get(OptionDefs.RUNTIME, com.veyron2.Runtime.class).getClient();
		} else {
			client = RuntimeFactory.getRuntime().getClient();
		}
		return new BoxSignallingStub(client, name);
	}
}
