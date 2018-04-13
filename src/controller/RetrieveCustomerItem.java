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
import model.Customer;
import model.DBConnection;
import model.Item;

/**
 * Servlet implementation class RetrieveCustomerItem
 */
@WebServlet("/RetrieveCustomerItem")
public class RetrieveCustomerItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetrieveCustomerItem() {
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
		List<Customer> customerlist = (List<Customer>) session.getAttribute("customerlist");
		List<Item> itemlist = new ArrayList<Item>();
		List<Item> customeritemlist = new ArrayList<Item>();
		List<Agent> agentlist = new ArrayList<Agent>();
		Item item;
		Customer customer = null;
		Agent agent = null;
		try {
			DBConnection db = DBConnection.getInstance();
			String query2 = "SELECT *FROM AGENT";
			String query = "SELECT * FROM ITEM ";
			ResultSet rs = db.RunQuery(query2);
			ResultSet rs2 = db.RunQuery(query);
			while (rs.next()) {
				agent = new Agent(rs.getInt("AGENT_ID"), rs.getString("AGENT_USERNAME"), rs.getString("AGENT_PASSWORD"),
						rs.getString("AGENT_NAME"), rs.getString("AGENT_GENDER"), rs.getString("AGENT_EMAILADDRESS"),
						rs.getString("AGENT_CONTACTNUMBER"), rs.getString("AGENT_COMPANYNAME"),
						rs.getString("AGENT_COMPANYADDRESS"), rs.getDouble("AGENT_CREDIT"));
				agentlist.add(agent);
			}
			while(rs2.next()){				
				if (rs2.getInt("BOOKING_ID") == 0) {
					for(int i =0; i<customerlist.size();i++) {
						if(rs2.getInt("CUST_ID") == customerlist.get(i).getCust_ID()) {
							customer = customerlist.get(i);
							break;
						}
					}
					for(int i =0; i<agentlist.size();i++) {
						if(rs2.getInt("AGENT_ID") == agentlist.get(i).getID()) {
							agent = agentlist.get(i);
							break;
						}
					}
					item = new Item(rs2.getInt("ITEM_ID"), rs2.getString("ITEM_NAME"), rs2.getString("ITEM_DESCRIPTION"),
							rs2.getInt("ITEM_QUANTITY"), customer, agent, null);
					itemlist.add(item);
				}
			}
			for(int i=0; i<itemlist.size(); i++) {
				if(itemlist.get(i).getCustomer().getCust_ID() == (customerlist.get(0).getCust_ID())) {					
					customeritemlist.add(itemlist.get(i));
				}
			}
			session.setAttribute("customeritemlist", customeritemlist);
			session.setAttribute("itemlist", itemlist);
			request.getRequestDispatcher("BookVessel.jsp").forward(request, response);
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
