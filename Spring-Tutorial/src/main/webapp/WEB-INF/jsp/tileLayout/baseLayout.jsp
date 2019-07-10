<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp"%>
<html>
<head>
<title>Explosion</title>
<link rel="stylesheet" href="<c:url value='/css/custom.css'/>"/>
<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>"/>
<script type="text/javascript" src="/js/custom.js"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
</head>
<body class="wrapper">
        <tiles:insertAttribute name="header"/>        
        <tiles:insertAttribute name="menu" />    
     <div id="page-wrapper" style="margin-top:200px;">
             <div class="row">
                <div class="col-lg-12">    
                    <h1 class="page-header"></h1>
                </div>
            </div>
            <div class="row">      
                <tiles:insertAttribute name="body" />                                                  
            </div>
          
     </div>
    
 
            <tiles:insertAttribute name="footer" />
</body>
</html>


