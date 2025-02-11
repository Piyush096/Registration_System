package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login_user")
public class login extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter out = resp.getWriter();
        
        // Get the parameters from the login form (name and email)
        String myname = req.getParameter("name");
        String myemail = req.getParameter("email");
        
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_reg", "root", "system");

            // Query to fetch user data from the database based on name and email
            String query = "SELECT * FROM users WHERE myname = ? AND myemail = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, myname);   // Set name parameter
            ps.setString(2, myemail);   // Set email parameter

            // Execute the query and get the result set
            ResultSet rs = ps.executeQuery();
            
            // If the user is found
            if (rs.next()) {
                // Create a session
                HttpSession session = req.getSession();
                
                // Store the user information in the session (you can store other data as needed)
                session.setAttribute("userName", myname);
                session.setAttribute("userEmail", myemail);
                
                // Login successful
                req.setAttribute("loginMessage", "User login successful!");  // Set success message
                
                // Forward the request to the new JSP page with user details
                RequestDispatcher rd = req.getRequestDispatcher("/welcome.jsp");
                rd.forward(req, resp);
            } else {
                // Login failed
                req.setAttribute("loginMessage", "Invalid name or email!");  // Set error message
                RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
                rd.include(req, resp);  // Include the login page with error message
            }
            
        } catch (Exception e) {
            // Print any exception that occurs during the process
            e.printStackTrace();
            resp.setContentType("text/html");
            out.print("<h3 style='color:red'> An error occurred during login! Please try again later. </h3>");
        }
    }
}
