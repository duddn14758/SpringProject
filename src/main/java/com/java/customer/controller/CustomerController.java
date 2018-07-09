package com.java.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;


import com.java.customer.service.ICustomerService;

public class CustomerController {
	ICustomerService custService;

	public void setCustomerService(ICustomerService custService) {
		this.custService = custService;
	}
	
	//@Inject
	//@Resource(name = "niceService")
	//@Autowired
	//@Qualifier("helloService")
	public void run(String name) {
		System.out.println("HelloController : " + custService.run(name));
	}
}