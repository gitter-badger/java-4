// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron2.services.security.access;

import com.veyron2.ipc.ServerContext;
import com.veyron2.ipc.VeyronException;
import com.veyron2.services.security.access.gen_impl.ObjectServiceWrapper;
import com.veyron2.vdl.VeyronService;

/**
 * Object provides access control for Veyron objects.
**/
@VeyronService(stubWrapper=ObjectServiceWrapper.class)
public interface ObjectService { 
	// SetACL replaces the current ACL for an object.  etag allows for optional,
// optimistic concurrency control.  If non-empty, etag's value must come
// from GetACL.  If any client has successfully called SetACL in the
// meantime, the etag will be stale and SetACL will fail.
//
// ACL objects are expected to be small.  It is up to the implementation to
// define the exact limit, though it should probably be around 100KB.  Large
// lists of principals should use the Group API or blessings.
//
// There is some ambiguity when calling SetACL on a mount point.  Does it
// affect the mount itself or does it affect the service endpoint that the
// mount points to?  The chosen behavior is that it affects the service
// endpoint.  To modify the mount point's ACL, use ResolveToMountTable
// to get an endpoint and call SetACL on that.  This means that clients
// must know when a name refers to a mount point to change its ACL.
	public void setACL(ServerContext context, ACL acl, String etag) throws VeyronException;
	// GetACLOut packages output arguments for method GetACL.
	public static class GetACLOut { 
		public ACL acl;
		public String etag;
	}
	// GetACL returns the complete, current ACL for an object.  The returned etag
// can be passed to a subsequent call to SetACL for optimistic concurrency
// control. A successful call to SetACL will invalidate etag, and the client
// must call GetACL again to get the current etag.
	public ObjectService.GetACLOut getACL(ServerContext context) throws VeyronException;
}
