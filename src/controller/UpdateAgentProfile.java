package controller;

import java.io.IOException;
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
 * Servlet implementation class UpdateAgentProfile
 */
@WebServlet("/UpdateAgentProfile")
public class UpdateAgentProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAgentProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		String emailaddress = request.getParameter("emailaddress");
		String contactnumber = request.getParameter("contact");
		String companyname = request.getParameter("companyname");
		String companyaddress = request.getParameter("companyaddress");
		if(password.equalsIgnoreCase(confirmpassword)) {
			Agent agent = (Agent) session.getAttribute("agentprofile");
			agent.updateProfile(password, emailaddress, contactnumber, companyname, companyaddress);
			try {
				DBConnection db= DBConnection.getInstance();
				db.UpdateAgent(agent);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("message", "Profile update successfully!");
			request.getRequestDispatcher("AgentProfile.jsp").forward(request, response);
		}
		else {
			request.setAttribute("message", "Confirm password and password is not same. Please try again!");
			request.getRequestDispatcher("AgentProfile.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
