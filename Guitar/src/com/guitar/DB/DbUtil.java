package com.guitar.DB;

import java.sql.*; 
import java.io.*; 

 
public class DbUtil implements Serializable { 
	 
	/** 
	 *  
	 */ 
 	private static final long serialVersionUID = 1L; 
 	public Connection connection = null; 


	public DbUtil(){ 
				try { 
					Class.forName("org.sqlite.JDBC");  
					connection = DriverManager.getConnection("jdbc:odbc:JDBC-ODBC"); 
					 

				} catch (Exception e) { 
				e.printStackTrace(); 
				} 
				String guitar ="select * from Guitar"; 
				System.out.println(guitar);


	}
}

 
      
 

