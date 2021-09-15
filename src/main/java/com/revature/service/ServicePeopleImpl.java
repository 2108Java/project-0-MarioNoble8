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

	@Override
	public String loginUser(String user, String pass) {
		
		return database.loginUser(user, pass);
	}

}
