package com.rubypaper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import com.rubypaper.board.domain.MemberVO;
import com.rubypaper.board.domain.Role;

import com.rubypaper.board.persistence.MemberServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberTest {

	@Autowired
	private MemberServiceImpl  service;
	
	@Autowired
	private  PasswordEncoder  encoder;
	
	//@Before
	public  void  insert1() {
		MemberVO	vo = new MemberVO();
		vo.setId("admin");
		vo.setName("도우너");
		vo.setPassword("admin123");
		vo.setRole(Role.ROLE_ADMIN);
		vo.setEnabled("TRUE");
		service.insert(vo);
	}
	
	// @Before
	public  void  insert2() {
		MemberVO	vo = new MemberVO();
		vo.setId("member");
		vo.setName("둘리");
		vo.setPassword("member123");
		vo.setRole(Role.ROLE_MEMBER);
		vo.setEnabled("TRUE");
		service.insert(vo);
	}
	
	//@Before
	public  void  insert3() {
		MemberVO	vo = new MemberVO();
		vo.setId("ppk");
		vo.setName("너구리");
		vo.setPassword("ppk123");
		vo.setRole(Role.ROLE_MEMBER);
		vo.setEnabled("TRUE");
		service.insert(vo);
	}
	
	@Before
	public  void  update() {
		MemberVO	vo = new MemberVO();
		vo.setId("ppk");		
		vo.setPassword(encoder.encode("ppk123"));
		service.updatePassword(vo);		
	}
	
	
	@Test
	public  void  select() {
		
		List<MemberVO> li=service.getMemberList(null);
		
		for(MemberVO m :li) {
		  System.out.println("==>" + m.toString());
		}
	}

	
}
