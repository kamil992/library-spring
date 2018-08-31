package com.library.testDatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Checking connetction with MySQL database
 * @author Kamil
 *
 */
public class TestConnection{

	public static void main(String[] args){
		
		String user = "student";
		String password = "student";
		String url = "jdbc:mysql://localhost:3306/library?useSSL=false"
				+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		try {
			System.out.println("CONNECTION TO :  " + url);
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			System.out.println("CONNECTED!");
			
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("NOT CONNECTED!");
		}
		
	}

}
