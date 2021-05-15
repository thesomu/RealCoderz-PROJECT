package com.realcoderz.registration.model;


public class Users {
	
	private int userid;
	private String firstname;
	private String lastname;	
	private String password;
	private String email;
	public Users(int userid, String firstname, String lastname, String password, String email) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
	}
	public Users() {
		super();
	}
	public int getUserId() {
		return userid;
	}
	public void setUserId(int userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
