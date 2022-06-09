<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

		<table>


			<tr>
				<th>予約時間</th>
				<th>人数</th>
				<th>名前</th>
				<th>予約日</th>
			</tr>
				<c:forEach var="table" items="${table}">
			<tr>
				<td>${table.getrTime()}</td>

				<td>${table.getNumber()}</td>

				<td>${table.getrName()}</td>

				<td>${table.getrDate()}</td>
			</tr>
				</c:forEach>

		</table>



	<input type="button" onclick="location.href='reserveback'" value="戻る"
		class="cancel_btn">


</body>
</html>