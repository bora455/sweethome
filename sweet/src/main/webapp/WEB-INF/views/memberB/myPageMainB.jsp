<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

<link rel="stylesheet" href="resources/css/memberB/goodsList.css?after" type="text/css">

<script>
function goodsList() {
	location.href = "./goodsList";
}
function goodsDetail() {
	location.href = "./goodsDetail";
}
function contractList() {
	location.href = "./contractList";
}
function QList() {
	location.href = "./QList";
}
</script>

</head>
<body>
<div>
    <h1>마이페이지</h1>
</div>
	<div class="myPageCategory">
		<h2>최근 인기 매물</h2>
		<button id="plus" onclick="goodsList()">+</button>
	</div>
	<div>
        <img src="#" alt="상품1" onclick="goodsDetail()">
        <img src="#" alt="상품2" onclick="goodsDetail()">
        <img src="#" alt="상품3" onclick="goodsDetail()">
    </div>
    
    <hr>
    
    <div class="myPageCategory">
		<h2>최근 계약 내역</h2>
		<button id="plus" onclick="contractList()">+</button>
	</div>
	<div>
        <img src="#" alt="상품1" onclick="goodsDetail()">
        <img src="#" alt="상품2" onclick="goodsDetail()">
        <img src="#" alt="상품3" onclick="goodsDetail()">
    </div>
    
    <hr>
    
    <div class="myPageCategory">
		<h2>최근 문의 내역</h2>
		<button id="plus" onclick="QList()">+</button>
	</div>
	<div>
        <img src="#" alt="상품1" onclick="goodsDetail()">
        <img src="#" alt="상품2" onclick="goodsDetail()">
        <img src="#" alt="상품3" onclick="goodsDetail()">
    </div>
</body>
</html>