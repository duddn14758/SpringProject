/************************************************************
 * 시스템 명 : 
 * 업무명 :
 * 프로그램명(ID) :
 * 프로그램 설명 :
 * 
 * 작성일 : 2018. 7. 7.
 * 작성자 : "Baniota"
 *
 * 수정자     수정일자     수정내역
 * ------    ----------    ---------------------------------
 * "Baniota"    2018. 7. 7.    최초 생성
 *
 ************************************************************/
package com.java.customer.dao;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.java.customer.model.Customer;


/**
 * CustomerMapper.java
 * @author "Baniota"
 */
public class CustomerMapper implements RowMapper<Customer> {
	@Override
	public Customer mapRow(ResultSet rs, int count) throws SQLException {
		Customer cust = new Customer();
		cust.setName(rs.getString("name"));
		cust.setGender(rs.getString("gender").charAt(0));
		cust.setEmail(rs.getString("email"));
		cust.setBirthYear(rs.getInt("birthday"));
		return cust;
	}			
}