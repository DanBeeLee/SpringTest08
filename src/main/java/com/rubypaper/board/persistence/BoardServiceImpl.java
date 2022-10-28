package com.rubypaper.board.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao  dao;
	
	@Override
	public void insertBoard(BoardVO vo) {
		dao.insertBoard(vo);
		
	}

	@Override
	public void update(BoardVO vo) {
		dao.updateBoard(vo);
		
	}

	@Override
	public void delete(BoardVO vo) {
		dao.delete(vo);
		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		
		return dao.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		return dao.getBoardList(vo);
	}

	@Override
	public void cnt(BoardVO vo) {
		dao.cnt(vo);
		
	}

	@Override
	public void writerDelete(BoardVO vo) {
		dao.writerDelete(vo);
		
	}

}
