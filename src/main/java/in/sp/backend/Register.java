package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.jasper.tagplugins.jstl.core.Out;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/process_registration")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		
		String myname = req.getParameter("name");
		String myemail = req.getParameter("email");
		String Gender = req.getParameter("gender");
		String state = req.getParameter("state");
		
		try {
			// Load the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Establish a connection to the database;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_reg", "root", "system");
			
			// Creating an SQL query to insert data into the database;
			PreparedStatement ps = con.prepareStatement("insert into users values(?, ?, ?, ?)");
			
			//set the values for each parameter in the PreparedStatement 
			ps.setString(1, myname);
			ps.setString(2, myemail);
			ps.setString(3, Gender);
			ps.setString(4, state);
			
			//Execute the update(insert operation)
			int result = ps.executeUpdate();	
			
			if (result > 0) {
				
                //resp.getWriter().println("Registration successful!");
				resp.setContentType("text/html");
				out.print("<h3 style='color:green; text-align:center'> User registered successfully </h3>");

				
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
				
            } else {
            	
                //resp.getWriter().println("Registration failed.");
            	resp.setContentType("text/html");
				out.print("<h3 style='color:red'> User not registered succesfully </h3>");
				
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
            }
					
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
