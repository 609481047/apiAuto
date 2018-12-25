package com.sunny.apiAutotest.changeCode;

import java.util.Arrays;

public class StringUtils {
	static StringBuffer sb = new StringBuffer();
	public static String ArraysByteToString(byte bytes[]) {
		for(int i = 0;i<bytes.length;i++) {
			int c = bytes[i]<0 ?256+bytes[i] :bytes[i];
			//System.out.println(c);
			String temp=Integer.toHexString(c).toUpperCase();
			temp = temp.length() == 1 ? "0"+ temp :temp;//灵活运用三目运算
			sb.append(temp);
		}
		return new String(sb);
	}
	public static byte[] hexString2ByteArray(String source){
        if(source.length() % 2 != 0){
            source = "0" + source;
        }
        int len = source.length() / 2;
        byte[] bytes = new byte[len];
        for(int i = 0; i < len; i++){
            int c = Integer.parseInt(source.substring(i*2, i*2+2), 16);
            bytes[i] = (byte)c;
        }
        return bytes;
    }

}
