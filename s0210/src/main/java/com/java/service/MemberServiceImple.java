package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImple implements MemberService {

	@Autowired MemberMapper memberMapper;
	
	@Override
	// 로그인 확인
	public MemberDto login(String id, String pw) {
		// Dao 보내기
		MemberDto memberDto = memberMapper.selectLogin(id,pw);
		return memberDto;
	}

	
	@Override
	// 회원가입
	public void member(MemberDto mdto) {
		int result = memberMapper.insertMember(mdto);
		
		System.out.println("결과값 : " + result);
		
	}
	
	
	
}
