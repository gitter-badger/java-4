package io.veyron.veyron.veyron.runtimes.google.security;

import android.security.KeyPairGeneratorSpec;

import io.veyron.veyron.veyron2.ipc.VeyronException;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;

import javax.security.auth.x500.X500Principal;

/**
 * CryptoUtil holds various cryptographic utilities.
 */
public class CryptoUtil {
	private static final String KEYSTORE = "AndroidKeyStore";
	private static final String PK_ALGORITHM = "EC";
	private static final int KEY_SIZE = 256;

	/**
	 * Generates a new private key and stores it in the Android KeyStore under the provided alias.
	 * If a key already exists under the provided alias, it will be overwritten.
	 * Throws an exception if the key could not be generated.
	 *
	 * @param  ctx             android Context.
	 * @param  alias           alias under which the private key will be stored inside the KeyStore.
	 * @return                 an entry storing the private key and the certificate chain for the
	 *                         corresponding public key.
	 * @throws VeyronException if the key could not be generated.
	 */
	public static KeyStore.PrivateKeyEntry genKeyStorePrivateKey(
    android.content.Context ctx, String alias) throws VeyronException {
    try {
			// NOTE(spetrovic): KeyPairGenerator needs to be initialized with "RSA" algorithm and
			// not "EC" algorithm, even though we generate "EC" keys below.  Otherwise, Android
			// KeyStore claims that "EC" is an unrecognized algorithm!
			final KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", KEYSTORE);
      final Calendar notBefore = Calendar.getInstance();
      final Calendar notAfter = Calendar.getInstance();
      notAfter.add(1, Calendar.YEAR);
      final KeyPairGeneratorSpec spec = new KeyPairGeneratorSpec.Builder(ctx)
        		.setAlias(alias)
        		.setKeyType(PK_ALGORITHM)
        		.setKeySize(KEY_SIZE)
        		.setSubject(new X500Principal(
        			String.format("CN=%s, OU=%s", alias, ctx.getPackageName())))
        		.setSerialNumber(BigInteger.ONE)
        		.setStartDate(notBefore.getTime())
        		.setEndDate(notAfter.getTime())
        		.build();
      keyGen.initialize(spec);
      keyGen.generateKeyPair();
      return getKeyStorePrivateKey(alias);
    } catch (NoSuchProviderException e) {
      throw new VeyronException("Couldn't find Android KeyStore");
    } catch (NoSuchAlgorithmException e) {
      throw new VeyronException(
      			"Keystore doesn't support " + PK_ALGORITHM + " algorithm: " + e.getMessage());
    } catch (InvalidAlgorithmParameterException e) {
      throw new VeyronException("Invalid keystore algorithm parameters: " + e.getMessage());
    }
  }

	/**
	 * Returns the private key if it exists in the Android KeyStore or null if it doesn't exist.
	 * Throws an exception on an error.
	 *
	 * @param  alias           alias of the key in the KeyStore.
	 * @return                 an entry storing the private key and the certificate chain for the
	 *                         corresponding public key.
	 * @throws VeyronException if the key could not be retrieved.
	 */
	public static KeyStore.PrivateKeyEntry getKeyStorePrivateKey(String alias) throws VeyronException {
		try {
      final KeyStore keyStore = KeyStore.getInstance(KEYSTORE);
      keyStore.load(null);
      final KeyStore.Entry entry = keyStore.getEntry(alias, null);
      if (entry == null) {
        return null;
      }
      if (!(entry instanceof KeyStore.PrivateKeyEntry)) {
        throw new VeyronException("Entry " + alias + " exists but not a private key entry.");
      }
      return (KeyStore.PrivateKeyEntry)entry;
		} catch (KeyStoreException e) {
			throw new VeyronException("KeyStore not initialized: " + e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new VeyronException("KeyStore doesn't support the algorithm: " + e.getMessage());
		} catch (IOException e) {
			throw new VeyronException("Error loading keystore: " + e.getMessage());
		} catch (CertificateException e) {
			throw new VeyronException("Error loading keystore certificates: " + e.getMessage());
		} catch (UnrecoverableEntryException e) {
			throw new VeyronException("Couldn't get keystore entry: " + e.getMessage());
		}
	}

  /**
   * Decodes the provided DER-encoded ECDSA public key.
   *
   * @param  encodedKey      DER-encoded ECDSA public key.
   * @return                 ECDSA public key.
   * @throws VeyronException if the public key could not be decoded.
   */
  public static ECPublicKey decodeECPublicKey(byte[] encodedKey) throws VeyronException {
   	try {
      final X509EncodedKeySpec spec = new X509EncodedKeySpec(encodedKey);
      final KeyFactory factory = KeyFactory.getInstance(PK_ALGORITHM);
      return (ECPublicKey)factory.generatePublic(spec);
  	} catch (NoSuchAlgorithmException e) {
  		throw new VeyronException(
    			"Java runtime doesn't support " + PK_ALGORITHM + " algorithm: " + e.getMessage());
   	} catch (InvalidKeySpecException e) {
  		throw new VeyronException("Encoded key is incompatible with " + PK_ALGORITHM +
   			" algorithm: " + e.getMessage());
   	}
  }
}