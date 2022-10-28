package com.rubypaper.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/system/login.do")
	public void login() {
		
	}
	
	@GetMapping("/system/accessDenied.do")
	public void accessDenied() {
		
	}
	
	@GetMapping("/system/logout.do")
	public void logout() {
		
	}
	
	@GetMapping("/admin/adminPage.do")
	public void admin() {
		
	}
	
	
}
