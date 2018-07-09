/************************************************************
 * 시스템 명 : 
 * 업무명 :
 * 프로그램명(ID) :
 * 프로그램 설명 :
 * 
 * 작성일 : 2018. 7. 8.
 * 작성자 : "Baniota"
 *
 * 수정자     수정일자     수정내역
 * ------    ----------    ---------------------------------
 * "Baniota"    2018. 7. 8.    최초 생성
 *
 ************************************************************/
package com.java.customer.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.java.customer.model.Customer;

/**
 * CustomerVIPData.java
 * @author "Baniota"
 */
@Repository
public class CustomerVIPRepository implements ICustomerVIPRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean insertData(Customer cust) {
		String sql = "insert into customer (name, gender, email, birthday) values (?,?,?,?)";
		jdbcTemplate.update(sql, 
				new Object[] { cust.getName(), String.valueOf(cust.getGender()), cust.getEmail(),
				String.valueOf(cust.getBirthYear()) });
		return true;
	}

	//@Override
	public boolean updateData(Customer cust) {
	String sql = "update customer set gender=?, email=?, birthyear=? where name=?";
		jdbcTemplate.update(sql, 
			new Object[] { String.valueOf(cust.getGender()), cust.getEmail(),
			String.valueOf(cust.getBirthYear()), cust.getName()});
		return true;
	}

	//@Override
	public boolean selectData(Customer cust) {
		Customer custPrint = new Customer();
		String sql = "select name, gender, email, birthyear "
				+ "from customer where name=?";		
		custPrint = jdbcTemplate.queryForObject(sql, new CustomerMapper(), cust.getName());
		
		System.out.println("==========CUSTOMER INFO================");
		System.out.println("이름 : " + custPrint.getName());
		System.out.println("성별 : " + custPrint.getGender());
		System.out.println("이메일 : " + custPrint.getEmail());
		System.out.println("출생년도 : " + custPrint.getBirthYear());
		System.out.println("=======================================");
		return true;
	}

	//@Override
	public boolean deleteData(Customer cust) {
		String sql = "delete from customer where name=?";
		jdbcTemplate.update(sql, cust.getName());
		return true;
	}

}