<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

	<div class="header">
		<h2>${shop.getShopName() }</h2>
		<h3>電話番号：${shop.getTelnumber()}</h3>
		<div class="user">
			<p class="user_name">${User.getName()}</p>


			<input type="button" onclick="openModal()" value="店舗削除"
				class="basic_btn"> <a href="/index" class="button">ログアウト</a>
		</div>
	</div>

	<hr>


	<div class="update">
		<div class="form_body">
			<div class="img_block">
				<img src="./images/loginlogo.png" class="product_img"><br>

				<input type="button" onclick="location.href='yoyaku'" value="予約"
					class="cancel_btn">


			</div>
			<form>

				<h3>エリア：${shop.getArea() }</h3>
				<h3>ジャンル:${shop.getCategory() }</h3>

				<p>${shop.getDescription()}</p>

				<div></div>
				<div class="btns">
					<input type="button" onclick="location.href='back'" value="戻る"
						class="cancel_btn">
				</div>
			</form>







		</div>
	</div>
	<form:form action="/edit">
		<div id="modal">
			<p class="modal_message">削除しますか？</p>
			<div class="btns">
				<button type="submit" class="basic_btn">削除</button>
				<button type="button" onclick="closeModal()" class="cancel_btn">キャンセル</button>
			</div>
		</div>
	</form:form>
	<div id="fadeLayer"></div>
</body>
</html>
<script src="./js/commons.js"></script>