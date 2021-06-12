package net.assignment.database;

import java.sql.*;

public class FillDatabaseDAO {

public static boolean fillDatabase() throws ClassNotFoundException {

//public static void main (String[] args) {
	
		boolean status = false;
	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		try (
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=assignment4","assignment","assignment")) {
				PreparedStatement ps = con.prepareStatement(
					"INSERT INTO dbo.Users VALUES ('alex95', 'mypassword1234', '016273846273', 'High Street 12', 'London'),"
					+ "		   ('joe', 'qwerty9876', '062738949018', 'Lindengasse 9', 'Vienna'),"
					+ "		   ('mary', 'qwerty', '0263718929', 'Green Alley 10', 'Manchester'),"
					+ "		   ('john', 'john12345', '02678123456', 'Brandenburger Straße 23', 'Berlin'),"
					+ "		   ('linda', 'passwordlinda', '617283156753', 'Meidlinger Hauptstraße 11', 'Vienna');"); 								
				System.out.println(ps);
				int i = ps.executeUpdate();
				if (i>0) {
					status = true;
					System.out.println("Update successful");
				}
				con.close();
	}
				
		catch (SQLException e) {
			
			printSQLException(e);
		}
		
		return status;

	}
	
	 private static void printSQLException(SQLException ex) {	 
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