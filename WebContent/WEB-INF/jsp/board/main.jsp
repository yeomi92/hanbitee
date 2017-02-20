<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BbsList</title>
<link rel="stylesheet" type="text/css" href="../../css/hanbit.css" />
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
		<li><a class="text_no_underline color_black" href="bbs_list.html">게시판</a></li>
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
		<li style="float:right;margin-right: 45px;"><a class="text_no_underline color_black" href="../common/join.html">회원 가입</a></li>
		<li style="float:right;"><a class="text_no_underline color_black" href="../common/login.html">로그인</a></li>
	</ul>
	</div>
</div>
<div style="height: 130px"></div>
<div id="container" class="width_full_size" style="height: 500px;">
<table class="table_default margin_center" style="width: 500px;height: 180px;">
	<tr>
		<td colspan="5" class="text_center font_bold" style="font-size: 15px;">게시판</td>
	</tr>
	<tr>
		<th>No.</th>
		<th style="width: 50%">제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<tr>
		<td>100</td>
		<td>제목100</td>
		<td>백번</td>
		<td>2017-01-13</td>
		<td>3</td>
	</tr>
	<tr>
		<td>99</td>
		<td>제목99</td>
		<td>구십구번</td>
		<td>2017-01-12</td>
		<td>6</td>
	</tr>
	<tr>
		<td>98</td>
		<td>제목98</td>
		<td>구십팔번</td>
		<td>2017-01-11</td>
		<td>12</td>
	</tr>
	<tr>
		<td>97</td>
		<td>제목97</td>
		<td>구십칠번</td>
		<td>2017-01-05</td>
		<td>25</td>
	</tr>
	<tr>
		<td>96</td>
		<td>제목96</td>
		<td>구십육번</td>
		<td>2017-01-01</td>
		<td>56</td>
	</tr>
	<tr>
		<td style="height: 20px;border-color: white;"></td>
	</tr>
	<tr>
		<td colspan="5" class="text_center" style="border-color: white;">1 2 3 4 5 ▶</td>
	</tr>
</table>
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