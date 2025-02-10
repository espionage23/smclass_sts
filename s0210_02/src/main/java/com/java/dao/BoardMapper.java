package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	
	// 게시글 리스트
	ArrayList<BoardDto> selectAll();

	// 게시글 저장
	int insertBoard(BoardDto bdto);

	// 게시글 상세보기
	BoardDto selectOne(int bno);

	// 조회수 1 증가
	void updateBHit(int bno);

	// 게시글 삭제
	void deleteBoard(int bno);

}
