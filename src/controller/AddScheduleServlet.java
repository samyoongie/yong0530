package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

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
 * Servlet implementation class AddScheduleServlet
 */
@WebServlet("/AddScheduleServlet")
public class AddScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddScheduleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String ddate = request.getParameter("departuredatetime");
			String addate = request.getParameter("arrivaldatetime");
			if (!ddate.equals("") && !addate.equals("")) {	
				Date departuredate = sdf.parse(ddate);
				Date arrivaldate = sdf.parse(addate);
				String shipname = request.getParameter("shipselection");
				String routename = request.getParameter("routeselection");
				Date currentdate = new Date();
				if (departuredate.before(currentdate)) {
					request.setAttribute("message", "Invalid date. PLease try again!") ;
					request.getRequestDispatcher("AddSchedule.jsp").forward(request, response);
				} else {
					HttpSession session = request.getSession(false);
					List shiplist = (List) session.getAttribute("shiplist");
					List routelist = (List) session.getAttribute("routelist");
					Iterator iterator = shiplist.iterator();
					Iterator iterator2 = routelist.iterator();
					Ship ship = null;
					Route route = null;
					while (iterator.hasNext()) {
						ship = (Ship) iterator.next();
						if (ship.getShip_Name().equalsIgnoreCase(shipname)) {
							break;
						}
					}
					while (iterator2.hasNext()) {
						route = (Route) iterator2.next();
						if (route.getRoute_Name().equalsIgnoreCase(routename)) {
							break;
						}
					}
					String query = "SELECT * FROM SCHEDULE WHERE SHIP_ID = '" + ship.getShip_ID() + "'";
					DBConnection db = DBConnection.getInstance();
					ResultSet rs = db.RunQuery(query);
					int count = 0;
					while (rs.next()) {
						Date createddepartdate = (Date) rs.getObject("DEPARTURETIME");
						Date createdarrdate = (Date) rs.getObject("ARRIVALTIME");
						if (departuredate.before(createddepartdate) && arrivaldate.after(createdarrdate)
								|| departuredate.after(createddepartdate) && arrivaldate.before(createdarrdate)
								|| departuredate.before(createddepartdate) && arrivaldate.after(createddepartdate)
								|| departuredate.before(createdarrdate) && arrivaldate.after(createdarrdate)
								|| departuredate.equals(createddepartdate) && arrivaldate.equals(createdarrdate)
								|| departuredate.equals(createddepartdate) && arrivaldate.before(createdarrdate)
								|| departuredate.after(createddepartdate) && arrivaldate.equals(createdarrdate)) {
							count++;
						}
					}
					if (count == 0) {
						Schedule s = new Schedule(departuredate, arrivaldate, ship, route);
						db.RunInsert(s);
						request.setAttribute("message", "Created Schedule successfully!");
						request.getRequestDispatcher("AddSchedule.jsp").forward(request, response);
					} else {
						request.setAttribute("message", "Ship is not available for that period. Please try again!");
						request.getRequestDispatcher("AddSchedule.jsp").forward(request, response);
					}
				}
			}
			else {
				request.setAttribute("message", "Please select the date!");
				request.getRequestDispatcher("AddSchedule.jsp").forward(request, response);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
