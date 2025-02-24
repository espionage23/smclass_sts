package com.java.service;

import java.util.List;

import com.java.dto.BoardDto;

public interface BoardService {
	
	// 전체리스트
	List<BoardDto> findAll();

	// 뷰 페이지
	BoardDto findById(int bno);

}
