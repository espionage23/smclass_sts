<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>가입회원정보</title>
		<style>
			h2{text-align: center;}
			table,th,td{border: 1px solid black; border-collapse: collapse; }
			table{text-align: center; width: 800px; margin: 0 auto;}
			th,td{height: 40px;}
		</style>
	</head>
	<body>
		<h2>가입회원정보</h2>
		<table>
			<colgroup>
				<col width="15%">
				<col width="15%">
				<col width="15%">
				<col width="15%">
				<col width="15%">
				<col width="*">
			</colgroup>
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>이름</th>
				<th>연락처</th>
				<th>성별</th>
				<th>취미</th>
			</tr>
			<tr>
				<td>${mem.id }</td>
				<td>${mem.pw }</td>
				<td>${mem.name }</td>
				<td>${mem.tel }</td>
				<td>${mem.gender }</td>
				<td>${mem.hobby }</td>
			</tr>
		</table>
		<div><a href="/">메인페이지</a></div>
	</body>
</html>