package model;

import java.io.Serializable;

public class Customer implements Serializable {
	private int cust_ID;
	private String cust_name;
	private String cust_icpassport;	
	private String cust_gender;
	private String cust_emailaddress;
	private String cust_contactnumber;
	private String cust_address;
	private Agent Agent;
	
	
	public Customer(int cust_ID, String cust_name, String cust_icpassport, String cust_gender, String cust_emailaddress,
			String cust_contactnumber, String cust_address, model.Agent agent) {
		super();
		this.cust_ID = cust_ID;
		this.cust_name = cust_name;
		this.cust_icpassport = cust_icpassport;
		this.cust_gender = cust_gender;
		this.cust_emailaddress = cust_emailaddress;
		this.cust_contactnumber = cust_contactnumber;
		this.cust_address = cust_address;
		Agent = agent;
	}
	
	public Customer(String cust_name, String cust_icpassport, String cust_gender, String cust_emailaddress,
			String cust_contactnumber, String cust_address, model.Agent agent) {
		super();
		this.cust_name = cust_name;
		this.cust_icpassport = cust_icpassport;
		this.cust_gender = cust_gender;
		this.cust_emailaddress = cust_emailaddress;
		this.cust_contactnumber = cust_contactnumber;
		this.cust_address = cust_address;
		Agent = agent;
	}

	public int getCust_ID() {
		return cust_ID;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_icpassport() {
		return cust_icpassport;
	}
	public void setCust_icpassport(String cust_icpassport) {
		this.cust_icpassport = cust_icpassport;
	}
	public String getCust_gender() {
		return cust_gender;
	}
	public void setCust_gender(String cust_gender) {
		this.cust_gender = cust_gender;
	}
	public String getCust_emailaddress() {
		return cust_emailaddress;
	}
	public void setCust_emailaddress(String cust_emailaddress) {
		this.cust_emailaddress = cust_emailaddress;
	}
	public String getCust_contactnumber() {
		return cust_contactnumber;
	}
	public void setCust_contactnumber(String cust_contactnumber) {
		this.cust_contactnumber = cust_contactnumber;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public Agent getAgent() {
		return Agent;
	}
	public void setAgent(Agent agent) {
		Agent = agent;
	}
	

	


	
}
