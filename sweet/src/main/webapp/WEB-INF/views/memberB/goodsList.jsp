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
    <title>상품관리 페이지</title>
    <link rel="stylesheet" href="webapp/resources/css/memberB/goodsList.css?after" type="text/css">
  </head>
  
  <style>
  button {
  font-size: 16px;
  padding: 5px 10px;
  background-color: #112d4e;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin: 5px;
}
  </style>
  
  <script>
  function goodsDetail() {
		location.href = "./goodsDetail";
	}
  function goodsAdd() {
		location.href = "./goodsAdd";
	}
  function goodsMod() {
		location.href = "./goodsMod";
	}
  function goodsDel() {
		if(!confirm('삭제하시면 복구할 수 없습니다. \n정말로 삭제하시겠습니까?')){
			return false;
		}
  }
  </script>
  
  <body>
  	
    <h1>상품 조회</h1>
    <form>
      <label for="거래유형">거래유형:</label>
      <select id="거래유형" name="거래유형">
        <option value="">전체</option>
        <option value="매매">매매</option>
        <option value="전세">전세</option>
        <option value="월세">월세</option>
      </select>
      <br>
      <label for="상품유형">상품유형:</label>
      <select id="상품유형" name="상품유형">
        <option value="">전체</option>
        <option value="아파트">아파트</option>
        <option value="오피스텔">오피스텔</option>
        <option value="주택">주택</option>
      </select>
      <br>
      <button type="submit">검색</button>
    </form>
    
    <table style="border:1px solid black;margin-left:auto;margin-right:auto;">
      <thead>
        <tr>
          <th>이미지</th>
          <th>층 수</th>
          <th>크기</th>
          <th>위치</th>
          <th>처리상태</th>
          <th>수정</th>
      	  <th>삭제</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td><img src="#" alt="상품1" onclick="goodsDetail()"></td>
          <td>3층</td>
          <td>50㎡</td>
          <td>강남구 역삼동</td>
          <td><b>처리상태</b></td>
          <td><button onclick="goodsMod()">수정하기</button></td>
      	  <td><button onclick="goodsDel()">삭제하기</button></td>
        </tr>
        <tr>
          <td><img src="#" alt="상품2" onclick="goodsDetail()"></td>
          <td>5층</td>
          <td>70㎡</td>
          <td>서초구 반포동</td>
          <td><b>처리상태</b></td>
          <td><button onclick="goodsMod()">수정하기</button></td>
      	  <td><button onclick="goodsDel()">삭제하기</button></td>
        </tr>
        <tr>
          <td><img src="#" alt="상품3" onclick="goodsDetail()"></td>
          <td>2층</td>
          <td>80㎡</td>
          <td>송파구 잠실동</td>
          <td><b>처리상태</b></td>
          <td><button onclick="goodsMod()">수정하기</button></td>
      	  <td><button onclick="goodsDel()">삭제하기</button></td>
        </tr>
      </tbody>
       
    </table>
      
	<div class="row">
        <div class="col">
            <button onclick="goodsAdd()">등록하기</button>
        </div>
    </div>
  </body>
</html>
