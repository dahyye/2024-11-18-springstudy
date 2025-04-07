<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<!-- <script type="text/javascript">
$(function(){
	$('#msg').keyup(function(){
		let msg=$('#msg').val()
		$('#print').text(msg)
	})
})
</script> -->
</head>
<body>
<div id="container"> <!-- vuejs는 반드시 제어할 수 있는 구역을 지정해줘야한다 -->
 <input type="text" size=20 id="msg">
 <div id="print">{{msg}}</div>
</div>
<script type="text/javascript">
 let app1=Vue.createApp({
	 	 data(){
	 		 return {
	 			 msg=''
	 		 }
	 	 }
 }).mount('#container')
</script>
</body>
</html>