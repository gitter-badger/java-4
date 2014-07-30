// This file was auto-generated by the veyron vdl tool.
// Source: identity.vdl
package com.veyron.services.identity;

/**
 * OAuthBlesser exchanges the provided authorization code for an email addres
 * from an OAuth-based identity provider and uses the email address as the
 * name to bless the client with.
 * 
 * The redirect URL used to obtain the authorization code must also be
 * provided in order to ensure a successful exchange.
 */

@com.veyron2.vdl.VeyronService(serviceWrapper=com.veyron.services.identity.gen_impl.OAuthBlesserServiceWrapper.class)
public interface OAuthBlesserService  {

    
    // TODO(ashankar,toddw): Once the "OneOf" type becomes available in VDL,
// then the "any" should be replaced by:
// OneOf<wire.ChainPublicID, []wire.ChainPublicID>
// where wire is from:
// import "veyron2/security/wire"

    public java.lang.Object bless(final com.veyron2.ipc.ServerContext context, final java.lang.String authcode, final java.lang.String redirecturl) throws com.veyron2.ipc.VeyronException;

}
