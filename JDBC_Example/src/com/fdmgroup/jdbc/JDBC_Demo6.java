/*
 * This version demonstrates callable statements
 * */
package com.fdmgroup.jdbc;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;


public class JDBC_Demo6 
{

	// For loading properties from file
	Properties properties;
	String url, username, password;
	
	// For connecting to the database
	Connection conn;

	
	public JDBC_Demo6(){
	
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
			
			String function = "{ ? = call get_average_age() }";
			
			// Get a PreparedStatement object	       	        			     
	        CallableStatement statement = conn.prepareCall(function);
	      
	        statement.registerOutParameter(1, Types.INTEGER, 3);
	        
        	// Execute everything in the batch, then commit
	        statement.execute();
	        int average = statement.getInt(1);
	        System.out.println(average);	        
	       	        
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
		
		new JDBC_Demo6().printAllRecordsInTable();

	}
}
