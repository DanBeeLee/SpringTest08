package com.rubypaper.board.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.board.domain.BoardVO;
import com.rubypaper.board.domain.JoinVO;
import com.rubypaper.board.persistence.BoardServiceImpl;
import com.rubypaper.board.persistence.JoinServiceImpl;

@RequestMapping("/board/")
@Controller
public class BoardController {

	@Autowired
	BoardServiceImpl  boardService;
	
	
	@Autowired
	JoinServiceImpl  joinService;
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(Model model, @ModelAttribute("join") JoinVO  vo){		
		
		// 세션 생성하기
		model.addAttribute("join", joinService.join1());
		model.addAttribute("li", joinService.join1());		
		return "board/getBoardList";		
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(Model model,@ModelAttribute("join")  JoinVO  vo){
		JoinVO m=joinService.join3(vo);
		System.out.println(m.toString());
		model.addAttribute("m", joinService.join3(vo));
		
		return "board/getBoard";
		
	}
	
		
	@RequestMapping("/insertBoard.do")
	public String insertBoard(Model model, @ModelAttribute("join") BoardVO  vo){
		vo.setCreateDate(new Date());
		vo.setCnt(3);
		boardService.insertBoard(vo)	;
		return "redirect:getBoardList.do";		
	}
		
	@RequestMapping("/insertBoard")
	public String insertBoardForm(Model model,@ModelAttribute("join") BoardVO  vo){
		
		return "board/insertBoard";		
	}
		
}
