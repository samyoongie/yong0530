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

/**
 * Servlet implementation class RetrieveCustomerList
 */
@WebServlet("/RetrieveCustomerList")
public class RetrieveCustomerList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetrieveCustomerList() {
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
		try {
			DBConnection db = DBConnection.getInstance();
			List<Customer> customerlist = new ArrayList<Customer>();
			Customer cust = null;
			String jsp = (String) session.getAttribute("jsp");
			String query = "SELECT * FROM CUSTOMER C LEFT OUTER JOIN AGENT A ON C.AGENT_ID = A.AGENT_ID";
			ResultSet rs2 = db.RunQuery(query);
			while (rs2.next()) {
				Agent custagent = new Agent(rs2.getInt("AGENT_id"), rs2.getString("AGENT_username"),
						rs2.getString("AGENT_password"), rs2.getString("AGENT_name"), rs2.getString("AGENT_gender"),
						rs2.getString("AGENT_emailaddress"), rs2.getString("AGENT_contactnumber"),
						rs2.getString("AGENT_companyname"), rs2.getString("AGENT_companyaddress"),
						rs2.getDouble("AGENT_credit"));
				cust = new Customer(rs2.getInt("CUST_ID"), rs2.getString("CUST_NAME"), rs2.getString("CUST_ICPASSPORT"),
						rs2.getString("CUST_GENDER"), rs2.getString("CUST_EMAILADDRESS"),
						rs2.getString("CUST_CONTACTNUMBER"), rs2.getString("CUST_ADDRESS"), custagent);
				customerlist.add(cust);
			}
			session.setAttribute("customerlist", customerlist);
			if (jsp.equals("login")) {
				session.setAttribute("jsp", "no");				
				request.getRequestDispatcher("RetrieveBookingList").forward(request, response);
			}else{
				request.getRequestDispatcher("AddItem.jsp").forward(request, response);
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
