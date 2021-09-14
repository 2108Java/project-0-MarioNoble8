package com.revature.views;

import java.util.Scanner;

import com.revature.people.Customer;
import com.revature.service.ServicePeople;

public class MenuV1 implements Menu {

	ServicePeople service;


	public MenuV1(ServicePeople service) {
		this.service = service;
	}


	public void displayEmployee() {
		
		
	}

	
	public void displayLogin() {
		
		
	}
	
	public void displayLogin(Scanner sc) {
		boolean running = true;
		while(running) {
			
		System.out.println("1) Create an account");
		System.out.println("2) Existing account");
		System.out.println("3) Exit");
		
		String result = sc.nextLine();
		
		switch(result) {
		case"1":
			displayCreateAccount(sc);
			break;
		case"2":
		case"3":
			running = false;
			break;
			default:
				
		}
		
		}
	}


	public void displayCreateAccount(Scanner sc) {
		boolean running = true;
		while(running) {
			
		System.out.println("1) Are you a Customer");
		System.out.println("2) Are you an Employee");
		System.out.println("3) Exit");
		
		
		String result = sc.nextLine();
		
		switch(result) {
		case"1":
			System.out.println("What is your username: ");
			String username = sc.nextLine();
			System.out.println("What is your password: ");
			String password = sc.nextLine();
//			System.out.println("What type of account do you want: ");
//			String accountType = sc.nextLine();
			
			Customer newCustomers = new Customer(username, password);
			
			if(service.addCustomer(newCustomers)) {
				System.out.println("Successfully added!");
			}else {
				System.out.println("not added!");
			}
			
			break;
		case"2":
		case"3":
			running = false;
			break;
			default:
				
		}
		
		}
	}

	public void displayCustomer() {
		

	}
	
	private void optionsMenuEmployee() {
		System.out.println("1) View all the Food");
		System.out.println("2) Add a new food");
		System.out.println("3) Complete a food");
		System.out.println("4) Delete a food");
		System.out.println("5) View all incomplete food");
		System.out.println("6) Exit");
	}
	
	private void optionsMenuCustomer() {
		System.out.println("1) View all the Food");
		System.out.println("2) Add a new food");
		System.out.println("3) Complete a food");
		System.out.println("4) Delete a food");
		System.out.println("5) View all incomplete food");
		System.out.println("6) Exit");
	}
	private void optionsMenu() {
		System.out.println("1) Login");
		System.out.println("2) Exit");
		
	}
	
	public void login() {
		
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		while(running) {
			
			optionsMenu();
			
			String result = scanner.nextLine();
			
			switch(result) {
			case "1":
				displayLogin(scanner);
				break;
			case "2":
				System.out.println("Thanks for using our application ");
				running = false;
				break;
			default:
				System.out.println("That's not a valid input!");
				System.out.println("Try again!");
				
			}
	}

	}


}


