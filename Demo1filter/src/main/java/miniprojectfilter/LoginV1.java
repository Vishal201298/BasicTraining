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
 * Servlet implementation class LoginValidator
 */
@WebServlet("/LoginV1")
public class LoginV1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginV1() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String un = (String) request.getAttribute("un");
		String pw = (String) request.getAttribute("pw");

		response.setContentType("text/html");

		if ("ashu".equals(un) && "ashu1".equals(pw)) {
			HttpSession session = request.getSession();

			String loggedUsers = (String) session.getAttribute("loggedUser");

			if (loggedUsers == null) {
				session.setAttribute("loggedUser", un);
			}

			RequestDispatcher rd = request.getRequestDispatcher("Landing1");
			rd.include(request, response);
		} else {
			response.getWriter().append("Username or password is wrong");
			RequestDispatcher rd = request.getRequestDispatcher("/Login1.html");
			rd.include(request, response);
		}
	}


}
