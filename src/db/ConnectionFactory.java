package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/northwind", "root", "123456");
		       
		}
		catch(SQLException e) {
			e.getMessage();
			
		}
		return null;
	}

	

}
