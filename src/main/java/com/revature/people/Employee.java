package com.revature.people;

import java.util.ArrayList;

public class Employee extends User {
	
	public Employee(String userName, String password) {
		super(userName, password, "Employee" );
		// TODO Auto-generated constructor stub
	}
	
	ArrayList<String> account = new ArrayList<String>();

	public void viewCustomersAccounts(String userName) {
		
	}
	
	public void viewAllTransactions(String userName) {
		
	}
	
	public void acceptRejectAccount() {
		
	}

	@Override
	public String getUserType() {
		// TODO Auto-generated method stub
		return "Employee";
	}
	

}
