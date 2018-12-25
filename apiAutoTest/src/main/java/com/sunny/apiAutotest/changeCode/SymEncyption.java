package com.sunny.apiAutotest.changeCode;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;


//Des Data Encryption Standard  //Aes   advance Encryption Standard 
//对称性加密
public class SymEncyption {
	public static String DESEncrypt(String content, String key) throws
	NoSuchAlgorithmException,
	UnsupportedEncodingException,
	InvalidKeyException,
	InvalidKeySpecException,
	NoSuchPaddingException,
	BadPaddingException,
	IllegalBlockSizeException,
	InvalidAlgorithmParameterException {
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		DESKeySpec keySpec = new DESKeySpec(key.getBytes("utf-8"));
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		IvParameterSpec iv = new IvParameterSpec("11223344".getBytes("utf-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
		byte[] bytes = cipher.doFinal(content.getBytes("utf-8"));
		return StringUtils.ArraysByteToString(bytes);
	}
//对称性解密
	public static String DESDecrypt(String content, String key) throws
	NoSuchAlgorithmException,
	UnsupportedEncodingException,
	InvalidKeyException,
	InvalidKeySpecException,
	NoSuchPaddingException,
	BadPaddingException,
	IllegalBlockSizeException,
	InvalidAlgorithmParameterException {
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		DESKeySpec keySpec = new DESKeySpec(key.getBytes("utf-8"));
		SecretKey secretKey = keyFactory.generateSecret(keySpec);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		IvParameterSpec iv = new IvParameterSpec("11223344".getBytes("utf-8"));
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
		byte[] bytes = cipher.doFinal(StringUtils.hexString2ByteArray(content));
		return new String(bytes,"utf-8");
	}

	public static void main(String[] args) {
		String str1 = "123456";
		String key = "liudao01";
		try{
			String str2 = DESEncrypt(str1, key);
			System.out.println("DES加密后的值: "+str2);
			String str3 = DESDecrypt(str2, key);
			System.out.println("DES解密后的值: "+str3);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
