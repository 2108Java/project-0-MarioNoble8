package com.revature.views;

import java.util.Scanner;

import com.revature.people.Customer;
import com.revature.people.Employee;
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
			displayLoginAccount(sc);
			break;
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
			System.out.println("What is your username: ");
			String username2 = sc.nextLine();
			System.out.println("What is your password: ");
			String password2 = sc.nextLine();
			
			Employee newEmployee = new Employee(username2, password2);
			
			if(service.addEmployee(newEmployee)) {
				System.out.println("Successfully added!");
			}else {
				System.out.println("not added!");
			}
			
			break;
		case"3":
			running = false;
			break;
			default:
				
		}
		
		}
	}
	
	public void displayLoginAccount(Scanner sc) {
		System.out.println("What is your username: ");
		String username = sc.nextLine();
		System.out.println("What is your password: ");
		String password = sc.nextLine();
		
		String name = service.loginUser(username, password);
		
		if(name.contentEquals("Employee")){
			optionsMenuEmployee(sc);
		}else if(name.contentEquals("Customer")) {
			optionsMenuCustomer(sc);
		}else
			System.out.println("Not a valid login");
	}

	public void displayCustomer() {
		

	}
	
	private void optionsMenuEmployee(Scanner sc) {
		
		
		boolean running = true;
		
		while (running) {
			
			
			System.out.println("1) Approve/Reject Bank Account");
			System.out.println("2) View Customers Bank Account");
			System.out.println("3) View all Log Transactions");
			System.out.println("4) Exit");
			
			String result = sc.nextLine();
			
			switch(result) {
			case "1":
//				System.out.println("Approve or Reject a Bank Account");
//				String user_name = scanner.nextLine();
//				System.out.println("View Account Balance");
//				int account = scanner.nextInt();
//				scanner.nextLine();
//				System.out.println("View all Transactions");
//				String account = scanner.nextLine();
//				
//				
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
				default:
					System.out.println("That's not a valid input!");
					System.out.println("Try again!");
			}
		}
	}
	
	private void optionsMenuCustomer(Scanner sc) {
		
		boolean running = true;
		
		while(running) {
		System.out.println("1) Apply for Bank Account");
		System.out.println("2) View Account Balance");
		System.out.println("3) Deposit");
		System.out.println("4) Withdrawl");
		System.out.println("5) Transfer Funds");
		System.out.println("6) Exit");
		
		String result = sc.nextLine();
		
		switch(result) {
		case "1":
			break;
		case "2":
			break;
		case "3":
			break;
		case "4":
			break;
		case "5":
			break;
		case "6":
			break;
			default:
				System.out.println("That's not a valid input!");
				System.out.println("Try again!");
		}
		}
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


