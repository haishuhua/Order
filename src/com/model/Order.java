package com.model;

public class Order {
	private String orderid;
	private String orderName;
	private String companyName;
	private String email;
	private String issueDate;
	private String gcid;
	private String denomination;
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;		
	}
	public void setGcid(String gcid) {
		this.gcid = gcid;		
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;	
		
	}
	
}
