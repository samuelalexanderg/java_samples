package encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EnryptionSample {

	public static byte[] encrypt(String plainText, String encryptionKey)
			throws Exception {
		// Algorithm to be used and the provider
		// We are not providing provider, so it will pick the first one
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"),
				"AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(plainText.getBytes("UTF-8"));
	}

	public static String decrypt(byte[] cipherText, String encryptionKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"),
				"AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		return new String(cipher.doFinal(cipherText), "UTF-8");
	}

	public static void main(String[] args) {
		try {
			String plaintext = "text_to_be_encrypted";
			// Key has to be of 16,24 or 36 bytes
			String encryptionKey = "0123456789abcdef";

			byte[] cipher = encrypt(plaintext, encryptionKey);
			System.out.print("cipher:  " + new String(cipher));

			String decrypted = decrypt(cipher, encryptionKey);
			System.out.println("decrypt: " + decrypted);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
