// This file was auto-generated by the veyron vdl tool.
// Source: repository.vdl
package com.veyron.services.mgmt.repository;

import com.veyron.services.mgmt.profile.Specification;
import com.veyron.services.mgmt.repository.gen_impl.ProfileServiceWrapper;
import com.veyron2.ipc.ServerContext;
import com.veyron2.ipc.VeyronException;
import com.veyron2.vdl.VeyronService;

/**
 * Profile describes a profile internally. Besides the public Profile
 * interface, it allows to add and remove profile specifications.
**/
@VeyronService(stubWrapper=ProfileServiceWrapper.class)
public interface ProfileService extends com.veyron2.services.mgmt.repository.ProfileService { 
	// Specification returns the profile specification for the profile
// identified through the veyron name suffix.
	public Specification specification(ServerContext context) throws VeyronException;
	// Put sets the profile specification for the profile identified
// through the veyron name suffix.
	public void put(ServerContext context, Specification specification) throws VeyronException;
	// Remove removes the profile specification for the profile
// identified through the veyron name suffix.
	public void remove(ServerContext context) throws VeyronException;
}
