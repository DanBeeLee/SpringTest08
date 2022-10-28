package com.rubypaper.board.persistence;

import java.util.List;

import com.rubypaper.board.domain.MemberVO;


public interface MemberService {
	   void insert(MemberVO vo);
	   List<MemberVO> getMemberList(MemberVO vo);
	   void delete(MemberVO vo) ;
	   
	   MemberVO getMember(MemberVO vo);
	   
	   void updatePassword(MemberVO vo);
}
