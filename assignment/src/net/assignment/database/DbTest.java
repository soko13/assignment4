package net.assignment.database;

import java.sql.*;
import net.assignment.bean.*;

public class DbTest {
	
	public static void main (String[] args) {
		
		//boolean status = false;
		
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		try (
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=assignment4","assignment","assignment");
			
			PreparedStatement ps = con.prepareStatement(
					"select * from dbo.Users where username='maria' and password='qwerty'")) {
			
			//System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while ( rs.next() ) {
                String username = rs.getString("username");
                System.out.println(username);
            }
	}
		catch (SQLException e) {
			
			//printSQLException(e);
		}
		
		//return status;

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
