package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;

/**
 * Servlet implementation class RetrieveItemAgain
 */
@WebServlet("/RetrieveItemAgain")
public class RetrieveItemAgain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveItemAgain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customername = request.getParameter("customerselection");
		String routename = request.getParameter("routeselection");
		String departuretime = request.getParameter("dateselection");
		List <Item> customeritemlist = new ArrayList<Item>();
		HttpSession session = request.getSession(false);
		List <Item> itemlist = (List<Item>) session.getAttribute("itemlist");
		for(int i=0; i<itemlist.size(); i++) {
			if(itemlist.get(i).getCustomer().getCust_name().equals(customername)) {				
				customeritemlist.add(itemlist.get(i));
			}
		}
		request.setAttribute("selecteddate", departuretime);
		request.setAttribute("selectedroute", routename);
		request.setAttribute("selectedcustomer", customername);
		session.setAttribute("customeritemlist", customeritemlist);
		request.getRequestDispatcher("BookVessel.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
