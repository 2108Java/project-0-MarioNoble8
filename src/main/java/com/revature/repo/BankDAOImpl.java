package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.people.Customer;
import com.revature.people.Employee;
import com.revature.people.User;

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


	@Override
	public boolean insertEmployee(Employee newEmployee) {
		
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement stmt=connection.prepareStatement("insert into users values(?,?,?,?)");
			stmt.setString(1, newEmployee.getUserName());
			stmt.setString(2, newEmployee.getPassword());
			stmt.setString(3, newEmployee.getUserType());
			stmt.setString(4, "");
			int i = stmt.executeUpdate();
			System.out.println(i + "records inserted");
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	return true;
		
	}
	
	public String loginUser(String userNme, String passwrd) {
		
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			String sql = "select user_type from users where user_name = ? and password = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userNme);
			ps.setString(2, passwrd);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString("user_type");
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		return null;

	}

	public boolean addAccount(String accountName, float balance, String acctType, String amountUsers) {
	
		try(Connection connection = DriverManager.getConnection(url, username, password)){
		
			String sql = "select account_type from accounts where user_name = ? and password = ?";
		
			PreparedStatement ps = connection.prepareStatement("insert into accounts values(?,?,?,?,?,?)");
			ps.setString(1, accountName);
			ps.setBoolean(2, true);
			ps.setFloat(3, balance);
			ps.setString(4, acctType);
			ps.setString(5, amountUsers);
			ps.setBoolean(6, true);
			
			int i = ps.executeUpdate();
			System.out.println(i + "records inserted");
			connection.close();
		
			
	
		} catch (SQLException e) {
	
			e.printStackTrace();
	}
		return true;

}


	@Override
	public String optionsMenuCustomer(String accountName, String balance) {
		// TODO Auto-generated method stub
		return null;
	}
}
