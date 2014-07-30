// This file was auto-generated by the veyron vdl tool.
// Source: repository.vdl
package com.veyron.services.mgmt.repository;

/**
 * Application describes an application repository internally. Besides
 * the public Application interface, it allows to add and remove
 * application envelopes.
 */

@com.veyron2.vdl.VeyronService(serviceWrapper=com.veyron.services.mgmt.repository.gen_impl.ApplicationServiceWrapper.class)
public interface ApplicationService extends com.veyron2.services.mgmt.repository.ApplicationService {

    
    // Put adds the given tuple of application version (specified
// through the object name suffix) and application envelope to all
// of the given application profiles.

    public void put(final com.veyron2.ipc.ServerContext context, final java.util.ArrayList<java.lang.String> Profiles, final com.veyron2.services.mgmt.application.Envelope Envelope) throws com.veyron2.ipc.VeyronException;

    
    // Remove removes the application envelope for the given profile
// name and application version (specified through the object name
// suffix). If no version is specified as part of the suffix, the
// method removes all versions for the given profile.
//
// TODO(jsimsa): Add support for using "*" to specify all profiles
// when Matt implements Globing (or Ken implements querying).

    public void remove(final com.veyron2.ipc.ServerContext context, final java.lang.String Profile) throws com.veyron2.ipc.VeyronException;

}
