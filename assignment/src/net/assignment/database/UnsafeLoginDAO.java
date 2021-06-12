package net.assignment.database;

import java.sql.*;
import net.assignment.bean.*;

public class UnsafeLoginDAO {
	
	public static boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		
		boolean status = false;
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
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
		catch (SQLException e) {
			
			//printSQLException(e);
		}
		
		return status;

	}
	
	 private void printSQLException(SQLException ex) {	 
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	            	
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	}