<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	1. 형식
	let app=Vue.creaetApp({
		data(){
			return {
				변수설정 
				-----
				no:0, => 0.0
				name:'', => ""
				isShow:false, => true
				vo:{},
				arr:[]
				==> 변수값이 변경이 되면 => HTML에 적용(자동)
			}
		},
		CallBack 함수 : 시스템에 의해 자동 호출되는 함수
		mounted(){}
		updated(){} : 데이터 변경시 처리
		methods:{
			사용자 정의 : 이벤트처리
		}
		
	})
	
	=> HTML을 제어
	 => v-model / v-show
	 	v-for / v-if, v-else
	 	v-bind:속성에 변수값이 첨부
	 	
	
 --%>
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
<div class="container" id="app1">
 <div class="row">
  <h3 class="text-center">v-if~v-elseif~v-else</h3>
  <button class="btn-sm btn-danger" @click="select(1)">한식</button>
  <button class="btn-sm btn-danger" @click="select(2)">양식</button>
  <button class="btn-sm btn-danger" @click="select(3)">중식</button>
  <button class="btn-sm btn-danger" @click="select(4)">일식</button>
  <button class="btn-sm btn-danger" @click="select(5)">분식</button>
 </div>
 <div style="height: 10px"></div>
 <div class="row">
  <div v-if="type===1">한식 선택</div>
  <%-- 다중조건문 사용방법 --%>
  <div v-else-if="type===2">양식 선택</div>
  <div v-else-if="type===3">중식 선택</div>
  <div v-else-if="type===4">일식 선택</div>
  <div v-else-if="type===5">분식 선택</div>
  <div v-else="type===0">선택이 없다</div>
 </div>
</div>
<div class="container" id="app2">
 <input type="button" value="로그인" class="btn-sm btn-success" @click="login2()">
 <input type="button" value="로그아웃" class="btn-sm btn-info" @click="logout()">
 <div v-if="login===true">
  로그인되었습니다
 </div>
 <div v-else>
  로그아웃되었습니다
 </div>
</div>
<script type="text/javascript">
 let app=Vue.createApp({
	 data(){
		 return {
			 type:0
		 }
	 },
	 methods:{
		 select:function(no)
		 {
			 console.log(no)
			 this.type=no
		 }
	 
	 }
 }).mount("#app1")
 
 let app2=Vue.createApp({
	 data(){
		 return {
			 login:false
		 }
	 },
	 methods:{
		 login2:function()
		 {
			 this.login=true
		 },
		 logout:function()
		 {
			 this.login=false
		 }
	 
	 }
	 
 }).mount("#app2")
</script>
</body>
</html>