package com.revature.service;

import com.revature.people.Customer;
import com.revature.people.Employee;

public interface ServicePeople {
	
	public boolean addCustomer(Customer newCustomer);
	

	public boolean addEmployee(Employee newEmployee);
	
	public String loginUser(String user, String pass);
	
	public boolean addAccount(String accountName, float balance, String acctType, String amountUsers);

}
