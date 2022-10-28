package com.rubypaper.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.board.domain.BoardVO;
import com.rubypaper.board.domain.JoinVO;
import com.rubypaper.board.domain.MemberVO;
import com.rubypaper.board.persistence.BoardServiceImpl;
import com.rubypaper.board.persistence.MemberServiceImpl;

@Controller
@RequestMapping("/board/")
public class MemberController {

	@Autowired
	MemberServiceImpl  memberService;
	
	@Autowired
	BoardServiceImpl  boardService;
	
	
	@RequestMapping("/getMemberList.do")
	public String getBoardList(Model model ){		
		model.addAttribute("li", memberService.getMemberList(null));		
		return "board/getMemberList";		
	}
	
	@RequestMapping("/delete.do")
	public String delete(Model model, BoardVO  vo1, MemberVO vo2 ){		

		memberService.delete(vo2);
		
		boardService.writerDelete(vo1);
		
		return "redirect:getMemberList.do";		
	}
	
	
}
