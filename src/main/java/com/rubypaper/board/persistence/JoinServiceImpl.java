package com.rubypaper.board.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.board.domain.JoinVO;

@Service
public class JoinServiceImpl implements JoinService {

	@Autowired
	private JoinDao  dao;
	
	@Override
	public List<JoinVO> join1() {
		
		return dao.join1();
	}

	@Override
	public List<JoinVO> join2(JoinVO vo) {
		
		return dao.join2(vo);
	}

	@Override
	public JoinVO join3(JoinVO vo) {
		
		return dao.join3(vo);
	}

}
