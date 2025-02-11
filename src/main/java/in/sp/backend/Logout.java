package in.sp.backend;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/logout")
public class Logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 HttpSession session = req.getSession(false); // false means do not create a new session if it doesn't exist
	        
	        if (session != null) {
	            // Invalidate the session to log the user out
	            session.invalidate();
	            // Redirect to login page after logout
	            resp.sendRedirect("login.jsp");  // Redirect user to login page after logging out
	        } else {
	            // If no session is found, simply redirect to login page
	            resp.sendRedirect("login.jsp");
	        }
	}
}
