// This file was auto-generated by the veyron vdl tool.
// Source: proximity.vdl
package com.veyron2.services.proximity;

import com.veyron2.Options;
import com.veyron2.ipc.Context;
import com.veyron2.ipc.VeyronException;
import java.util.ArrayList;

public interface ProximityScanner { 
	// NearbyDevices returns the most up-to-date list of nearby devices,
// sorted in increasing distance order.
	public ArrayList<Device> nearbyDevices(Context context) throws VeyronException;
	public ArrayList<Device> nearbyDevices(Context context, Options veyronOpts) throws VeyronException;
}
