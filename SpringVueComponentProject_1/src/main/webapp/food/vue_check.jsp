<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <div class="container">
  <div class="row">
   <input type="checkbox" value="사과" v-model="f">사과
   <input type="checkbox" value="배" v-model="f">배
   <input type="checkbox" value="바나나" v-model="f">바나나
   <input type="checkbox" value="토마토" v-model="f">토마토
   <input type="checkbox" value="딸기" v-model="f">딸기
   <div>선택된 과일:{{f}}</div>
   <div>선택된 갯수:{{len}}</div>
   <div>{{hello()}}</div>
  </div>
 </div>
 <script>
  let app=Vue.createApp({
	  data(){
		  return {
			  f:[]
		  
		  }
	  },
	  computed:{ //템플릿의 데이터 표현을 더 직관적이고 간결하게 도와주는 속성.
		  len:function(){
			  return this.f.length
		  }
	  },
	  methods:{
		  hello(){
			  return "Hello"
		  }
	  }
	 
  }).mount(".container")
 </script>
</body>
</html>