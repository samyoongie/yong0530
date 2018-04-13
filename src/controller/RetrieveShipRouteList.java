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

import model.DBConnection;
import model.Route;
import model.Ship;

/**
 * Servlet implementation class RetrieveShipRouteList
 */
@WebServlet("/RetrieveShipRouteList")
public class RetrieveShipRouteList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveShipRouteList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession(false);
			DBConnection db = DBConnection.getInstance();
			String query = "SELECT * FROM ROUTE";
			String query2 = "SELECT * FROM SHIP";
			ResultSet rs = db.RunQuery(query);
			ResultSet rs2 = db.RunQuery(query2);
			List <Route> routelist = new ArrayList<Route>();
			Route route = null;
			List <Ship> shiplist = new ArrayList<Ship>();
			Ship ship = null;
			while(rs.next()) {
				route = new Route(rs.getInt("ROUTE_ID"), rs.getString("ROUTE_NAME"), rs.getString("ROUTE_DEPARTUREDESTINATION"), rs.getString("ROUTE_ARRIVALDESTINATION"));
				routelist.add(route);
			}
			while(rs2.next()) {
				ship = new Ship(rs2.getInt("SHIP_ID"), rs2.getString("SHIP_NAME"), rs2.getInt("SHIP_BAY"));
				shiplist.add(ship);
			}
			session.setAttribute("routelist", routelist);
			session.setAttribute("shiplist", shiplist);
			request.getRequestDispatcher("AddSchedule.jsp").forward(request, response);
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
