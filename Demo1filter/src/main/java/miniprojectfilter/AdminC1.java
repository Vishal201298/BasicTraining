package miniprojectfilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Base64.Decoder;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
* Servlet implementation class LoginController
*/
@WebServlet("/admin1")
public class AdminC1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminC1() {
        super();
    }



   /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
Decoder decoder = Base64.getDecoder();
        
        byte[] adminname = request.getParameter("adminname").toString().getBytes();
        byte[] password = request.getParameter("password").toString().getBytes();
        
        String uname = new String(decoder.decode(adminname));
        String pword = new String(decoder.decode(password));
        
        System.out.println(uname + " : " + pword);
        
        HttpSession session = request.getSession();
        
        String loggedUser = (String) session.getAttribute("loggedUser");
        
        System.out.println("loggedUser : " + loggedUser);
        
        if (loggedUser == null) {
            System.out.println("loggedUser is null " + loggedUser);
            request.setAttribute("un", uname);
            request.setAttribute("pw", pword);
            RequestDispatcher rd = request.getRequestDispatcher("AdminV1");
            rd.forward(request, response);
        } else if (uname.equals(loggedUser)) {
            System.out.println("loggedUser : " + loggedUser);
            response.setContentType("text/html");
            response.getWriter().append("You are already logged in");
            RequestDispatcher rd = request.getRequestDispatcher("AdminLanding1");
            rd.include(request, response);
        } else {
            response.setContentType("text/html");
            RequestDispatcher rd = request.getRequestDispatcher("/Admin1.html");
            rd.include(request, response);
        }          
            
    }
}
