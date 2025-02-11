package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.BoardDto;

public interface BoardService {

	// 게시글 전체리스트
	Map<String, Object> blist(int page);

	// 게시글 저장
	void bwrite(BoardDto bdto);
	
	// 게시글 상세보기
	Map<String , Object> bview(int bno);

	// 게시글 삭제
	void bdelete(int bno);

	// 게시글 수정
	BoardDto bupdate(int bno);

	// 게시글 수정 저장
	void bupdate(BoardDto bdto);

	// 답변 달기
	BoardDto breply(int bno);

	// 답변 저장
	void breply(BoardDto bdto);

}
