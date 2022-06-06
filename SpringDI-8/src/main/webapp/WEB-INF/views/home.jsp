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
<body class="home_body">
  <div class="header">
    
     <img src="./images/homelogo.png" class="home_logo">
    
   </div>
   <div class="head">
    <a href="" class="button">ログアウト</a>
    <p class="name">${Username}さんこんにちは</p>
    <h2 class="">ぐるなび沖縄版</h2>
    
   <div class="home_form">
   
    <p class="error"></p>
  

    <form method="get" action="/menu">
        <div class="home_search">
          <input type="text" size="25" placeholder="店名" name="key">
          <input type="submit" value="&#xf002" >
        
            <div class="order">
    
              <select class="base-text" name="category" >
                <option>カテゴリ</option>
                <option value="dining">沖縄食堂</option>
                <option value="izakaya">沖縄居酒場</option>
                <option value="steak">ステーキ</option>
                <option value="tacos">タコス・タコライス</option>
                <option value="soba">沖縄そば</option>
                <option value="sweets">沖縄スイーツ</option>
              </select>         
              <select class="base-text" name="area" >
                <option>エリア</option>
                <option value="id">北部</option>
                <option value="category">中部</option>
                <option value="lowprice">南部</option>
              </select>         
            </div>
          </div>
           </form>   
  </div>
</div>



  <!-- <c:forEach var="car" items="${historyList}">
        <tr>
          <td>${car.getBodyColor()}</td>
        </tr>
      </c:forEach>
-->  
</body>
</html>