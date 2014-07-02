
// This file was auto-generated by the veyron vdl tool.
// Source: application.vdl
package com.veyron2.services.mgmt.application;

import java.util.ArrayList;

/**
 * Envelope is a collection of metadata that describes an application.
**/
public class Envelope { 
	// Arguments is an array of command-line arguments to be used when
// executing the binary.
public ArrayList<String> args;
	// Binary is a veyron name that identifies the application binary.
public String binary;
	// Environment is a map that stores the environment variable values
// to be used when executing the binary.
public ArrayList<String> env;
}
