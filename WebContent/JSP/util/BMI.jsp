<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
	public String bmi(double height,double weight){	
		String result="";
		double bmi = weight / (height/100 * height/100);
		if (bmi > 30.0) {
			result = "고도비만";
		} else if (bmi > 25.0) {
			result = "비만";
		} else if (bmi > 23.0) {
			result = "과체중";
		} else if (bmi > 18.5) {
			result = "정상";
		} else {
			result = "저체중";
		}
		return result;
	}
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>

<%
int age=0;
double height=0,weight=0;
%>
나이: <input type="text" name="age" /><br>
몸무게: <input type="text" name="weight" /><br>
키: <input type="text" name="height"/><br>


결과: <%= bmi(height,weight) %>
</body>
</html>