package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import model.Schedule;

/**
 * Servlet implementation class BookVesselServlet
 */
@WebServlet("/BookVesselServlet")
public class BookVesselServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookVesselServlet() {
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String routename = request.getParameter("routeselection");
		try {
			DBConnection db = DBConnection.getInstance();
			String dedate = request.getParameter("dateselection");
			String ddate[] = dedate.split("#");
			Date departuredate = sdf.parse(ddate[0]);
			Date arrivaldate = sdf.parse(request.getParameter("arrival"));
			String customername = request.getParameter("customerselection");
			String shipname = request.getParameter("shipname");
			Double price = Double.parseDouble(request.getParameter("price"));
			String[] itemname = request.getParameterValues("checkedvalue");
			HttpSession session = request.getSession(false);
			if (itemname != null) {
				Schedule schedule = null;
				Customer customer = null;
				Date currentdate = new Date();
				List<Schedule> schedulelist = (List<Schedule>) session.getAttribute("newschedulelist");
				List<Customer> customerlist = (List<Customer>) session.getAttribute("customerlist");
				List<Item> itemlist = (List<Item>) session.getAttribute("customeritemlist");
				List<Item> ilist = (List<Item>) session.getAttribute("itemlist");
				Agent agent = (Agent) session.getAttribute("loginuser");
				for (int i = 0; i < schedulelist.size(); i++) {
					if (sdf.format(schedulelist.get(i).getSchedule_departuretime()).equals(sdf.format(departuredate))
							&& sdf.format(schedulelist.get(i).getSchedule_arrivaldatetime())
									.equals(sdf.format(arrivaldate))
							&& schedulelist.get(i).getRoute().getRoute_Name().equals(routename)
							&& schedulelist.get(i).getShip().getShip_Name().equals(shipname)) {
						schedule = schedulelist.get(i);
						break;
					}
				}
				for (int i = 0; i < customerlist.size(); i++) {
					if (customerlist.get(i).getCust_name().equals(customername)) {
						customer = customerlist.get(i);
						break;
					}
				}
				if (agent.getCredit() >= price) {
					String query2 = "SELECT SHIP_BAY FROM SHIP WHERE SHIP_ID = '" + schedule.getShip().getShip_ID()
							+ "'";
					ResultSet rs2 = db.RunQuery(query2);
					int totalsize = 0;
					if (rs2.next()) {
						totalsize = rs2.getInt("SHIP_BAY");
					}
					String query3 = "SELECT * FROM ITEM i WHERE i.BOOKING_ID IN (SELECT b.BOOKING_ID FROM BOOKING b WHERE b.SCHEDULE_ID = '"
							+ schedule.getSchedule_ID() + "')";
					ResultSet rs3 = db.RunQuery(query3);
					int count = 0;
					while (rs3.next()) {
						count++;
					}
					if (count + itemname.length <= totalsize) {
						String query = "SELECT * FROM BOOKING";
						ResultSet rs = db.RunQuery(query);
						int id = 0;
						while (rs.next()) {
							id = rs.getInt("BOOKING_ID");
						}
						agent.deductcredit(price);
						db.UpdateAgent(agent);
						Booking booking = new Booking(id + 1, currentdate, price, customer, agent, schedule);
						db.RunInsert(booking);
						for (int a = 0; a < itemname.length; a++) {
							for (int i = 0; i < itemlist.size(); i++) {
								if (itemlist.get(i).getItem_name().equals(itemname[a])) {
									Item item = itemlist.get(i);
									item.setBooking(booking);
									db.UpdateItem(item);
									itemlist.remove(item);
									ilist.remove(item);
									break;
								}
							}

						}
						session.setAttribute("customeritemlist", itemlist);
						request.setAttribute("message", "Booked vessel successfully!");
						request.getRequestDispatcher("RetrieveRoute").forward(request, response);
					} else {
						request.setAttribute("message", "The chosen ship is full. Please try another ship!");
						request.getRequestDispatcher("RetrieveRoute").forward(request, response);
					}
				} else {
					request.setAttribute("message", "Insufficient credit! Please try again.");
					request.getRequestDispatcher("RetrieveRoute").forward(request, response);
				}
			} else {
				request.setAttribute("message", "No item selected! Please try again.");
				request.getRequestDispatcher("RetrieveRoute").forward(request, response);
			}
		} catch (ParseException | ClassNotFoundException | SQLException e) {
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
