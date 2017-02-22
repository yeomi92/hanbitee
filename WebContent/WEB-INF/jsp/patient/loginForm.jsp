<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/top.jsp"/>
<jsp:include page="../common/header.jsp"/>
<div style="height: 100px;"></div>
<div id="container" class="width_full_size" style="height: 200px;">
<form action="${context}/patient.do" method="post" style="width: 20%;" class="margin_center">
<table>
	<tr>
		<td colspan="3"><span style="font-size: 20px;">로그인 또는
		<a href="join.html"style="text-decoration: none;line-height: inherit;"><span style="color: #254391;">회원가입</span></a></span></td>
	</tr>
	<tr>
		<td colspan="3" class="font_bold" style="font-size: 10px;">아이디</td>
	</tr>
	<tr>
		<td colspan="3"> <input type="text" placeholder="아이디" name="id" class="width_full_size" style="font-size: 10px;padding: 4px;"/> </td>
	</tr>
	<tr>
		<td colspan="3" class="font_bold" style="font-size: 10px;">비밀번호</td>
	</tr>
	<tr>
		<td colspan="3"> <input type="password" placeholder="비밀번호" name="password" class="width_full_size" style="font-size: 10px;padding: 4px;"/> </td>
	</tr>
	<tr>
		<td colspan="2" style="font-size: 10px; color:#254391;">비밀번호가 기억나지 않으세요?</td>
		<td style="height: 20px;"><input type="submit" value="로그인" class="color_white text_no_underline height_full_size" style="background-color: #254391;"/></td>
	</tr>
</table>
<input type="hidden" name="action" value="login" />
<input type="hidden" name="page" value="main" />
</form>
</div>
<jsp:include page="../common/footer.jsp"/>