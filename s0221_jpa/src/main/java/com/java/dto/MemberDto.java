package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamicInsert	// 데이터값이 null인 경우 컬럼에서 제외
@Builder
@AllArgsConstructor
@NoArgsConstructor	// 기본 생성자
@Data	// @Setter, @Getter
@Entity	// jpa 자동생성 - memberdto 테이블 : 컬럼 생성, varchar2(50)
public class MemberDto {

	
	@Id // primary key 생성
	@Column(length = 100)
	private String id;
	@Column(nullable = false, length=100) // varchar2(100) not null
	private String pw;
	@Column(nullable = false, length=50)
	private String name;
	@Column(length = 20)
	private String phone;
	@ColumnDefault(" '남자' ")
	private String gender;
	@Column(length=100)
	private String hobby;
	// @CreationTimestamp // 시간자동입력 - sysdate와 같음
	@UpdateTimestamp
	private Timestamp mdate;

	
	
	
	
}
