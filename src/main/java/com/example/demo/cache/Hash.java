//package com.example.demo.cache;
//
//import java.nio.charset.StandardCharsets;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Hash {
//
//	@Cacheable("md5")
//	public byte[] md5(String text) {
//
//		System.out.println("hash: " + text);
//
//		try {
//			MessageDigest md = MessageDigest.getInstance("MD5");
//
//			return md.digest(text.getBytes(StandardCharsets.UTF_8));
//
//		} catch (NoSuchAlgorithmException e) {
//			throw new IllegalStateException(e);
//		}
//	}
//}
