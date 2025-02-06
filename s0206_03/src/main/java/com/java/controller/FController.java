package com.java.controller;

//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemDto;
import com.java.dto.StuDto;
import com.java.service.BService;
import com.java.service.BServiceImpl;
import com.java.service.BServiceImpl2;
import com.java.service.BServiceImpl3;
import com.java.service.BServiceImpl4;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FController {

	// 객체선언
	@Autowired BService b;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}

	// 매게변수로 전달받은 형태.
//	@PostMapping("/meminfo")
//	public String meminfo(HttpServletRequest request,
//			String id, String pw,String name,String tel,String gender,String[] hobby,
//			Model model
//			) {
//		
//		System.out.println("hobby " + Arrays.toString(hobby));
//		String hobbys = "";
//		for(int i=0; i<hobby.length; i++) {
//			if(i==0)hobbys += hobby[i];
//			else hobbys += ","+hobby[i];
//		}
//		
//		model.addAttribute("mem", new MemDto(id,pw,name,tel,gender,hobbys));
//		
//		return "meminfo";
//	}
	
	

	@PostMapping("/meminfo")
	public String meminfo(MemDto mDto, Model model) {
		System.out.println("mDto : "+ mDto.getId());
		System.out.println("mDto hobby : "+ mDto.getHobby());
		
		model.addAttribute("mem",mDto);
		return "meminfo";
	}
	@GetMapping("/StuInput")
	public String StuInput() {
		return "StuInput";
	}

	@PostMapping("/StuInpo")
	public String StuInpo(HttpServletRequest request,
			StuDto sDto,
			Model model) {
		
		sDto.setTotal(sDto.getKor()+sDto.getEng()+sDto.getMath());
		sDto.setAvg(sDto.getTotal()/3.0);
		
		model.addAttribute("stu",sDto);
		
		return "StuInpo";
	}
	
	@GetMapping("/StuInpo")
	public String StuInpo() {
		return "StuInpo";
	}

	@GetMapping("/data")
	public String data(@RequestParam(defaultValue = "1")int bno, Model model) {
		
		System.out.println("bno : " + bno);
		model.addAttribute("bno",bno);
		
		return "data";
	}
	@GetMapping("/data2/{bno}")	//PathVariable 방식
	public String data2(@PathVariable int bno, Model model) {
		
		System.out.println("bno : " + bno);
		model.addAttribute("bno",bno);
		
		return "data2";
	}

	@GetMapping("/data3/{bno}")	//PathVariable 방식 - 여러개를 받을때
	public String data3(@PathVariable List<Integer> bno, Model model) {
		
		System.out.println("bno : " + bno);
		model.addAttribute("bno",bno);
		
		return "data3";
	}
	
	
	@GetMapping("/data4")
	public String data4() {
		String str = b.slist();
		System.out.println("str : " + str);
		return "data4";
	}
	
	
	
	
}
