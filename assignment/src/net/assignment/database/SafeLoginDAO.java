package net.assignment.database;

import java.sql.*;

import net.assignment.bean.LoginBean;

// This login is safe, because we are using prepared statement of Java EE. 

public class SafeLoginDAO {
	
public static boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		
		boolean status = false;
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
// Safe connection using prepared statements and parameterized queries, we also close connection immediately;
		
		try (
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=assignment4","assignment","assignment")) {
				PreparedStatement ps = con.prepareStatement(
					"select * from dbo.users where username=? and password=?"); {
						ps.setString(1, loginBean.getUsername());
						ps.setString(2, loginBean.getPassword());
			
						System.out.println(ps);
						ResultSet rs = ps.executeQuery();
						status = rs.next();
						con.close();
	}
				}
		catch (Exception e) {
			
			System.out.println(e);
		}
		
		return status;

	}	
} 


