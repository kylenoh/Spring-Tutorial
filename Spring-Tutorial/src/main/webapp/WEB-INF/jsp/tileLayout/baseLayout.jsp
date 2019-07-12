<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<html>
<head>
<title>Explosion</title>
<link rel="stylesheet" href="<c:url value='/css/custom.css'/>"/>
<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/custom.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</head>
<body class="wrapper">
        <tiles:insertAttribute name="header"/>        
        <tiles:insertAttribute name="menu" />    
     <div class="container" style="min-height:800px;">
        <tiles:insertAttribute name="body" />                                                  
     </div>
        <tiles:insertAttribute name="footer" />
</body>
</html>


