package io.veyron.veyron.veyron2.security;

import io.veyron.veyron.veyron2.VeyronException;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.interfaces.ECPublicKey;
import java.util.Arrays;

/**
 * Security class implements various functions used for creating and managing Veyron security
 * primitives.
 */
public class Security {
	private static final String TAG = "Veyron runtime";

	/**
	 * Mints a new private key and generates a principal based on this key, storing its
	 * BlessingRoots and BlessingStore in memory.
	 *
	 * @return                 in-memory principal using the newly minted private key.
	 * @throws VeyronException if the principal couldn't be created.
	 */
	public static Principal newPrincipal() throws VeyronException {
		return PrincipalImpl.create();
	}

	/**
	 * Creates a principal using the provided signer, storing its BlessingRoots and BlessingStore
	 * in memory.
	 *
	 * @param  signer          signer to be used by the new principal.
	 * @return                 in-memory principal using the provided signer.
	 * @throws VeyronException if the principal couldn't be created.
	 */
	public static Principal newPrincipal(Signer signer) throws VeyronException {
		return PrincipalImpl.create(signer);
	}

	/**
	 * Creates a principal using the provided signer, BlessingStore, and BlessingRoots.
	 *
	 * @param  signer signer to be used by the principal.
	 * @param  store  BlessingStore to be used by the principal.
	 * @param  roots  BlessingRoots to be used by the principal.
	 * @return        newly created principal.
	 */
	public static Principal newPrincipal(Signer signer, BlessingStore store, BlessingRoots roots)
		throws VeyronException {
		return PrincipalImpl.create(signer, store, roots);
	}

	/**
	 * Reads the entire state for a principal (i.e., private key, BlessingRoots, BlessingStore) from
	 * the provided directory {@code dir} and commits all state changes to the same directory.
	 *
	 * If the directory does not contain state, a new private key is minted and all state of the
	 * principal is committed to {@code dir}. If the directory does not exist, it is created.
	 *
	 * @param  passphrase      passphrase used to encrypt the private key.  If empty, no encryption
	 *                         is done.
	 * @param  dir             directory where the state for a principal is to be persisted.
	 * @return                 principal whose state is persisted in the provided directory.
	 * @throws VeyronException if the principal couldn't be created.
	 */
	public static Principal newPersistentPrincipal(String passphrase, String dir)
			throws VeyronException {
		return PrincipalImpl.createPersistent(passphrase, dir);
	}

	/**
	 * Creates a new principal using the provided signer and a partial state (i.e., BlessingRoots,
	 * BlessingStore) that is read from the provided directory {@code dir}.  Changes to the
	 * partial state are persisted and commited to the same directory.  The provided signer isn't
	 * persisted: the caller is expected to persist it separately or use the
	 * {@code newPersistentPrincipal()} method instead.
	 *
	 * If the directory does not contain any partial state, a new partial state instances are
	 * created and subsequently commited to {@code dir}.  If the directory does not exist, it
	 * is created.
	 *
	 * @param  signer          signer to be used by the new principal.
	 * @param  dir             directory where the partial state for a principal is to be persisted.
	 * @return                 principal whose partial state is persisted in the provided directory.
	 * @throws VeyronException if the principal couldn't be created.
	 */
	public static Principal newPersistentPrincipal(Signer signer, String dir)
		throws VeyronException {
		return PrincipalImpl.createPersistent(signer, dir);
	}

	/**
	 * Creates new blessings using the provided wire-encoded blessings.
	 *
	 * @param  wire            wire-encoded blessings.
	 * @return                 new blessings based on the wire-encoded blessings.
	 * @throws VeyronException if the blessings couldn't be created.
	 */
	public static Blessings newBlessings(WireBlessings wire) throws VeyronException {
		return BlessingsImpl.create(wire);
	}

	/**
	 * Returns a caveat that never fails to validate. This is useful only for providing
	 * unconstrained blessings to another principal.
	 *
	 * @return a caveat that never fails to validate.
	 */
	public static Caveat newUnconstrainedUseCaveat() {
		return new Caveat(null);
	}

	/**
	 * Verifies the provides signature of the given message, using the supplied public key.
	 *
	 * @param  sig             signature in the veyron format.
	 * @param  key             public key.
	 * @param  message         message whose signature is verified.
	 * @throws VeyronException iff the signature doesn't verify.
	 */
	public static void verifySignature(Signature sig, ECPublicKey key, byte[] message)
		throws VeyronException {
		final String hashAlgorithm = sig.getHash().getValue();
		final String verifyAlgorithm = hashAlgorithm + "withECDSA";
		try {
			message = CryptoUtil.messageDigest(hashAlgorithm, message, sig.getPurpose());
			final byte[] jSig = CryptoUtil.javaSignature(sig);
			final java.security.Signature verifier = java.security.Signature.getInstance(hashAlgorithm + "withECDSA");
			verifier.initVerify(key);
			verifier.update(message);
			if (!verifier.verify(jSig)) {
				throw new VeyronException("Signature doesn't verify.");
			}
		} catch (NoSuchAlgorithmException e) {
			throw new VeyronException("Verifying algorithm " + verifyAlgorithm +
					" not supported by the runtime: " + e.getMessage());
		} catch (InvalidKeyException e) {
			throw new VeyronException("Invalid private key: " + e.getMessage());
		} catch (SignatureException e) {
			throw new VeyronException(
				"Invalid signing data [ " + Arrays.toString(message) + " ]: " + e.getMessage());
		}
	}

	// Set of all valid Labels for IPC methods.
	public static Label[] VALID_LABELS =
		{ SecurityConstants.READ_LABEL, SecurityConstants.WRITE_LABEL, SecurityConstants.ADMIN_LABEL,
			SecurityConstants.DEBUG_LABEL, SecurityConstants.MONITORING_LABEL };

	/**
	 * Returns true iff the provided label is among the set of valid labels.
	 *
	 * @param  label the label being checked for validity.
	 * @return       true iff the label is valid.
	 */
	public static boolean IsValidLabel(Label label) {
		for (Label validLabel : VALID_LABELS) {
			if (validLabel.equals(label)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Creates an authorizer for the provided ACL. The authorizer authorizes a request iff the
	 * identity at the remote end has a name authorized by the provided ACL for the request's label,
	 * or the request corresponds to a self-RPC.
	 *
	 * @param  acl ACL used for authorization checks.
	 * @return     Authorizer that performs authorization checks.
	 */
	public static Authorizer newACLAuthorizer(ACL acl) {
		return new ACLAuthorizer(acl);
	}

	private static class ACLAuthorizer implements Authorizer {
		private final ACL acl;

		ACLAuthorizer(ACL acl) {
			this.acl = acl;
		}

		@Override
		public void authorize(Context context) throws VeyronException {
			// TODO(spetrovic): implement this.
		}
	}
}
