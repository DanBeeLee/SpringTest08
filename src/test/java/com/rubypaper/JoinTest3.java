package com.rubypaper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.rubypaper.board.domain.JoinVO;
import com.rubypaper.board.persistence.JoinServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JoinTest3 {

	@Autowired
	private  JoinServiceImpl service;
		
	
	// @Test
	public  void  select1() {
		
		List<JoinVO> li=service.join1();
		
		for(JoinVO m :li) {
		  System.out.println("==>" + m.toString());
		}
	}
	
	// @Test
	public  void  select2() {
		JoinVO vo = new JoinVO();
		vo.setId("member");
		List<JoinVO> li=service.join2(vo);
		
		for(JoinVO m :li) {
		  System.out.println("==>" + m.toString());
		}
	}

	
	@Test
	public  void  select3() {
		JoinVO vo = new JoinVO();
		vo.setSeq(1015);
		JoinVO m=service.join3(vo);		
     	System.out.println("==>" + m.toString());
	}

	
}
