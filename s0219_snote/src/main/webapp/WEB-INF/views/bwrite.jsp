<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글쓰기</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/write.css">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>

<script>
	$(function() {
		$("#summernote").summernote({
			placeholder: '최대 2048자까지 쓸 수 있습니다',
		    tabsize: 1,
	   		height: 300,
	   		minHeight: 400,           // 에디터 최소 높이
  		    maxHeight: 400,          // 에디터 최대 높이
  		    lang: "ko-KR",	         // 한글 설정
  		    
			toolbar: [
 			    // [groupName, [list of button]]
 			    ['fontname', ['fontname']],
 			    ['fontsize', ['fontsize']],
 			    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
 			    ['color', ['forecolor','color']],
 			    ['table', ['table']],
 			    ['para', ['ul', 'ol', 'paragraph']],
 			    ['height', ['height']],
 			    ['insert',['picture','link','video']],
 			    ['view', ['fullscreen', 'help']]
 			  ],
 			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
 			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
 			callback:{
				onImageUpload:function(file){
					uploadImageFile(files[0],this); //이미지 업로드 호출
				 },
				 onPaste: function (e) {
				   var clipboardData = e.originalEvent.clipboardData;
				   if (clipboardData && clipboardData.items &&
				   clipboardData.items.length) {
				       var item = clipboardData.items[0];
				if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
				  e.preventDefault();	// 페이지 새로고침 방지
				       }
				   }
				 }
					}
				}
 			}//callback
		});//summernote
				// 이미지 업로드 함수 : this.editor(현재위치점)
				function uploadImageFile(file,this_editor){
					var form_data = new FormData();
					form_data.append("file", file);
					$.ajax({
						data:form_data,	// 이미지 파일
						type:"post",
						url:"/bwrite_upload",
						cache:false,
						contentType:false,
						enctype:'multipart/form-data',
						processData:false,
						success:function(data){
							console.log(data);
							$(this_editor).summernote("editor.insertImage",data);
						}
					});//ajax
	});//jquery
</script>

</head>
<body>
	<section>
		<a href="/"><h1>관리자 글쓰기</h1></a>
		<hr>

		<form action="bwrite" name="write" method="post" enctype="multipart/form-data">
			<table>
				<colgroup>
					<col width="15%">
					<col width="85%">
				</colgroup>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="btitle"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="bcontent" id="summernote" cols="50" rows="10">
						</textarea>
					</td>
				</tr>
				<tr>
					<th>이미지 표시</th>
					<td><input type="file" name="file" id="file"></td>
				</tr>
			</table>
			<hr>
			<div class="button-wrapper">
				<button type="submit" class="write">작성완료</button>
				<button type="button" class="cancel"
					onclick="javascript:location.href='list.do'">취소</button>
			</div>
		</form>

	</section>

</body>
</html>