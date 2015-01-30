package io.v.core.veyron2;

import go.Go;
import io.v.core.veyron2.context.VContext;
import io.v.core.veyron2.ipc.Client;
import io.v.core.veyron2.ipc.ListenSpec;
import io.v.core.veyron2.ipc.Server;
import io.v.core.veyron2.naming.Namespace;
import io.v.core.veyron2.security.Principal;

/**
 * Class {@code V} represents the local environment allowing clients and servers to communicate
 * with one another.  The expected usage pattern of this class goes something like this:
 *
 *    ...
 *    final VContext ctx = V.init(opts);
 *    ...
 *    final Server s = V.newServer(ctx);
 *    ...
 *    final Client c = V.getClient(ctx);
 *    ...
 */
public class V {
	private static native void nativeInit();
	static {
		System.loadLibrary("jniwrapper");
		System.loadLibrary("veyronjni");
		Go.init();
		nativeInit();
	}

	private static volatile VContext context = null;
	private static volatile VRuntime runtime = null;

	/**
	 * Initializes the Veyron environment, returning the base context.  Calling this method multiple
	 * times will always return the result of the first call to {@code init()}, ignoring
	 * subsequently provided options.
	 *
	 * A caller may pass the following option that specifies the runtime implementation to be used:
	 *     {@code OptionDefs.RUNTIME}
	 *
	 * If this option isn't provided, the default runtime implementation is used.
	 *
	 * @param  opts options
	 * @return      base context
	 */
	public static VContext init(Options opts) {
		if (context != null) return context;
		synchronized (V.class) {
			if (context != null) return context;
			if (opts == null) opts = new Options();
			// See if a runtime was provided as an option.
			if (opts.get(OptionDefs.RUNTIME) != null) {
				runtime = opts.get(OptionDefs.RUNTIME, VRuntime.class);
			} else {
				// Use the default runtime implementation.
				try {
					runtime = io.v.core.veyron.runtimes.google.VRuntime.create();
				} catch (VeyronException e) {
	    			throw new RuntimeException(
	    				"Couldn't initialize Google Veyron Runtime: " + e.getMessage());
				}
			}
			context = runtime.getContext();
			return context;
		}
	}

	/**
	 * Initializes the Veyron environment without options.  See {@code init(Options)} for more
	 * information.
	 *
	 * @return base context
	 */
	public static VContext init() {
		return V.init(null);
	}

	/**
	 * Creates a new client instance and attaches it to a new context.
	 *
	 * @param  ctx             current context
	 * @return                 child context to which the new client is attached
	 * @throws VeyronException if a new client cannot be created
	 */
	public static VContext setNewClient(VContext ctx) throws VeyronException {
		return setNewClient(ctx, null);
	}

	/**
	 * Creates a new client instance with the provided options and attaches it to a new context.
	 * A particular runtime implementation chooses which options to support, but at the minimum must
	 * handle the following options:
	 *     CURRENTLY NO OPTIONS ARE MANDATED
	 *
	 * @param  ctx             current context
	 * @param  opts            client options
	 * @return                 child context to which the new client is attached
	 * @throws VeyronException if a new client cannot be created
	 */
	public static VContext setNewClient(VContext ctx, Options opts) throws VeyronException {
		if (opts == null) opts = new Options();
		return getRuntime().setNewClient(ctx, opts);
	}

	/**
	 * Returns the client attached to the given context.
	 *
	 * @param  ctx current context
	 * @return     the client attached to the given context
	 */
	public static Client getClient(VContext ctx) {
		return getRuntime().getClient(ctx);
	}

	/**
	 * Creates a new server instance.
	 *
	 * @param  ctx             current context
	 * @return                 the new server instance
	 * @throws VeyronException if a new server cannot be created
	 */
	public static Server newServer(VContext ctx) throws VeyronException {
		return newServer(ctx, null);
	}

	/**
	 * Creates a new server instance with the provided options.  A particular runtime
	 * implementation chooses which options to support, but at the minimum it must handle
	 * the following options:
	 *     CURRENTLY NO OPTIONS ARE MANDATED
	 *
	 * @param  ctx             current context
	 * @param  opts            server options
	 * @return                 the new server instance
	 * @throws VeyronException if a new server cannot be created
	 */
	public static Server newServer(VContext ctx, Options opts) throws VeyronException {
		if (opts == null) opts = new Options();
		return getRuntime().newServer(ctx, opts);
	}


	/**
	 * Attaches the given principal to a new context (that is derived from the given context).
	 *
	 * @param  ctx             current context
	 * @param  principal       principal to be attached
	 * @return                 child context to which the principal is attached
	 * @throws VeyronException if the principal couldn't be attached
	 */
	public static VContext setPrincipal(VContext ctx, Principal principal) throws VeyronException {
		return getRuntime().setPrincipal(ctx, principal);
	}

	/**
	 * Returns the principal attached to the given context.
	 *
	 * @param  ctx current context
	 * @return     the principal attached to the given context
	 */
	public static Principal getPrincipal(VContext ctx) {
		return getRuntime().getPrincipal(ctx);
	}

	/**
	 * Creates a new namespace instance and attaches it to a new context.
	 *
	 * @param  ctx             current context
	 * @param  roots           roots of the namespace
	 * @return                 child context to which the principal is attached
	 * @throws VeyronException if the namespace couldn't be created
	 */
	public static VContext setNewNamespace(VContext ctx, String... roots) throws VeyronException {
		return getRuntime().setNewNamespace(ctx, roots);
	}

	/**
	 * Returns the namespace attached to the given context.
	 *
	 * @param  ctx current context
	 * @return     the namespace attached to the given context.
	 */
	public static Namespace getNamespace(VContext ctx) {
		return getRuntime().getNamespace(ctx);
	}

	/**
	 * Attaches the given {@code ListenSpec} to a new context (that is derived from the given
	 * context).
	 *
	 * @param  ctx  current context
	 * @param  spec {@code ListenSpec} to be attached
	 * @return      child context to which the {@code ListenSpec} is attached
	 */
	public static VContext setListenSpec(VContext ctx, ListenSpec spec) {
		return getRuntime().setListenSpec(ctx, spec);
	}

	/**
	 * Returns the {@code ListenSpec} attached to the given context.
	 *
	 * @param  ctx current context
	 * @return     the {@code ListenSpec} attached to the given context
	 */
	public static ListenSpec getListenSpec(VContext ctx) {
		return getRuntime().getListenSpec(ctx);
	}

	private static VRuntime getRuntime() {
		init(null);
		return runtime;
	}
}