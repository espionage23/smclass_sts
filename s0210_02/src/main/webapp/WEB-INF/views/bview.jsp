<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>뷰페이지</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/read.css">
  <script>
  	const deleteBtn = (bno) => {
		if(confirm(bno+"번 게시글을 삭제하시겠습니까?")){
			alert("게시글이 삭제되었습니다.");
			location.href="/board/bdelete?bno=${bdto.bno}"
		}
  	}
  </script>
</head>
<body>
<section>
    <h1>NOTICE</h1>

    <table>
      <colgroup>
        <col width="80%">
        <col width="10%">
        <col width="10%">
        
      </colgroup>
      <tr>
        <th colspan="3">제목</th>
      </tr>
      <tr>
        <td colspan="3"><strong>${bdto.btitle}</strong></td>
      </tr>
      <tr>
        <td>${bdto.id}</td>
        <td>조회수</td>
        <td>${bdto.bhit}</td>
      </tr>
      <tr>
        <td colspan="3" class="article">${bdto.bcontent}</td>
      </tr>
      <tr>
        <td colspan="3"><strong>다음글</strong> <span class="separator">|</span>
        <a href="/board/bview?bno=${ndto.bno}">
        <c:if test="${ndto != null }">${ndto.btitle}</a></c:if>
        <c:if test="${ndto == null }">다음글이 없습니다.</c:if>
        </td>
      </tr>
      <tr>
        <td colspan="3"><strong>이전글</strong> <span class="separator">|</span>
        <a href="/board/bview?bno=${pdto.bno}">
        <c:if test="${pdto != null }">${pdto.btitle}</a></c:if>
        <c:if test="${pdto == null }">이전글이 없습니다.</c:if>
        </td>
      </tr>
    </table>

    <a href="/board/blist"><div class="list">목록</div></a>
    <a onclick="deleteBtn(${bdto.bno})"><div class="list">삭제</div></a>
    <a href="/board/bupdate?bno=${bdto.bno}"><div class="list">수정</div></a>
    <a href="/board/breply?bno=${bdto.bno}"><div class="list">답변달기</div></a>
  </section>
</body>
</html>