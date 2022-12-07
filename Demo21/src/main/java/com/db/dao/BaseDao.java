package com.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	 protected  Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.cj.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/information","root","root");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  

}
