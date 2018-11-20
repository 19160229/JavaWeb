package com.po;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class User {

	private String username;
	private String password;
	
	public User(){}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) throws UnsupportedEncodingException {
		this.username = URLEncoder.encode(username, "utf-8");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws UnsupportedEncodingException {
		this.password = URLEncoder.encode(password, "utf-8");
	}
	
}
