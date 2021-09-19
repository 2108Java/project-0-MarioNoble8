package com.revature.service;

import com.revature.people.Customer;
import com.revature.people.Employee;

public interface ServicePeople {
	
	public boolean addCustomer(Customer newCustomer);
	

	public boolean addEmployee(Employee newEmployee);
	
	public String loginUser(String user, String pass);
	
	public boolean addAccount(String accountName, float balance, String acctType, String amountUsers, String username);


	public boolean viewBalance(String accountName, String username);


	public boolean addDeposit(String accountName, float balance);


	public boolean takeMoney(String accountName, float balance);


	public void approvingAccounts();


	public void viewAccounts(String userName);


	public boolean transferMoney(String accountName, String accountNamme, float balance, String usrname);

}
