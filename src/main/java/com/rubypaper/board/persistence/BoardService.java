package com.rubypaper.board.persistence;

import java.util.List;

import com.rubypaper.board.domain.BoardVO;

public interface BoardService {
	
	   void insertBoard( BoardVO vo );
	   void update( BoardVO vo );
	   void delete( BoardVO vo );
	   BoardVO getBoard( BoardVO vo );
	   List<BoardVO> getBoardList( BoardVO vo );
	   
	   void cnt( BoardVO vo );
	   void writerDelete( BoardVO vo );
}
