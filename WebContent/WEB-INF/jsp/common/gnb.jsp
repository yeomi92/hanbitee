<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="divGnb">
	<ul style="margin: 0px;">
		<li><a id="aMain" class="text_no_underline color_black" href="#">홈으로</a></li>
		<li><a id="aBoard" class="text_no_underline color_black" href="#">게시판</a></li>
		<li><div class="dropdown">
			<a id="aAdminLogin" class="text_no_underline color_black" href="#">관리자</a>
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
		<li style="float:right;margin-right: 45px;"><a id="aJoin" class="text_no_underline color_black" href="#">회원 가입</a></li>
		<li style="float:right;"><a id="aPatLogin" class="text_no_underline color_black" href="#">로그인</a></li>
	</ul>
</div>
<script>
$(function(){
	$('#divGnb').addClass('gnb').addClass('width_full_size');
	document.getElementById('aMain').onclick=function(){
		location.href="${context}/home.do?action=move&page=main";
	}
	document.getElementById('aBoard').addEventListener('click',function(){
		alert('aBoard');
		location.href="${context}/board.do?action=move&page=articleList";
	});
	document.getElementById('aAdminLogin').onclick=function(){
		location.href="${context}/admin.do?action=move&page=login";
	}
	$('#aJoin').click(function(){
		alert('jQuery');
		location.href="${context}/patient.do?action=move&page=registerForm";
	});
	document.getElementById('aPatLogin').onclick=function(){
		location.href="${context}/patient.do?action=move&page=loginForm";
	}
});
</script>