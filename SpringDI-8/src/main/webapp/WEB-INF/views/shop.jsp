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
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.2.0/chart.min.js"
  integrity="sha512-VMsZqo0ar06BMtg0tPsdgRADvl0kDHpTbugCBBrL55KmucH6hP9zWdLIWY//OTfMnzz6xWQRxQqsUFefwHuHyg=="
  crossorigin="anonymous"></script>
<script
  src="https://cdn.jsdelivr.net/npm/chartjs-adapter-date-fns@next/dist/chartjs-adapter-date-fns.bundle.min.js"></script>
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
			 <a href="/logout" class="button">ログアウト</a>
		</div>
	</div>

	<hr>


	<div class="update">
		<div class="form_body">
			<div class="img_block">
<div style="width:400px">
  <canvas id="mychart"></canvas>
</div>
<div class="gurafu">
<p> "" </p>
<p>  ""</p>
<p>  "" </p>
<p>""  </p>
</div>
<script>
var ctx = document.getElementById('mychart');
var myChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: ['9時', '10時', '11時', '12時', '13時', '14時', '15時','16時','17時','18時','19時','20時','21時','22時'],
    datasets: [{
      label: '混み具合',
      data: [${time.get(0).getCoalesce()},${time.get(1).getCoalesce()},${time.get(2).getCoalesce()},${time.get(3).getCoalesce()},${time.get(4).getCoalesce()},${time.get(5).getCoalesce()},${time.get(6).getCoalesce()},${time.get(7).getCoalesce()},${time.get(8).getCoalesce()},${time.get(9).getCoalesce()},${time.get(10).getCoalesce()},${time.get(11).getCoalesce()},${time.get(12).getCoalesce()},${time.get(13).getCoalesce()}],
      borderColor: '#f88',
    }],
  },
  options: {
    y: {
      min: 0,
      max: 10,
    },
  },
});
</script>

				


			</div>
			<form>

				<h3>エリア：${fn:escapeXml(shop.getArea())}</h3>
				<h3>ジャンル:${fn:escapeXml(shop.getCategory())}</h3>

				<p>${fn:escapeXml(shop.getDescription())}</p>

				<div></div>
				<div class="btns">
				<input type="button" onclick="location.href='yoyakuin'" value="予約"
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