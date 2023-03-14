<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품상세 페이지</title>
    <link rel="stylesheet" href="webapp/resources/css/memberB/goodsDetail.css?after" type="text/css">
</head>

<script>
function goodsMod() {
	location.href = "./goodsMod";
}
function goodsDel() {
	if(!confirm('삭제하시면 복구할 수 없습니다. \n정말로 삭제하시겠습니까?')){
		return false;
	}
}
function goodsList() {
	location.href = "./goodsList";
}
</script>

<body>
<form>
<div>
    <div>
        <h1>상품 상세</h1>
    </div>

    <div>
        <form>
        <div>
        <label form="goods_img1">매물 사진</label>
        <input type="file" id="goods_img1" name="goods_img1" class="file-upload" accept="image/*" required multiple>
        </div>
            <div>
                <label form="goods_name">매물 이름</label>
                <input type="text" id="goods_name" name="goods_name">
            </div>
            <div>
                <label form="goods_floor">건물 층수</label>
                <input type="text" id="goods_floor" name="goods_floor">
            </div>
            <div>
                <label form="goods_area">공급 면적</label>
                <input type="text" id="goods_area" name="goods_area">
            </div>
            <div>
                <label form="goods_adr">주소</label>
                <input type="text" id="goods_adr" name="goods_adr">
            </div>

            <hr>
            
            <div class="row">
				<div class="col">
					<button type="button" onclick="goodsMod()">수정하기</button>
				</div>
				<div class="col">
					<button type="button" onclick="goodsDel()">삭제하기</button>
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