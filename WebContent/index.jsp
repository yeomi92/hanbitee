<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="resources/js/jquery-3.1.1.js"></script>
<img src="${img}/common/loading.gif" alt="" style="width: 250px; height: 200px;"/>
<button onclick="test()">팝업창 예제</button>
<script>
$(function(){
	location.href="${context}/home.do?action=move&page=main";
});
</script>