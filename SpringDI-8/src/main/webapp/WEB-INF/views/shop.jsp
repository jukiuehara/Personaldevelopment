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
		<h1>${shop.getShopName() }</h1>
		<br>
		<h3>電話番号：${shop.getTelnumber()}</h3>
		<div class="user">
			<p class="user_name">${User.getName()}</p>

						<p>${msg}</p>
		<form method="get" action="/reserve">
        <div class="home_search">
          <input type="text" size="25" placeholder="店舗パスワード" name="pass">
          <input type="submit" value="店舗ページ"class="basic_btn" >
          </div>
           </form>  
			 <a href="/index" class="button">ログアウト</a>
		</div>
	</div>

	<hr>


	<div class="update">
		<div class="form_body">
			<div class="img_block">
				<img src="./images/loginlogo.png" class="product_img"><br>

				


			</div>
			<form>

				<h3>エリア：${shop.getArea() }</h3>
				<h3>ジャンル:${shop.getCategory() }</h3>

				<p>${shop.getDescription()}</p>

				<div></div>
				<div class="btns">
				<input type="button" onclick="location.href='yoyaku'" value="予約"
					class="yoyaku_btn">
					<input type="button" onclick="location.href='back'" value="戻る"
						class="cancel_btn">
				</div>
			</form>


		</div>
	</div>

	<div id="fadeLayer"></div>
	<script src="./js/commons.js"></script>
</body>
</html>
