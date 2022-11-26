package miniprojectfilter;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
* Servlet implementation class AdminValidator
*/
@WebServlet("/AdminV1")
public class AdminV1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminV1() {
        super();
        // TODO Auto-generated constructor stub
    }



   



   /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        String un = (String) request.getAttribute("un");
        String pw = (String) request.getAttribute("pw");
        
        response.setContentType("text/html");
        
        if ("vishal".equals(un) && "yadav".equals(pw)) {
            HttpSession session = request.getSession();
            
            String loggedUsers = (String) session.getAttribute("loggedUser");
            
            if (loggedUsers == null) {
                session.setAttribute("loggedUser", un);
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("AdminLanding1");
            rd.include(request, response);
        } else {
            response.getWriter().append("Adminname or password is wrong");
            RequestDispatcher rd = request.getRequestDispatcher("/Admin1.html");
            rd.include(request, response);
        }
    }



}
