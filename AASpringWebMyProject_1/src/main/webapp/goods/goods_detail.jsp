<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
  width: 960px;
  margin: 0px auto;
}
</style>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['단어', '횟수'],
          ['Work',     11],
          ['Eat',      2],
          ['Commute',  2],
          ['Watch TV', 2],
          ['Sleep',    7]
        ]);

        var options = {
          title: '맛집 소개 정보',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>

</head>
<body>
  <div class="container">
   <div class="row">
    <table class="table">
     <tr>
      <td width=40% class="text-center" rowspan="8">
        <img src="${vo.goods_poster }"
         style="width:380px;height: 300px" class="img-rounded">
      </td>
      <td width="60%" colspan="2">
        <h3>${vo.goods_name }&nbsp;
      </td>
     </tr>
     
    </table>
   
    <div style="height: 20px"></div>
    <table class="table">
      <tr>
        <td>
          <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
        </td>
      </tr>
    </table>
   </div>
  </div>
</body>
</html>