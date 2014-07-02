// This file was auto-generated by the veyron vdl tool.
// Source: node.vdl
package com.veyron.services.mgmt.node;

import com.veyron.services.mgmt.node.gen_impl.NodeServiceWrapper;
import com.veyron2.ipc.ServerContext;
import com.veyron2.vdl.VeyronService;

/**
 * Node describes a node manager internally. In addition to the public
 * Node interface, it implements the config functionality.
**/
@VeyronService(stubWrapper=NodeServiceWrapper.class)
public interface NodeService extends com.veyron2.services.mgmt.node.NodeService, ConfigService { 
}
