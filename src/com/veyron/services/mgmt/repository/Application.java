// This file was auto-generated by the veyron vdl tool.
// Source: repository.vdl
package com.veyron.services.mgmt.repository;

import com.veyron2.Options;
import com.veyron2.ipc.Context;
import com.veyron2.ipc.VeyronException;
import com.veyron2.services.mgmt.application.Envelope;
import java.util.ArrayList;

/**
 * Application describes an application repository internally. Besides
 * the public Application interface, it allows to add and remove
 * application envelopes.
**/
public interface Application extends com.veyron2.services.mgmt.repository.Application { 
	// Put adds the given tuple of application version (specified
// through the veyron name suffix) and application envelope to all
// of the given application profiles.
	public void put(Context context, ArrayList<String> profiles, Envelope envelope) throws VeyronException;
	public void put(Context context, ArrayList<String> profiles, Envelope envelope, Options veyronOpts) throws VeyronException;
	// Remove removes the application envelope for the given profile
// name and application version (specified through the veyron name
// suffix). If no version is specified as part of the suffix, the
// method removes all versions for the given profile.
//
// TODO(jsimsa): Add support for using "*" to specify all profiles
// when Matt implements Globing (or Ken implements querying).
	public void remove(Context context, String profile) throws VeyronException;
	public void remove(Context context, String profile, Options veyronOpts) throws VeyronException;
}
