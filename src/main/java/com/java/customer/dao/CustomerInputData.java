/************************************************************
 * 시스템 명 : 
 * 업무명 :
 * 프로그램명(ID) :
 * 프로그램 설명 :
 * 
 * 작성일 : 2018. 7. 5.
 * 작성자 : "Baniota"
 *
 * 수정자     수정일자     수정내역
 * ------    ----------    ---------------------------------
 * "Baniota"    2018. 7. 5.    최초 생성
 *
 ************************************************************/
package com.java.customer.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.customer.model.Customer;

/**
 * CustomerInputData.java
 * @author "Baniota"
 */
@Repository
public class CustomerInputData implements ICustomerRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean run(Customer cust) {
		String sql = "insert into info (name, gender, email, birthday) values (?,?,?,?)";
		jdbcTemplate.update(sql, 
				new Object[] { cust.getName(), String.valueOf(cust.getGender()), cust.getEmail(),
				String.valueOf(cust.getBirthYear()) });
		return true;
	}
}