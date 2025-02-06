package com.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller

public class FController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		System.out.println("index 페이지 오픈");
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("login get 오픈");
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		System.out.println("ID : "+id);
		System.out.println("login post 오픈");
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		session.setAttribute("session_id", id);
		
		return "index";
	}
	
	@RequestMapping("/logout") // getMapping, postMapping 2개 모두 사용
	public String logout() {
		System.out.println("로그아웃");
		session.invalidate();	// 섹션삭제
		return "index";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	
	@PostMapping("/member")
	public ModelAndView member(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String gender = request.getParameter("gender");
		String[] hobbys= request.getParameterValues("hobby");
		String hobby="";
		for(int i=0; i<hobbys.length; i++) {
			if(i==0) hobby += hobbys[i];
			else hobby += ","+hobbys[i];
		}
		
		// model 방식
		// public String member(HttpServletRequest request, Model model)
		//model.addAttribute("member",new MemberDto(id, pw, name, tel, gender, hobby));
		
		// ModelAndView
		ModelAndView mv = new ModelAndView();
		mv.setViewName("meminfo");
		mv.addObject("member",new MemberDto(id, pw, name, tel, gender, hobby));
		return mv;
		
		//return "meminfo";
	}

	@GetMapping("/meminfo")
	public String meminfo() {
		return "meminfo";
	}
	
}
