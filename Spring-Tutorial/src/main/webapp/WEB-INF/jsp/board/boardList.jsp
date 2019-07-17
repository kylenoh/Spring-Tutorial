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
	<h2>게시판 목록</h2>
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
			<c:choose>
				<c:when test="${fn:length(list) > 0}">
					<c:forEach items="${list }" var="row">
						<tr>
							<td>${row.IDX }</td>
							<td class="title">
								<a href="#this" name="title">${row.TITLE }</a>
								<input type="hidden" id="IDX" value="${row.IDX }">
							</td>
							<td>${row.HIT_CNT }</td>
							<td>${row.CREA_DTM }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">조회된 결과가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>

	<div id="PAGE_NAVI"></div>
	<input type="hidden" id="PAGE_INDEX" name="PAGE_INDEX"/>

	<a href="#this" id="write">글쓰기</a>
<script type="text/javascript">
	$(document).ready(function(){
		selectBoardList(1);
		
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
		comSubmit.setUrl("<c:url value='/openBoardWrite' />");
		comSubmit.submit();
	}
	function openBoardDetail(obj){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/openBoardDetail' />");
		comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
		comSubmit.submit();
	}
	function selectBoardList(pageNo){
		var comAjax = new ComAjax();
		comAjax.setUrl("<c:url value='/selectBoardList' />");
		comAjax.setCallback("selectBoardListCallback");
		comAjax.addParam("PAGE_INDEX",pageNo);
		comAjax.addParam("PAGE_ROW", 15);
		comAjax.ajax();
	}
	function selectBoardListCallback(data){
		var total = data.TOTAL;
		var body = $("table>tbody");
		body.empty();
		if(total == 0){
			var str = "<tr>" + "<td colspan='4'>조회된 결과가 없습니다.</td>" + "</tr>";
			body.append(str);
		} else{
			var params = { divId : "PAGE_NAVI", pageIndex : "PAGE_INDEX", totalCount : total, eventName : "selectBoardList" };
			gfn_renderPaging(params);
			var str = "";
				$.each(data.list, function(key, value){
					str += "<tr>" + "<td>" + value.IDX + "</td>" + "<td class='title'>" 
					+ "<a href='#this' name='title'>" 
					+ value.TITLE + "</a>" 
					+ "<input type='hidden' name='title' value=" 
					+ value.IDX + ">" + "</td>" + "<td>" 
					+ value.HIT_CNT + "</td>" + "<td>" 
					+ value.CREA_DTM + "</td>" + "</tr>"; 
				});
			body.append(str); 
			$("a[name='title']").on("click", function(e){
				e.preventDefault();
				openBoardDetail($(this));
			});
		}
	}

</script>
</body>
</html>