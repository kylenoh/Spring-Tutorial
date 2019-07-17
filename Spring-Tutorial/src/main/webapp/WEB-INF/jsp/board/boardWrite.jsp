<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="frm" name="frm" enctype="multipart/form-data">
		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th scope="row">제목</th>
					<td><input type="text" id="TITLE" name="TITLE" class="wdp_90"></input></td>
				</tr>
				<tr>
					<td colspan="2" class="view_text">
						<textarea rows="20"	cols="100" title="내용" id="CONTENTS" name="CONTENTS"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<div id="fileDiv">
			<p>
				<input type="file" id="file" name="file_0">
				<a href="#this" id="delete" name="delete">삭제</a>
			</p>
		</div>
		<a href="#this" id="addFile">파일 추가</a>
		<a href="#this" id="write">작성하기</a>
		<a href="#this"	id="list">목록으로</a>
	</form>
<script type="text/javascript"> 
var gfv_count = 1;
$(document).ready(function(){
	$("#list").on("click", function(e){
		e.preventDefault(); 
		BoardList(); 
	});
	$("#write").on("click", function(e){
		e.preventDefault(); 
		insertBoard(); 
	});
	$("#addFile").on("click", function(e){
		e.preventDefault();
		addFile();
	});
	$("a[name='delete']").on("click", function(e){
		e.preventDefault();
		deleteFile($(this));
	});

}); 
function BoardList(){
	var comSubmit = new ComSubmit();
	comSubmit.setUrl("<c:url value='/openBoardList' />");
	comSubmit.submit();
}
function insertBoard(){
	var comSubmit = new ComSubmit("frm");
	comSubmit.setUrl("<c:url value='/insertBoard' />");
	comSubmit.submit();
}
function addFile(){
	var str = "<p><input type='file' name='file_"+(gfv_count++)+"'><a href='#this' name='delete'>삭제</a></p>";
	$("#fileDiv").append(str);
	$("a[name='delete']").on("click", function(e){
		e.preventDefault();
		deleteFile($(this));
	});
}
function deleteFile(obj){
	obj.parent().remove();
}

</script>

</body>
</html>

