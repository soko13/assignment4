package net.assignment.database;

import java.sql.*;

public class FillDatabaseDAO {

public static boolean fillDatabase() throws ClassNotFoundException {
	
		boolean status = false;
	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		try (
				Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=assignment4","assignment","assignment")) {
				PreparedStatement ps = con.prepareStatement(
					"if not exists (select [name] from sys.tables where [name] = 'users') "
					+ "	create table dbo.Users "
					+ " 		(username varchar(50), password varchar(50), phoneNumber varchar(50), adressStreet varchar(50), adressCity varchar(50));"
					+ "			INSERT INTO dbo.Users VALUES ('alex95', 'mypassword1234', '016273846273', 'High Street 12', 'London'),"
					+ "		   ('joe', 'qwerty9876', '062738949018', 'Lindengasse 9', 'Vienna'),"
					+ "		   ('mary', 'qwerty', '0263718929', 'Green Alley 10', 'Manchester'),"
					+ "		   ('john', 'john12345', '02678123456', 'Brandenburger Straße 23', 'Berlin'),"
					+ "		   ('linda', 'passwordlinda', '617283156753', 'Meidlinger Hauptstraße 11', 'Vienna'),"
					+ "        ('admin', 'adminpassword', '000000000', 'Admin street', 'Admin');"); 								
				System.out.println(ps);
				int i = ps.executeUpdate();
				if (i>0) {
					status = true;
					System.out.println("Update successful");
				}
				con.close();
	}
				
		catch (Exception e) {
			
			System.out.println(e);
		}
		
		return status;

	}
}