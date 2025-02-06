<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
		<h2>메인페이지</h2>
		<h4>섹션 : ${session_id }</h4>
		<ul>
		<c:if test="${session_id == null }">
			<li><a href="login">로그인</a></li>
			<li><a href="member">회원가입</a></li>
			<li><a href="/StuInput">학생성적입력</a></li>
			<li><a href="/data?bno=10">데이터전달1</a></li>
			<li><a href="/data2/100">데이터전달2</a></li>
			<li><a href="/data3/1,2,3">데이터전달3</a></li>
			<li><a href="/data4">데이터전달 - 객체(list)</a></li>
		</c:if>
		<c:if test="${session_id != null }">
			<li><a href="logout">로그아웃</a></li>
			<li><a href="board">게시판</a></li>
			<li><a href="meminfo">회원정보</a></li>
		</c:if>
		</ul>
	</body>
</html>