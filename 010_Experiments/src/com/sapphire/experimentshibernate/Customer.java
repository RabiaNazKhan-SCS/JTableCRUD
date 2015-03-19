package com.sapphire.experimentshibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
	
	@Entity
	@Table(name="customer")
	public class Customer {
		
	@Id
	@GeneratedValue
	@Column(name="cust_id")
	private int customerId;
	
	@Column(name="cust_name")
	private String customerName;
	
	@Column(name="cust_email")
	private String customerEmail;
	
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


}
