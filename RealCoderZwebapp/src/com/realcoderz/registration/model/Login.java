package com.realcoderz.registration.model;

public class Login {

	private String email;
	private String pwd;
	
	public Login() {
		super();
	}
	public Login(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
