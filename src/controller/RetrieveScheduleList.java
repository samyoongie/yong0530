package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DBConnection;
import model.Route;
import model.Schedule;
import model.Ship;

/**
 * Servlet implementation class RetrieveScheduleList
 */
@WebServlet("/RetrieveScheduleList")
public class RetrieveScheduleList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveScheduleList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		try {
			DBConnection db = DBConnection.getInstance();
			HttpSession session = request.getSession(false);
			String query = "SELECT * FROM SCHEDULE s LEFT JOIN ROUTE r ON s.ROUTE_ID = r.ROUTE_ID LEFT JOIN SHIP sh ON s.SHIP_ID = sh.SHIP_ID";
			Schedule schedule;
			List <Schedule> ScheduleList = new ArrayList<Schedule>();
			List <Schedule> NewScheduleList = new ArrayList<Schedule>();
			Route route;
			Ship ship;
			Date currentdate = new Date();
			ResultSet rs = db.RunQuery(query);
			while(rs.next()) {
				route = new Route(rs.getInt("ROUTE_ID"), rs.getString("ROUTE_NAME"), rs.getString("ROUTE_DEPARTUREDESTINATION"), rs.getString("ROUTE_ARRIVALDESTINATION"));
				ship = new Ship(rs.getInt("SHIP_ID"), rs.getString("SHIP_NAME"), rs.getInt("SHIP_BAY"));
				schedule = new Schedule(rs.getInt("SCHEDULE_ID"), (Date) rs.getObject("DEPARTURETIME"), (Date) rs.getObject("ARRIVALTIME"), ship, route);
				if(schedule.getSchedule_departuretime().after(currentdate)) {
					ScheduleList.add(schedule);
				}
			}
			List <Route> routelist = (List<Route>) session.getAttribute("routelist");
			for(int i=0; i<ScheduleList.size(); i++) {
				if(ScheduleList.get(i).getRoute().getRoute_Name().equals(routelist.get(0).getRoute_Name())) {
					
					NewScheduleList.add(ScheduleList.get(i));
				}
			};
			session.setAttribute("newschedulelist", NewScheduleList);
			session.setAttribute("schedulelist", ScheduleList);
			request.getRequestDispatcher("RetrieveCustomerItem").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
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
