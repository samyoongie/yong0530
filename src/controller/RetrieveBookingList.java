package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Agent;
import model.Booking;
import model.Customer;
import model.DBConnection;
import model.Item;
import model.Route;
import model.Schedule;
import model.Ship;

/**
 * Servlet implementation class RetrieveBookingList
 */
@WebServlet("/RetrieveBookingList")
public class RetrieveBookingList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetrieveBookingList() {
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
		HttpSession session = request.getSession(false);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String from = (String) session.getAttribute("for");
		Item item = null;
		Agent agent = null;
		Route route = null;
		Ship ship = null;
		Schedule schedule = null;
		Booking booking = null;
		List<Agent> agentlist = new ArrayList<Agent>();
		List<Customer> customerlist = new ArrayList<Customer>();
		List<Schedule> schedulelist = new ArrayList<Schedule>();
		List<Booking> bookinglist = new ArrayList<Booking>();
		List<Item> itemlist = new ArrayList<Item>();
		List<Item> tempitemlist = new ArrayList<Item>();
		List<Item> currentitemlist = new ArrayList<Item>();
		Customer customer = null;
		try {
			DBConnection db = DBConnection.getInstance();
			Date currentdate = new Date();
			String query = "SELECT * FROM ITEM";
			String query3 = "SELECT * FROM CUSTOMER"; //
			String query2 = "SELECT * FROM AGENT"; //
			String query4 = "SELECT * FROM BOOKING";
			String query5 = "SELECT * FROM SCHEDULE s LEFT JOIN ROUTE r ON s.ROUTE_ID = r.ROUTE_ID LEFT JOIN SHIP sh ON s.SHIP_ID = sh.SHIP_ID";
			ResultSet rs5 = db.RunQuery(query5);
			ResultSet rs4 = db.RunQuery(query4);
			ResultSet rs3 = db.RunQuery(query);
			ResultSet rs2 = db.RunQuery(query3);
			ResultSet rs = db.RunQuery(query2);
			while (rs5.next()) { // all schedule
				route = new Route(rs5.getInt("ROUTE_ID"), rs5.getString("ROUTE_NAME"),
						rs5.getString("ROUTE_DEPARTUREDESTINATION"), rs5.getString("ROUTE_ARRIVALDESTINATION"));
				ship = new Ship(rs5.getInt("SHIP_ID"), rs5.getString("SHIP_NAME"), rs5.getInt("SHIP_BAY"));
				schedule = new Schedule(rs5.getInt("SCHEDULE_ID"), (Date) rs5.getObject("DEPARTURETIME"),
						(Date) rs5.getObject("ARRIVALTIME"), ship, route);
				schedulelist.add(schedule);
			}
			while (rs.next()) { // all agent
				agent = new Agent(rs.getInt("AGENT_ID"), rs.getString("AGENT_USERNAME"), rs.getString("AGENT_PASSWORD"),
						rs.getString("AGENT_NAME"), rs.getString("AGENT_GENDER"), rs.getString("AGENT_EMAILADDRESS"),
						rs.getString("AGENT_CONTACTNUMBER"), rs.getString("AGENT_COMPANYNAME"),
						rs.getString("AGENT_COMPANYADDRESS"), rs.getDouble("AGENT_CREDIT"));
				agentlist.add(agent);
			}
			while (rs2.next()) { // all customer
				for (int i = 0; i < agentlist.size(); i++) {
					if (rs2.getInt("AGENT_ID") == agentlist.get(i).getID()) {
						customer = new Customer(rs2.getInt("CUST_ID"), rs2.getString("CUST_NAME"),
								rs2.getString("CUST_ICPASSPORT"), rs2.getString("CUST_GENDER"),
								rs2.getString("CUST_EMAILADDRESS"), rs2.getString("CUST_CONTACTNUMBER"),
								rs2.getString("CUST_ADDRESS"), agentlist.get(i));
						customerlist.add(customer);
						break;
					}
				}
			}
			while (rs4.next()) { // all booking
				for (int i = 0; i < customerlist.size(); i++) {
					if (rs4.getInt("CUST_ID") == customerlist.get(i).getCust_ID()) {
						customer = customerlist.get(i);
						break;
					}
				}
				for (int i = 0; i < agentlist.size(); i++) {
					if (rs4.getInt("AGENT_ID") == agentlist.get(i).getID()) {
						agent = agentlist.get(i);
						break;
					}
				}
				for (int i = 0; i < schedulelist.size(); i++) {
					if (rs4.getInt("SCHEDULE_ID") == schedulelist.get(i).getSchedule_ID()) {
						schedule = schedulelist.get(i);
						break;
					}
				}
				booking = new Booking(rs4.getInt("BOOKING_ID"), (Date) rs4.getObject("BOOKING_DATE"),
						rs4.getDouble("BOOKING_PRICE"), customer, agent, schedule);
				bookinglist.add(booking);
			}
			while (rs3.next()) {
				for (int i = 0; i < customerlist.size(); i++) {
					if (rs3.getInt("CUST_ID") == customerlist.get(i).getCust_ID()) {
						customer = customerlist.get(i);
						break;
					}
				}
				for (int i = 0; i < agentlist.size(); i++) {
					if (rs3.getInt("AGENT_ID") == agentlist.get(i).getID()) {
						agent = agentlist.get(i);
						break;
					}
				}
				if (rs3.getInt("BOOKING_ID") != 0) {
					for (int i = 0; i < bookinglist.size(); i++) {
						if (rs3.getInt("BOOKING_ID") == bookinglist.get(i).getBooking_ID()) {
							booking = bookinglist.get(i);
							break;
						}
					}
					item = new Item(rs3.getInt("ITEM_ID"), rs3.getString("ITEM_NAME"),
							rs3.getString("ITEM_DESCRIPTION"), rs3.getInt("ITEM_QUANTITY"), customer, agent, booking);
					itemlist.add(item);
				}
			}
			session.setAttribute("currentdate", currentdate);
			session.setAttribute("overallitemlist", itemlist);
			for(int i =0; i<itemlist.size();i++) {				
				if(sdf.format(itemlist.get(i).getBooking().getBooking_Date()).equals(sdf.format(currentdate))) {
					currentitemlist.add(itemlist.get(i));
				}	
			}
			if (from.equals("foradmin")) {					
				session.setAttribute("allitemlist", currentitemlist);
				request.getRequestDispatcher("AdminPortal.jsp").forward(request, response);
			} else if(from.equals("foragent")){
				Agent cagent = (Agent) session.getAttribute("loginuser");
				for (int i = 0; i < currentitemlist.size(); i++) {
					if (currentitemlist.get(i).getBooking().getAgent().getID() == cagent.getID()) {
						tempitemlist.add(currentitemlist.get(i));
					}
				}
				session.setAttribute("allitemlist", tempitemlist);
				request.getRequestDispatcher("AgentPortal.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
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
