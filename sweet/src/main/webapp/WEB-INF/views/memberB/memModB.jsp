<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=3.0">
<title>회원정보수정</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"> 
</script> 
</head>

<style>
.memberBMod {
margin-top: 200px;
}

h3 {  
font-size: 4em;   
line-height: 0.5em;  
display:inline;
}  
  
h4 {  
font-size: 3em;   
line-height: 0.5em;  
display:inline;
}  
  
h5 {  
font-size: 2em;   
line-height: 0.1em;  
display:inline;
}  
  
small {
font-size: 0.5em;   
line-height: 1.0em;  
display: block;
}
  
a{color:#000; text-decoration:none}  /* a:link a tag 기본 */
a:hover {color:#000}   /* 마우스오버 link*/
a:active {color:#000}  /* 선택된 link*/
a:visited {color:#000}

/*d*/
ul li {
list-style: none;/*텍스트가로정렬*/
display: inline;
}

/*회원구분+가입양식*/
.sign{
  border:0px solid blue;
  margin:0 auto;
  
}
.sign h3{
  font-size:1.5em;  
  padding:20px;
  line-height:2em;

}
.sign h5{
  font-size: 1.2em;
  line-height:2em;
}

.hr1{
  margin:20px auto 10px; border:1px solid black;
  padding: 0px;
  width: 1000px;
}
.hr2{
  margin:15px auto 15px;
  width: 1000px;
}

.sign-text{
  border:px solid red;
  float:left;
  
}
.sign-input{
  border:0px solid black;
  width:800px;
  margin: auto;
  padding:0px;
  
}
.sign-input .d-button{
  padding:0px;
  margin:0px;
  border:1px solid #ccc;
  width:50px;
  height:10px;
  position:relative;
  top:2px;
  line-height:1em;
  cursor: pointer;
}
.ia{
  padding:10px;
  margin-right:15px;
}
.ib{
  padding:6px;
  width:50px;
  height:15px;  
}
.sign select{
  padding:6px;
}

/*체크박스 설정*/

/* 체크박스 요소 스타일 */
input[type="checkbox"] + label {
  display: inline-block;
  width: 20px;
  height: 20px;
  border: 1px solid #666;
  cursor: pointer;
  position: relative;
  top: 5px;
  left: 5px;
  margin-right: 8px;
}

/* 체크박스가 선택되었을 때의 스타일 */
input[type="checkbox"]:checked + label {
  background-color: #666666;
}

/* 우편번호 찾기 버튼 */
#zipcode {
  background-color: #4285F4;
  color: #FFF;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

/* 우편번호 검색 팝업창 */
#zipcode-modal {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0,0,0,0.5);
  display: none;
  z-index: 9999;
}

#zipcode-modal .modal-content {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: #FFF;
  padding: 20px;
  border-radius: 3px;
}

#zipcode-modal .modal-content h2 {
  margin-top: 0;
  font-size: 24px;
  font-weight: bold;
}

#zipcode-modal .modal-content form {
  margin-bottom: 20px;
}

#zipcode-modal .modal-content label {
  display: block;
  margin-bottom: 10px;
}

#zipcode-modal .modal-content input[type="text"] {
  padding: 10px;
  font-size: 16px;
  border-radius: 3px;
  border: 1px solid #CCC;
}

#zipcode-modal .modal-content input[type="submit"] {
  padding: 10px;
  background-color: #4285F4;
  color: #FFF;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

#zipcode-modal .close {
  position: absolute;
  top: 10px;
  right: 10px;
  font-size: 20px;
  font-weight: bold;
  color: #666;
  cursor: pointer;
}

/* 수정, 삭제버튼 */
.btn {
background-color: #112d4e;
border: none;
border-radius: 4px;
color: #fff;
cursor: pointer;
font-size: 1rem;
margin-top: 1rem;
padding: 0.5rem 1rem;
}

.btn:hover {
background-color: #3e8e41;
}
</style>

<script>
/* 기업회원이 체크된 상태 */
window.onload = function() {
  document.getElementById("radio").checked = true;
};

