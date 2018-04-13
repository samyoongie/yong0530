package model;

import java.io.Serializable;

public class Item implements Serializable{
	private int item_id;
	private String item_name;
	private String item_description;
	private int item_quantity;
	private Customer customer;
	private Agent agent;
	private Booking booking;
	
	public Item(int item_id, String item_name, String item_description, int item_quantity, Customer customer, Agent agent, Booking booking) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_description = item_description;
		this.item_quantity = item_quantity;
		this.customer = customer;
		this.agent = agent;
		this.booking = booking;
	}
	
	public Item(String item_name, String item_description, int item_quantity, Customer customer, Agent agent) {
		super();
		this.item_name = item_name;
		this.item_description = item_description;
		this.item_quantity = item_quantity;
		this.customer = customer;
		this.agent = agent;
	}

	public int getItem_id() {
		return item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_description() {
		return item_description;
	}
	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
	public int getItem_quantity() {
		return item_quantity;
	}
	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
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

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	
	
}
