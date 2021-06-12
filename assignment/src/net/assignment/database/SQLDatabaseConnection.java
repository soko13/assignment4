package net.assignment.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class SQLDatabaseConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
	
    public static void main (String[] args) {
    	
    	boolean status = false; 
    	
    	//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	//zurückgeben der neuen Verbindung
    	//Connection connectionUrl = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=assignment4","assignment","assignment");

        //try (
        		try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=assignment4","assignment","assignment")) {
        		if (connection != null) {
        			System.out.println("Connected"); } }       		
        				
        				/*{
        	PreparedStatement ps = connection.prepareStatement(
					"select * from userdata"); //where name=? and password=?");
			//ps.setString(1, "assignment");
			//ps.setString(2, "assignment");
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
        }*/
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
