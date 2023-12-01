package carmgmt.backend;

import java.sql.*;

public class ConnectionManager {
	private static int currentLoginId = -1;
	private static UserType currentUserType = null;
	private static final String dbURL = "jdbc:mysql://localhost:3306/carmgmtdb";
	private static final String dbUsername = "root";
	private static final String dbPassword = "admin";
	
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
	
	private static void validateCustomerLogin(String username, String password) {
		currentUserType = UserType.Customer;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customer where username='" + username + "' and password='" + password + "'");
			if(resultSet.next()) {
				currentLoginId = resultSet.getInt("id");
			}
			connection.close();
		} catch(Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}
	
	private static void validateStaffLogin(String staffname, String password) {
		currentUserType = UserType.Staff;
	}
	
	public static int getCurrentLoginId() {
		return currentLoginId;
	}
	
	public static UserType getCurrentUserType() {
		return currentUserType;
	}
}
