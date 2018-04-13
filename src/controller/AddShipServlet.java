package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBConnection;
import model.Ship;

/**
 * Servlet implementation class AddShipServlet
 */
@WebServlet("/AddShipServlet")
public class AddShipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShipServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String shipname = request.getParameter("shipname");
		int noofbay = Integer.parseInt(request.getParameter("bayquantity"));
		Ship ship = new Ship(shipname,noofbay);
		try {
			DBConnection db = DBConnection.getInstance();
			db.RunInsert(ship);
			request.setAttribute("message", "Ship added successfully!");
			request.getRequestDispatcher("AddShip.jsp").forward(request, response);
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
