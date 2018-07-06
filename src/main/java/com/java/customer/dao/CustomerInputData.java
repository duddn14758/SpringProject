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

import com.java.customer.model.Customer;

/**
 * CustomerInputData.java
 * 
 * @author "Baniota"
 */
public class CustomerInputData {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Customer insertCustomerData(Scanner scan) {
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("성별(M/F) : ");
		char gender = scan.next().charAt(0);
		System.out.print("이메일 : ");
		String email = scan.next();
		System.out.print("출생년도 : ");
		int birthYear = scan.nextInt();

		// 입력받은 데이터로 고객 객체를 생성
		Customer cust = new Customer(name, gender, email, birthYear);

		//String sql = "insert into info (name,gender,email,birthday) values(?,?,?,?)";
		//jdbcTemplate.update(sql, cust.getName().toString(), cust.getGender(), cust.getEmail().toString(), cust.getBirthYear());
		String sql="insert into info values('"+name+"','"+gender+"','"+email+"','"+birthYear+"')";
		jdbcTemplate.update(sql);		
		
		return cust;
	}
}
