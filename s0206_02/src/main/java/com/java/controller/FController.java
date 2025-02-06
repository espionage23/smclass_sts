package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemDto;
import com.java.dto.StuDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller

public class FController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/StuInput")
	public String StuInput() {
		return "StuInput";
	}
	
	@PostMapping("/StuInput")
	public String StuInput(HttpServletRequest request,
			int stuno,
			String name,
			int kor,
			int eng,
			int math,
			Model model) {
		
		int total = kor+eng+math;
		double avg = total/3.0;
		
		StuDto s = StuDto.builder().stuno(stuno).name(name).kor(kor).eng(eng).math(math).total(total).avg(avg).build();
		model.addAttribute("stu",s);
		
		return "doStuInput";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@PostMapping("/login")
	public String login(HttpServletRequest request,
			@RequestParam("id") String id, 					// form name="id" 데이터 입력받음
			@RequestParam(required = false) String pw, 		// null값 허용
			String name,									// @RequestParam 생략가능, form 이름과 같아야함.
			@RequestParam int kor,							// 값이 없으면 에러
			@RequestParam(defaultValue = "0") int eng, 		// 값이 없으면 0으로 세팅
			int math,										// 값이 없으면 에러
			Model model) {
		
		int total = kor+eng+math;
		double avg = total/3.0;
		
//		String aid = request.getParameter("id");
//		String apw = request.getParameter("pw");
//		String akor = request.getParameter("kor");
//		String aeng = request.getParameter("eng");
//		String amath = request.getParameter("math");
//		
//		int ikor = Integer.parseInt(akor);
//		int ieng = Integer.parseInt(aeng);
//		int imath = Integer.parseInt(amath);
//		int total = ikor+ieng+imath;
//		double avg = total/3.0;
		
		
		
		System.out.println("데이터 : "+id+","+pw);
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("kor",kor);
		model.addAttribute("eng",eng);
		model.addAttribute("math",math);
		model.addAttribute("total",total);
		model.addAttribute("avg",avg);
		model.addAttribute("mem",MemDto.builder().id(id).pw(pw).build());
		
		MemDto m = new MemDto();
		//MemDto m2 = new MemDto(id, pw);
		//MemDto m3 = MemDto.builder().id("bbb").pw("1111").build();
		
		
		return "dologin";
	}
	
	@GetMapping("/board")
	public String board(int bno, String btitle, Model model) {
		System.out.println("bno : "+bno);
		System.out.println("btitle : "+btitle);
		
		model.addAttribute("bno",bno);
		model.addAttribute("btitle",btitle);
		
		return "board";
	}
	
}












