package com.user;

import java.util.*;

import com.db.dao.BaseDao;

import java.sql.*;  
  
public class UserDao extends BaseDao {  
  
   
    public  int save(User e){  
        int status=0;  
        try{  
        	
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into user(username,password,type) values (?,?,?)");
       //     PreparedStatement ps1=con.prepareStatement("select * from user where type=user");
     //       ps.setString(1,e.getId());
            ps.setString(1,e.getUsername());  
            ps.setString(2,e.getPassword());
            ps.setString(3,e.getType());
           
              
            status=ps.executeUpdate();  
//            ps1.setString(4, "user");
//            status=ps1.executeUpdate();
//            ResultSet rs = ps1.executeQuery();
            
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
   
}
