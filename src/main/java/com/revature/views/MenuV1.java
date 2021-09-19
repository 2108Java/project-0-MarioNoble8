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
			optionsMenuCustomer(sc, username);
		}else
			System.out.println("Not a valid login");
	}

	public void displayCustomer() {
		

	}
	
	private void optionsMenuEmployee(Scanner sc) {
		String userName;
		
		boolean running = true;
		
		while (running) {
			
			
			System.out.println("1) Approve/Reject Bank Accounts");
			System.out.println("2) View Customers Bank Accounts");
			System.out.println("3) View all Log Transactions");
			System.out.println("4) Exit");
			
			String result = sc.nextLine();
			
			switch(result) {
			case "1":
				service.approvingAccounts();
				break;
			case "2":
				System.out.println("What is the Customer's username");
				userName = sc.nextLine();
				service.viewAccounts(userName);
				break;
			case "3":
				break;
			case "4":
				running = false;
				break;
				default:
					System.out.println("That's not a valid input!");
					System.out.println("Try again!");
			}
		}
	}
	
	private void optionsMenuCustomer(Scanner sc, String username) {
		String accountName;
		String accountNamme;
		float balance;
		boolean running = true;
		
		while(running) {
		System.out.println("1) Apply for Bank Account");
		System.out.println("2) View Account Balance");
		System.out.println("3) Deposit");
		System.out.println("4) Withdrawl");
		System.out.println("5) Transfer Funds");//come back to it
		System.out.println("6) Exit");
		
		String result = sc.nextLine();
		
		switch(result) {
		case "1":
			System.out.println("What is the name of the account");
			accountName = sc.nextLine();
			System.out.println("What is the initial balance");
			balance = sc.nextFloat();
			sc.nextLine();
			System.out.println("What is the account type");			
			String acctType = sc.nextLine();
			System.out.println("List any other authorized users for account");
			String amountUsers = getAccessUsers(sc);
			if(service.addAccount(accountName, balance, acctType, amountUsers, username)) {
				System.out.println("Account made");
			}else { 
				System.out.println("Invalid Entry");
			}
			break;
		case "2":
			System.out.println("View balance of which account");
			accountName = sc.nextLine();
			if( service.viewBalance(accountName, username)) {
				
			} else {
				System.out.println("Transaction failed");
			}
	
			break;
		case "3":
			System.out.println("What is the account name");
			accountName = sc.nextLine();
			System.out.println("How much do you want to deposit");
			balance = sc.nextFloat();
			if(service.addDeposit(accountName, balance)) {
				System.out.println("Funds deposited");
			}else {
				System.out.println("Transaction failed");
			}
			sc.nextLine();
			break;
		case "4":
			System.out.println("What is the account name");
			accountName = sc.nextLine();
			System.out.println("How much do you want to withdraw");
			balance = sc.nextFloat();
			if(service.takeMoney(accountName, balance)) {
				System.out.println("Funds withdrawn");
			}else {
				System.out.println("Transaction failed");
			}
			sc.nextLine();
			break;
		case "5":
			System.out.println("Which account are you transferring from?");
			accountName = sc.nextLine();
			System.out.println("Which account are you transferring too?");
			accountNamme = sc.nextLine();
			System.out.println("How much would you like to transfer?");
			balance = sc.nextFloat();
			sc.nextLine();
			if(service.transferMoney(accountName, accountNamme, balance, username)) {
				System.out.println("Funds added");
			}else {
				System.out.println("Transaction denied");
			}
			sc.nextLine();
			break;
		case "6":
			running = false;
			break;
			default:
				System.out.println("That's not a valid input!");
				System.out.println("Try again!");
		}
		}
	}
	private String getAccessUsers(Scanner sc) {
		String AccessUsers = "";
		boolean accessing = true;
		while(accessing) {
			System.out.println("1) Add User?");
			System.out.println("2) Exit");
			
			String result = sc.nextLine();
			
			switch(result) {
				case "1":
					System.out.println("Enter User");
					String hotdog = sc.nextLine();
					AccessUsers = AccessUsers + hotdog + ",";
					break;
				case "2":
					accessing = false;
					break;
			}
		}
		
		return AccessUsers;
		
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
			scanner.close();
	}


}


