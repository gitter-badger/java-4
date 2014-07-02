
// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron.services.store.raw;

import com.veyron2.storage.DEntry;
import com.veyron2.storage.Tag;
import java.util.ArrayList;

/**
 * Mutation represents an update to an entry in the store, and contains enough
 * information for a privileged service to replicate the update elsewhere.
**/
public class Mutation { 
	// ID is the key that identifies the entry.
public byte[] iD;
	// The version of the entry immediately before the update. For new entries,
// the PriorVersion is NoVersion.
public long priorVersion;
	// The version of the entry immediately after the update. For deleted entries,
// the Version is NoVersion.
public long version;
	// IsRoot is true if
// 1) The entry was the store root immediately before being deleted, or
// 2) The entry is the store root immediately after the update.
public boolean isRoot;
	// Value is value stored at this entry.
public Object value;
	// Tags specify permissions on this entry.
public ArrayList<Tag> tags;
	// Dir is the implicit directory of this entry, and may contain references
// to other entries in the store.
public ArrayList<DEntry> dir;
}
