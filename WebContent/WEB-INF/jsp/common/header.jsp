<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="context" value="<%= application.getContextPath() %>"/>
<c:set var="img" value="${context}/images"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" type="text/css" href="css/hanbit.css" />
</head>
<body>
<div id="wrapper" class="width_full_size">
<div id="header" class="width_full_size" style="height: 100px;position: fixed;height: 68px;z-index: 2; background-color: white;">
	<div class="logo_box width_full_size">
	<img src="${img}/common/index_logo.png"/>
	</div>
	<div class="gnb width_full_size">
	<ul style="margin: 0px;">
		<li><a class="text_no_underline color_black" href="${context}/home.do?action=move&page=main">홈으로</a></li>
		<li><a class="text_no_underline color_black" href="${context}/board.do?action=move&page=main">게시판</a></li>
		<li>
			<div class="tooltip">
				<a class="text_no_underline color_black" href="#">병원소개</a>
					<span class="tooltiptext">구현되지 않았습니다.</span>
			</div>
		</li>
		<li style="float:right;margin-right: 45px;"><a class="text_no_underline color_black" href="${context}/patient.do?action=move&page=registerForm">회원 가입</a></li>
		<li style="float:right;"><a class="text_no_underline color_black" href="${context}/patient.do?action=move&page=loginForm">로그인</a></li>
	</ul>
	</div>
</div>
<div style="height: 100px"></div>