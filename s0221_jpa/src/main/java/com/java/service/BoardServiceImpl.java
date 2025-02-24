package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardRepository boardRepository;
	
	@Override
	public List<BoardDto> findAll() {
//		// 다중정렬
//		Sort sort = Sort.by(
//				Sort.Order.desc("bgroup"),
//				Sort.Order.asc("bstep")
//				);
//		List<BoardDto> list = boardRepository.findAll(sort);
				
		// nativeQuery
		
		List<BoardDto> list = boardRepository.findAll();
		return list;
	}

	@Override
	public BoardDto findById(int bno) {
		BoardDto boardDto = boardRepository.findById(bno).orElseThrow(
				()->{	// 람다식 함수
					return new IllegalArgumentException("데이터 처리시 에러 !!");
				});
		return boardDto;
	}

}
