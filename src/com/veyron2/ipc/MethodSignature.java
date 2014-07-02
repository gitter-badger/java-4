
// This file was auto-generated by the veyron vdl tool.
// Source: signature.vdl
package com.veyron2.ipc;

import java.util.ArrayList;

/**
 * MethodSignature represents the structure for passing around method
 * signatures. This is usually sent in a ServiceSignature.
**/
public class MethodSignature { 
	public ArrayList<MethodArgument> inArgs; // Positional Argument information.
	public ArrayList<MethodArgument> outArgs;
	public long inStream; // Type of streaming arguments (or TypeIDInvalid if none). The type IDs here use the definitions in ServiceSigature.TypeDefs.
	public long outStream;
}
