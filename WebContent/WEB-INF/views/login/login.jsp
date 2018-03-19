<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery.cookie.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css"/>

<style type="text/css">
#login_wrap {
	margin:10px;
}
#login_wrap th {
	font-weight:bold;
}
#main_wrap { 
	width:800px; 
	margin-left:auto; 
	margin-right:auto; padding:0px; 
}			
#content_wrap { 
	width: 100%; 
	height: 500px; 
	background-image:url("image/backa.jpg"); 
	background-repeat:no-repeat; 
	background-position:top center;  
}
			
.login_title_warp {
	width:500px; 
	color:#FFFFFF; 
	text-align:center; 
	background-color:#3e5fba; 
	border:solid 1px #EFEFEF; 
	font-weight:bold; 
	height:60px;
}

/* table셋팅 */
.content_table { width:98%; border-bottom:1px solid #EFEFEF; border-right:1px solid #EFEFEF; border-collapse:collapse; margin-left:auto; margin-right:auto;  clear:both; }
.content_table td, .content_table th { text-align:center; border-top:1px solid #EFEFEF; border-left:1px solid #EFEFEF; padding:0.3em; }
.content_table th { background-color:#4D6BB3; color:#FFFFFF; line-height: 1.7em; font-weight:normal;}
.content_table td { padding-left:5px; text-align:left; line-height: 1.7em; }
.content_table td.contents { width:100%; height:400px; overflow:auto; }
.content_table th, .content_table td { vertical-align:middle; }

.content_table select { height:19px; border:#CCCCCC solid 1px; vertical-align:middle; line-height: 1.8em; padding-left:0px; }
.content_table select option { margin-right:10px; }

</style>
</head>
<body>

<div id="main_wrap">
	<div id="middle-wrap">
		<div id="content-wrap">
		
		</div>
	</div>
</div>

</body>
</html>