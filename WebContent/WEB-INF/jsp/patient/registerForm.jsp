<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/top.jsp"/>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/gnb.jsp"/>
<div id="container">
	<form id="registerForm">
		<table>
			<tr>
				<td>
					<p>
						<font size="2">한글 또는 영문으로 입력해 주세요.</font>
					</p>
					<input type="text" name="id" placeholder="email" size="60">
					<input type="button" value="중복확인" size="60"><br>
					<p>
						<font size="2">LPOINT 아이디는 자주 사용하시는 이메일주소로 입력해주세요.</font>
					</p>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="password" placeholder="비밀번호" size="60">
					<p>
						<font size="2">8~15자의 영문자, 숫자, 특수문자를 함께 입력해주세요.</font>
					</p>
					<input type="text" name="ckPassword" placeholder="비밀번호 확인" size="60">
				</td>
			</tr>
			<tr>
				<td>
					<select name="year">
						<option value="" selected>생년 선택</option>
						<option value="1992">1992</option>
						<option value="1993">1993</option>
						<option value="1994">1994</option>
						<option value="1995">1995</option>
						<option value="1996">1996</option>
						<option value="1997">1997</option>
						<option value="1998">1998</option>
						<option value="1999">1999</option>
						<option value="2000">2000</option>
						<option value="2001">2001</option>
					</select>
					<select name="month">
						<option value="" selected>월 선택</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select>
					<select name="date">
						<option value="" selected>일 선택</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select><br>
				</td>
			</tr>
			<tr>
				<td>
					<select name="telecom">
						<option value="" selected>통신사 선택</option>
						<option value="SKT">SKT</option>
						<option value="KT">KT</option>
						<option value="LGU+">LGU+</option>
					</select>
					<select name="firstNum">
						<option value="" selected>번호 선택</option>
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
					</select>
				  - <input type="text" name="middleNum"/>
				  - <input type="text" name="lastNum"/>
				</td>
			</tr>
			<tr>
				<td>
					<font size="2">
						<b>정보수신 동의</b>
						<b>전체선택</b>
						<input type="checkbox" name="" value="전체선택"/><br>
						<b>LPOINT</b>
						<input type="checkbox" name="ckbox" value="lpointEmail"/>E-Mail
						<input type="checkbox" name="ckbox" value="lpointSms"/>SMS<br>
						<b>롯데시네마</b>
						<input type="checkbox" name="ckbox" value="lotteEmail"/>E-Mail
						<input type="checkbox" name="ckbox" value="lotteSms"/>SMS<br>
						*정보수신동의를 하시면, 고객혜택 및 이벤트 등 다양한 정보를 받으실 수 있습니다.
					</font>
				</td>
			</tr>
			<tr>
				<td>
					<font size="2">
						<span>개인정보<br>유효기간</span>
						<input type="radio" name="rdBtn" value="del" checked="checked"/>탈퇴 시 파기
						<input type="radio" name="rdBtn" value="1year"/>1년<br>
						*개인정보 유효기간 경과 이후 개인정보를 분리 저장관리 또는 파기합니다.
					</font>
				</td>
			</tr>
			<tr>
				<td>
					<font size="2">
						<b>*선택항목에 동의하지 않으셔도 정상적인 서비스를 이용하실 수 있습니다.</b>
					</font>
				</td>
			</tr>
		</table>
		<input type="hidden" name="action" value="register" />
		<input type="hidden" name="page" value="loginForm" />
		<input type="button" name="test" value="이전"/>
		<input type="submit" name="register" value="다음"/>
	</form>
</div>
<jsp:include page="../common/footer.jsp"/>
<script>
$(function(){
	var $registerForm=$('#registerForm');
	var tab=$registerForm.find('table');
	$('input[name=register]').click(function(){
		$registerForm.attr('action','${context}/patient.do');
		$registerForm.attr('method','post');
		alert('전송직전');
		$registerForm.submit();
	});
	$('#container').addClass('width_full_size');
	$registerForm.add('margin_center').css('width','40%');
	tab.addClass('table_default');
	tab.find('tr:nth-child(1) p:nth-child(1)').addClass('color_blue');
	tab.find('select').addClass('join_select');
	tab.find('tr:nth-child(4) input').css('width','80px').css('height','14px');
	tab.find('tr:nth-child(6) span').addClass('font_bold');
	tab.find('tr:nth-child(7) td').addClass('color_blue');
	$registerForm.find('table~input:nth-child(3)').addClass('color_white').css('background-color','#ff0000').css('width','500px');
	$registerForm.find('table~input:nth-child(4)').addClass('color_white').css('background-color','#3c70c5').css('width','200px');	
});
</script>