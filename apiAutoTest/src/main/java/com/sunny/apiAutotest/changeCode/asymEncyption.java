package com.sunny.apiAutotest.changeCode;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.HashMap;
import java.util.Map;
//非对称性加密
public class asymEncyption {

	public static Map<String, Key> genRSAKeyPair(int keyPairSize) throws 
	NoSuchAlgorithmException{
		Map<String, Key> keyMap = new HashMap<>();
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(keyPairSize);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		keyMap.put("publicKey", keyPair.getPublic());
		keyMap.put("privateKey", keyPair.getPrivate());
		return keyMap;	
	}
	//
	public static String publicRsaEncypt(String content,PublicKey publicKey) throws 
	NoSuchAlgorithmException, 
	NoSuchPaddingException,
	InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {

		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(cipher.ENCRYPT_MODE, publicKey);
		byte[] bytes = cipher.doFinal(content.getBytes("utf-8"));
		return StringUtils.ArraysByteToString(bytes);
	}

	public static String privateRsaDecyte(String content,PrivateKey privateKey) throws 
	NoSuchAlgorithmException, 
	NoSuchPaddingException, 
	InvalidKeyException, 
	IllegalBlockSizeException, 
	BadPaddingException, 
	UnsupportedEncodingException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(cipher.DECRYPT_MODE, privateKey);
		byte[] bytes = cipher.doFinal(StringUtils.hexString2ByteArray(content));
		return new String(bytes,"utf-8");
	} 
	public static void main(String[] args) throws Exception {
		Map<String, Key> keyMap = genRSAKeyPair(2048);
		PublicKey publicKey = (PublicKey) keyMap.get("publicKey");
		PrivateKey privateKey = (PrivateKey) keyMap.get("privateKey");
		System.out.println("public key --> " + publicKey);
		System.out.println("private key --> " + privateKey);
		String content = "陈云峰";
		String str1 = publicRsaEncypt(content, publicKey);
		System.out.println("RSA公钥加密后: "+str1);
		String str2 = privateRsaDecyte(str1, privateKey);
		System.out.println("RSA私钥解密后: "+str2);
	}
}
