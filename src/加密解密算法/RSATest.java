package 加密解密算法;

import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class RSATest {
	
	private static String KEY_ALGORITHM = "RSA";
	private static String ALGORITHM = "DESede";
	private static String KEY_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRdVn4FFfhTkhlnpUUfquGDwOsJuZWveER+30L"
			+ "VbNBXIqBfEtcIrvstwaJ9QKb7zf55mEFCf4t3GxWdcMV39KPFyuCRj9fQxgBxrKksAUzawuBchhT"
			+ "QhJ/4nIlDw6zl/HyJi26S2IIFyBK2QhwjQQQ/spyZ9fgtoLCKr1MhmkUOQIDAQAB";
	private static String KEY_PRIVATE = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJF1WfgUV+FOSGWelRR+q4YPA6wm"
			+ "5la94RH7fQtVs0FcioF8S1wiu+y3Bon1ApvvN/nmYQUJ/i3cbFZ1wxXf0o8XK4JGP19DGAHGsqSw"
			+ "BTNrC4FyGFNCEn/iciUPDrOX8fImLbpLYggXIErZCHCNBBD+ynJn1+C2gsIqvUyGaRQ5AgMBAAEC"
			+ "gYBEgbKX5mzlTktGoQOxnV8HSnb+U2vUmqUwJPPlrL06IW2SQonzoOBFQoYv31cVPfttFRXIm8Y8"
			+ "rz3PErOIz9uIk+M8Pd1K1+eN/Lu8DBTANVFXEZ0OL48Vvr9wzzyk9Ht1IAtzTMQwtdv9zUXNhCor"
			+ "xQe9YebBIgDyaYS7g2qoiQJBAOlBohxGrG/2x0ZsqEk0FWpsyZKi1sB9pDIn4eUqQ1HqI9IX5xwM"
			+ "ddQZhhD17pU9tBgEZXPPc7YnBjCezAvY7aMCQQCfpCwpB6Nnmqs/BOfI0+bMLErMy+1dXBVy58A6"
			+ "8vwIhPbjzCWw47NBLes0fl8u9xT3dw5RAa67kWR47HKkrZxzAkBechzZpiQcEagOc+CQA27IcNQN"
			+ "c7HQrw7U4CEvUTWA7XUjlFoXmVP8VXlbVLkN5LYPI3iQs+b+Uj7HYQTtpyBRAkEAi7m00SCXW+nb"
			+ "MqhHetZFLrUhrwhaNBmRyGWhMbdU8tv1/8HBx4Y0cbsQH3zwMHogRsxUooA3gIIsD07ctNgjkwJB"
			+ "AKwqyMpO60I/eFzjX0dTjmCZnTqCjn4xHwCDUvvNJ3ywZPHNKJtJ85TtoBL2jzhyPF4zfiiCfboM"
			+ "q8X2chyeUTk=";
	

	public static void main(String[] args) throws Exception{
		System.out.println(KEY_PRIVATE.getBytes().length);
		System.out.println(KEY_PUBLIC.getBytes().length);
		System.out.println(encryptRSA("王东起"));
		System.out.println(decryptRSA(encryptRSA("王东起")));

	}
	public static String encryptRSA(String key) throws Exception{
		String value = encryptBASE64(encryptByPublicKeyRSA(key.getBytes("UTF-8"), KEY_PUBLIC));
		return value.replaceAll("\r", "").replaceAll("\n", "");
	}
	public static String decryptRSA(String key) throws Exception{
		byte[] decodedData = decryptByPrivateRSA(decryptBASE64(key), KEY_PRIVATE);
		String outputStr = new String(decodedData);
		return outputStr.replaceAll("\t", "").replaceAll("\n", "");
	}
	//对数据进行加密
	public static String encryptBASE64(byte[] key){
		return new BASE64Encoder().encodeBuffer(key);
	}
	//对数据进行解密
	public static byte[] decryptBASE64(String key) throws IOException{
		return new BASE64Decoder().decodeBuffer(key);
	}
	
	//对数据进行RSA根据私钥加密
	public static byte[] encryptByprivateKeyRSA(byte[] data, String key) throws Exception{
		//对私钥进行BASE64进行解密
		byte[] keyBytes = decryptBASE64(key);
		//获得私钥
		PKCS8EncodedKeySpec pkcs8keyspec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8keyspec);
		
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		return cipher.doFinal(data);
	}
	//对数据进行RSA公钥加密
	public static byte[] encryptByPublicKeyRSA(byte[] data, String key) throws Exception{
		//对私钥进行BASE64进行解密
		byte[] keyBytes = decryptBASE64(key);
		//获得私钥
		X509EncodedKeySpec pkcs8keyspec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey publicKey = keyFactory.generatePublic(pkcs8keyspec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(data);
	}
	//对数据进行RSA私钥解密
	public static byte[] decryptByPrivateRSA(byte[] data, String key) throws Exception{
		//对私钥进行BASE64进行解密
		byte[] keyBytes = decryptBASE64(key);
		//获得私钥
		PKCS8EncodedKeySpec x509keyspec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateKey = keyFactory.generatePrivate(x509keyspec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(data);
	}
	//对数据进行RSA公钥解密
	public static byte[] decryptByPublicRSA(byte[] data, String key) throws Exception{
		byte[] keyBytes = decryptBASE64(key);
		X509EncodedKeySpec x509keyspec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicKey = keyFactory.generatePublic(x509keyspec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		return cipher.doFinal(data);
	}
}
