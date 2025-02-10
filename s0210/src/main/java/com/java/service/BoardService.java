package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {
	
	//게시판
	ArrayList<BoardDto> blist();

	// 글쓰기
	void boardwrite(BoardDto bdto);

}
