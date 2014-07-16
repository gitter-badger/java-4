
// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron2.services.watch;

import java.util.ArrayList;

/**
 * ResumeMarker specifies how much of the existing underlying state
 * is delivered to the client when the watch request is received by
 * the system. The client can set this marker in one of the
 * following ways to get different semantics:
 *
 * (A) Parameter is left empty.
 *     Semantics: Fetch initial state.
 *     The client wants the entities' initial states to be delivered.
 *     See the description in "Initial State".
 *
 * (B) Parameter is set to the string "now" (UTF-8 encoding).
 *     Semantics: Fetch new changes only.
 *     The client just wants to get the changes received by the
 *     system after the watch point. The system may deliver changes
 *     from before the watch point as well.
 *
 * (C) Parameter is set to a value received in an earlier
 *     Change.ResumeMarker field while watching the same entity with
 *     the same query.
 *     Semantics: Resume from a specific point.
 *     The client wants to receive the changes from a specific point
 *     - this value must correspond to a value received in the
 *     Change.ResumeMarker field. The system may deliver changes
 *     from before the ResumeMarker as well.  If the system cannot
 *     resume the stream from this point (e.g., if it is too far
 *     behind in the stream), it can return the
 *     ErrUnknownResumeMarker error.
 *     ResumeMarkers are received in lexicographical order.
 *
 * An implementation MUST support the empty string "" marker
 * (initial state fetching) and the "now" marker. It need not
 * support resuming from a specific point.
**/
public final class ResumeMarker { 
		private ArrayList<Byte> value;

	public ResumeMarker(ArrayList<Byte> value) { 
		this.value = value;
	}
	public ArrayList<Byte> getValue() { return this.value; }

	public void setValue(ArrayList<Byte> value) { this.value = value; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		final ResumeMarker other = (ResumeMarker)obj;
		if (!(this.value.equals(other.value))) return false;
		return true;
	}
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + (value == null ? 0 : value.hashCode());
		return result;
	}
}
