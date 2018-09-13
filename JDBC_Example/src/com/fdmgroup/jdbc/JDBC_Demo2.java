/*
 * This version shows the use of parameters when creating a result set.
 * See that we can scroll forward and backward through the result set,
 * only IF we set that parameter ResultSet.TYPE_SCROLL_SENSITIVE.
 * */
package com.fdmgroup.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBC_Demo2 
{

	// For loading properties from file
	Properties properties;
	String url, username, password;
	
	// For connecting to the database
	Connection conn;

	
	public JDBC_Demo2(){
	
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
	       
	        String query = "SELECT * FROM test1";
	        
	        // Get a ResultSet from executing SELECT query
	        ResultSet rs = 
	        		statement.executeQuery(query);
	        
	        	        
	        // Must call rs.next() to get first row! 
	        // While loop gets this done
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	       
	        while(rs.next()) {
	        	String entry;

	        	try {
	                 entry = br.readLine();
	                 if (entry.equals("next"))
	                 {
	                	 System.out.println(		        		
	         	        		rs.getString("FIRST_NAME")+" "+
	         	        		rs.getString("LAST_NAME"));
	                 }
	                 else if (entry.equals("previous"))
	                 {
	                	 rs.previous();
	                	 System.out.println(		        		
	         	        		rs.getString("FIRST_NAME")+" "+
	         	        		rs.getString("LAST_NAME"));
	                 }  
	                 else if (entry.equals("update"))
	                 {
	                	 //read new data from user
	                	 System.out.println("First Name: ");
	                	 String fname = br.readLine();
	                	 System.out.println("Last Name: ");
	                	 String lname = br.readLine();
	                	 
	                	 //create update query
	                	 String query2 = "UPDATE test1 " +
	                	 				 "SET first_name = '"+fname+"',"+
	                			             "last_name = '"+lname+"'"+
	                	 		         " WHERE first_name = '"+rs.getString("first_name")+"' AND "+
	                			               "last_name = '"+rs.getString("last_name")+"'";
	                	 System.out.println(query2);
	               
	           
	                	 //update result set then break out 
	                	 //because rs is null after update
	                	 statement.executeUpdate(query2);	                	
	                	 break;
	                 }
	              } catch (IOException ioe) {
	                 System.out.println("IO error trying to read your entry");
	                 System.exit(1);
	              }
	            
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
		
		new JDBC_Demo2().printAllRecordsInTable();

	}
}
