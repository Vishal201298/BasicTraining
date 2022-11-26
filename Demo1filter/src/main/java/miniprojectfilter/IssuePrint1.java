package miniprojectfilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IssuePrint
 */
@WebServlet("/IssuePrint1")
public class IssuePrint1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssuePrint1() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getRequestURI());
		
		    response.setContentType("text/html");
		    response.getWriter().append("<h2>Issue DashBoard</h2>");
		    
		        String emp=request.getParameter("empid");
		        String issue=request.getParameter("issues");
		        Map<String, String> issueMap = new HashMap<String, String>();
		        issueMap.put(emp, issue);
		        
		        HttpSession session = request.getSession();
		        
		        ArrayList userIssues = (ArrayList)session.getAttribute("userIssues");
		        
		        if (userIssues == null) {
		            userIssues = new ArrayList();
		            userIssues.add(issueMap);
		            
		        } else {
		            userIssues.add(issueMap);
		        }
		        
		        session.setAttribute("userIssues", userIssues);
		        
		    for (int i =0; i < userIssues.size(); i++) {
		        
		        HashMap pMap = (HashMap) userIssues.get(i);
		        response.getWriter().append("<table border='1'>");
		        pMap.forEach((empid, issues) -> {
		            try {
		            	response.getWriter().append("<tr>");
						response.getWriter().append("<td> EmpId :"+ empid + "</td>");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}        
		            try {
						response.getWriter().append("<td> Issue :"+ issues + "</td>");
						response.getWriter().append("</tr>");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					}
		            
		        });
		        response.getWriter().append("</table>");
		        
		    }
		    String user=request.getParameter("username");
		   if(user.equals("username")) {
		        
		        response.getWriter().append("<a href=\"Landing1.html\">Add Issue </a>");
		        response.getWriter().append("<a href=\"Login1.html\">Logout </a>");
	}else {
		response.getWriter().append("Other user");
	}
	}
	
	}
	




