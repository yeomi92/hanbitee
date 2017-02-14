<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.SSN" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>

<%
String ssn=request.getParameter("ssn");
%>
<%= new SSN().calcSsn(ssn) %>입니다.
</body>
</html>