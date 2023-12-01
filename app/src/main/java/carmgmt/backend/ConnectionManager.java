package carmgmt.backend;

import java.sql.*;

public class ConnectionManager {
	private static int currentLoginId = -1;
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
	
	private static void validateCustomerLogin(String customerUserName, String password) {
		currentUserType = UserType.Customer;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customer where username='" + customerUserName + "' and password='" + password + "'");
			if(resultSet.next()) {
				currentLoginId = resultSet.getInt("id");
			}
			connection.close();
		} catch(Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}
	
	private static void validateStaffLogin(String staffUserName, String password) {
		currentUserType = UserType.Staff;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from staff where username='" + staffUserName + "' and password='" + password + "'");
			if(resultSet.next()) {
				currentLoginId = resultSet.getInt("id");
			}
			connection.close();
		} catch(Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}
	
	public static int getCurrentLoginId() {
		return currentLoginId;
	}
	
	public static UserType getCurrentUserType() {
		return currentUserType;
	}
}
