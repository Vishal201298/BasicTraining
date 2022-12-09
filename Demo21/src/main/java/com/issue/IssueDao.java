package com.issue;

import java.util.*;

import com.db.dao.BaseDao;

import java.sql.*;  
  
public class IssueDao extends BaseDao {  
  
    
    public  int save(Issue e){  
        int status1=0;  
        try{  
        
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into issue(discription,user_id,status) values (?,?,?)");  
         //   ps.setString(1,e.getId());
            ps.setString(1,e.getDiscription());  
            ps.setInt(2,e.getUserid());
            ps.setString(3,e.getStatus());
           
              
            status1=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status1;  
    }  
    
    
    public int update(Issue e){  
        int status1=0;  
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update issue set  discription=?,user_id=?, status=? where ID=? ");  
            ps.setString(1,e.getDiscription());  
            ps.setInt(2,e.getUserid());
            ps.setString(3,e.getStatus());  
           
            ps.setInt(4,e.getId());  
              
            status1=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status1;  
    }  
    public  int delete(int id){  
        int status1=0;  
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from issue where ID=?");  
            ps.setInt(1,id);  
            status1=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status1;  
    }  
    public Issue getIssueById(int id){  
        Issue e=new Issue();  
          
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from issue where ID=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setDiscription(rs.getString(2));  
                e.setStatus(rs.getString(3));  
                 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
  
        
    }  
    // Admin method
    public List<Issue> getAllIssue(){  
    	String query= "select * from issue";
        List<Issue> list=new ArrayList<Issue>();  
          
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement(query);  
  //          ps.setInt(1,userid);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){ 
//            	 if (rs.getString("user_id").equals(userid)) {
                Issue e=new Issue();  
                e.setId(rs.getInt(1));  
                e.setDiscription(rs.getString(2)); 
                e.setUserid(rs.getInt(3));
                e.setStatus(rs.getString(4));  
                 
                list.add(e); 
            	 }
 //           }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
        
        return list;  
        
    }
    
  //  User method  
    public List<Issue> getIssueByUserid(){  
    	String query= "select * from issue";
        List<Issue> list1=new ArrayList<Issue>();  
          
        try{  
            Connection con=getConnection();  
            PreparedStatement ps=con.prepareStatement(query);  
       //     ps.setInt(1,userid);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){ 
//            	 if (rs.getString("user_id").equals(userid)) {
                Issue e=new Issue();  
                e.setId(rs.getInt(1));  
                e.setDiscription(rs.getString(2)); 
                e.setUserid(rs.getInt(3));
                e.setStatus(rs.getString(4));  
                 
                list1.add(e); 
            	 }
 //           }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
        
        return list1;  
        
    }


}
