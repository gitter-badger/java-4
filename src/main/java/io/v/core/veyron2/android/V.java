package io.v.core.veyron2.android;

import io.v.core.veyron2.Options;
import io.v.core.veyron2.verror2.VException;
import io.v.core.veyron2.context.VContext;
import io.v.core.veyron2.ipc.ListenSpec;
import io.v.core.veyron2.security.Blessings;
import io.v.core.veyron2.security.ECDSASigner;
import io.v.core.veyron2.security.Principal;
import io.v.core.veyron2.security.Security;
import io.v.core.veyron2.security.Constants;
import io.v.core.veyron2.security.Signer;

import java.security.KeyStore;
import java.security.interfaces.ECPublicKey;

/**
 * Class {@code V} represents the local android environment allowing clients and servers to
 * communicate with one another. The expected usage pattern of this class goes something like this:
 * <code>
 *    ...
 *    final VContext ctx = V.init(getApplicationContext(), opts);
 *    ...
 *    final Server s = V.newServer(ctx);
 *    ...
 *    final Client c = V.getClient(ctx);
 *    ...
 * </code>
 * This class is a convenience wrapper for android users.  It provides Android-related setup
 * and then delegates to the Java {@code V} methods.
 */
public class V extends io.v.core.veyron2.V {
	static {
		RedirectStderr.Start();
	}
	private static final ListenSpec DEFAULT_LISTEN_SPEC = new ListenSpec(
			new ListenSpec.Address[] { new ListenSpec.Address("tcp", ":0")},
			"/ns.dev.v.io:8101/proxy",
			true);
	private static volatile VContext context = null;

	/**
	 * Initializes the Veyron environment, returning the base context.  Calling this method multiple
	 * times will always return the result of the first call to {@code init()}, ignoring
	 * subsequently provided options.
	 *
	 * A caller may pass the following option that specifies the runtime implementation to be used:
	 *   {@code OptionDefs.RUNTIME}
	 *
	 * If this option isn't provided, the default runtime implementation is used.  The rest of
	 * the options are passed to this runtime.  Currently, only the following options are
	 * recognized:
	 *   CURRENTLY NO OPTIONS ARE SUPPORTED
	 *
	 * @param  ctx  Android application context
	 * @param  opts options for the default runtime
	 * @return      base context
	 */
	public static VContext init(android.content.Context ctx, Options opts) {
		if (context != null) return context;
		synchronized (V.class) {
			if (context != null) return context;
			context = io.v.core.veyron2.V.init(opts);
			// Attach principal and listen spec to the context.
			try {
				context = V.setPrincipal(context, createPrincipal(ctx, opts));
				context = V.setListenSpec(context, DEFAULT_LISTEN_SPEC);
			} catch (VException e) {
				throw new RuntimeException(
		    			"Couldn't setup Vanadium Runtime options: " + e.getMessage());
			}
			return context;
		}
	}

	/**
	 * Initializes the Veyron environment without options.  See {@code init(Options)} for more
	 * information.
	 *
	 * @return base context
	 */
	public static VContext init(android.content.Context ctx) {
		return V.init(ctx, null);
	}

	private static Principal createPrincipal(android.content.Context ctx, Options opts)
			throws VException {
		// Check if the private key has already been generated for this package.
		// (NOTE: Android package names are unique.)
		KeyStore.PrivateKeyEntry keyEntry =
				KeyStoreUtil.getKeyStorePrivateKey(ctx.getPackageName());
		if (keyEntry == null) {
			// Generate a new private key.
			keyEntry = KeyStoreUtil.genKeyStorePrivateKey(ctx, ctx.getPackageName());
		}
		final Signer signer = new ECDSASigner(
				keyEntry.getPrivateKey(), (ECPublicKey)keyEntry.getCertificate().getPublicKey());
		final Principal principal = Security.newPrincipal(signer);
		final Blessings blessings = principal.blessSelf(ctx.getPackageName());
		principal.blessingStore().setDefaultBlessings(blessings);
		principal.blessingStore().set(blessings, Constants.ALL_PRINCIPALS);
		principal.addToRoots(blessings);
		return principal;
	}
}