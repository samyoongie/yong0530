package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Agent;

/**
 * Servlet implementation class SearchAgentProfile
 */
@WebServlet("/SearchAgentProfile")
public class SearchAgentProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAgentProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("agentname");
		HttpSession session = request.getSession(false);
		List agentlist = (List) session.getAttribute("agentlist");
		Iterator iterator = agentlist.iterator();
		int count =0;
		Agent agent = null;
		while(iterator.hasNext()) {
			agent = (Agent) iterator.next();
			if(agent.getName().equalsIgnoreCase(name)) {
				count++;
				break;
			}
		}
		if(count==0) {
			request.setAttribute("message", "Agent is not found. Please try again!");
			request.getRequestDispatcher("ViewAgent.jsp").forward(request, response);
		}
		else {
			session.setAttribute("agentprofile", agent);
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
