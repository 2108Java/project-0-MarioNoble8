package com.revature.people;

public abstract class User {
	
	String userName;
	String password;
	String userType;
	
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
	
	public void login(String userName, String password) {
		
		
	}
	
	abstract public String getUserType();
	public User(String userName, String password, String userType) {
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}
	}


