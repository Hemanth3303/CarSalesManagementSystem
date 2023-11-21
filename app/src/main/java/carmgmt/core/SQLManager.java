package carmgmt.core;

import java.sql.*;

public class SQLManager {
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private final String dbName="carmgmtdb";
	public SQLManager() {
	}
	
	public ResultSet executeSQL(String sqlStatement) {
		openConnection();
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sqlStatement);
		}
		catch (SQLException e) {
			System.out.println("Error: "+ e);
		}
		closeConnection();
		
		return resultSet;
	}
	
	private void openConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, "root", "admin");
		}
		catch (SQLException e) {
			System.out.println("Error: "+ e);
		}
	}
	
	private void closeConnection() {
		try {
			connection.close();
		}
		catch (SQLException e) {
			System.out.println("Error: "+ e);
		}
	}
}
