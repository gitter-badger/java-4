
// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron2.services.watch;


/**
 * GlobRequest specifies which entities should be watched and, optionally,
 * how to resume from a previous Watch call.
**/
public final class GlobRequest { 
	// Pattern specifies the subset of the children of the root entity
// for which the client wants updates.
	private String pattern;
	// ResumeMarker specifies how to resume from a previous Watch call.
// See the ResumeMarker type for detailed comments.
	private ResumeMarker resumeMarker;

	public GlobRequest(String pattern, ResumeMarker resumeMarker) { 
		this.pattern = pattern;
		this.resumeMarker = resumeMarker;
	}
	public String getPattern() { return this.pattern; }
	public ResumeMarker getResumeMarker() { return this.resumeMarker; }

	public void setPattern(String pattern) { this.pattern = pattern; }
	public void setResumeMarker(ResumeMarker resumeMarker) { this.resumeMarker = resumeMarker; }

	@Override
	public boolean equals(java.lang.Object obj) {
		if (!(obj instanceof GlobRequest)) return false;
		final GlobRequest other = (GlobRequest)obj;
		if (!(this.pattern.equals(other.pattern))) return false;
		if (!(this.resumeMarker.equals(other.resumeMarker))) return false;
		return true;
	}
}
