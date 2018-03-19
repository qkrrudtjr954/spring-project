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

<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery.cookie.js"></script>
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
							<h2>회원 가입</h2>
						</div>
					</div>

					<div id="login_wrap">
						<form action="" name="frmForm" id="_frmForm" method="POST">
							
							<table class="content_table" style="width:75%;">
								<colgroup>
									<col style="width:30%">
									<col style="width:70%">
								</colgroup>
								<tbody>
								
								<tr>
									<th>ID check</th>
									<td>
										<input type="text" name="sid" id="_id" size="30">
										<a href="#none" id="_btnGetId" title="회원가입">
											<img alt="회원 가입" src="image/idcheck.png">
										</a>
										<div id="_rgetid"></div>
									</td>
								</tr>
								
								<tr>
									<th>ID</th>
									<td>
										<input type="text" name="id" id="_userid" size="30" data-msg="아이디" readonly="readonly">
									</td>
								</tr>
								<tr>
									<th>PASSWORD</th>
									<td>
										<input type="password" name="pwd" id="_pwd" size="30" data-msg="비밀번호">
									</td>
								</tr>
								<tr>
									<th>NAME</th>
									<td>
										<input type="password" name="name" id="_name" size="30" data-msg="이름">
									</td>
								</tr>
								<tr>
									<th>EMAIL</th>
									<td>
										<input type="email" name="email" id="_email" size="30" data-msg="이메일">
									</td>
								</tr>
								<tr>
									<td colspan="2" style="height: 50px; text-align:center;">
										<a href="#none" id="_btnLogin" title="로그인">
											<img alt="로그인" src="image/login_btn.jpg">
										</a>
										<a href="#none" id="_btnRegi" title="회원가입">
											<img alt="회원가입" src="image/regi.jpg">
										</a>
									</td>
								</tr>
								</tbody>
							</table>
						
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$('#_btnLogin').click(function () {
			location.href = "login.do";
		});
		
		$("#_btnLogin").click(function() {
			alert("id:" + $("#_userid").val());
			if($("#_userid").val() == ""){		
				alert($("#_userid").attr("data-msg") + " 입력해 주십시오" );
				$("#_userid").focus();
			} else if($("#_pwd").val() == ""){
				alert($("#_pwd").attr("data-msg") + " 입력해 주십시오" );
				$("#_pwd").focus();
			} else if($("#_name").val() == ""){
				alert($("#_name").attr("data-msg") + " 입력해 주십시오" );
				$("#_name").focus();
			} else if($("#_email").val() == ""){
				alert($("#_email").attr("data-msg") + " 입력해 주십시오" );
				$("#_email").focus();
			} else{
				$("#_frmForm").attr("target", "_self").submit();
			}	
		});
		
		$('#_btnGetId').on('click', function () {
			var _id = $('#_id').val();
			if(_id == '' ){
				alert('아이디를 입력해주세요.');
				$('#_id').focus();
			} else {
				idCheckFunc(_id);
			}
		})
		
		function idCheckFunc(id) {
			/* alert('아이디를 체크합니다.') */
			$.ajax({
				url: 'getID.do',
				type: 'POST',
				async : true,
				data : {id : id},
				success : function (msg) {
					alert(msg);
					idCheckMessage(msg, id);
				}
			})
		}
		
		function idCheckMessage(msg, id) {
			if(msg.message=='success'){
				$('#_rgetid').html('<span>사용할 수 없는 아이디 입니다.</span>');
				$('#_rgetid span').css('color', 'red');
				
				$('#_userid').val('');
			} else {
				$('#_rgetid').html('<span>사용할 수 있는 아이디 입니다.</span>');
				$('#_rgetid span').css('color', 'green');
				
				$('#_userid').val(id);
			}
		}
	</script>
</body>
</html>