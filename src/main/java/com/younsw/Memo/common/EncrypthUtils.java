package com.younsw.Memo.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncrypthUtils {
	
	// 암호화 가능 메소드 
	public static String md5(String message) {
		
		String resultDate = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			
			byte[] bytes = message.getBytes();
			
			md.update(bytes);
			// 암호화된 결과 받기
			byte[] digest = md.digest();
			
			// 암호화된 결과를 16진수 문자열로 변환
			for(int i=0; i<digest.length; i++) {
				resultDate += Integer.toHexString(digest[i] & 0xff);
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultDate;
		
		
	}

}
