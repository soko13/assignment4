package net.assignment.database;

import java.sql.*;

public class SafeLoginDAO {
	
	public static void main(String[] args) {
	
	//validate(String username, String password) {
		
		boolean status = false;
			
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
