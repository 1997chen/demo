package com.demo.utils;

import java.security.MessageDigest;

public class Md5Util {
	public static String doMD5(String rescoure) throws Exception{
		MessageDigest md = MessageDigest.getInstance("md5");
		StringBuffer sb = new StringBuffer();
		byte[] b = md.digest(rescoure.getBytes());
		for(int i = 0; i < b.length; i++){
			String temp = Integer.toHexString(b[i]);
			if(temp.length() < 2){
				sb.append("0");
			}
			sb.append(temp);
		}
		return sb.toString();
	}
}
