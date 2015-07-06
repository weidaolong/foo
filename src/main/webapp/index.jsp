<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body> 
<%
Map categorys =(Map) session.getAttribute("categorys");
%>
<c:forEach items="${categorys}" var="item">

	${item.key }
	${item.value }

</c:forEach>


</body>
</html>