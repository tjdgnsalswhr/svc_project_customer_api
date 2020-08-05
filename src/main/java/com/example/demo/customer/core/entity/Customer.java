package com.example.demo.customer.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.customer.core.application.object.command.CustomerRequestDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j //로그 기록을 위한 Annotation
@ToString //tostirng method 자동 생성
@NoArgsConstructor //파라미터가 없는 생성자 생성
@Getter //접근자 자동 생성
@Setter //설정자 자동 생성
@Table(name="customers") //entity와 매핑할 테이블. 생략시 매핑한 엔티티 이름을 테이블 이름으로 사용.
@Entity //JPA를 사용해서 테이블과 매핑할 클래스. 이 Annotation이 붙으면 JPA가 관리하는 것

public class Customer {
	
	@Id 				//기본키 할당
	String cid; 		//회원 아이디
	String cpassword; 	//회원 비밀번호
	String cname; 		//가게 or 팀 이름
	String code; 		//접근 권한, 1이면 팀, 2면 가게
	
	@Builder
	public Customer(String cid, String cpassword, String cname, String code)
	{
		this.cid = cid;
		this.cpassword = cpassword;
		this.cname = cname;
		this.code = code;
	}
	
	public void update(CustomerRequestDTO customerRequestDTO)
	{
		this.cid = customerRequestDTO.getCid();
		this.cpassword = customerRequestDTO.getCpassword();
		this.cname = customerRequestDTO.getCname();
		this.code = customerRequestDTO.getCode();
		
	}

}
