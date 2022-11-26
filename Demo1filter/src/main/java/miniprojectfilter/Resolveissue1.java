package miniprojectfilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;



import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionIdListener;



/**
* Servlet implementation class Issuesolved
*/
@WebServlet("/Resolveissue1")
public class Resolveissue1  extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resolveissue1() {
        super();
        // TODO Auto-generated constructor stub
    }



   /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */




    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.sendRedirect("IssuePage");
        HttpSessionIdListener session1=(HttpSessionIdListener) request.getSession();
        ((ServletRequest) session1).getAttribute("userIssue");



    }
    }



