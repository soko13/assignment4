package net.assignment.database;

import java.sql.*;

import net.assignment.bean.LoginBean;

// This login is safe, because we are using prepared statement of Java EE. 

public class SafeLoginDAO {
	
public static boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		
		boolean status = false;
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
// Safe connection using prepared statements and parameterized queries
		
		try (
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=assignment4","assignment","assignment")) {
				PreparedStatement ps = con.prepareStatement(
					"select * from dbo.users where username=? and password=?"); {
			ps.setString(1, loginBean.getUsername());
			ps.setString(2, loginBean.getPassword());
			
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			while ( rs.next() ) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(username);
                System.out.println(password);
            }
	}
				}
		catch (Exception e) {
			
			System.out.println(e);
		}
		
		return status;

	}
	
} 


