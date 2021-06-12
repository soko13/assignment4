package net.assignment.bean;

import java.io.*;

public class LoginBean implements Serializable {
	
	private static final long UID = 1;
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password; 
	}

}
