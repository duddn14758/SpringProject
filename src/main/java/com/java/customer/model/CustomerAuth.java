package com.java.customer.model;

public class CustomerAuth extends Customer{
	int auth;
	
	public CustomerAuth(String name, char gender, String email, int birthYear,int authen) {
		super(name, gender, email, birthYear);
		// TODO Auto-generated constructor stub
		auth=authen;
	}	

}
