package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller	//url 모든 링크 -> Controller로 분기

public class FController {

	@Autowired	//스프링 컨테이너에서 관리하는 빈(Bean) 객체를 자동으로 주입
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")	//get
	public String login() {
		System.out.println("get 방식으로");
		return "login";
	}
	
	@PostMapping("/doLogin")	//post
	public String doLogin(HttpServletRequest request) {
		System.out.println("post 방식으로");
		//HttpSession session = request.getSession();
		session.setAttribute("session_id", "aaa");	//섹션 추가
		return "index";
	}

	@GetMapping("/logout")
	public String logout() {
		session.invalidate();	// 섹션 삭제
		return "logout";
	}
	
	
	
}
