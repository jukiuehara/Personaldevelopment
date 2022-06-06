<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link href="css/gurume.css" rel="stylesheet">
</head>
<body class="login_body">
  <div class="header">
    <h1 class="site_logo">ぐるなび沖縄版</h1>
  </div>
  <div class="login_form">
    <img src="./images/loginlogo.png" class="login_logo">
    <p class="error"></p>

    <form:form action="rogin" modelAttribute="shop">
      <fieldset>
        <div class="cp_iptxt">
          <form:input class="base_input" type="text" path="id" placeholder="ID"/>
          <form:errors path="id" cssStyle="color: red"/>
        </div>
        <div>
          <form:input class="base_input" type="password" path="pass" placeholder="PASS"/>
		<form:errors path="pass" cssStyle="color: red"/>
		<p>${msg}</p>
        </div>
      </fieldset>
      <button class="logout_btn" type="submit">ログイン</button>
    </form:form>
  </div>
</body>
</html>