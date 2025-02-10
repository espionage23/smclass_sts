package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDto {
	private int bno;
	private String btitle;
	private String bcontent;
	private String id;
	private String bgroup;	// 답변달기 그룹핑 용도
	private int bstep;		// 답변달기 순서 용도
	private int bindent;	// 답변달기 들여쓰기 용도
	private int bhit;
	private Timestamp bdate;
	
}
