package encryption;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sun.misc.BASE64Encoder;

public class EncryptionSample {

	public static String encrypt(String plainText, String encryptionKey)
			throws Exception {
		// Algorithm to be used and the provider
		// We are not providing provider, so it will pick the first one
		Cipher cipher = Cipher.getInstance("AES");
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"),
				"AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
//		return new BASE64Encoder().encode(cipher.doFinal(plainText.getBytes("UTF-8")));
		return new String(Base64.encodeBase64(cipher.doFinal(plainText.getBytes("UTF-8"))));
	}

	public static String decrypt(String cipherText, String encryptionKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"),
				"AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		return new String(cipher.doFinal(Base64.decodeBase64(cipherText.getBytes())), "UTF-8");
	}

	public static void main(String[] args) {
		try {
//			EncryptBean encryptBean = new EncryptBean();
//			encryptBean.setCipher("mNl941+d+wyOQBOUYgXhiw==");
//			GsonBuilder gsonBuilder = new GsonBuilder();
//			gsonBuilder.disableHtmlEscaping();
//			Gson gson = gsonBuilder.create();
//			String json1 = new Gson().toJson(encryptBean);
//			String json2 = gson.toJson(encryptBean);
//			System.out.println(gson.toJson(encryptBean));
//			System.out.println(new Gson().toJson(encryptBean));
//			EncryptBean bean = new Gson().fromJson(json2, EncryptBean.class);
//			System.out.println(bean.getCipher());
//			System.out.println(URLDecoder.decode("mNl941+d+wyOQBOUYgXhiwu003du003d", "UTF-8"));
			String plaintext = "text_to_be_encrypted";
			// Key has to be of 16,24 or 36 bytes
//			String encryptionKey = "0123456789abcdef";
			String encryptionKey = "aZM<CE(2&riZ7^d2";

			String cipher = encrypt(plaintext, encryptionKey);
			System.out.println("cipher:  " + cipher);

			String decrypted = decrypt(cipher, encryptionKey);
			System.out.println("decrypt: " + decrypted);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
