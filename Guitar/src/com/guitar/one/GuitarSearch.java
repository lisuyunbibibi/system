package com.guitar.one;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.guitar.one.Guitar.*;  
import javax.servlet.*; 


import com.guitar.DB.DbUtil;

public class GuitarSearch { 
 	private static Connection connection = null; 
 	private DbUtil jdbc = null; 
 	private static PreparedStatement ps = null; 
 	 
 	public GuitarSearch(){ 
 		jdbc = new DbUtil(); 
 		connection= jdbc.connection; 
 	} 
 	 
 	public static List<Guitar> getGuitars(String builder, String backwood, String topwood, String type){ 
 		List<Guitar> guitars = new ArrayList<Guitar>(); 
 		Guitar guitar = null; 
 			try { 
 		 
 				if(builder!= "" && backwood!= "" && topwood!= "" && type!= ""){ 
 					ps = connection.prepareStatement("select * from Guitar where builder=? and backwood=? and topwood=? and type=?"); 
 					ps.setString(1, builder); 
					ps.setString(2, type); 
 					ps.setString(3, backwood); 
					ps.setString(4, topwood); 
 				} 
 				
								
 				 
 				ResultSet rs = ps.executeQuery(); 
 				 
 				while(rs.next()){ 
 					guitar = new Guitar(); 
 					 
 					guitar.setSerialNumber(rs.getString(2)); 
 					guitar.setBackWood(rs.getString(3)); 
 					guitar.setTopWood(rs.getString(4)); 
 					guitar.setPrice(rs.getDouble(5)); 
					guitar.setBuilder(rs.getString(6)); 
					guitar.setModel(rs.getString(7)); 
 					guitar.setType(rs.getString(8)); 
								 
					guitars.add(guitar);			 
 				} 
 				if(rs != null){ 
 					rs.close(); 
 				} 
 			} catch (SQLException e) { 
 				e.printStackTrace(); 
 			} 
 		return guitars; 
 	} 
}
