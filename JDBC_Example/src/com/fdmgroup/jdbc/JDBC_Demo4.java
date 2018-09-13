/*
 * This version demonstrates prepared statements
 * */
package com.fdmgroup.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;


public class JDBC_Demo4 
{

	// For loading properties from file
	Properties properties;
	String url, username, password;
	
	// For connecting to the database
	Connection conn;

	
	public JDBC_Demo4(){
	
		properties = PropertiesLoader.getProperties("real.properties");
	
		if (properties != null) {
			
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			
		}
	}
	
	
	public void printAllRecordsInTable()
	{			
		try 
		{
			// First, make sure the driver jar is in your build path 
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	        
			// Get a connection object -- this could fail!
			conn = DriverManager.getConnection(url,username,password);
		    
			//Get first and last name from user  
			Scanner in = new Scanner(System.in);
	        System.out.println("Enter first name to input");
	        String first_input = in.nextLine();
	        System.out.println("Enter last name to input");
	        String last_input = in.nextLine();
	        
	        String query = "INSERT INTO test1 (First_Name,Last_Name) VALUES (?,?)";
        	
			
			// Get a PreparedStatement object	       	        			     
	        PreparedStatement statement = conn.prepareStatement(query);
	        statement.setString(1, first_input);
	        statement.setString(2, last_input);
	     
        	// Get a ResultSet from executing SELECT query
	        statement.executeUpdate();
	       	        
		} catch (SQLException sqle) {
			sqle.printStackTrace(); 
		}
		finally 
		{
		    
			// Close the connection
		    if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		new JDBC_Demo4().printAllRecordsInTable();

	}
}

