<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>

<h1>회원 정보</h1>

<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>아이디</b></td>
      <td><b>비밀번호</b></td>
      <td><b>이름</b></td>
      <td><b>이메일</b></td>
      <td><b>가입일</b></td>
      <td><b>수정</b></td>
      <td><b>삭제</b></td>
   </tr>
   
 <c:forEach var="memberB" items="${businessList}" >     
   <tr align="center">
      <td>${memberB.bp_id}</td>
      <td>${memberB.bp_pw}</td>
      <td>${memberB.name}</td>
      <td>${memberB.email}</td>
      <td>${memberB.join_date}</td>
      <td><a href="${contextPath }/memberB/modMemberB?bp_id=${memberB.bp_id}">수정하기</a></td>
      <td><a href="#">삭제하기</a></td>
   </tr>
</c:forEach>
 
</table>
</body>
</html>
