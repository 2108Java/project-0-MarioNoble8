package com.revature.service;

import com.revature.people.Customer;
import com.revature.repo.BankDAO;

public class ServicePeopleImpl implements ServicePeople {
	
	BankDAO database;

	public ServicePeopleImpl(BankDAO database) {
		this.database = database;
	}

	public boolean addCustomer(Customer newCustomer) {
		
		return database.insertCustomer(newCustomer);
	}

}
