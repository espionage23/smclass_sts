package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller

public class FController {
	
	@Autowired
	HttpSession session;
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		System.out.println("get 접근");
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin() {
		session.setAttribute("session_id","aaa");
		System.out.println("post 접근");
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();	// session 삭제
		return "logout";
	}
	
}
