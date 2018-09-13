package com.fdmgroup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_Demo1 {

	// For loading properties from file
	Properties properties;
	String url, username, password;
	
	// For connecting to the database
	Connection conn;

	
	public JDBC_Demo1(){
	
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
	        Statement statement = conn.createStatement();
	       
	        String query = "SELECT * FROM test1";
	        
	        // Get a ResultSet from executing SELECT query
	        ResultSet rs = 
	        		statement.executeQuery(query);
	        
	        
	     
	        
	        // Must call rs.next() to get first row! 
	        // While loop gets this done	      
	        while(rs.next()) {
	        	
	        	System.out.println(		        		
	        			rs.getString("FIRST_NAME")+" "+
	        			rs.getString("LAST_NAME")
    					);
	        	

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
		
		new JDBC_Demo1().printAllRecordsInTable();

	}
}




