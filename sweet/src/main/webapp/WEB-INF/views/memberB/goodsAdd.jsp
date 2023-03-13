<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>상품등록 페이지</title>
    <link rel="stylesheet" href="resources/css/memberB/goodsAdd.css" type="text/css">
</head>

<script>
function goodsList() {
	location.href = "./goodsList";
}
</script>
  
<body>
<div>
    <div>
        <h1>상품 등록</h1>
    </div>

    <div>
        <form>
        <div>
        <label form="goods_img1">매물 사진</label>
        <input type="file" id="goods_img1" name="goods_img1" class="file-upload" accept="image/*" required multiple>
        </div>
            <div>
                <label form="goods_name">매물 이름</label>
                <input type="text" id="goods_name" name="goods_name" placeholder="이름을 입력하세요">
            </div>
            <div>
                <label form="goods_floor">건물 층수</label>
                <input type="text" id="goods_floor" name="goods_floor" placeholder="층수를 입력하세요">
            </div>
            <div>
                <label form="goods_area">공급 면적</label>
                <input type="text" id="goods_area" name="goods_area" placeholder="공급 면적을 입력하세요">
            </div>
            <div>
                <label form="goods_adr">주소</label>
                <input type="text" id="goods_adr" name="goods_adr" placeholder="주소을 입력하세요">
            </div>

            <hr>
            
            <div class="row">
                <div class="col">
                    <button type="submit">등록완료</button>
                </div>
                <div class="col">
                    <button type="button" onclick="goodsList()">목록으로</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>