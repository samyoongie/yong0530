package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String name = request.getParameter("name");
        String icpassport = request.getParameter("icpassport");
        String gender = request.getParameter("gender");
        String emailaddress = request.getParameter("emailaddress");
        String contactnumber = request.getParameter("contact");
        String address = request.getParameter("address");
        HttpSession session = request.getSession(false);
        Agent agent = (Agent) session.getAttribute("loginuser");
        try {
			DBConnection db = DBConnection.getInstance();
			String sql = "SELECT * FROM CUSTOMER WHERE CUST_NAME = '" + name + "'";
			ResultSet rs = db.RunQuery(sql);
			if(rs.next()) {
				request.setAttribute("message", "Name has been registered! Please try again!");
				request.getRequestDispatcher("AddCustomer.jsp").forward(request, response);
			}
			else {
				Customer c = new Customer(name, icpassport, gender, emailaddress, contactnumber, address, agent);
				db.RunInsert(c);
				request.setAttribute("message", "Customer registered successfully!");
				request.getRequestDispatcher("AddCustomer.jsp").forward(request, response);
			}
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
