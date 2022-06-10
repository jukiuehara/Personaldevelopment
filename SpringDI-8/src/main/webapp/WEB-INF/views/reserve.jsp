<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗マイページ</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<h1>${shop.getShopName()}</h1><h1>マイページ</h1>

 <a href="/logout" class="button3">ログアウト</a>


<hr>
<div class="my">
<input type="button"onclick="location.href='up'" value="店舗更新" class="basic_btn">
<input type="button" onclick="openModal()" value="店舗削除"class="basic_btn">
<input type="button" onclick="location.href='reservationtable'" value="予約表"class="basic_btn">

								
<input type="button" onclick="location.href='shop2'" value="戻る"class="cancel_btn">
		</div>
				<form:form action="/edit">
		<div id="modal">
			<p class="modal_message">本当に店舗を削除しますか？</p>
			<div class="btns">
				<button type="submit" class="basic_btn">削除</button>
				<button type="button" onclick="closeModal()" class="cancel_btn">キャンセル</button>
			</div>
		</div>
	</form:form>
	<div id="fadeLayer"></div>
	<script src="./js/commons.js"></script>
</body>
</html>
