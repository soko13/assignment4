package net.assignment.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShowDatabase {

public static boolean validate(String username, String password) {
		
		boolean status = false;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String connectionUrl = "jdbc:sqlserver://localhost:1433;database=userdata;integratedSecurity=true";
					
			Connection con = DriverManager.getConnection(connectionUrl);
			
			PreparedStatement ps = con.prepareStatement(
					"select * from userdata");
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
	}
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
}
}