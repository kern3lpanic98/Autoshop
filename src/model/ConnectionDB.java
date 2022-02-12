package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	private static ConnectionDB connection = null;
	private Connection con = null;

	private ConnectionDB()  throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/concessionaria", "root","Camilla98");
		

	}

	public static synchronized ConnectionDB getIstance() {
		try {
			
			if (connection == null) {
				connection = new ConnectionDB();
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return connection;

	}

	public Connection getConnection() {
		return con;
	}
}
