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

import com.java.customer.model.Customer;

/**
 * ICustomerVIPRepository.java
 * @author "Baniota"
 */
public interface ICustomerVIPRepository {
	public interface ICustomerRepository {
		boolean insertData (Customer cust);
		boolean updateData (Customer cust);
		boolean selectData (Customer cust);
		boolean deleteData (Customer cust);
	}
}
