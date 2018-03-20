<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:requestEncoding value="utf-8"/>

<div class="menu_table">
	<ul style="width:100%;">
		<li class="title">
			달력 게시판 
		</li>
		<li class="subtitle">
			달력 게시판
		</li>
		<li class="menu_item">
			<a href="#none" onclick="url_calendarlist()">글목록</a>
		</li>
		<li class="menu_item">
			<a href="#none" onclick="url_calendarwrite()">글쓰기</a>
		</li>
	</ul>
</div>

<script type="text/javascript">
	function url_logout() {
		if(confirm('Are u sure?')){
			location.href = 'logout.do';			
		}
	}

	function url_calendarlist() {
		location.href = 'calendar.do';
	}
	
	function url_calendarwrite() {
		location.href = 'calendarwrite.do';
	}
</script>