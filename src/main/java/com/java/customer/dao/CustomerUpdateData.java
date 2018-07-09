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

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.customer.model.Customer;

/**
 * CustomerUpdateData.java
 * @author "Baniota"
 */
@Repository
public class CustomerUpdateData implements ICustomerRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//index 위치의 고객 정보를 수정합니다.
	@Override
	public boolean run(Customer cust) {
		Customer custUpdate = new Customer();
		String sql = "select name, gender, email, birthday "
				+ "from customer where name=?";		
		custUpdate = jdbcTemplate.queryForObject(sql, new CustomerMapper(), cust.getName());	
		
		if(custUpdate.equals(null)) {
			System.out.println(cust.getName()+"은(는) 존재하지 않는 이름입니다.");
		}
		
	String sqlupdate = "update customer set gender=?, email=?, birthday=? where name=?";
		jdbcTemplate.update(sqlupdate, 
			new Object[] { String.valueOf(cust.getGender()), cust.getEmail(),
			String.valueOf(cust.getBirthYear()), cust.getName()});
		return true;
	}
}
