package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
//import org.springframework.stereotype.Repository;

import com.java.dto.BoardDto;

//@Repository - //Dao 원래 사용할때

@Mapper
public interface BMapper {

	// 게시판리스트
	ArrayList<BoardDto> blist();
	
	
	
}
