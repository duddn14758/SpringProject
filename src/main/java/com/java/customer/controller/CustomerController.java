package com.java.customer.controller;


import com.java.customer.service.ICustomerService;

public class CustomerController {
//	ICustomerService custService = new CustomerService();
	ICustomerService custService;
	
//	public CustomerController(ICustomerService custService) {
//		this.custService = custService;
//	}
	
	public void setCustomerService(ICustomerService custService) {
		this.custService = custService;
	}
	
	public void run(String name) {
		System.out.println("HelloController : " + custService.run(name));
	}
}