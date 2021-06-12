package net.assignment.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShowDataDAO {

public static boolean showData() throws ClassNotFoundException {
		
	boolean status = false;
	
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	
			try (
					Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=assignment4","assignment","assignment")) {
					PreparedStatement ps = con.prepareStatement("select * from dbo.users"); 
					System.out.println(ps);
					ResultSet rs = ps.executeQuery();
					status = rs.next();
					if (rs.next()) {
						String username = rs.getString(1);
						String password = rs.getString(2);
						String phoneNumber = rs.getString(3);
						String addressStreet = rs.getString(4);
						String addressCity = rs.getString(5);
					}			
					con.close();
		}
				
			catch (Exception e) {
				
				System.out.println(e);
			}
			
			return status;

		}	
	} 