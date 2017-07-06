package com.github.dtos;

public class LoginDto {
	private String email;
	private String password;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {	return email;	}
	public void setEmail(String email) {	this.email = email;	}

	public String getPassword() {	return password;	}
	public void setPassword(String password) {	this.password = password;	}
	
	@Override
	public String toString() {
		return "LoginDto [email=" + email + ", password=" + password + ", userName=" + userName + "]";
	}
}