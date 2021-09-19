package com.revature.service;

import com.revature.people.Customer;
import com.revature.people.Employee;
import com.revature.repo.BankDAO;

public class ServicePeopleImpl implements ServicePeople {
	
	BankDAO database;

	public ServicePeopleImpl(BankDAO database) {
		this.database = database;
	}

	public boolean addCustomer(Customer newCustomer) {
		
		return database.insertCustomer(newCustomer);
	}

	
	public boolean addEmployee(Employee newEmployee) {
		
		return database.insertEmployee(newEmployee);
	}

	
	public String loginUser(String user, String pass) {
		
		return database.loginUser(user, pass);
	}

	
	public boolean addAccount(String accountName, float balance, String acctType, String amountUsers, String username) {
		
		return database.addAccount(accountName, balance, acctType, amountUsers, username);
	}


	
	public boolean addDeposit(String accountName, float balance) {
		// TODO Auto-generated method stub
		return database.addDeposit(accountName, balance);
	}

	@Override
	public boolean takeMoney(String accountName, float balance) {
		// TODO Auto-generated method stub
		return database.takeMoney(accountName, balance);
	}

	@Override
	public void approvingAccounts() {
		database.approvingAccounts();		
	}

	@Override
	public void viewAccounts(String userName) {
		database.viewAccounts(userName);
		
	}

	@Override
	public boolean viewBalance(String accountName, String username) {
		// TODO Auto-generated method stub
		return database.viewBalance(accountName, username);
	}

	@Override
	public boolean transferMoney(String accountName, String accountNamme, float balance, String usrname) {
		// TODO Auto-generated method stub
		return database.transferMoney(accountName, accountNamme, balance, usrname);
	}

}
