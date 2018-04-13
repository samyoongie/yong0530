package model;

import java.io.Serializable;

public class Agent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String name;
	private String gender;
	private String emailaddress;
	private String contactnumber;
	private String companyname;
	private String companyaddress;
	private double credit;
	
	public Agent(String username, String password, String name, String gender, String emailaddress, String contactnumber,
			String companyname, String companyaddress, double credit) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.emailaddress = emailaddress;
		this.contactnumber = contactnumber;
		this.companyname = companyname;
		this.companyaddress = companyaddress;
		this.credit = credit;
	}
	
	public Agent(int id,String username, String password, String name, String gender, String emailaddress, String contactnumber,
			String companyname, String companyaddress, double credit) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.emailaddress = emailaddress;
		this.contactnumber = contactnumber;
		this.companyname = companyname;
		this.companyaddress = companyaddress;
		this.credit = credit;
	}
	
	public int getID() {
		return id;
	}
	
	public void updateProfile(String password, String emailaddress, String contactnumber, String companyname, String companyaddress) {
		this.setPassword(password);
		this.setEmailaddress(emailaddress);
		this.setContactnumber(contactnumber);
		this.setCompanyname(companyname);
		this.setCompanyaddress(companyaddress);
	}
	
	public void topupcredit(double topupcredit) {
		credit = credit + topupcredit;
	}
	
	public void deductcredit(double deductcredit) {
		credit = credit - deductcredit;
	}
	
	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	
	
}
