/*
 * This version demonstrates batching and auto commit
 * */
package com.fdmgroup.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;


public class JDBC_Demo5 
{

	// For loading properties from file
	Properties properties;
	String url, username, password;
	
	// For connecting to the database
	Connection conn;

	
	public JDBC_Demo5(){
	
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
			conn.setAutoCommit(false); //so that we can commit multiple sql commands at the same time

			
			//Get first and last name from user  
			Scanner in = new Scanner(System.in);
	        System.out.println("Enter first name to input");
	        String first1 = in.nextLine();
	        System.out.println("Enter last name to input");
	        String last1 = in.nextLine();
	        System.out.println("Enter first name to input");
	        String first2 = in.nextLine();
	        System.out.println("Enter last name to input");
	        String last2 = in.nextLine();
	        	        
	        String query = "INSERT INTO test1 (First_Name,Last_Name) VALUES (?,?)";        	
			
			// Get a PreparedStatement object	       	        			     
	        PreparedStatement statement = conn.prepareStatement(query);
	      
	        statement.setString(1, first1);
	        statement.setString(2, last1);
	        statement.addBatch();
	        statement.setString(1, first2);
	        statement.setString(2, last2);
	        statement.addBatch();
	        
        	// Execute everything in the batch, then commit
	        statement.executeBatch();
	        conn.commit();
	       	        
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
		
		new JDBC_Demo5().printAllRecordsInTable();

	}
}

