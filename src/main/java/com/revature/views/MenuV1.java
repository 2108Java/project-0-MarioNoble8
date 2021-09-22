package com.revature.views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.people.Customer;
import com.revature.people.Employee;
import com.revature.service.ServicePeople;

public class MenuV1 implements Menu {
	
	private static final Logger loggy = Logger.getLogger("MenuV1.class");

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
			
		System.out.println("1) Register a Customer or Employee");
		System.out.println("2) Registered User");
		System.out.println("3) Exit");
		
		String result = sc.nextLine();
		
		switch(result) {
		case"1":
			MenuV1.loggy.info("User selected 1, creating an account");
			displayCreateAccount(sc);
			break;
		case"2":
			MenuV1.loggy.info("User selected 2, choose an existing account");
			displayLoginAccount(sc);
			break;
		case"3":
			MenuV1.loggy.info("User selected 3, chose to exit the login");
			running = false;
			break;
			default:
				MenuV1.loggy.warn("Not a valid input!");
				System.out.println("That's not a valid input!");
				System.out.println("Try again!");
				break;
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
			MenuV1.loggy.info("User selected 1, chose being a Customer");
			System.out.println("What is your username: ");
			String username = sc.nextLine();
			MenuV1.loggy.info("Username: " + username);
			System.out.println("What is your password: ");
			String password = sc.nextLine();
			MenuV1.loggy.info("Password: " + password);
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
			MenuV1.loggy.info("User selected 2, chose being an Employee");
			System.out.println("What is your username: ");
			String username2 = sc.nextLine();
			MenuV1.loggy.info("Username: " + username2);
			System.out.println("What is your password: ");
			String password2 = sc.nextLine();
			MenuV1.loggy.info("Password: " + password2);
			
			Employee newEmployee = new Employee(username2, password2);
			
			if(service.addEmployee(newEmployee)) {
				System.out.println("Successfully added!");
			}else {
				System.out.println("not added!");
			}
			
			break;
		case"3":
			MenuV1.loggy.info("User selected 3, chose to exit the menu");
			running = false;
			break;
			default:
				MenuV1.loggy.warn("Not a valid input!");
				System.out.println("That's not a valid input!");
				System.out.println("Try again!");
				break;
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
			optionsMenuEmployee(sc, username);
		}else if(name.contentEquals("Customer")) {
			optionsMenuCustomer(sc, username);
		}else
			System.out.println("Not a valid login");
	}

	public void displayCustomer() {
		

	}
	
	private void optionsMenuEmployee(Scanner sc, String username) {
		String userName;
		
		boolean running = true;
		
		while (running) {
			
			
			System.out.println("1) Approve/Reject Bank Accounts");
			System.out.println("2) View Customers Bank Accounts");
			System.out.println("3) View all Log Transactions");
			System.out.println("4) Logout");
			
			String result = sc.nextLine();
			
			switch(result) {
			case "1":
				MenuV1.loggy.info("User selected 1, approving or denying an account");
				service.approvingAccounts();
				break;
			case "2":
				MenuV1.loggy.info("User selected 2, requesting info to view accounts");
				System.out.println("What is the Customer's username");
				userName = sc.nextLine();
				service.viewAccounts(userName);
				break;
			case "3":
				MenuV1.loggy.info("User selected 3, viewing all Log Transactions");
				try {
				      File myObj = new File("C:\\Users\\dmari\\OneDrive\\Documents\\GitHub\\2108\\LogLoggy\\log4j-log-application.log");
				      Scanner myReader = new Scanner(myObj);
				      while (myReader.hasNextLine()) {
				        String data = myReader.nextLine();
				        System.out.println(data);
				      }
				      myReader.close();
				    } catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
				break;
			case "4":
				MenuV1.loggy.info("User selected 4," + username + "Employee logged out");
				running = false;
				break;
				default:
					MenuV1.loggy.warn("Not a valid input!");
					System.out.println("That's not a valid input!");
					System.out.println("Try again!");
					break;
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
		System.out.println("6) Logout");
		
		String result = sc.nextLine();
		
		switch(result) {
		case "1":
			MenuV1.loggy.info("User selected 1, requesting name on account");
			System.out.println("What is the name of the account");
			accountName = sc.nextLine();
			MenuV1.loggy.info("User selected 1, requesting initial balance");
			System.out.println("What is the initial balance");
			balance = sc.nextFloat();
			sc.nextLine();
			MenuV1.loggy.info("User selected 1, choosing account type");
			System.out.println("What is the account type");			
			String acctType = getTypeOfAccount(sc);
			MenuV1.loggy.info("User selected 1, requesting other authorized users for account");
			System.out.println("List any other authorized users for account");
			String amountUsers = getAccessUsers(sc);
			if(service.addAccount(accountName, balance, acctType, amountUsers, username)) {
				System.out.println("Account made");
			}else { 
				System.out.println("Invalid Entry");
			}
			break;
		case "2":
			MenuV1.loggy.info("User selected 2, requesting to view balance");
			System.out.println("View balance of which account");
			accountName = sc.nextLine();
			if( service.viewBalance(accountName, username)) {
				
			} else {
				System.out.println("Transaction failed");
			}
	
			break;
		case "3":
			MenuV1.loggy.info("User selected 3, requesting name of account");
			System.out.println("What is the account name");
			accountName = sc.nextLine();
			MenuV1.loggy.info("User selected 3, requesting how much money to deposit");
			System.out.println("How much do you want to deposit");
			balance = sc.nextFloat();
			MenuV1.loggy.info(String.format("User is depositing %.02f", balance));
			if(service.addDeposit(accountName, balance)) {
				System.out.println("Funds deposited");
			}else {
				System.out.println("Transaction failed");
			}
			sc.nextLine();
			break;
		case "4":
			MenuV1.loggy.info("User selected 4, requesting name of account");
			System.out.println("What is the account name");
			accountName = sc.nextLine();
			MenuV1.loggy.info("User selected 4, requesting how much money to withdraw from account");
			System.out.println("How much do you want to withdraw");
			balance = sc.nextFloat();
			MenuV1.loggy.info(String.format("User is withdrawing %.02f", balance));
			if(service.takeMoney(accountName, balance)) {
				System.out.println("Funds withdrawn");
			}else {
				System.out.println("Transaction failed");
			}
			sc.nextLine();
			break;
		case "5":
			MenuV1.loggy.info("User selected 5, requesting an account to transfer from");
			System.out.println("Which account are you transferring from?");
			accountName = sc.nextLine();
			MenuV1.loggy.info(String.format("User is withdrawing from %s", accountName));
			MenuV1.loggy.info("User selected 5, requesting an account to transfer too");
			System.out.println("Which account are you transferring too?");
			accountNamme = sc.nextLine();
			MenuV1.loggy.info(String.format("User is transferring to %s", accountNamme));
			MenuV1.loggy.info("User selected 5, requesting how much to transfer");
			System.out.println("How much would you like to transfer?");
			balance = sc.nextFloat();
			MenuV1.loggy.info(String.format("User is attempting to transfer %.02f", balance));
			sc.nextLine();
			if(service.transferMoney(accountName, accountNamme, balance, username)) {
				System.out.println("Funds added");
			}else {
				System.out.println("Transaction denied");
			}
			break;
		case "6":
			MenuV1.loggy.info("User selected 6, "+ username+ "Customer logged out");
			running = false;
			break;
			default:
				MenuV1.loggy.warn("Not a valid input!");
				System.out.println("That's not a valid input!");
				System.out.println("Try again!");
				break;
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
					MenuV1.loggy.info("User selected 1, Enter a User");
					System.out.println("Enter User");
					String hotdog = sc.nextLine();
					AccessUsers = AccessUsers + hotdog + ",";
					break;
				case "2":
					MenuV1.loggy.info("User selected 2, exiting adding more users");
					accessing = false;
					break;
					default:
						MenuV1.loggy.warn("Not a valid input!");
						System.out.println("That's not a valid input!");
						System.out.println("Try again!");
						break;
				}
			}
		return AccessUsers;
		}
		
		
	
	private String getTypeOfAccount(Scanner sc) {
		
		boolean accessing = true;
		while(accessing) {
			System.out.println("1) Checking");
			System.out.println("2) Savings");
			
			
			String result = sc.nextLine();
			
			switch(result) {
				case "1":
					MenuV1.loggy.info("User selected 1, choosing checkings account");
				return "checking";
			case "2":
					MenuV1.loggy.info("User selected 2, choosing savings account");
				return "savings";
				
					default:
						MenuV1.loggy.warn("Not a valid input!");
						System.out.println("That's not a valid input!");
						System.out.println("Try again!");
						break;
				}
			}
		return "";
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
				MenuV1.loggy.info("User selected 1");
				displayLogin(scanner);
				break;
			case "2":
				MenuV1.loggy.info("User selected 2, exiting the application");
				System.out.println("Thanks for using our application ");
				running = false;
				break;
			default:
				MenuV1.loggy.warn("Not a valid input!");
				System.out.println("That's not a valid input!");
				System.out.println("Try again!");
				break;
			}
	}
			scanner.close();
	}
		

}


