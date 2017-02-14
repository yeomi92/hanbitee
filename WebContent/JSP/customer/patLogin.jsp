<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="serviceImpl.MemberServiceImpl" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	
</head>
<body>
<%
	String id=request.getParameter("id"),password=request.getParameter("password");
%>
<%= id %> 님, <a href="">내정보</a>
<input type="submit" value="로그아웃"/>
</body>
</html> 