package net.assignment.database;

import java.sql.*;
import javax.servlet.*;  
import javax.servlet.http.*;  


public class FillDatabase {

public static boolean fillDatabase() {
		
		boolean status = false;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String connectionUrl = "jdbc:sqlserver://localhost:1433;database=userdata;integratedSecurity=true";
					
			Connection con = DriverManager.getConnection(connectionUrl);
			
			PreparedStatement ps = con.prepareStatement(
					"insert into dbo.users (");
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
	}
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
