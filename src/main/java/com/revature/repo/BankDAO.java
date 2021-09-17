package com.revature.repo;

import com.revature.people.Customer;
import com.revature.people.Employee;

//import com.revature.models.ToDoItem;

public interface BankDAO {

	boolean insertCustomer(Customer newCustomer);

	boolean insertEmployee(Employee newEmployee);
	
	String loginUser(String userName, String password);
	
	String optionsMenuCustomer(String accountName, String balance);
	
	boolean addAccount(String accountName, float balance, String acctType, String amountUsers);
	
}
