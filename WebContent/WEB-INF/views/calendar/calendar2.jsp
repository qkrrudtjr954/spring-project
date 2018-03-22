
<%@page import="kh.com.a.arrow.CalendarUtil"%>
<%@page import="kh.com.a.arrow.myCal"%>
<%@ page contentType="text/html; charset=UTF-8"%>


<%@page import="java.util.Calendar" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="utf-8"/>

<style>
table{
	border-collapse: collapse; 
}
table, td, th{
	border: 1px solid black;
}
.sunday{
	color:red;
	text-align: left;
	vertical-align: top;
}
.satday{
	color:blue;
	text-align: left;
	vertical-align: top;
}
.otherday{
	color:black;
	text-align: left;
	vertical-align: top;
}
.days2{
	font-size:20px;
	color:#4d6bb3;
	text-align: center;
	vertical-align: middle;
}
.days3{
	font-size:10px;
	color:#4d6bb3;
	text-align: center;
	vertical-align: middle;
}
.days4{	
	align:center;
	text-align: center;
	vertical-align: middle;
}
.innerTable{
	border: 0px;
}
</style>

<h3>일정관리</h3>
<% 
myCal jcal = (myCal)request.getAttribute("jcal");

int dayOfWeek = jcal.getDayOfWeek();
int lastDayOfMonth = jcal.getLastDay();

int year = jcal.getYear();
int month = jcal.getMonth();

String pp=String.format("<a href='./%s?year=%d&month=%d'><img src='image/left.gif'/></a>", 
		"calendar2.do", year-1, month);
String p=String.format("<a href='./%s?year=%d&month=%d'><img src='image/prec.gif'/></a>", 
		"calendar2.do", year, month-1);
String nn=String.format("<a href='./%s?year=%d&month=%d'><img src='image/last.gif'/></a>", 
		"calendar2.do", year+1, month);
String n=String.format("<a href='./%s?year=%d&month=%d'><img src='image/next.gif'/></a>", 
		"calendar2.do", year, month+1);

Calendar cal = Calendar.getInstance();
cal.set(year, month-1, 1);

int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
%>

<div class="list_table">
<table align="center">
<col width="40px"/>
<col width="40px"/>
<col width="40px"/>
<col width="40px"/>
<col width="40px"/>
<col width="40px"/>
<col width="40px"/>

<tr height="40px">
	<td class="days2" colspan="7">
		<%=pp %><%=p %>
			<font color="red" style="font-size: 20">
				<%=String.format("%d년&nbsp;&nbsp;%d월", year, month) %>
			</font>
		<%=n %><%=nn %>	
	</td> 
</tr>

<tr height="40px">
	<th class="days2">일</th>
	<th class="days2">월</th>
	<th class="days2">화</th>
	<th class="days2">수</th>
	<th class="days2">목</th>
	<th class="days2">금</th>
	<th class="days2">토</th>
</tr>

<tr height="40px">
	<%
	for(int i = 1;i < dayOfWeek; i++){
		%>
		<td>&nbsp;</td>
		<%	
	}
	for(int i = 1;i <= lastDay; i++){
		String rdate = CalendarUtil.yyyymmdd(year, month, i);
		%>
		<td id='mytd<%=i %>' class="days3"
			onmouseout="mout('<%=i %>')"
			onmouseover="ajaxcalendar('<%=i %>','${login.id }','<%=rdate %>')">
			<%=i %>
			<div id="my<%=i %>"></div>
		</td>
		<% 
		if((i+dayOfWeek-1)%7 == 0){
			%>
			</tr><tr height="40px">
			<%
		}
	}
	for(int i = 0;i < (7-(dayOfWeek+lastDayOfMonth-1)%7)%7; i++){
		%>
		<td>&nbsp;</td>	
		<%
	}
	%>
</tr>
</table>
</div>

<script type="text/javascript">

function ajaxcalendar(i, id, rdate) {
	$("#mytd"+i).css("background-color", "#ff0000");
	showallcust(i, id, rdate);
}
function mout(i) {
	$("#mytd"+i).css("background-color", "#ffffff");
	$("#my"+i).hide();
}
$(document).ready(function name() {
	$("#my").html("나는 미래다");
});

function showallcust(i, id, rdate) {	
	$.ajax({
		type:"POST",
		url:"<%=application.getContextPath() %>/calendarjson.do",
		async:true,
		data:"id="+id+"&rdate="+rdate,
		success:function(msg){	
			
			if(msg.my != null){
				
				$.each(msg.my, function(index, value) { 
					alert(index + '번째:' + value.title);					
				});
			}  
			
			alert("날짜:" + i + " 아이디:" + id +  " 연월일:" + rdate);
			console.log("날짜:" + i + " 아이디:" + id +  " 연월일:" + rdate);
		}
	});	
}  


</script>











