package com.issue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
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
	          
	        String sid1=request.getParameter("id");  
	        int id=Integer.parseInt(sid1); 
	        String discription=request.getParameter("discription");  
	        String sid=request.getParameter("userid");
	         int userid=Integer.parseInt(sid);
	        String Status=request.getParameter("status");  
	       
	          
	        Issue e=new Issue();  
	        e.setId(id);  
	        e.setDiscription(discription); 
	        e.setUserid(userid);
	        e.setStatus(Status);  
	        
	          IssueDao dao=new IssueDao();
	        int status=dao.update(e);  
	        if(status>0){  
	            response.sendRedirect("ViewServlet");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	        out.close();  
	}

}