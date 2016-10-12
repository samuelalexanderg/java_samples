package encryption;

import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class DecryptRuby {    
    public static String decrypt(String encrypted, String pwd, byte[] salt)
            throws Exception {

        String[] parts = encrypted.split("--");
        if (parts.length != 2) return null;

        byte[] encryptedData = Base64.decodeBase64(parts[0]);
        byte[] iv = Base64.decodeBase64(parts[1]);
        
        System.out.println(new String(Base64.decodeBase64(encryptedData)));
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(pwd.toCharArray(), salt, 1000, 64);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey aesKey = new SecretKeySpec(tmp.getEncoded(), "AES");

		SecretKeySpec key = new SecretKeySpec(pwd.getBytes("UTF-8"),
				"AES");
		
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv, 0, 16));

        byte[] result = cipher.doFinal(encryptedData);
        System.out.println(new String(result));
        return result.toString();
    }
    
    public static void main(String[] args) throws Exception {
    	String encrypted = "N1M4Yk5jdTFwbnFCb3NTZVJiL0UwMkJ3eXNZdmdjQVYvK0pBdk5YSnZzR0dxT1pqUWlBa2lLQ0pXbndteXhNeGhVUGMwYnRZMDFmaFJSVUZKQ0Noamc9PS0tcE5PMHY2RnNQOUhpTTF0S3ZOV1pQQT09--21c2d9fbdff006681d17095d896c70c9cc2c6bca";
    	String pwd = "02f1a0da7d56fc0783b18a9fe4e5f7e91ee57acccd6abf00f78a8ee910e4a6d545edf53f9606b2245d5d3418dcde2cebfe1a5bcff92b29eac9fb058af1d977de";
    	String salt = "encrypted cookie";
    	decrypt(new String(Base64.decodeBase64(encrypted)), new String(Base64.decodeBase64(encrypted)), salt.getBytes());
    }
}