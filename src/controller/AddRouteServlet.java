package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBConnection;
import model.Route;

/**
 * Servlet implementation class AddRouteServlet
 */
@WebServlet("/AddRouteServlet")
public class AddRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRouteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String departure = request.getParameter("departure");
		String arrival = request.getParameter("arrival");
		String name = departure + " to " + arrival;
		
		try {
			DBConnection db = DBConnection.getInstance();
			String query = "SELECT * FROM ROUTE WHERE ROUTE_DEPARTUREDESTINATION = '" + departure + "' AND ROUTE_ARRIVALDESTINATION = '" + arrival + "'";
			ResultSet rs = db.RunQuery(query);
			if(rs.next()) {
				request.setAttribute("message", "Route has been added. Please try again");
				request.getRequestDispatcher("AddRoute.jsp").forward(request, response);
			}
			else {
				Route route = new Route(name, departure, arrival);
				db.RunInsert(route);
				request.setAttribute("message", "Route added successfully!");
				request.getRequestDispatcher("AddRoute.jsp").forward(request, response);
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
