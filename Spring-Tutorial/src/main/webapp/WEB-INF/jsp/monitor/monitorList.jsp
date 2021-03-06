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
	<div style="width:100%; height:500px; overflow:auto">
		<h2>기술지원이력</h2>
			<table class="board_list">
				<colgroup>
					<col width="10%" />
					<col width="*" />
					<col width="15%" />
					<col width="20%" />
				</colgroup>
				<thead>
					<tr>
						<th scope="col">분류명</th>
						<th scope="col">지원이력</th>
						<th scope="col">프로젝트명</th>
						<th scope="col">지원요청일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(list) > 0}">
							<c:forEach items="${list }" var="row">
								<c:if test="${row.GUBUN==1}">
										<tr>
											<td>${row.DATA2 }</td>
											<td>${row.DATA1 }</td>
											<td>${row.DATA5 }</td>
											<td>${row.DATA4 }</td>
										</tr>
								</c:if>
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
		</div>
	<div class="row mb-2">
    	<div class="col-md-6">
				<h2>프로젝트</h2>
	    		<div style="width:100%; height:300px; overflow:auto">
			    <table class="board_list">
					<colgroup>
						<col width="10%" />
						<col width="*" />
						<col width="15%" />
						<col width="20%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">프로젝트명</th>
							<th scope="col">담당자</th>
							<th scope="col">시작일</th>
							<th scope="col">종료일</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${fn:length(list) > 0}">
								<c:forEach items="${list }" var="row">
									<c:if test="${row.GUBUN==2}">
										<tr>
											<td>${row.DATA1 }</td>
											<td>${row.DATA3 }</td>
											<td>${row.DATA4 }</td>
											<td>${row.DATA5 }</td>
										</tr>
									</c:if>
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
			</div>
		</div>
		<div class="col-md-6">
			<h2>솔루션</h2>
			<div style="width:100%; height:300px; overflow:auto">
			<table class="board_list">
					<colgroup>
						<col width="10%" />
						<col width="*" />
						<col width="15%" />
						<col width="20%" />
					</colgroup>
					<thead>
						<tr>
							<th scope="col">분류명</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
							<th scope="col">수정일</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${fn:length(list) > 0}">
								<c:forEach items="${list }" var="row">
									<c:if test="${row.GUBUN==3}">
										<tr>
											<td>${row.DATA2 }</td>
											<td>${row.DATA1 }</td>
											<td>${row.DATA3 }</td>
											<td>${row.DATA4 }</td>
										</tr>
									</c:if>
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
			</div>
		</div>
	</div>
	
	
<script type="text/javascript">
	setTimeout(function(){
		location.reload();
	},500000); //5분
	
	$(document).ready(function(){
		$("a[name='title']").on("click",function(e){
			e.preventDefault();
			openBoardDetail($(this));
		});
	});
	function openBoardDetail(obj){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/boardDetail' />");
		comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
		comSubmit.submit();
	}
</script>
</body>
</html>