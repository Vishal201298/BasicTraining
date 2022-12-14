package com.issue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/IssueServlet")
public class Issueservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Issueservlet() {
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
          
  //      String id=request.getParameter("id");
        String discription=request.getParameter("discription"); 
        String sid=request.getParameter("userid");
         int userid=Integer.parseInt(sid);
        String status=request.getParameter("status");  
        
          
        Issue e=new Issue();  
     //   e.setId(id);
        e.setDiscription(discription); 
        e.setUserid(userid);
        e.setStatus(status); 
       
        
          IssueDao dao=new IssueDao();
        int status1=dao.save(e);  
        if(status1>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("issue.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
	

}

