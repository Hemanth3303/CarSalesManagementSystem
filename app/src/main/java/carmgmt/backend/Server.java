package carmgmt.backend;

import carmgmt.car.CarProps;

import java.sql.*;
import java.text.SimpleDateFormat;

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
	
	public static String[][] getCarsToStaff() {
		String[][] outStringTable = new String[15][6];
		int rowIndex = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from cars"
			);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				outStringTable[rowIndex][0] = String.valueOf(resultSet.getInt("id"));
				outStringTable[rowIndex][1] = resultSet.getString("model");
				outStringTable[rowIndex][2] = resultSet.getString("year");
				outStringTable[rowIndex][3] = resultSet.getBoolean("availability") ? "available" : "sold";
				outStringTable[rowIndex][4] = resultSet.getString("cost");
				outStringTable[rowIndex][5] = "Delete";
				rowIndex++;
			}
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}
		return outStringTable;
	}
	
	public static String[][] getCarsToUser() {
		String[][] outStringTable = new String[15][6];
		int rowIndex = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from cars"
			);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				outStringTable[rowIndex][0] = String.valueOf(resultSet.getInt("id"));
				outStringTable[rowIndex][1] = resultSet.getString("model");
				outStringTable[rowIndex][2] = resultSet.getString("year");
				outStringTable[rowIndex][3] = resultSet.getBoolean("availability") ? "available" : "sold";
				outStringTable[rowIndex][4] = resultSet.getString("cost");
				outStringTable[rowIndex][5] = "Buy";
				rowIndex++;
			}
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}
		return outStringTable;
	}
	
	public static void addCar(String model, String year, String cost) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into cars(model, year, availability, cost) values(?, ?, ?, ?)"
			);
			preparedStatement.setString(1, model);
			preparedStatement.setString(2, year);
			preparedStatement.setBoolean(3, true);
			preparedStatement.setString(4, cost);
			
			preparedStatement.executeUpdate();
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	public static CarProps getCarProps(int id) {
		CarProps props = new CarProps();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from cars where id=?"
			);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				props.model = resultSet.getString("model");
				props.year = resultSet.getString("year");
				props.cost = resultSet.getString("cost");
			}
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}
		return props;
	}
	
	public static void buyCar(int id, String cost) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update cars set availability=? where id=?"
			);
			preparedStatement.setBoolean(1, false);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			preparedStatement = connection.prepareStatement(
					"insert into sales(customer_id, car_id, amount, payment_time) values (?, ?, ?, ?)"
			);
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss").format(new java.util.Date());
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, currentLoginId);
			preparedStatement.setString(3, cost);
			preparedStatement.setString(4, timeStamp);
			preparedStatement.executeUpdate();
		} catch(Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	public static void deleteCar(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"delete from cars where id=?"
			);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
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
