package com.rubypaper.board.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.board.domain.MemberVO;

@Service
public class MemberServiceImpl 
                 implements MemberService {

	@Autowired
	private MemberDao  dao;
	
	@Override
	public void insert(MemberVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public List<MemberVO> getMemberList(MemberVO vo) {
		
		return dao.getMemberList(vo);
	}

	@Override
	public void delete(MemberVO vo) {
		dao.delete(vo);
		
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.getMember(vo);
	}

	@Override
	public void updatePassword(MemberVO vo) {
          dao.updatePassword(vo);		
	}

}
