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
package com.java.customer;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * JDBCEn.java
 * @author "Baniota"
 */
public class JDBCEncryptor {
	/**
	 * Enter the description of main.
	 *
	 * @param args
	 * @author "Baniota" 
	 * @see
	 */
	public static void main(String[] args) {
		StandardPBEStringEncryptor enc = new StandardPBEStringEncryptor();
		enc.setPassword("qwer1324");
		System.out.println(enc.encrypt("oracle.jdbc.driver.OracleDriver"));
		System.out.println(enc.encrypt("jdbc:oracle:thin:@localhost:1521:xe"));
		System.out.println(enc.encrypt("hr"));
		System.out.println(enc.encrypt("hr"));
	}
}