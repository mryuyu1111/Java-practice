/*
 * Demonstrates handling null values
 * */
package com.fdmgroup.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBC_Demo3 
{

	// For loading properties from file
	Properties properties;
	String url, username, password;
	
	// For connecting to the database
	Connection conn;

	
	public JDBC_Demo3(){
	
		properties = PropertiesLoader.getProperties("real.properties");
	
		if (properties != null) {
			
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			
		}
	}
	
	
	public void printAllRecordsInTable(){	
		
		try {
			
			// First, make sure the driver jar is in your build path 
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	        
			// Get a connection object -- this could fail!
			conn = DriverManager.getConnection(url,username,password);
		    
			// Get a statement object
	        Statement statement = conn.createStatement(
	        		ResultSet.TYPE_SCROLL_SENSITIVE,
	        	    ResultSet.CONCUR_UPDATABLE);
	       
	        //Johnny's last name is null
	        String query = "SELECT * FROM test1 WHERE AGE IS NULL";
	        
	        // Get a ResultSet from executing SELECT query
	        ResultSet rs = statement.executeQuery(query);
	        
	        	        
	        // Must call rs.next() to get first row! 
	        // While loop gets this done
	        while(rs.next()) 
	        {	
	        	//WRONG: See how it puts their age as 0
	        	//0 is a valid number, and it is NOT their age.
	        	//The DB says null, which must be reflected in our code
	        	System.out.println(		        		
	        			rs.getString("FIRST_NAME")+" "+
	        			rs.getString("LAST_NAME")+" "+
	        			rs.getInt("Age")
    			);
	        	
	        	//CORRECT
	        	System.out.print(		        		
	        			rs.getString("FIRST_NAME")+" "+
	        			rs.getString("LAST_NAME")+" ");	        			
	        	BigDecimal age = rs.getBigDecimal("Age"); //wrappers
    			System.out.println(age);
	        }
	      
		} catch (SQLException sqle) {
			sqle.printStackTrace(); 
		}
		finally {
		    
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
		
		new JDBC_Demo3().printAllRecordsInTable();

	}
}

