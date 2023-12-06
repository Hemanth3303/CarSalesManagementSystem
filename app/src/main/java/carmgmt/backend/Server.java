package carmgmt.backend;

import java.sql.*;

public class Server {
	private static int currentLoginId = 0;
	private static UserType currentUserType = null;
	private static String dbURL;
	private static String dbUsername;
	private static String dbPassword;
	
	public static void init(String p_dbURL, String p_dbUsername, String p_dbPassword) {
		dbURL = p_dbURL;
		dbUsername = p_dbUsername;
		dbPassword = p_dbPassword;
	}
	
	public static void validateLogin(String username, String password, UserType userType) {
		if(userType == UserType.Customer) {
			validateCustomerLogin(username, password);
		} else {
			validateStaffLogin(username, password);
		}
	}
	
	public static void disconnect() {
		currentLoginId = -1;
		currentUserType = null;
	}
	
	public static boolean userNameExists(String customerUserName) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from customer where username=?"
			);
			preparedStatement.setString(1, customerUserName);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
			connection.close();
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}
		return false;
	}
	
	public static void registerCustomer(String username, String password, String fname, String lname, String email, String phone, String address) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into customer(username,password,fname,lname,email,phone,address) values(?,?,?,?,?,?,?)"
			);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, fname);
			preparedStatement.setString(4, lname);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, phone);
			preparedStatement.setString(7, address);
			
			preparedStatement.executeUpdate();
			
			connection.close();
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	private static void validateCustomerLogin(String customerUserName, String password) {
		currentUserType = UserType.Customer;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from customer where username=? and password=?"
			);
			preparedStatement.setString(1, customerUserName);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				currentLoginId = resultSet.getInt("id");
			}
			connection.close();
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	private static void validateStaffLogin(String staffUserName, String password) {
		currentUserType = UserType.Staff;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from staff where username=? and password=?"
			);
			preparedStatement.setString(1, staffUserName);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				currentLoginId = resultSet.getInt("id");
			}
			connection.close();
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	public static int getCurrentLoginId() {
		return currentLoginId;
	}
	
	public static UserType getCurrentUserType() {
		return currentUserType;
	}
}
