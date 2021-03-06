<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
   <input type="button"onclick="location.href='in'" value="店舗登録" class="basic_btn">
    <a href="/logout" class="button">ログアウト</a>
    <p class="name">${Username}さんこんにちは</p>
    <h2 class="">ぐるなび沖縄版</h2>
    
   <div class="home_form">
   
    <p class="error"></p>
  

    <form method="get" action="/search">
        <div class="home_search">
          <input type="text" size="25" placeholder="店名" name="key">
          <input type="submit" value="検索" >
        
            <div class="order">
    
              <select class="base-text" name="category" >
                <option>ジャンル</option>
                <option value="沖縄食堂">沖縄食堂</option>
                <option value="沖縄居酒場">沖縄居酒場</option>
                <option value="ステーキ">ステーキ</option>
                <option value="タコス・タコライス">タコス・タコライス</option>
                <option value="沖縄そば">沖縄そば</option>
                <option value="沖縄スイーツ">沖縄スイーツ</option>
              </select>         
              <select class="base-text" name="area" >
                <option>エリア</option>
                <option value="北部">北部</option>
                <option value="中部">中部</option>
                <option value="南部">南部</option>
              </select>         
            </div>
          </div>
           </form>   
  </div>
</div>
<hr>
   <c:forEach var="shop" items="${list}">
        <table>


  <tr>
    <th>会社名</th>
    <td>${fn:escapeXml(shop.getShopName())}</td>
 </tr>
  <tr>
    <th>ジャンル</th>
    <td>${fn:escapeXml(shop.getCategory())}</td>
  </tr>
  <tr>
    <th>エリア</th>
    <td>${fn:escapeXml(shop.getArea())}</td>
  </tr>
  <tr>
    <th>電話番号</th>
    <td>${fn:escapeXml(shop.getTelnumber())}</td>
  </tr>
          <tr>
       <td colspan="2" class="syousai"><a class="button2" href="/shop?name=${shop.getShopName()} ">店舗ページ</a><p>      </p></td>
       
  </tr>

</table>

      </c:forEach>



</body>
</html>