package com.promineotech.customerTrackerApi.entity;

import java.security.Key;
import java.util.Base64;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class Credentials {
	
	private String userName;
	private String password;
	
	Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	String jwt = Jwts.builder()
			.claim("role", "ADMIN")
			.setSubject("customerTackerApi JWT")
			.signWith(key)
			.compact();
	
	String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
	
	byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
	
	public Key isTokenValid() {
		
	}
	
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	

}
