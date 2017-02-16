<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="service.MemberService" %>
<%@ page import="serviceImpl.MemberServiceImpl" %>
<%@page import="domain.MemberBean"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="../../css/hanbit.css"/>
</head>
<body>
<div id="wrapper" class="width_full_size">
<div id="header" class="width_full_size" style="height: 100px;position: fixed;height: 68px;z-index: 2; background-color: white;">
	<div class="logo_box width_full_size">
	<img src="../../images/common/index_logo.png"/>
	</div>
	<div class="gnb width_full_size">
	<ul style="margin: 0px;">
		<li><a class="text_no_underline color_black" href="../../index.html">홈으로</a></li>
		<li><a class="text_no_underline color_black" href="../bbs/bbs_list.html">게시판</a></li>
		<li><div class="dropdown">
			<a class="text_no_underline color_black" href="../admin/admin.html">관리자</a>
				<div class="dropdown_content">
				   <p><a class="active" href="../staff/doctors.html">의사</a></p>
				   <p><a class="active" href="../staff/nurses.html">간호사</a></p>
				   <p><a class="active" href="../customer/patients.html">환자</a></p>
				   <p><a class="active" href="../chart/chart_list.html">차트</a></p>
				</div>
			</div>
		</li>
		<li>
			<div class="tooltip">
				<a class="text_no_underline color_black" href="#">병원소개</a>
					<span class="tooltiptext">구현되지 않았습니다.</span>
			</div>
		</li>
		<li style="float:right;margin-right: 45px;"><a class="text_no_underline color_black" href="join.html">회원 가입</a></li>
		<li style="float:right;"><a class="text_no_underline color_black" href="login.html">로그인</a></li>
	</ul>
	</div>
</div>
<div style="height: 140px;"></div>
<div id="container" class="width_full_size" style="height: 200px;">
<%
	MemberService service=MemberServiceImpl.getInstance();
	MemberBean member=new MemberBean();
	member.setId(request.getParameter("id"));
	member.setPassword(request.getParameter("password"));
	if(service.findById(member.getId())==null){
%>
id가 존재하지 않습니다.
<a href="patLoginForm.jsp">뒤로가기</a>
<% 	
	}else{
		if(service.login(member)){
			member = service.findById(member.getId());
%>
<%= member.getName() %>님,<a href="">내정보</a>
<input type="submit" value="로그아웃"/>
<%
		}else{
%>
pw가 틀렸습니다.
<a href="patLoginForm.jsp">뒤로가기</a>
<%
		}
	}
%>
</div>
<div id="footer" class="width_full_size" style="height: 100px; border-top:2px solid black;">
	<dl class="notice">
		<dt><a href="/NOTICE" class="h_notice">공지사항</a></dt>
	</dl>
	<dl class="policy">
		<dt>네이버 정책 및 약관</dt>
		<dd class="f"><a href="http://www.navercorp.com/" target="_blank" id="plc.intronhn">회사소개</a></dd>
		<dd><a href="http://mktg.naver.com/" id="plc.adinfo">광고</a></dd>
		<dd><a href="https://submit.naver.com/" id="plc.search">마이비즈니스</a></dd>
		<dd><a href="https://www.navercorp.com/ko/company/proposalGuide.nhn" target="_blank" id="plc.contact">제휴제안</a></dd>
		<dd><a href="rules/service.html" id="plc.service">이용약관</a></dd>
		<dd><a href="rules/privacy.html" id="plc.privacy"><strong>개인정보처리방침</strong></a></dd>
		<dd><a href="rules/youthpolicy.html" id="plc.youth">청소년보호정책</a></dd>
		<dd><a href="rules/spamcheck.html" id="plc.policy">네이버 정책</a></dd>
		<dd><a href="https://help.naver.com/" id="plc.helpcenter">네이버 고객센터</a></dd>
	</dl>
	<address>&copy; <strong><a href="http://www.navercorp.com/" target="_blank">NAVER Corp.</a></strong></address>
</div>
</div>
</body>
</html> 