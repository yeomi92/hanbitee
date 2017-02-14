<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="util.BMI" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
<%
int age=Integer.parseInt(request.getParameter("age"));
double height=Double.parseDouble(request.getParameter("height")),weight=Double.parseDouble(request.getParameter("weight"));
if(age<2){
%>
2살 미만은 계산이 어렵습니다. 다시입력하세요.
<%
}else{
%>
나이: <%= age %>세<br>
몸무게: <%= weight %>kg<br>
키: <%= height %>cm<br>
결과: <%=  new BMI().getBmi(weight,height)%>
<%} %>
<form action="inputBmi.jsp">
<input type="submit" value="다시 입력하기"/>
</form>
</body>
</html>