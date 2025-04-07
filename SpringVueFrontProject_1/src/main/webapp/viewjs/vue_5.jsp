<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.container{
	margin-top: 50px;
	
}
.row{
	width: 960px;
	margin: 0px auto;
}
.dataTr:hover{
	cursor: pointer;
	background-color: cyan;
}
</style>
</head>
<body>
 <div class="container">
  <div class="row">
   <h3 class="text-center">v-if~v-elseif~v-else</h3>
	  <button class="btn-sm btn-danger" @click=type(1)">한식</button>
	  <button class="btn-sm btn-danger" @click="type(2)">양식</button>
	  <button class="btn-sm btn-danger" @click="type(3)">일식</button>
	  <button class="btn-sm btn-danger" @click="type(4)">중식</button>
 </div>
  </div> 
  <div class="row">
   <div v-if="type===1">
    한식을 선택
   </div>
   <div v-if="type===2">
    양식을 선택
   </div>
   <div v-if="type===3">
    일식을 선택
   </div>
   <div v-if="type===4">
    중식을 선택
   </div>
  </div>
 </div>
<script type="text/javascript">
  let app=Vue.createApp({
	data(){
		return {
			type:0
		}
	},
	methods:function(no){
		this.type=no
	}
  }).mount(".container")
 </script>
</body>
</html>