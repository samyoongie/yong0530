package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Schedule;

/**
 * Servlet implementation class RetrieveScheduleAgain
 */
@WebServlet("/RetrieveScheduleAgain")
public class RetrieveScheduleAgain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveScheduleAgain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String routename = request.getParameter("routeselection");
		String customername = request.getParameter("customerselection");
		List <Schedule> NewScheduleList = new ArrayList<Schedule>();
		HttpSession session = request.getSession(false);
		List <Schedule> schedulelist = (List<Schedule>) session.getAttribute("schedulelist");
		for(int i=0; i<schedulelist.size(); i++) {
			if(schedulelist.get(i).getRoute().getRoute_Name().equals(routename)) {				
				NewScheduleList.add(schedulelist.get(i));
			}
		}
		
		request.setAttribute("selectedroute", routename);
		request.setAttribute("selectedcustomer", customername);
		session.setAttribute("newschedulelist", NewScheduleList);
		request.getRequestDispatcher("BookVessel.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
