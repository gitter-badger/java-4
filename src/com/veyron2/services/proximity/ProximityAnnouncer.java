// This file was auto-generated by the veyron vdl tool.
// Source: proximity.vdl
package com.veyron2.services.proximity;

import com.veyron2.Options;
import com.veyron2.ipc.Context;
import com.veyron2.ipc.VeyronException;

/**
 * Proximity maintains a list of devices in our close proximity, using scan
 * readings from nearby devices.  It also continuously advertises a set of
 * provided names, which will be visible at nearby devices and associated
 * with this device.
**/
public interface ProximityAnnouncer { 
	// RegisterName adds a name that this device will be associated with;
// a remote device will see all the unique names currently registered
// with this device (see Names field in Device).
	public void registerName(Context context, String name) throws VeyronException;
	public void registerName(Context context, String name, Options veyronOpts) throws VeyronException;
	// UnregisterName removes a name previously associated with this device.
// If the name doesn't exist, this method will return an error.
// If the name has been registered multiple times, this method will
// remove only one instance of that registration.
	public void unregisterName(Context context, String name) throws VeyronException;
	public void unregisterName(Context context, String name, Options veyronOpts) throws VeyronException;
}
