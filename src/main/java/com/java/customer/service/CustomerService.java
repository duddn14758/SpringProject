package com.java.customer.service;

import java.util.Scanner;


import com.java.customer.dao.ICustomerRepository;
import com.java.customer.model.Customer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

	@Override
	public String run(String name) {
		//기본 입력장치로부터 데이터를 입력받기 위해 Scanner객체 생성
		Scanner scan = new Scanner(System.in);

		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");
		ICustomerRepository custRepository;
		Customer cust = new Customer();

		while(true) {
			//System.out.printf("\n[INFO] 고객 수 : %d, 인덱스 : %d\n");
			System.out.println("메뉴를 입력하세요.");
			System.out.println("(I)nsert, (P)rint, " +
					"(U)pdate, (D)elete, (Q)uit");
			System.out.print("메뉴 입력: ");
			String menu = scan.next();
			menu = menu.toLowerCase();	//입력한 문자열을 모두소문자로 변환
			switch(menu.charAt(0)) {
			case 'i':
				custRepository = (ICustomerRepository) context.getBean("custInput");
				System.out.println("고객정보 입력을 시작합니다.");
				System.out.print("이름 : ");	
				cust.setName(scan.next());
				System.out.print("성별(M/F) : ");	
				cust.setGender(scan.next().charAt(0));
				System.out.print("이메일 : ");	
				cust.setEmail(scan.next());
				System.out.print("출생년도 : ");	
				cust.setBirthYear(scan.nextInt());

				//입력받은 데이터로 고객 객체를 생성
				custRepository.run(cust);
				System.out.println("고객정보를 입력했습니다.");
				break;
			case 'p' :
				System.out.println("고객 데이터를 출력합니다.");
				custRepository = (ICustomerRepository) context.getBean("custPrint");
				System.out.println("출력할 고객 이름을 입력하십시요.");
				System.out.print("이름 : ");
				cust.setName(scan.next());
				custRepository.run(cust);
				break;
			case 'u' :
				System.out.println("데이터를 수정합니다.");
				custRepository = (ICustomerRepository) context.getBean("custUpdate");
				System.out.println("수정할 고객 이름을 입력하십시요.");
				System.out.print("이름 : ");
				cust.setName(scan.next());
				custRepository.run(cust);
				break;
			case 'd' :
				System.out.println("데이터를 삭제합니다.");
				custRepository = (ICustomerRepository) context.getBean("custDelete");
				System.out.println("삭제할 고객 이름을 입력하십시요.");
				System.out.print("이름 : ");
				cust.setName(scan.next());
				custRepository.run(cust);
				break;
			case 'q' :
				System.out.println("프로그램을 종료합니다.");
				context.close();
				scan.close();	//Scanner 객체를 닫아준다.
				System.exit(0);	//프로그램을 종료시킨다.
				break;	
			default : 
				System.out.println("메뉴를 잘 못 입력했습니다.");	
			}//end switch
		}//end while
	}
}