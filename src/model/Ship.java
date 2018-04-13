package model;

import java.io.Serializable;

public class Ship implements Serializable{
	private int Ship_ID;
	private String Ship_Name;
	private int Ship_Bay;
	
	public Ship(int ship_ID, String ship_Name, int ship_Bay) {
		super();
		Ship_ID = ship_ID;
		Ship_Name = ship_Name;
		Ship_Bay = ship_Bay;
	}

	public Ship(String ship_Name, int ship_Bay) {
		super();
		Ship_Name = ship_Name;
		Ship_Bay = ship_Bay;
	}

	public int getShip_ID() {
		return Ship_ID;
	}


	public String getShip_Name() {
		return Ship_Name;
	}

	public void setShip_Name(String ship_Name) {
		Ship_Name = ship_Name;
	}

	public int getShip_Bay() {
		return Ship_Bay;
	}

	public void setShip_Bay(int ship_Bay) {
		Ship_Bay = ship_Bay;
	}
	
	
}
