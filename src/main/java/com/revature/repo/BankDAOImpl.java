package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.people.Customer;

public class BankDAOImpl implements BankDAO {
	
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "noble1";
	private String url = "jdbc:postgresql://" + dbLocation + ":5433/postgres";
	

	@Override
	public boolean insertCustomer(Customer newCustomer) {
			
			try(Connection connection = DriverManager.getConnection(url, username, password)){
				
				PreparedStatement stmt=connection.prepareStatement("insert into users values(?,?,?,?)");
				stmt.setString(1, newCustomer.getUserName());
				stmt.setString(2, newCustomer.getPassword());
				stmt.setString(3, newCustomer.getUserType());
				stmt.setString(4, "");
				int i = stmt.executeUpdate();
				System.out.println(i + "records inserted");
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		return true;
		
	}

	
}
