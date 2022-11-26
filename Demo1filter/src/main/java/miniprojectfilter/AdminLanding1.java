package miniprojectfilter;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
* Servlet implementation class AdminLanding
*/
@WebServlet("/AdminLanding1")
public class AdminLanding1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLanding1() {
        super();
        // TODO Auto-generated constructor stub
    }





   /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
        
        System.out.println(request.getRequestURI());
        response.setContentType("text/html");
        RequestDispatcher rd = request.getRequestDispatcher("/AdminLanding1.html");
        rd.include(request, response);
    }



}
