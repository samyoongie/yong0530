package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Agent;
import model.DBConnection;

/**
 * Servlet implementation class RetrieveAgentList
 */
@WebServlet("/RetrieveAgentList")
public class RetrieveAgentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveAgentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		try {
			List <Agent> agentlist = new ArrayList<Agent>();
			Agent agent = null;
			DBConnection db = DBConnection.getInstance();
			String sql = "Select * from  AGENT";
			ResultSet rs = db.RunQuery(sql);
			while(rs.next()) {
				agent = new Agent(rs.getInt("Agent_id"), rs.getString("AGENT_username"),rs.getString("AGENT_password"),rs.getString("AGENT_name"),rs.getString("AGENT_gender"),
						rs.getString("AGENT_emailaddress"),rs.getString("AGENT_contactnumber"),rs.getString("AGENT_companyname"),
						rs.getString("AGENT_companyaddress"),rs.getDouble("AGENT_credit"));
			agentlist.add(agent);
			}			
			session.setAttribute("agentlist", agentlist);
			request.getRequestDispatcher("ViewAgent.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
