<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<%@ page import="util.Clock" %>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>현재 시간 출력</title>
</head>
<body>
현재시간은 <%= new Clock().now() %>입니다.
</body>
</html>