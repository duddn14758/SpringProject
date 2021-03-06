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
 * CustomerDeleteData.java
 * @author "Baniota"
 */
@Repository
public class CustomerDeleteData implements ICustomerRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//index 위치의 고객정보를 삭제합니다.
	@Override
	public boolean run(Customer cust) {
		String sql = "delete from customer where name=?";
		jdbcTemplate.update(sql, cust.getName());
		return true;
	}
}
