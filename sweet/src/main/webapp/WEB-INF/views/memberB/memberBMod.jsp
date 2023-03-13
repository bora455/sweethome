<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=3.0">
<title>회원정보수정</title>
<link rel="stylesheet" href="resources/css/memberB/memberBMod.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"> 
</script> 
</head>

<body> 
  <div class="d-div" style="padding:20px;">
  <div class="sign">
    <h3 style="margin-right:30px;">회원구분</h3>
    <input type="radio" name="radio"> <h5 style="padding:0px; margin-right:20px;">개인회원</h5>
    <input type="radio" checked name="radio"> <h5 style="padding:0px;">기업회원</h5>
    <hr class="hr1">
    <br>
    <h3>기본정보</h3>
     <hr class="hr1">
   <div class="sign-text">
    <h5 style="line-height:3em;">아이디<span style="color:red;">*</span></h5>
    </div>
    <div class="sign-input">
      <input type="text" class="ia">
      (영문 소문자/숫자 , 4~16자)
    </div>
    <hr class="hr2">
    <div class="sign-text">
     <h5 style="line-height:2.5em;">비밀번호<span style="color:red;">*</span></h5>
    </div>
    <div class="sign-input">
    <input type="password"  class="ia">(영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 10자~16자)
    </div>
    <hr class="hr2">
    <div class="sign-text">
     <h5 style="line-height:2.5em;">비밀번호 확인<span style="color:red;">*</span></h5>
    </div>
    <div class="sign-input">
    <input type="password"  class="ia">
    </div>
    <hr class="hr2">
    <div class="sign-text">
     <h5 style="line-height:2.5em;">이름<span style="color:red;">*</span></h5>
    </div>
    <div class="sign-input">
      
    <input type="text"  class="ia">
    </div>
    <hr class="hr2">
    <div class="sign-text">
    <h5 style="line-height:8.5em;">주소<span style="color:red;">*</span></h5>
    </div>
    <div class="sign-input">
    <input type="text" class="ib">&nbsp;-&nbsp;
    <a class="d-button">우편번호</a>
    <br>
    <input type="text"  class="ia" style="margin-top:10px; width:300px;"> 기본주소
    <br>
    <input type="text"  class="ia" style="margin-top:10px;
width:300px;"> 상세주소
    </div>
    <hr class="hr2">
    <div class="sign-text">
    <h5 style="line-height:1.7em;">일반전화</h5>
    </div>
    <div class="sign-input">
    <select>
      <option>02</option>
      <option>070</option>
    </select>
    &nbsp;-&nbsp;
    <input type="text" class="ib"> &nbsp;-&nbsp;
    <input type="text" class="ib">   
    </div>
    <hr class="hr2">
    <div class="sign-text">
     <h5 style="line-height:1.7em;">휴대전화<span style="color:red;">*</span></h5>
    </div>
    <div class="sign-input">
    <select>
      <option>010</option>
      <option>011</option>
      <option>016</option>
    </select>
    &nbsp;-&nbsp;
    <input type="text" class="ib">
    &nbsp;-&nbsp;
     <input type="text" class="ib">
    </div>
    <hr class="hr2">
    <h3 style="line-height:2em;">추가정보</h3>
     <hr class="hr1" style="margin:10px auto 10px;">
    <br>
    <div class="sign-text">
     <h5>생년월일<span style="color:red;">*</span></h5>
    </div>
    <div class="sign-input">
    <input type="text" class="ib">&nbsp;년&nbsp;
    <input type="text" class="ib">&nbsp;월&nbsp;
    <input type="text" class="ib">&nbsp;일&nbsp;
     <input type="radio" name="radio"> <h5 style="padding:0px; margin-right:20px;">양력</h5>
    <input type="radio" checked name="radio"> <h5 style="padding:0px;">음력</h5>
    </div>
    <hr class="hr2">
    </div>
  </div>
  
         <div class="d-div">
        	<div class="sign-button">
             <button class="d-button">수정하기</button>
             <button class="d-button">돌아가기</button>
           </div>
         </div>
  </body>
</html>
