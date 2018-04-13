package model;

import java.io.Serializable;

public class Route implements Serializable{
	private int Route_ID;
	private String Route_Name;
	private String departuredestination;
	private String arrivaldestination;
	
	public Route(int route_ID, String route_Name, String departuredestination, String arrivaldestination) {
		super();
		Route_ID = route_ID;
		Route_Name = route_Name;
		this.departuredestination = departuredestination;
		this.arrivaldestination = arrivaldestination;
	}

	public Route(String route_Name, String departuredestination, String arrivaldestination) {
		super();
		Route_Name = route_Name;
		this.departuredestination = departuredestination;
		this.arrivaldestination = arrivaldestination;
	}

	public int getRoute_ID() {
		return Route_ID;
	}

	public String getRoute_Name() {
		return Route_Name;
	}

	public void setRoute_Name(String route_Name) {
		Route_Name = route_Name;
	}

	public String getDeparturedestination() {
		return departuredestination;
	}

	public void setDeparturedestination(String departuredestination) {
		this.departuredestination = departuredestination;
	}

	public String getArrivaldestination() {
		return arrivaldestination;
	}

	public void setArrivaldestination(String arrivaldestination) {
		this.arrivaldestination = arrivaldestination;
	}
	
	
}
