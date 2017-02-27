<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/top.jsp"/>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/gnb.jsp"/>
<div id="container" class="width_full_size">

<form action="" style="width: 40%;" class="margin_center">
<table class="table_default">
	<tr>
		<td><p class="color_blue"><font size="2">한글 또는 영문으로 입력해 주세요.</font></p>
		<input type="text" name="" value="E-mail" size="60">
		<input type="button" value="중복확인" size="60"><br>
		<p><font size="2">LPOINT 아이디는 자주 사용하시는 이메일주소로 입력해주세요.</font></p>
		</td>
	</tr>
	<tr>
		<td><input type="text" name="" value="비밀번호" size="60">
		<p><font size="2">8~15자의 영문자, 숫자, 특수문자를 함께 입력해주세요.</font></p>
		<input type="text" name="" value="비밀번호 확인">
		</td>
	</tr>
	<tr>
		<td>
		<select name="" class="join_select">
			<option value="생년">생년</option>
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
		<select name="" class="join_select">
			<option value="월">월</option>
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
		<select name="" class="join_select">
			<option value="일">일</option>
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
		<select name="" class="join_select">
			<option value="SKT">SKT</option>
			<option value="KT">KT</option>
			<option value="LGU+">LGU+</option>
		</select>
		<select name="" class="join_select">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
		</select>
		- <input type="text" name="" style="width: 80px;height: 14px;">
		- <input type="text" name="" style="width: 80px;height: 14px;">
		</td>
	</tr>
	<tr>
		<td><font size="2"><b>정보수신 동의</b>
		<b>전체선택</b><input type="checkbox" name="" value="전체선택"><br>
		<b>LPOINT</b><input type="checkbox" name="" value="E-Mail">E-Mail
		<input type="checkbox" name="" value="SMS">SMS<br>
		<b>롯데시네마</b><input type="checkbox" name="" value="E-Mail">E-Mail
		<input type="checkbox" name="" value="SMS">SMS<br>
		*정보수신동의를 하시면, 고객혜택 및 이벤트 등 다양한 정보를 받으실 수 있습니다.</font></td>
	</tr>
	<tr>
		<td><font size="2"><span class="font_bold">개인정보<br>
		유효기간</span><input type="radio" name="" value="탈퇴 시 파기" checked="checked">탈퇴 시 파기 <input type="radio" name="" value="1년">1년<br>
		*개인정보 유효기간 경과 이후 개인정보를 분리 저장관리 또는 파기합니다.</font></td>
	</tr>
	<tr>
		<td class="color_blue"><font size="2"><b>*선택항목에 동의하지 않으셔도 정상적인 서비스를 이용하실 수 있습니다.</b></font></td>
	</tr>
	<tr>
		<td><input type="submit" name="" value="이전" class="color_white" style="background-color: #a0a0a0;width: 200px;">
		<input type="submit" name="" value="다음" class="color_white" style="background-color: #3c70c5;width: 200px;"></td>
	</tr>
</table>
</form>
</div>
<jsp:include page="../common/footer.jsp"/>