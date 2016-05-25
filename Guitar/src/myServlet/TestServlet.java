package myServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.guitar.DB.DbUtil;
import com.guitar.one.Guitar;  
 

//@WebServlet("/TextServlet") 
public class TestServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L; 
	/*public TextServlet() { 
		      super(); 
		 	} 
*/
    @Override  
   protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
    	doPost(request, response);
          
       
          
    }  
  
   @Override  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
           throws ServletException, IOException {  
        // TODO Auto-generated method stub  
	   request.setCharacterEncoding("UTF-8");  
	    	response.setContentType("text/html;charset=UTF-8"); 
	    	String builder = request.getParameter("builder"); 
	    	String type = request.getParameter("type"); 
	    	String backwood = request.getParameter("backwood"); 
	    	String topwood = request.getParameter("topwood"); 
	    	
	    	 if(!getGuitars(builder,type,backwood,topwood).isEmpty()){ 
	    		 		request.setAttribute("guitars", getGuitars(builder,type,backwood,topwood)); 
	    		 		request.getRequestDispatcher("/showGuitar.jsp").forward(request, response); 
	    		 	 } 

    }
   public static List<Guitar> getGuitars(String builder, String backwood, String topwood, String type){ 
	   		DbUtil jdbc = new DbUtil(); 
	    		Connection connection = jdbc.connection; 
	    		PreparedStatement ps = null; 
	    		List<Guitar> guitars = new ArrayList<Guitar>();
	    		try{
	    			if(builder!= "" && backwood!= "" && topwood!= "" && type!= ""){ 
	    								ps = connection.prepareStatement("select * from Guitar where builder=? and backwood=? and topwood=? and type=?"); 
	    								ps.setString(1, builder); 
	    								ps.setString(2, type); 
	    								ps.setString(3, backwood); 
	    								ps.setString(4, topwood); 
	    				 				} 
	    			ResultSet rs = ps.executeQuery(); 
	    							 
	    			 				while(rs.next()){ 
	    								Guitar guitar = new Guitar(); 
	    			 					 
	    			 					guitar.setSerialNumber(rs.getString(1)); 
	    								guitar.setBackWood(rs.getString(2)); 
	    								guitar.setTopWood(rs.getString(3)); 
	    			 					guitar.setPrice(rs.getDouble(4)); 
	    			 					guitar.setBuilder(rs.getString(5)); 
	    			 					guitar.setModel(rs.getString(6)); 
	    			 					guitar.setType(rs.getString(7)); 
	    			 					guitar.setNumStrings(rs.getInt(8)); 
	    			 								 
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






    

 
  
 
