package com.java.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;

@Service
public interface BService {

	// 게시판 리스트
	ArrayList<BoardDto> blist();

	BoardDto bview(int bno);

}
