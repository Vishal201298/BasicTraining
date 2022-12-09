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
    
    //check method
//    public  boolean checkType(String type) {
//
//        boolean find = false;
//        PreparedStatement pst = null;  
//        ResultSet rs = null;  
//        try( Connection con=getConnection(); ){
//            pst = con.prepareStatement("SELECT * FROM user WHERE type=?;");  
//            pst.setString(1, type);  
//            rs = pst.executeQuery();
//            while (rs.next()) {
//           if (rs.getString("type").equals("admin")) {
//               find = true;
//                } else {find = false;}
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return find;  
//    }
   
}
