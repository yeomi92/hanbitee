<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<img src="${img}/common/loading.gif" alt="" style="width: 250px; height: 200px;"/>
<button onclick="test()">팝업창 예제</button>
<a onclick="goMain()" href="#">메인페이지로 이동</a>
<script>
function goMain(){
	alert("a태그 클릭");
	location.href="${context}/home.do?action=move&page=main";
}
</script>