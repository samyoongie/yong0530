package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agent;
import model.DBConnection;

/**
 * Servlet implementation class AddAgentServlet
 */
@WebServlet("/AddAgentServlet")
public class AddAgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAgentServlet() {
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
        String confirmpassword = request.getParameter("confirmpassword");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String emailaddress = request.getParameter("emailaddress");
        String contactnumber = request.getParameter("contact");
        String companyname = request.getParameter("companyname");
        String companyaddress = request.getParameter("companyaddress");
        Double credit;
        Agent agent =null;
        int count = 0;
        DBConnection db;
		try {
			db = DBConnection.getInstance();		
        if(username.equalsIgnoreCase("admin")|| password.equalsIgnoreCase("admin")) {
        	request.setAttribute("message", "Invalid username and password! Please try again.");
            request.getRequestDispatcher("AddAgent.jsp").forward(request, response);
        }
        else {
        	if(confirmpassword.equals(password)) {
        		String sql1 = "SELECT * FROM AGENT WHERE AGENT_NAME = '" + name +"'";
        		String sql2 = "SELECT * FROM AGENT WHERE AGENT_USERNAME = '" + username +"'";
        		ResultSet rs = db.RunQuery(sql1);
        		ResultSet rs2= db.RunQuery(sql2);
        		while(rs.next()) {
        			count++;
        		}
        		while(rs2.next()) {
        			count++;
        		}
        		if(count ==0) {
        		credit = (double) 0;
        		agent = new Agent(username, password,name,gender,emailaddress,contactnumber,companyname,companyaddress,credit);        	
				db.RunInsert(agent);
				request.setAttribute("message", "Agent added successfully!");
				request.getRequestDispatcher("AddAgent.jsp").forward(request, response);
        		}
        		else {
        			request.setAttribute("message", "Name or username has been registered! Please try again.");
    				request.getRequestDispatcher("AddAgent.jsp").forward(request, response);
        		}
            }
            else {
            	request.setAttribute("message", "Password are not same!");
                request.getRequestDispatcher("AddAgent.jsp").forward(request, response);
            }
        }
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

}
