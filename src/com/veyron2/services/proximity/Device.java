
// This file was auto-generated by the veyron vdl tool.
// Source: proximity.vdl
package com.veyron2.services.proximity;

import java.util.ArrayList;

/**
 * Device represents one neighborhood device.  It contains that device's
 * MAC address, observed names, and the average distance to the device.
 * TODO(bprosnitz) This is bluetooth specific. We need a more generate service as well.
**/
public class Device { 
	// MAC is remote device's MAC address, in one of the following formats
// (as per http://golang.org/pkg/net/#ParseMAC):
//   01:23:45:67:89:ab
//   01:23:45:67:89:ab:cd:ef
//   01-23-45-67-89-ab
//   01-23-45-67-89-ab-cd-ef
//   0123.4567.89ab
//   0123.4567.89ab.cdef
public String mAC;
	// Names represents all unique observed names of the remote device.
public ArrayList<String> names;
	// Distance represents the (estimated) distance to the neighborhood
// device.  It can be parsed using distance.Parse method.
// TODO(bprosnitz) Change from string.
public String distance;
}
