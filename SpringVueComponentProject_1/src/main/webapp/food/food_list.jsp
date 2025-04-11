<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 100%;
}
</style>
</head>
<body>
 <div class="container container-fluid">
  <div class="row">
   <form action="food_list.do"  method="post">
   <!-- 
     ?ss=aaa&fd=A&fd=B
    -->
   <input type="checkbox" value="N" name="fd">업체명
   <input type="checkbox" value="A" name="fd">주소
   <input type="checkbox" value="T" name="fd">음식종류
   <input type="checkbox" value="M" name="fd">테마
   <input type=text size=15 class="input-sm" name="ss">
   <input type="button" class="btn-sm btn-primary" value="검색">
  </form>
  </div>
  
  <div style="height: 10px"></div>
  <div class="row">
   <div class="col-sm-8">
   <c:forEach var="vo" items="${list }">
    <div class="col-md-3">
    <div class="thumbnail">
      <a href="#">
        <img src="https:www.menupan.com${vo.poster}" alt="Lights" style="width:width:180px; height: 150px">
        <div class="caption">
          <p>${ vo.name}</p>
        </div>
      </a>
    </div>
  </div>
   </c:forEach>  
   </div>
   <div class="col-sm-4">
    <detail></detail>
   </div>
  </div>
 </div>
</body>
</html>