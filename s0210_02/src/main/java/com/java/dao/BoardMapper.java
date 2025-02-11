package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	
	// 게시글 리스트
	ArrayList<BoardDto> selectAll(int startrow, int endrow);

	// 게시글 저장
	int insertBoard(BoardDto bdto);

	// 게시글 상세보기
	BoardDto selectOne(int bno);

	// 이전 게시글 정보
	BoardDto selectOnePrev(int bno);
	// 다음 게시글 정보
	BoardDto selectOneNext(int bno);

	// 조회수 1 증가
	void updateBHit(int bno);

	// 게시글 삭제
	void deleteBoard(int bno);

	// 게시글 수정 저장
	void updateBoard(BoardDto bdto);

	// 답변 저장
	void InsertBreply(BoardDto bdto);
	// 자식 게시글 bstep1 증가
	void bstepUp(BoardDto bdto);

	// 게시글 총 개수
	int countAll();



}
