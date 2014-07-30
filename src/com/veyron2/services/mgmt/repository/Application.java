// This file was auto-generated by the veyron vdl tool.
// Source: repository.vdl
package com.veyron2.services.mgmt.repository;

/**
 * Application provides access to application envelopes. An
 * application envelope is identified by an application name and an
 * application version, which are specified through the object name,
 * and a profile name, which is specified using a method argument.
 * 
 * Example:
 * /apps/search/v1.Match([]string{"base", "media"})
 * returns an application envelope that can be used for downloading
 * and executing the "search" application, version "v1", runnable
 * on either the "base" or "media" profile.
 */

public interface Application  {

    
    

    
    // Match checks if any of the given profiles contains an application
// envelope for the given application version (specified through the
// object name suffix) and if so, returns this envelope. If multiple
// profile matches are possible, the method returns the first
// matching profile, respecting the order of the input argument.

    public com.veyron2.services.mgmt.application.Envelope match(final com.veyron2.ipc.Context context, final java.util.ArrayList<java.lang.String> Profiles) throws com.veyron2.ipc.VeyronException;
    public com.veyron2.services.mgmt.application.Envelope match(final com.veyron2.ipc.Context context, final java.util.ArrayList<java.lang.String> Profiles, final com.veyron2.Options veyronOpts) throws com.veyron2.ipc.VeyronException;

}
