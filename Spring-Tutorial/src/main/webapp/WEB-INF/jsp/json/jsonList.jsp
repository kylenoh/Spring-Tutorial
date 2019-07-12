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
	<h2>JSON 목록</h2>
	<table class="board_list">
		<colgroup>
			<col width="10%" />
			<col width="*" />
			<col width="15%" />
			<col width="20%" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">글번호</th>
				<th scope="col">제목</th>
				<th scope="col">조회수</th>
				<th scope="col">작성일</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<br/> 
	<a href="#this" id="write">글쓰기</a>
	
<script type="text/javascript">
	$(document).ready(function(){
		$("#write").on("click",function(e){
			e.preventDefault();
			openBoardWrite();
		});
		$("a[name='title']").on("click",function(e){
			e.preventDefault();
			openBoardDetail($(this));
		});
	});
	function openBoardWrite(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/boardWrite' />");
		comSubmit.submit();
	}
	function openBoardDetail(obj){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/boardDetail' />");
		comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
		comSubmit.submit();
	}
</script>
</body>
</html>