package com.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.po.User;

public class UserDAO {
	
	public boolean login(User user) throws UnsupportedEncodingException {
		String username=URLEncoder.encode(user.getUsername(), "utf-8");
		String password=URLEncoder.encode(user.getPassword(), "utf-8");
		if(username.equals("admin") && password.equals("admin")) 
			return true;
		else
			return false;
	}
	
}
