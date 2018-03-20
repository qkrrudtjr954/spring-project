<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:requestEncoding value="utf-8"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jquery/jquery.cookie.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />

<style type="text/css">
#login_wrap {
	margin: 10px;
}

#login_wrap th {
	font-weight: bold;
}

#main_wrap {
	width: 800px;
	margin-left: auto;
	margin-right: auto;
	padding: 0px;
}

#content_wrap {
	width: 100%;
	height: 500px;
	background-image: url("image/backa.jpg");
	background-repeat: no-repeat;
	background-position: top center;
}

.login_title_wrap {
	width: 500px;
	color: #FFFFFF;
	text-align: center;
	background-color: #3e5fba;
	border: solid 1px #EFEFEF;
	font-weight: bold;
	height: 60px;
}

/* table셋팅 */
.content_table {
	width: 98%;
	border-bottom: 1px solid #EFEFEF;
	border-right: 1px solid #EFEFEF;
	border-collapse: collapse;	
	background-color:rgba(0, 0, 0, 0.5);
	margin-left: auto;
	margin-right: auto;
	clear: both;
}

.content_table td, .content_table th {
	text-align: center;
	border-top: 1px solid #EFEFEF;
	border-left: 1px solid #EFEFEF;
	padding: 0.3em;
}

.content_table th {
	background-color: #4D6BB3;
	color: #FFFFFF;
	line-height: 1.7em;
	font-weight: normal;
}

.content_table td {
	padding-left: 5px;
	text-align: left;
	line-height: 1.7em;
}

.content_table td.contents {
	width: 100%;
	height: 400px;
	overflow: auto;
}

.content_table th, .content_table td {
	vertical-align: middle;
}

.content_table select {
	height: 19px;
	border: #CCCCCC solid 1px;
	vertical-align: middle;
	line-height: 1.8em;
	padding-left: 0px;
}

.content_table select option {
	margin-right: 10px;
}
</style>
</head>
<body>

	<div id="main_wrap">
		<div id="middle_wrap">
			<div id="content_wrap">
				<div style="width: 502px; height: 166px; margin-left: auto; margin-right: auto; position: relative; top: 100px;">
					<div class="login_title_wrap">
						<div style="margin-top: 12px;">
							<h2>홈페이지 제목</h2>
						</div>
					</div>

					<div id="login_wrap">
						<form action="loginAf.do" name="frmForm" id="_frmForm" method="POST">
							<table class=content_table style="width:75%;">
								<colgroup>
									<col style="width:30%;">
									<col style="width:70%;">
								</colgroup>
								<tbody>
									<tr>
										<th style="background-color: #eeeeee; color:#3e5fba">
											ID
										</th>
										<td>
											&nbsp; 
											<input type="text" id="_userid" name="id" value="" data-msg="ID를" size="15" title="아이디" style="border:1px solid #dddddd;">
											<input type="checkbox" id="_chk_save_id"> remind this id? 
										</td>
									</tr>	
									<tr>
										<th style="background-color: #eeeeee; color:#3e5fba">
											PASSWORD
										</th>
										<td>
											&nbsp; 
											<input type="password" id="_pwd" name="pwd" data-msg="Password를 "size="15" title="패스워드" style= "border: 1px solid #dddddd;">
										</td>
									</tr>
									<tr>
										<td colspan="2" style="height: 50px; text-align: center;">
											<span>
												<a href="#none" id="_btnLogin" title="로그인">
													<img alt="Sign in" src="image/login_btn.jpg">
												</a>
												<a href="#none" id="_btnRegi" title="회원가입">
													<img alt="Sign up" src="image/regi.jpg">
												</a>
											</span>
										</td>
								</tbody>
							</table>
						
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	
	
<script type="text/javascript">
$("#_btnLogin").click(function() {
	alert("id:" + $("#_userid").val());
	if($("#_userid").val() == ""){		
		alert($("#_userid").attr("data-msg") + " 입력해 주십시오" );
		$("#_userid").focus();
	} else if($("#_pwd").val() == ""){
		alert($("#_pwd").attr("data-msg") + " 입력해 주십시오" );
		$("#_pwd").focus();
	} else{
		$("#_frmForm").attr("target", "_self").submit();
	}	
});

$("#_btnRegi").click(function() {
	location.href = "regi.do";
});

$("#_userid").keypress(function(event) {
	if(event.which == "13"){
		event.preventDefault();
		$("#_pwd").focus();
	}
});

$("#_pwd").keypress(function() {
	if(event.which == "13"){
		event.preventDefault();
		$("#_btnLogin").click();
	}
});

// id저장
var user_id = $.cookie("user_id");
if(user_id != null){
	$("#_userid").val(user_id);
	$("#_chk_save_id").attr("checked", true);
}

$("#_chk_save_id").click(function() {		
	if($('input:checkbox[id="_chk_save_id"]').is(":checked")){
		if($("#_userid").val() == ""){
			$(this).prop("checked", false);
			alert("아이디를 입력해 주십시오");
		}else{
			$.cookie("user_id", $("#_userid").val(), { expires: 7, path: '/' });
		}		
	}else{
		$.removeCookie("user_id", {path:'/'});
	}
});



</script>

</body>
</html>