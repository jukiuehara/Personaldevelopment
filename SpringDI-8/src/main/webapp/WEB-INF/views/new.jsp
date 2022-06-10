<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

	<div class="header">
		<h2 >
			<a href="menu.html">新規登録</a>
		</h2>

	</div>

	<hr>

	<div class="insert">
		<div class="discription">
			<p>
				新規登録情報を入力してください（<span class="required"></span>は必須です）
			</p>
		</div>

		<div class="form_body">
			<p class="error">${usermsg}</p>

			<form:form action="news" method="post" modelAttribute="new">
				<fieldset class="label-130">
					<div>
						<label class="required">ログインID</label>
						<form:input type="text" path="id" class="base-text" />
						<form:errors path="id" cssStyle="color: red" />

					</div>
					<div>
						<label class="required">パスワード</label>
						<form:input type="password" path="pass" class="base-text" />
						<form:errors path="pass" cssStyle="color: red" />
					</div>
					<div>
						<label class="required">名前</label>
						<form:input type="text" path="name" class="base-text" />
						<form:errors path="name" cssStyle="color: red" />
					</div>

				</fieldset>
				<div class="btns">
					<button type="button" onclick="openModal()" class="basic_btn">登録</button>
					<input type="button" onclick="location.href='index'" value="戻る"
						class="cancel_btn">
				</div>

				<div id="modal">
					<p class="modal_message">新規登録しますか？</p>
					<div class="btns">
						<button type="submit" class="basic_btn">登録</button>
						<button type="button" onclick="closeModal()" class="cancel_btn">キャンセル</button>
					</div>

				</div>
			</form:form>
		</div>
	</div>
	<div id="fadeLayer"></div>
</body>
</html>
<script src="./js/commons.js">
	
</script>