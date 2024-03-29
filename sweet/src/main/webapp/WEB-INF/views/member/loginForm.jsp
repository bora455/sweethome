<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<style>
main {
	position: absolute;
	border: 2px #112d4e solid;
	padding: 20px;
}

h2 {
	text-align: center;
}

.top {
	display: flex;
	justify-content: space-between;
}

.hc {
	width: 260px;
	left: 0;
	right: 0;
	margin-top: 5px;
	margin-left: auto;
	margin-right: auto;
	margin-left: auto;
} /* 가로 중앙 정렬 */
input {
	box-sizing: border-box;
	font-family: 'Noto Sans KR', sans-serif;
	border-radius: 5px;
}

body {
	margin: 0;
	background-color: #FFFFFF;
}

.login-form {
	width: 300px;
	background-color: #EEEFF1;
	margin-right: auto;
	margin-left: auto;
	margin-top: 50px;
	padding: 20px;
	text-align: center;
	border: none;
}

.text-field {
	font-size: 14px;
	padding: 10px;
	width: 260px;
	margin-bottom: 10px;
	border: 1px #112d4e solid;
}

.links {
	text-align: center;
}

.links a {
	font-size: 12px;
	color: #112d4e;
}

.btnon1 {
	width: 260px;
	margin-top: 5px;
	background-color: #ffffff;
	color: #112d4e;
	border: 1px #112d4e solid;
}

.btnon1:hover {
	width: 260px;
	height: 35px;
	margin-top: 5px;
	border: none;
	border-radius: 4px;
	font-size: 13px;
	font-weight: bold;
	background-color: #112d4e;
	color: white;
}

.form_radio_btn {
	width: 120px;
	margin-top: 5px;
	background-color: #ffffff;
	border: 1px #112d4e solid;
	border-radius: 6px;
	font-size: 13px;
}

.form_radio_btn input[type=radio] {
	display: none;
}

.form_radio_btn label {
	display: block;
	border-radius: 10px;
	margin: 0 auto;
	text-align: center;
	height: -webkit-fill-available;
	line-height: 35px;
}

/* Checked */
.form_radio_btn input[type=radio]:checked+label {
	width: 120px;
	height: 35px;
	border: none;
	border-radius: 4px;
	font-size: 13px;
	font-weight: bold;
	background-color: #112d4e;
	color: white;
}

/* Hover */
.form_radio_btn label:hover {
	width: 120px;
	height: 35px;
	border: none;
	border-radius: 6px;
	font-size: 13px;
	font-weight: bold;
	background-color: #112d4e;
	color: white;
}

/* Disabled */
.form_radio_btn input[type=radio]+label {
	background: #F9FAFC;
	color: #666;
}
</style>

<body>

<main class="hc">
	<h2>로그인</h2>
	<hr>
	<div class="top">
		<div class="form_radio_btn">
			<input id="radio-1" type="radio" name="user" value="userC" checked>
			<label for="radio-1" onclick="location.href = '${contextPath}/member/loginForm.do'">사용자 로그인</label>
		</div>
		<div class="form_radio_btn" >
			<input id="radio-2" type="radio" name="user" value="userB">
			<label for="radio-2" onclick="location.href = '${contextPath}/memberB/loginFormB.do'">사업자 로그인</label>
		</div>
	</div>
	<div class="hc">
		<form id="loginForm" action="${contextPath}/member/login.do" method="post">
			<br> 
			<input type="text" name="member_id" class="text-field" placeholder="아이디"> 
			<input type="password" name="member_pw" class="text-field" placeholder="비밀번호"> 
			<input type="checkbox" />아이디 저장<br>
			<br>
			<br>
			<br>
			<button class="btnon btnon1" type="submit" id="loginBtn">로그인</button>
		</form>
		<br>
		<button class="btnon btnon1" onclick="location.href = '#'">회원가입</button>
		<br>
		<button class="btnon btnon1" onclick="location.href = '#'">아이디/비밀번호 찾기</button>
	</div>
</main>

</body>
</html>