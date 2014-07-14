
// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron2.services.watch;

import java.util.ArrayList;

/**
 * ChangeBatch is a batch of Change messages.
**/
public final class ChangeBatch { 
		private ArrayList<Change> changes;

	public ChangeBatch(ArrayList<Change> changes) { 
		this.changes = changes;
	}
	public ArrayList<Change> getChanges() { return this.changes; }

	public void setChanges(ArrayList<Change> changes) { this.changes = changes; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (!(obj instanceof ChangeBatch)) return false;
		final ChangeBatch other = (ChangeBatch)obj;
		if (!(this.changes.equals(other.changes))) return false;
		return true;
	}
}
