<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/top.jsp"/>
<jsp:include page="../common/header.jsp"/>
<jsp:include page="../common/gnb.jsp"/>
<div id="divContainer"></div>
<div id="container">
<form id="login" action="${context}/patient.do" method="post" >
<table>
	<tr>
		<td colspan="3"><span id="loginOr">로그인 또는
		<a id="aJoin" href="join.html"><span id="spanJoin">회원가입</span></a></span></td>
	</tr>
	<tr>
		<td id="id" colspan="3">아이디</td>
	</tr>
	<tr>
		<td colspan="3"> <input id="inputId" type="text" placeholder="아이디" name="id"/> </td>
	</tr>
	<tr>
		<td id="pw" colspan="3">비밀번호</td>
	</tr>
	<tr>
		<td colspan="3"> <input id="inputPw" type="password" placeholder="비밀번호" name="password"/> </td>
	</tr>
	<tr>
		<td id="forgot" colspan="2">비밀번호가 기억나지 않으세요?</td>
		<td id="loginButt" style="height: 20px;"><input id="inputButt" type="submit" value="로그인"/></td>
	</tr>
</table>
<input type="hidden" name="action" value="login" />
<input type="hidden" name="page" value="main" />
</form>
</div>
<jsp:include page="../common/footer.jsp"/>
<script>
$(function(){
	$('#divContainer').css('height','100px');
	$('#container').addClass('width_full_size').css('height','200px');
	$('#login').addClass('margin_center').css('width','20%');
	$('#loginOr').css('font-size','20px');
	$('#aJoin').css('text-decoration','none').css('line-height','inherit');
	$('#spanJoin').css('color','#254391');
	$('#id').addClass('font_bold').css('font-size','10px');
	$('#inputId').addClass('width_full_size').css('font-size','10px').css('padding','4px');
	$('#pw').addClass('font_bold').css('font-size','10px');
	$('#inputPw').addClass('width_full_size').css('font-size','10px').css('padding','4px');
	$('#forgot').css('font-size','10px').css('color','#254391');
	$('#loginButt').css('height','20px').css('color','#254391');
	$('#inputButt').addClass('color_white').addClass('text_no_underline').addClass('height_full_size').css('background-color','#254391');
});
</script>