/* 우편번호 찾기 */
// 버튼을 누르면 우편번호 검색 팝업창을 띄우는 함수
function openZipcodePopup() {
  window.open('우편번호 검색 팝업창 URL', '우편번호 검색', 'width=500, height=600');
}

// 버튼 클릭 이벤트 처리
var zipcode = document.getElementById('zipcode');
zipcode.addEventListener('click', openZipcodePopup);

</script>

<body> 
<div>
    <h1>회원정보수정</h1>
</div>

<div>
	<div class="sign">
		<h3>회원구분</h3>

		<input type="radio" name="radio" disabled />
		<h5>개인회원</h5>

		<input type="radio" id="radio" name="radio" checked> <label
			for="radio"><h5>기업회원</h5></label>

		<hr class="hr1">
		<br>



		<h3>기본정보</h3>
		<hr class="hr1">

			<div class="sign-text">
				<h5 style="line-height: 3em;">아이디</h5>
			</div>
			<div class="sign-input">
				<input type="text" class="ia" id="bp_id" name="bp_id" value="${memberB.bp_id}" readonly>
			</div>

			<hr class="hr2">

		<div class="sign-text">
			<h5 style="line-height: 2.5em;">
				비밀번호<span style="color: red;">*</span>
			</h5>
		</div>

		<div class="sign-input">
			<input type="password" class="ia"> (영문 대소문자/숫자/특수문자 중 2가지
			이상조합, 10자~16자)
		</div>
		<hr class="hr2">

		<div class="sign-text">
			<h5 style="line-height: 2.5em;">
				비밀번호 확인<span style="color: red;">*</span>
			</h5>
		</div>

		<div class="sign-input">
			<input type="password" class="ia">
		</div>
		<hr class="hr2">

		<div class="sign-text">
			<h5 style="line-height: 2.5em;">이름</h5>
		</div>

		<div class="sign-input">
			<input type="text" class="ia">
		</div>
		<hr class="hr2">

		<div class="sign-text">
			<h5 style="line-height: 8.5em;">주소</h5>
		</div>

		<div class="sign-input">
			<input type="text" class="ib">&nbsp;-&nbsp; <input
				type="text" class="ib">&nbsp;&nbsp;
			<button id="zipcode" onclick="openZipcodePopup()">우편번호찾기</button>
			<br> <input type="text" class="ia"
				style="margin-top: 10px; width: 300px;"> 기본주소 <br> <input
				type="text" class="ia" style="margin-top: 10px; width: 300px;">
			상세주소
		</div>
		<hr class="hr2">

		<div class="sign-text">
			<h5 style="line-height: 1.7em;">일반전화</h5>
		</div>
		<div class="sign-input">
			<select>
				<option>02</option>
				<option>070</option>
			</select> &nbsp;-&nbsp; <input type="text" class="ib"> &nbsp;-&nbsp;
			<input type="text" class="ib">
		</div>
		<hr class="hr2">

		<div class="sign-text">
			<h5 style="line-height: 1.7em;">휴대전화</h5>
		</div>
		<div class="sign-input">
			<select>
				<option>010</option>
				<option>011</option>
				<option>016</option>
			</select> &nbsp;-&nbsp; <input type="text" class="ib"> &nbsp;-&nbsp;
			<input type="text" class="ib">
		</div>

		<hr class="hr1">
		<h3>추가정보</h3>
		<hr class="hr1">
		<br>


		<div class="sign-text">
			<h5>생년월일</h5>
		</div>
		<div class="sign-input">
			<input type="text" class="ib">&nbsp;년&nbsp; <input
				type="text" class="ib">&nbsp;월&nbsp; <input type="text"
				class="ib">&nbsp;일&nbsp; <input type="radio" name="radio">
			<h5 style="padding: 0px; margin-right: 20px;">양력</h5>
			<input type="radio" checked name="radio">
			<h5 style="padding: 0px;">음력</h5>
		</div>
		<hr class="hr2">
	</div>

	<br> <br> <br>

	<div>
		<button class="btn" type="submit" onclick="location.href = './myPageMainB'">취소</button>
		<button class="btn" type="submit">수정완료</button>
	</div>
</div>
 </body>
</html>
