<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="utf-8"/>   

<div class="menu_table">
	<ul style="width: 100%;">	
		<li class="title">자료실</li>
		<li class="subtitle">자료실</li>	
		<li class="menu_item">
			<a href="#none" onclick="url_pdslist()" title="자료 목록">자료 목록</a>
		</li>
	</ul>
</div>

<script>
function url_pdslist() {
	location.href = "pdslist.do";
}
</script>




