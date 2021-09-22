package com.revature.repo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.people.Customer;
import com.revature.people.Employee;
import com.revature.people.User;
import com.revature.views.MenuV1;




public class BankDAOImpl implements BankDAO {
	
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "noble1";
	private String url = "jdbc:postgresql://" + dbLocation + ":5433/postgres";
	private static final Logger loggy = Logger.getLogger("BankDAOImpl.class");

	@Override
	public boolean insertCustomer(Customer newCustomer) {
			String sql = "";
			try(Connection connection = DriverManager.getConnection(url, username, password)){
				
				sql = "insert into users values(?,?,?,?)";
				
				PreparedStatement stmt=connection.prepareStatement(sql);
				stmt.setString(1, newCustomer.getUserName());
				stmt.setString(2, newCustomer.getPassword());
				stmt.setString(3, newCustomer.getUserType());
				stmt.setString(4, "");
				int i = stmt.executeUpdate();
				System.out.println(i + "records inserted");
				connection.close();
				
			} catch (SQLException e) {
				BankDAOImpl.loggy.fatal(sql);
				e.printStackTrace();
			}
		
		
		return true;
		
	}


	@Override
	public boolean insertEmployee(Employee newEmployee) {
		String sql = "";
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			sql = "insert into users values(?,?,?,?)";
			
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setString(1, newEmployee.getUserName());
			stmt.setString(2, newEmployee.getPassword());
			stmt.setString(3, newEmployee.getUserType());
			stmt.setString(4, "");
			int i = stmt.executeUpdate();
			System.out.println(i + "records inserted");
			connection.close();
			
		} catch (SQLException e) {
			BankDAOImpl.loggy.fatal(sql);
			e.printStackTrace();
		}
	
	
	return true;
		
	}
	
	public String loginUser(String userNme, String passwrd) {
		String sql = "";
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			sql = "select user_type from users where user_name = ? and password = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, userNme);
			ps.setString(2, passwrd);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			return rs.getString("user_type");
			else
				return "";
		
	} catch (SQLException e) {
		BankDAOImpl.loggy.fatal(sql);
		e.printStackTrace();
	}
		return "";

	}

	public boolean addAccount(String accountName, float balance, String acctType, String amountUsers, String user) {
		String sql = "";
		if(balance <= 0) {
			return false;
		}
		try(Connection connection = DriverManager.getConnection(url, username, password)){
		
			sql = "insert into accounts values(?,?,?,?,?,?,?)";
		
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, accountName);
			ps.setString(2, user);
			ps.setBoolean(3, false);// account will only become available when an employee comes along and makes it true
			ps.setFloat(4, balance);
			ps.setString(5, acctType);
			ps.setString(6, amountUsers);
			ps.setBoolean(7, true);
			
			int i = ps.executeUpdate();
			System.out.println(i + "records inserted");
			connection.close();
		
			
	
		} catch (SQLException e) {
			BankDAOImpl.loggy.fatal(sql);
			e.printStackTrace();
	}
		return true;

}


	@Override
	public String optionsMenuCustomer(String accountName, String balance) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean viewBalance(String accountName, String user) {
		String sql = "";
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			boolean loggedIn = false;
			
			loggedIn = checkAccess(user, accountName, connection);
			
			
			if(loggedIn) {
				
				
			sql = "select balance from accounts where name_account = ? and approve_deny_account = true";
		
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, accountName);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
			System.out.println(String.format("Here's your balance: $%.02f", rs.getFloat("balance")));
				return true;
			} else {
				return false;
			}
			
			}
	
		} catch (SQLException e) {
			BankDAOImpl.loggy.fatal(sql);
			e.printStackTrace();
	}
		return false;
	}


	@Override
	public boolean addDeposit(String accountName, float balance) {
		String sql = "";
		if(balance <= 0) {
			return false;
		}
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			sql = "update accounts set balance = balance + ? where name_account = ? and approve_deny_account = true";
		
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(2, accountName);
			ps.setFloat(1, balance);
			ps.executeUpdate();
			
			return true;
		
			
	
		} catch (SQLException e) {
			BankDAOImpl.loggy.fatal(sql);
			e.printStackTrace();
	}
		return false;
	}


	@Override
	public boolean takeMoney(String accountName, float balance) {
		String sql = "";
		if(balance <= 0) {
			return false;
		}
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			sql = "select balance from accounts where name_account = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, accountName);
			ps.executeQuery();
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			if(rs.getFloat("balance") < balance) {
				return false;
			}
			sql = "update accounts set balance = balance - ? where name_account = ? and approve_deny_account = true";
		
			ps = connection.prepareStatement(sql);
			ps.setString(2, accountName);
			ps.setFloat(1, balance);
			ps.executeUpdate();
			
			return true;
		
			
	
		} catch (SQLException e) {
			BankDAOImpl.loggy.fatal(sql);
			e.printStackTrace();
	}
		return false;
		
	}


	@Override
	public void approvingAccounts() {
		String approveAccounts;
		String primaryHolder;
		Scanner scanner = new Scanner(System.in);
		String sql = "";
		try(Connection connection = DriverManager.getConnection(url, username, password)) {
			
			sql = "select name_account, primary_holder from accounts where approve_deny_account = false";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				approveAccounts = rs.getString("name_account");
				primaryHolder = rs.getString("primary_holder");
				System.out.println(String.format("Approve(1) or deny(2) \n account: %s, Primary Holder: %s", approveAccounts, primaryHolder));
				
				String result = scanner.nextLine();
				
				switch(result) {
				case "1":
					BankDAOImpl.loggy.info("User selected 1, approving an account");
					System.out.println("Account approved");
					sql = "update accounts set approve_deny_account = true where name_account = ?";
					ps = connection.prepareStatement(sql);
					ps.setString(1, approveAccounts);
					ps.executeUpdate();
					break;
				case "2":
					BankDAOImpl.loggy.info("User selected 2, denying an account");
					System.out.println("Account denied");
					break;
					default:
						BankDAOImpl.loggy.warn("Not a valid input!");
						System.out.println("Invalid input");
						break;
				}
				
				
			}
			
			
		} catch (SQLException e) {
			
			BankDAOImpl.loggy.fatal(sql);
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
//		scanner.close();
	}


	@Override
	public void viewAccounts(String userName) {
		String sql = "";
		try(Connection connection = DriverManager.getConnection(url, username, password)) {
			boolean printFirst = true;
			sql = "select * from accounts";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int count = rsMetaData.getColumnCount();
			while(rs.next()) {
				if(rs.getString("primary_holder").contentEquals(userName)) {
					if(printFirst) {
						
					
						System.out.printf(String.format("%s \t %s \t %s \t %s \t", "Account Name", "Primary Holder", "Balance", "Authorized Users" ));
					
					printFirst = false;
					System.out.println();
					}
					
					
						System.out.printf(String.format("%s \t\t %s \t\t %s \t\t %s \t", rs.getString("name_account"), rs.getString("primary_holder"), rs.getString("balance"), rs.getString("list_of_access")));
					
					System.out.println();
//					System.out.printf(String.format("%f\n",rs.getFloat("balance")));
				}else {
					if(rs.getString("list_of_access").contains(userName)) {
						
							
							
							System.out.printf(String.format("%s \t\t %s \t\t %s \t\t %s \t", rs.getString("name_account"), rs.getString("primary_holder"), rs.getString("balance"), rs.getString("list_of_access")));
						
						System.out.println();
					}
				}
				
			}
			
			
		} catch (SQLException e) {
			BankDAOImpl.loggy.fatal(sql);
			e.printStackTrace();
		}
		
	}


	@Override
	public boolean transferMoney(String accountName, String accountNamme, float balance, String usrname) {
		String sql = "";
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			
			if(balance <= 0) {
				return false;
			}
			if(checkAccess(usrname, accountName, connection)) {
				
			sql = "select name_account from accounts where name_account = ?";
		
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, accountName);
			ps.executeQuery();
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
			if(rs.getString("name_account").contentEquals("")) {
				return false;
			}
			}
			sql = "select name_account from accounts where name_account = ?";
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, accountNamme);
			ps.executeQuery();
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
			if(rs.getString("name_account").contentEquals("")) {
				return false;
			}
		
			}
			sql = "select balance from accounts where name_account = ?";
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, accountName);
			ps.executeQuery();
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
			if(rs.getFloat("balance") < balance) {
				return false;
			}
			
			}
	
			sql = "update accounts set balance = balance - ? where name_account = ? and approve_deny_account = true";
			
			ps = connection.prepareStatement(sql);
			ps.setString(2, accountName);
			ps.setFloat(1, balance);
			ps.executeUpdate();
		
			sql = "update accounts set balance = balance + ? where name_account = ? and approve_deny_account = true";
			
			ps = connection.prepareStatement(sql);
			ps.setString(2, accountNamme);
			ps.setFloat(1, balance);
			ps.executeUpdate();
			
			return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			BankDAOImpl.loggy.fatal(sql);
			e.printStackTrace();
	}
		return false;
	}

	private boolean checkAccess(String User, String accountName, Connection connection2) throws SQLException {
		String sqll = "";
		boolean loggedIn = false;
		
			
		sqll= "select list_of_access , primary_holder from accounts where name_account = ?;";
		
		PreparedStatement ps = connection2.prepareStatement(sqll);
		ps.setString(1, accountName);
		
		ResultSet rs = ps.executeQuery();
		
		
		if(rs.next()) {
			
		if(rs.getString("primary_holder").contentEquals(User)) 
		{
			loggedIn  = true;
		} 
		else
		{
			
			String[] values = rs.getString("list_of_access").split(",");
			for(int i = 0; i < values.length; i++)
			{
				if(values[i].contentEquals(User))
				{
					loggedIn = true;
				}
			}
			
		}
		}
		
		return loggedIn;
		} 
		
	}
	
	

	

