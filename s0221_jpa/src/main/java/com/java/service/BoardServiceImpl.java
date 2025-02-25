package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;
import com.java.repository.BoardRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardRepository boardRepository;
	
	@Override
	public Page<BoardDto> findAll(Pageable pageable) {
//		// 다중정렬
//		Sort sort = Sort.by(
//				Sort.Order.desc("bgroup"),
//				Sort.Order.asc("bstep")
//				);
//		List<BoardDto> list = boardRepository.findAll(sort);
				
		// nativeQuery
		
		Page<BoardDto> list = boardRepository.findAll(pageable);
		return list;
	}

	@Override	// 게시글 보기
	public BoardDto findById(int bno) {
		BoardDto boardDto = boardRepository.findById(bno).orElseThrow(
				()->{	// 람다식 함수
					return new IllegalArgumentException("데이터 처리시 에러 !!");
				});
		boardDto.setBhit(boardDto.getBhit()+1);	// 게시글 조회수 1 증가
		// boardRepository.save(boardDto);
		// @Transactional 가 걸려있으면 save를 일일히 안해도된다.
		
		return boardDto;
	}

	@Override	// 게시글 검색
	public List<BoardDto> findByBtitleContaining(String search) {
		List<BoardDto> list = boardRepository.findByBtitleContaining(search);
		return null;
	}

}
