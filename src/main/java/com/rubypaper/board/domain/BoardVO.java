package com.rubypaper.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private  int  seq;
	private  String  title;
	private  String  writer;
	private  String  content;
	private  Date  createDate ;
	private  int  cnt;	
	
}
