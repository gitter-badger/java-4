// This file was auto-generated by the veyron vdl tool.
// Source(s):  node.vdl
package com.veyron2.services.mgmt.node;

import com.google.common.reflect.TypeToken;
import com.veyron2.OptionDefs;
import com.veyron2.Options;
import com.veyron2.RuntimeFactory;
import com.veyron2.ipc.Client;
import com.veyron2.ipc.Context;
import com.veyron2.ipc.VeyronException;
import com.veyron2.services.mgmt.build.BinaryDescription;
import com.veyron2.services.mgmt.node.gen_impl.NodeStub;
import java.util.ArrayList;

/* Factory for binding to Node interfaces. */
public class NodeFactory {
	public static Node bind(String name) throws VeyronException {
		return bind(name, null);
	}
	public static Node bind(String name, Options veyronOpts) throws VeyronException {
		Client client = null;
		if (veyronOpts != null && veyronOpts.get(OptionDefs.CLIENT) != null) {
			client = veyronOpts.get(OptionDefs.CLIENT, Client.class);
		} else if (veyronOpts != null && veyronOpts.get(OptionDefs.RUNTIME) != null) {
			client = veyronOpts.get(OptionDefs.RUNTIME, com.veyron2.Runtime.class).getClient();
		} else {
			client = RuntimeFactory.getRuntime().getClient();
		}
		return new NodeStub(client, name);
	}
}
