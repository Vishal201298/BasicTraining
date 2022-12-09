package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
         
  
        String name=request.getParameter("name");
        String psw= request.getParameter("password");
       // String typ= request.getParameter("type");
        String QUERY="select * from user where username=? and password=?"; 

        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Connection
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/information","root","root")) {
            PreparedStatement ps = con.prepareStatement(QUERY);
            
				ps.setString(1, name);
                ps.setString(2, psw);
            //    ps.setString(3, typ);
            try (ResultSet rs = ps.executeQuery()) {
            	while(rs.next()) {
            	 if (rs.getString("type").equals("admin")) {
            		 out.print("<p>Login successfully!</p>");  
            //		 request.setAttribute("usertype", "admin");
                     request.getRequestDispatcher("check.html").include(request, response); 
            	 }
                if(rs.getString("type").equals("user")){
                	 out.print("<p>Login successfully!</p>");  
                   request.getRequestDispatcher("issue.html").include(request, response); 
            //    	 request.setAttribute("usertype", "user");
                }else{
                    out.println("ERROR");
                }
            	}
            }
        } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}