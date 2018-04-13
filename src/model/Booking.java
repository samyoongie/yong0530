package model;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable{
	private int Booking_ID;
	private Date Booking_Date;
	private Double Booking_Price;
	private Customer customer;
	private Agent agent;
	private Schedule schedule;
	
	public Booking(int booking_ID, Date booking_Date, Double booking_Price, Customer customer, Agent agent, Schedule schedule) {
		super();
		Booking_ID = booking_ID;
		Booking_Date = booking_Date;
		Booking_Price = booking_Price;
		this.customer = customer;
		this.agent = agent;
		this.schedule = schedule;
	}
	
	public Booking(Date booking_Date, Double booking_Price, Customer customer, Agent agent, Schedule schedule) {
		super();
		Booking_Date = booking_Date;
		Booking_Price = booking_Price;
		this.customer = customer;
		this.agent = agent;
		this.schedule = schedule;
	}
	public int getBooking_ID() {
		return Booking_ID;
	}
	public Date getBooking_Date() {
		return Booking_Date;
	}
	public void setBooking_Date(Date booking_Date) {
		Booking_Date = booking_Date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Double getBooking_Price() {
		return Booking_Price;
	}

	public void setBooking_Price(Double booking_Price) {
		Booking_Price = booking_Price;
	}
	
	
}
