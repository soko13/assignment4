package net.assignment.database;

import java.sql.*;
import net.assignment.bean.*;

// To make this login unsafe, we use simple queries instead of prepared statements with parameterized queries. 

public class UnsafeLoginDAO {
	
	public static boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		
		boolean status = false;
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		try (
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=assignment4","assignment","assignment")) {
			
				Statement statement = con.createStatement();
			
				String username = loginBean.getUsername();
				String password = loginBean.getPassword();
				
				String query = "select * from dbo.users where username='" + username + "' and password='" + password + "'"; {
					//query.setString(1, loginBean.getUsername());
					//query.setString(2, loginBean.getPassword());
				System.out.println(query);
				
				ResultSet rs = statement.executeQuery(query);
				status = rs.next();
	}
				}
		catch (Exception e) {
			
			System.out.println(e);
		}
		
		return status;

	}
}