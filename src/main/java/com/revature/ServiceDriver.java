package com.revature;
//
//import com.revature.repo.FoodDAO;
//import com.revature.repo.FoodDAOImpl;
//import com.revature.service.ServiceFood;
//import com.revature.service.ServiceFoodImpl;
//import com.revature.views.MenuV1;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.revature.repo.BankDAO;
import com.revature.repo.BankDAOImpl;

import com.revature.service.ServicePeopleImpl;
import com.revature.service.ServicePeople;
import com.revature.views.MenuV1;

public class ServiceDriver {
	
	public final static Logger loggy = Logger.getLogger("ServiceDriver.class");
	
	public static void main(String[] args) {
	
	loggy.setLevel(Level.WARN);
	
	loggy.info("Starting the application");
		
		BankDAO database = new BankDAOImpl();
		
		ServicePeople service = new ServicePeopleImpl(database);
		
		MenuV1 theMenu = new MenuV1(service);
		
		theMenu.login();
	}

}
