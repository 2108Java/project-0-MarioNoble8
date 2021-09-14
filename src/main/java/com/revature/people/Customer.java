package com.revature.people;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
	public Customer(String userName, String password) {
		super(userName, password, "Customer");
		// TODO Auto-generated constructor stub
	}

	ArrayList<String> account = new ArrayList<String>();
	
	public void applyForAccount() {
		
	}
	
	public void viewBalances() {
		
	}
	
	public void withdrawMoney(double totalWithdraw) {
		
	}
	
	public void depositMoney(double totalDeposit) {
		
	}
	
	public void transferMoney(double totalTransfer, String accountId) {
		
	}
	
	public void acceptReject(boolean answer) {
		
	}

	public String getUserType() {
		// TODO Auto-generated method stub
		return "Customer";
	}

	

//	public String getAccountType() {
//		
//		return database.getAccountType();
//	}

	
}
