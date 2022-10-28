package com.rubypaper.board.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rubypaper.board.persistence.MemberDao;
import com.rubypaper.board.domain.MemberVO;

@SessionAttributes("member")
@Service
public class BoardUserDetailsService implements UserDetailsService{

	BoardUserDetailsService(){
		System.out.println("==> BoardUserDetailsService");
	}
	@Autowired
    private MemberDao dao;
	
	@Autowired
	private Model model;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("==> UserDetails loadUserByUsername");

		// login 폼에서 넘어온 값
		MemberVO member = new MemberVO();
		member.setId(username);
	
		MemberVO user = dao.getMember(member);
		model.addAttribute("member",user);
		
		if(user == null) {
			throw new UsernameNotFoundException(username + "사용자없음");
		}else {
			return new SecurityUser(user);
		}
		
	
	}

}
