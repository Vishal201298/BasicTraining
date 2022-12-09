package com.issue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet1")
public class UserViewissueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletResponse response;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserViewissueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter(); 
	

	// For User
	 
     out.println("<a href='issue.html'>Add New Issue</a>");  
     out.println("<h1>Issues List</h1>");
     
//     String userid=request.getParameter("userid");  
//        int user=Integer.parseInt(userid);
	 IssueDao dao1= new IssueDao();
     List<Issue> list1=dao1.getIssueByUserid();  
     
     
     out.print("<table border='1' width='100%'");  
     out.print("<tr><th>Id</th><th>Discription</th><th>Userid</th><th>Status</th></tr>");  
     for(Issue e:list1){  
      out.print("<tr><td>"+e.getId()+"</td><td>"+e.getDiscription()+"</td><td>"+e.getUserid()+"</td><td>"+e.getStatus()+"</td></tr>");  
     }
     out.print("</table>");  
       
     out.close(); 


	}

}