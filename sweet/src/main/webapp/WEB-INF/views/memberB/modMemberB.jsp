<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("utf-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modMember.jsp</title>
<style type="text/css">

h3 {
  margin-bottom: 10px;
}

h5 {
  margin-left: 5px;
}

p {
  margin: 10px 0;
}

input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 5px;
  margin-bottom: 20px;
  font-size: 16px;
}

input[type="radio"] {
  margin-right: 5px;
}

label[for="radio"] {
  margin-left: 5px;
}

button#zipcode {
  padding: 10px;
  background-color: #ddd;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-left: 15px;
}

input[type="button"],
input[type="reset"] {
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-top: 20px;
}

input[type="button"]:hover,
input[type="reset"]:hover {
  background-color: #0069d9;
}

/* 수평선 스타일 */
.hr1 {
  border: none;
  height: 1px;
  background-color: #ddd;
  margin: 20px 0;
}

</style>
 
<script type="text/javascript">

function execDaumPostcode() {
	  new daum.Postcode({
	    oncomplete: function(data) {
	      // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	      // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
	      // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	      var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
	      var extraRoadAddr = ''; // 도로명 조합형 주소 변수

	      // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	      // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	      if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	        extraRoadAddr += data.bname;
	      }
	      // 건물명이 있고, 공동주택일 경우 추가한다.
	      if(data.buildingName !== '' && data.apartment === 'Y'){
	        extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	      }
	      // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	      if(extraRoadAddr !== ''){
	        extraRoadAddr = ' (' + extraRoadAddr + ')';
	      }
	      // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
	      if(fullRoadAddr !== ''){
	        fullRoadAddr += extraRoadAddr;
	      }

	      // 우편번호와 주소 정보를 해당 필드에 넣는다.
	      document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
	      document.getElementById('roadAddress').value = fullRoadAddr;
	      document.getElementById('jibunAddress').value = data.jibunAddress;

	      // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
	      if(data.autoRoadAddress) {
	        //예상되는 도로명 주소에 조합형 주소를 추가한다.
	        var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
	        document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

	      } else if(data.autoJibunAddress) {
	          var expJibunAddr = data.autoJibunAddress;
	          document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
	      } else {
	          document.getElementById('guide').innerHTML = '';
	      }
	      
	     
	    }
	  }).open();
	}

function fn_sub(obj){
	document.getElementById("i_id").disabled=false;
	obj.submit();
}
</script>

</head>
<body>

<form name="frm" method="post" action="${contextPath }/memberB/updateMemberB">
		<h1>회원 정보 수정</h1>
		<table align="center">
			<c:if test="${memberB != null }">
			
			<h3>회원구분</h3>

			<input type="radio" name="radio" disabled />
			<h5>개인회원</h5>

			<input type="radio" id="radio" name="radio" checked>
			<label for="radio"><h5>기업회원</h5></label>

			<hr class="hr1">
			<br>

			<tr>
				<td><p>아이디</p></td>
				<td><input type="text" name="bp_id" id="i_id" value="${memberB.bp_id }" readonly></td>
			</tr>
			<tr>
				<td><p>비밀번호</p></td>
				<td><input type="password" name="bp_pw" value="${memberB.bp_pw }"></td>
			</tr>
			<tr>
				<td><p>이름</p></td>
				<td><input type="text" name="name" value="${memberB.name }"></td>
			</tr>
			<tr>
				<td><p>이메일</p></td>
				<td><input type="text" name="email" value="${memberB.email }"></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input type="text" id="zipcode" name="zipcode" size="10"></td>
				<td><button onclick="execDaumPostcode()">우편번호찾기</button></td>
			</tr>
			<tr>
				<td id="roadAddress" ><p>기본 주소</p></td>
				<td><input type="text" name="addr1" value="${memberB.addr1 }"></td>
			</tr>
			<tr>
				<td><p>상세 주소</p></td>q
				<td><input type="text" name="addr2" value="${memberB.addr2 }"></td>
			</tr>
			<tr>
				<td><p>전화번호</p></td>
				<td><input type="text" name="tel1" value="${memberB.tel1 }"></td>
				<td><input type="text" name="tel2" value="${memberB.tel2 }"></td>
			</tr>
			<tr>
				<td><p>휴대전화</p></td>
				<td><input type="text" name="hp1" value="${memberB.hp1 }"></td>
				<td><input type="text" name="hp2" value="${memberB.hp2 }"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" onClick="fn_sub(this.form)" value="수정하기"><input type="reset"></td>
			</tr>
			</c:if>
		</table>
	</form>
 </body>
</html>
