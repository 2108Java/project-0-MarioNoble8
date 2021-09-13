package com.revature.views;

import java.util.Scanner;

import com.revature.service.ServicePeople;

public class MenuV1 implements Menu {

	


	public MenuV1(ServicePeople service) {
		// TODO Auto-generated constructor stub
	}


	public void displayEmployee() {
		
		
	}

	
	public void displayLogin() {
		
		
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


