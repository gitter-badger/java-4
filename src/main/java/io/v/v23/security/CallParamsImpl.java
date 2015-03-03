package io.v.v23.security;

import org.joda.time.DateTime;

import io.v.v23.context.VContext;
import io.v.v23.vdl.VdlValue;

class CallParamsImpl implements Call {
    private final CallParams params;

    CallParamsImpl(CallParams params) {
        this.params = params;
    }

    @Override
    public DateTime timestamp() {
        return this.params.getTimestamp();
    }
    @Override
    public String method() {
        return this.params.getMethod();
    }
    @Override
    public VdlValue[] methodTags() {
        return this.params.getMethodTags();
    }
    @Override
    public String suffix() {
        return this.params.getSuffix();
    }
    @Override
    public String localEndpoint() {
        return this.params.getLocalEndpoint();
    }
    @Override
    public String remoteEndpoint() {
        return this.params.getRemoteEndpoint();
    }
    @Override
    public Principal localPrincipal() {
        return this.params.getLocalPrincipal();
    }
    @Override
    public Blessings localBlessings() {
        return this.params.getLocalBlessings();
    }
    @Override
    public Blessings remoteBlessings() {
        return this.params.getRemoteBlessings();
    }
    @Override
    public VContext context() {
        return this.params.getContext();
    }
}