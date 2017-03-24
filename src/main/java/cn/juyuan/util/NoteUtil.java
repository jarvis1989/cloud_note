package cn.juyuan.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;


public class NoteUtil {
	public static String md5(String str){
		try {
			MessageDigest md=MessageDigest.getInstance("md5");
			byte[] output=md.digest(str.getBytes());
			String out=Base64.encodeBase64String(output);
			
			return out;
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		
		
		
		
		
		
	}
	
	public static String createId(){
		UUID uuid=UUID.randomUUID();
		String id=uuid.toString();
		return id.replace("-", "");
	}
	
	public static void main(String[] args) {
		String s=NoteUtil.md5("123456");
		System.out.println(s);
	}
	
	
}
