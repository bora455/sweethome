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
<script type="text/javascript">
var loopSearch=true;
function keywordSearch(){
	if(loopSearch==false)
		return;
 var value=document.frmSearch.searchWord.value;
	$.ajax({
		type : "get",
		async : true, //false인 경우 동기식으로 처리한다.
		url : "${contextPath}/goods/keywordSearch.do",
		data : {keyword:value},
		success : function(data, textStatus) {
		    var jsonInfo = JSON.parse(data);
			displayResult(jsonInfo);
		},
		/* error : function(data, textStatus) {
			alert("에러가 발생했습니다."+data); */
		},
		complete : function(data, textStatus) {
			//alert("작업을완료 했습니다");
			
		}
	}); //end ajax	
}


function displayResult(jsonInfo){
	var count = jsonInfo.keyword.length;
	if(count > 0) {
	    var html = '';
	    for(var i in jsonInfo.keyword){
		   html += "<a href=\"javascript:select('"+jsonInfo.keyword[i]+"')\">"+jsonInfo.keyword[i]+"</a><br/>";
	    }
	    var listView = document.getElementById("suggestList");
	    listView.innerHTML = html;
	    show('suggest');
	}else{
	    hide('suggest');
	} 
}

function select(selectedKeyword) {
	 document.frmSearch.searchWord.value=selectedKeyword;
	 loopSearch = false;
	 hide('suggest');
}
	
function show(elementId) {
	 var element = document.getElementById(elementId);
	 if(element) {
	  element.style.display = 'block';
	 }
	}

function hide(elementId){
   var element = document.getElementById(elementId);
   if(element){
	  element.style.display = 'none';
   }
}
</script>
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
				<c:when test="${isLogOn==true and not empty member }">
				
				<h2>${member.member_name} 님! 로그인을 환영합니다.!</h2>
				<c:if test="${isLogOn==true and member.member_id =='admin' }">
				<a href="#">관리자페이지</a>
				</c:if>
				<c:if test="${isLogOn==true and member.member_id !='admin' }">
				<a href="#">마이페이지</a>
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