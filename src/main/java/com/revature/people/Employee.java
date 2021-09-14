package com.revature.people;

public class Employee extends User {
	
	public Employee(String userName, String password) {
		super(userName, password, "Employee" );
		// TODO Auto-generated constructor stub
	}

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
