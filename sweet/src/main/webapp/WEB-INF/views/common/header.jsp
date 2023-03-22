<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<style>
header {
	background-color: beige;
}
</style>
<html>
<link rel="stylesheet" href="${contextPath}/resources/css/header.css">
<body>
	<header>

		<nav>
			<ul>
				<a href="#"><img
					src="${contextPath}/resources/image/main_logo.png" /></a>
				<li><a href="#">신축분양</a></li>
				<li><a href="#">매매/전월세</a></li>
				<li><a href="#">부동산/포장이사</a></li>
				<li><a href="#">관심목록</a></li>
				<li><a href="#">커뮤니티</a></li>
				<li><a href="#">고객센터</a></li>
				<li><a href="#">날씨정보</a></li>

				<c:choose>
					<c:when test="${isLogOn == true}">
						<h2>
							<c:choose>
								<c:when test="${not empty member}">${member.name} 님! 로그인을 환영합니다.</c:when>
								<c:otherwise>${memberB.name} 님! 로그인을 환영합니다.</c:otherwise>
							</c:choose>
						</h2>
						<c:if test="${isLogOn == true and member.member_id == 'admin'}">
							<a href="#">관리자페이지</a>
						</c:if>
						<c:if test="${isLogOn == true and member.member_id != 'admin' }">
							<c:choose>
								<c:when test="${not empty member}">
									<a href="${contextPath}/member/myPageMain">마이페이지</a>
								</c:when>
								<c:otherwise>
									<a href="${contextPath}/memberB/myPageMainB">사업자페이지</a>
								</c:otherwise>
							</c:choose>
						</c:if>
						<br>
						<br>
						<a href="${contextPath}/member/logout.do">로그아웃</a>
					</c:when>
					<c:otherwise>
						<button class="btnon" method="POST"
							onclick="location.href = '${contextPath}/member/loginForm.do'">로그인</button>
						<button class="btnon" type="submit" method="POST"
							onclick="location.href = '#'">회원가입</button>
					</c:otherwise>
				</c:choose>

			</ul>
		</nav>

	</header>
</body>
</html>