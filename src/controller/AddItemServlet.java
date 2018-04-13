package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
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
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String custname = request.getParameter("customerselection");
		String itemname = request.getParameter("itemname");
		String itemdes = request.getParameter("itemdescription");
		int quantity = Integer.parseInt(request.getParameter("itemquantity"));
		List customerlist =  (List) session.getAttribute("customerlist");
		Agent agent = (Agent) session.getAttribute("loginuser");
		Iterator iterator = customerlist.iterator();
		Customer cust = null;
		while(iterator.hasNext()) {
			cust = (Customer) iterator.next();
			if(cust.getCust_name().equalsIgnoreCase(custname)) {
				break;
			}
		}
		Item item = new Item(itemname, itemdes, quantity, cust, agent);
		try {
			DBConnection db = DBConnection.getInstance();
			db.RunInsert(item);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("message", "Item registered successfully!");
		request.getRequestDispatcher("AddItem.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
