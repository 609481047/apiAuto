package com.sunny.apiAutotest.changeCode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

public class urlEncode {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String a = "abcd//#";
		String b = URLEncoder.encode(a, "utf-8");
		 
		System.out.println(b);
	}
}
