package com.sunny.apiAutotest.changeCode;

import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class digestUtils {
	public static String hashDigest(String content,String algorithm) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String result = null;
		MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
		byte[]  bytes =   messageDigest.digest(content.getBytes("utf-8"));
		result = StringUtils.ArraysByteToString(bytes);
		System.out.println(result);
		return result;
		
	}
	public static void main(String[] args) {
		String message = "hello,baby";

		try {
			hashDigest(message, "sha-512");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
