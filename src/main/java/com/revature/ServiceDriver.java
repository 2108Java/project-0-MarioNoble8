package com.revature;
//
//import com.revature.repo.FoodDAO;
//import com.revature.repo.FoodDAOImpl;
//import com.revature.service.ServiceFood;
//import com.revature.service.ServiceFoodImpl;
//import com.revature.views.MenuV1;

import com.revature.repo.BankDAO;
import com.revature.repo.BankDAOImpl;
import com.revature.service.ServiceFoodImpl;
import com.revature.service.ServicePeople;
import com.revature.views.MenuV1;

public class ServiceDriver {
public static void main(String[] args) {
		
		BankDAO database = new BankDAOImpl();
		
		ServicePeople service = new ServiceFoodImpl(database);
		
		MenuV1 theMenu = new MenuV1(service);
		
		theMenu.login();
	}

}
