package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Agent;
import model.DBConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
        	HttpSession session = request.getSession();
            session.setAttribute("loginuser","admin");
            session.setAttribute("for","foradmin");
        	request.getRequestDispatcher("RetrieveBookingList").forward(request, response);
        }
        else {        	
        	try {
				DBConnection db= DBConnection.getInstance();
				String query = "SELECT * FROM AGENT WHERE AGENT_USERNAME = '" + username + "' AND AGENT_PASSWORD = '" + password +"'";
				ResultSet rs = db.RunQuery(query);
				if(rs.next()) {
					HttpSession session = request.getSession(); 
					Agent agent = new Agent(rs.getInt("AGENT_id"), rs.getString("AGENT_username"),rs.getString("AGENT_password"),
							rs.getString("AGENT_name"),rs.getString("AGENT_gender"),rs.getString("AGENT_emailaddress"),
							rs.getString("AGENT_contactnumber"),rs.getString("AGENT_companyname"),
							rs.getString("AGENT_companyaddress"),rs.getDouble("AGENT_credit"));
		            session.setAttribute("loginuser",agent);	
		            session.setAttribute("jsp","login");
		            session.setAttribute("for","foragent");
		            request.getRequestDispatcher("RetrieveCustomerList").forward(request, response);
				}
				else {
					request.setAttribute("message", "Invalid username or password!");
					request.getRequestDispatcher("Home.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
	}

}
