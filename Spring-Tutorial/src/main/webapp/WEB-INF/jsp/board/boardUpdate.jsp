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
	<form id="frm" enctype="multipart/form-data">
		<table class="board_view">
			<colgroup>
				<col width="15%" />
				<col width="35%" />
				<col width="15%" />
				<col width="35%" />
			</colgroup>
			<tbody>
				<tr>
					<th scope="row">글 번호</th>
					<td>${map.IDX }
						<input type="hidden" id="IDX" name="IDX" value="${map.IDX }">
					</td>
					<th scope="row">조회수</th>
					<td>${map.HIT_CNT }</td>
				</tr>
				<tr>
					<th scope="row">작성자</th>
					<td>${map.CREA_ID }</td>
					<th scope="row">작성시간</th>
					<td>${map.CREA_DTM }</td>
				</tr>
				<tr>
					<th scope="row">제목</th>
					<td colspan="3">
						<input type="text" id="TITLE" name="TITLE" class="wdp_90" value="${map.TITLE }" />
					</td>
				</tr>
				<tr>
					<td colspan="4" class="view_text"><textarea rows="20"
							cols="100" title="내용" id="CONTENTS" name="CONTENTS">${map.CONTENTS }</textarea>
					</td>
				</tr>
				<tr>
					<th scope="row">첨부파일</th>
					<td colspan="3">
						<div id="fileDiv">
							<c:forEach var="row" items="${list }" varStatus="var">
								<p> 
									<input type="hidden" id="IDX" name="IDX_${var.index }" value="${row.IDX }">
									<a href="#this" id="name_${var.index }" name="name_${var.index }">${row.ORIGINAL_FILE_NAME }</a>
									<input type="file" id="file_${var.index }" name="file_${var.index }"> (${row.FILE_SIZE }kb)
									<a href="#this" id="delete_${var.index }" name="delete_${var.index }">삭제</a>
								</p>
							</c:forEach>
						</div>
					</td>
				</tr>

			</tbody>
		</table>
	</form>
	<a href="#this" id="addFile">파일 추가</a>
	<a href="#this" id="list">목록으로</a>
	<a href="#this" id="update">저장하기</a>
	<a href="#this" id="delete">삭제하기</a>

	<script type="text/javascript">
	var gfv_count = '${fn:length(list)+1}';

		$(document).ready(function() {
			$("#list").on("click", function(e) {
				e.preventDefault();
				BoardList();
			});
			$("#update").on("click", function(e) {
				e.preventDefault();
				updateBoard();
			});
			$("#delete").on("click", function(e) {
				e.preventDefault();
				deleteBoard();
			});
			$("#addFile").on("click", function(e){
				e.preventDefault();
				addFile();
			});
			$("a[name^='delete']").on("click", function(e){
				e.preventDefault();
				deleteFile($(this));
			});

		});
		function BoardList() {
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/openBoardList' />");
			comSubmit.submit();
		}
		function updateBoard() {
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/updateBoard' />");
			comSubmit.submit();
		}
		function deleteBoard() {
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/deleteBoard' />");
			comSubmit.addParam("IDX", $("#IDX").val());
			comSubmit.submit();
		}
		function addFile(){
			var str = "<p>" + "<input type='file' id='file_"+(gfv_count)+"' name='file_"+(gfv_count)+"'>"
							+ "<a href='#this' id='delete_"+(gfv_count)+"' name='delete_"+(gfv_count)+"'>삭제</a>" 
							+ "</p>"; $("#fileDiv").append(str);
			$("#delete_"+(gfv_count++)).on("click", function(e){
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

