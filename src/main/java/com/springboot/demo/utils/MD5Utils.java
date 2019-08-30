package com.springboot.demo.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	public static String md5(String str) {

		try {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			byte[] b1 = md.digest(str.getBytes());

			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(b1);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public static void de(String base){
		
		System.out.println(base);
		BASE64Encoder encoder=new BASE64Encoder();
		String bb=encoder.encode(base.getBytes());
		System.out.println(bb);
		BASE64Decoder decoder=new BASE64Decoder();
		
		try{
			byte[] b1=decoder.decodeBuffer(bb);
			System.out.println(new String(b1));
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		
		
		
		
		
		
	}
	

	
	public static String getMD5Str(String origStr) throws Exception{
			MessageDigest md = 
				MessageDigest.getInstance("md5");
			byte[] buf = md.digest(origStr.getBytes());
			BASE64Encoder encoder = 
				new BASE64Encoder();
			String str2 = encoder.encode(buf);
			return str2;
		
	}
	public static void main(String[] args){
	
	
	}
}
