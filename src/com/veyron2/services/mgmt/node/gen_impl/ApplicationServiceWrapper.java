// This file was auto-generated by the veyron vdl tool.
// Source(s):  node.vdl
package com.veyron2.services.mgmt.node.gen_impl;

import com.veyron2.ipc.ServerCall;
import com.veyron2.ipc.VeyronException;
import com.veyron2.services.mgmt.node.Application;
import com.veyron2.services.mgmt.node.ApplicationFactory;
import com.veyron2.services.mgmt.node.ApplicationService;
import com.veyron2.services.mgmt.node.Description;
import com.veyron2.services.mgmt.node.Node;
import com.veyron2.services.mgmt.node.NodeFactory;
import com.veyron2.services.mgmt.node.NodeService;
import java.util.ArrayList;

public class ApplicationServiceWrapper {

	private final ApplicationService service;

	public ApplicationServiceWrapper(ApplicationService service) {
		this.service = service;
	}
	/**
	 * Returns all tags associated with the provided method or null if the method isn't implemented
	 * by this service.
	 */
	public Object[] getMethodTags(ServerCall call, String method) { 
		if (method == "Install") {
			return new Object[]{  };
		}
		if (method == "Refresh") {
			return new Object[]{  };
		}
		if (method == "Restart") {
			return new Object[]{  };
		}
		if (method == "Resume") {
			return new Object[]{  };
		}
		if (method == "Revert") {
			return new Object[]{  };
		}
		if (method == "Start") {
			return new Object[]{  };
		}
		if (method == "Stop") {
			return new Object[]{  };
		}
		if (method == "Suspend") {
			return new Object[]{  };
		}
		if (method == "Uninstall") {
			return new Object[]{  };
		}
		if (method == "Update") {
			return new Object[]{  };
		}
		if (method == "UpdateTo") {
			return new Object[]{  };
		}
		return null;
	}
	// Methods from interface Application.
	public String install(ServerCall call, String Name) throws VeyronException { 
		return this.service.install(call, Name);
	}
	public void refresh(ServerCall call) throws VeyronException { 
		this.service.refresh(call);
	}
	public void restart(ServerCall call) throws VeyronException { 
		this.service.restart(call);
	}
	public void resume(ServerCall call) throws VeyronException { 
		this.service.resume(call);
	}
	public void revert(ServerCall call) throws VeyronException { 
		this.service.revert(call);
	}
	public ArrayList<String> start(ServerCall call) throws VeyronException { 
		return this.service.start(call);
	}
	public void stop(ServerCall call, long Deadline) throws VeyronException { 
		this.service.stop(call, Deadline);
	}
	public void suspend(ServerCall call) throws VeyronException { 
		this.service.suspend(call);
	}
	public void uninstall(ServerCall call) throws VeyronException { 
		this.service.uninstall(call);
	}
	public void update(ServerCall call) throws VeyronException { 
		this.service.update(call);
	}
	public void updateTo(ServerCall call, String Name) throws VeyronException { 
		this.service.updateTo(call, Name);
	}
}
