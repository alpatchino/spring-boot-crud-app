package com.patrick.demo.security.service;

public interface EncryptionService {
	
	String encryptString(String input);
	
	boolean checkPassword(String plainPassword, String encryptedPassword);
}
