package com.rubypaper.board.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rubypaper.board.domain.MemberVO;

@SessionAttributes("member")
public class SecurityUser extends User{

	private static final long serialVersionUID = 1L;
    //private MemberVO member;
	
	public SecurityUser(MemberVO member) {
		super(member.getId(),member.getPassword(),
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		
		// 데이터베이스 리턴값
		System.out.println("==> SecurityUser 확인:" + member.getId()+ ":"+ member.getPassword());
		//this.member = member;
	}
    
	/*
	public MemberVO getMember() {
		return member;
		
	}
	*/
}
