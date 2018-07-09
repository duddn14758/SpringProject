package com.java.customer.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.java.customer.model.Customer;

public class CustomerAuthData {
	@Autowired
	JdbcTemplate jdbcTemplate;
	ArrayList<String> nameList=new ArrayList<String>();
	public void CustomerAuthData(){
		String sql="select name from authentication where auth=1";
		String name;
		//jdbcTemplate.queryForList(sql, args, String)
		
	}
	

}
