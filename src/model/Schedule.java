package model;

import java.io.Serializable;
import java.util.Date;

public class Schedule implements Serializable{
	private int Schedule_ID;
	private Date Schedule_departuretime;
	private Date Schedule_arrivaldatetime;	
	private Ship ship;
	private Route route;
	
	public Schedule(int schedule_ID, Date schedule_departuretime, Date schedule_arrivaldatetime, Ship ship, Route route) {
		super();
		Schedule_ID = schedule_ID;
		Schedule_departuretime = schedule_departuretime;
		Schedule_arrivaldatetime = schedule_arrivaldatetime;
		this.ship = ship;
		this.route = route;		
	}

	public Schedule(Date schedule_departuretime, Date schedule_arrivaldatetime, Ship ship, Route route) {
		super();
		this.Schedule_departuretime = schedule_departuretime;
		this.Schedule_arrivaldatetime = schedule_arrivaldatetime;
		this.ship = ship;
		this.route = route;
	}


	public int getSchedule_ID() {
		return Schedule_ID;
	}

	public Date getSchedule_departuretime() {
		return Schedule_departuretime;
	}

	public void setSchedule_departuretime(Date schedule_departuretime) {
		Schedule_departuretime = schedule_departuretime;
	}

	public Date getSchedule_arrivaldatetime() {
		return Schedule_arrivaldatetime;
	}

	public void setSchedule_arrivaldatetime(Date schedule_arrivaldatetime) {
		Schedule_arrivaldatetime = schedule_arrivaldatetime;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	
}
