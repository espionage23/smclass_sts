package com.java.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	
	@GetMapping("/board/blist")	//게시글 전체리스트
	public String blist(
			@RequestParam(value="page", defaultValue = "1") int page,
			Model model) {
		Map<String, Object> map = boardService.blist(page);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("page", map.get("page"));
		model.addAttribute("startpage", map.get("startpage"));
		model.addAttribute("endpage", map.get("endpage"));
		model.addAttribute("maxpage", map.get("maxpage"));
		return "blist";
	}
	
	@GetMapping("/board/bwrite")	// 글쓰기 페이지
	public String bwrite() {
		return "bwrite";
	}


	@PostMapping("/board/bwrite")	// 글쓰기 저장
	public String bwrite(BoardDto bdto) {
		System.out.println("제목 : "+ bdto.getBtitle());
		boardService.bwrite(bdto);
		return "redirect:/board/blist";
	}
	
	@GetMapping("/board/bview")	// 글 상세보기 페이지
	public String bview(@RequestParam(defaultValue = "1") int bno, Model model) {
		// 1개 게시글 가져오기
		Map<String , Object> map = boardService.bview(bno);
		model.addAttribute("bdto",map.get("boardDto"));
		model.addAttribute("pdto",map.get("prevDto"));
		model.addAttribute("ndto",map.get("nextDto"));
		return "bview";
	}

	@GetMapping("/board/bdelete")	// 글 상세보기 페이지
	public String bdelete(int bno, Model model) {
		System.out.println("BoardController bdelete : " + bno);
		boardService.bdelete(bno);
		return "redirect:/board/blist";
	}
	

	@GetMapping("/board/bupdate")	// 게시글 수정페이지
	public String bupdate(int bno, Model model) {
		System.out.println("BoardController bupdate-bno: " + bno);
		BoardDto boardDto = boardService.bupdate(bno);
		model.addAttribute("bdto",boardDto);
		return "bupdate";
	}

	@PostMapping("/board/bupdate")	// 게시글 수정 저장
	public String bupdate(BoardDto bdto) {
		System.out.println("BoardController bupdate-bno: " + bdto.getBno());
		boardService.bupdate(bdto);
		return "redirect:/board/blist";
	}
	
	
	@GetMapping("/board/breply")	// 답변
	public String breply(int bno, Model model) {
		System.out.println("BoardController breply-bno: " + bno);
		BoardDto boardDto = boardService.breply(bno);
		model.addAttribute("bdto",boardDto);
		return "breply";
	}
	

	@PostMapping("/board/breply")	// 답변
	public String breply(BoardDto bdto) {
		System.out.println("BoardController breply-bno: " + bdto.getBno());
		boardService.breply(bdto);
		return "redirect:/board/blist";
	}
	
	
	
	
	
	
	
	
}//controller
