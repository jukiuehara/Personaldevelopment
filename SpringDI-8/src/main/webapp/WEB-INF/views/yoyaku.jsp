<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<div class="header">
		<h1>
			予約フォーム
		</h1>
		<div class="user">
			<p class="user_name">${User.getName()}</p>
			<a href="/index" class="button">ログアウト</a>
		</div>
	</div>

	<hr>

	<div class="insert">
		<div class="discription">
			<p>
				予約情報を入力してください（<span class="required"></span>は必須です）
			</p>
		</div>

		<div class="form_body">
			<p class="error">${msg}</p>
	<form:form method="get" action="/yoyaku"  modelAttribute="yoyaku">
		<label> </label> 
		
			<div>
		<label class="required">名前</label>
			<form:input type="text" path="rName" class="base-text" />
		<form:errors path="rName" cssStyle="color: red" />

					</div>
					<div>
		<label class="required">人数</label>
			<form:input type="number" path="number" class="base-text" value="1"/>人
			<form:errors path="number" cssStyle="color: red" />
					</div>
					<div>
		<form:input type="date" path="date" /><form:errors path="date" cssStyle="color: red" />
		
		 </div>
					<div>
		<form:input type="time" path="times" value="9:00" min="10:00" max="22:00" /><form:errors path="times" cssStyle="color: red" />
							<div class="btns">
							</div>
					<button type="button" onclick="openModal()" class="yoyaku_btn">予約</button>
					<input type="button" onclick="location.href='shop2'" value="戻る"
						class="cancel_btn">
				</div>

				<div id="modal">
					<p class="modal_message">予約しますか？</p>
					<div class="btns">
						<button type="submit" class="basic_btn">予約</button>
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