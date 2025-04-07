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
</style>
</head>
<body>
<%--
	생명주기
	Vue
	1. 가상 돔 사용 => mount() : 속도가 빠르다
		=> 게임( 더블 버퍼링 )
		=> String / StringBuffer
		=> 가상메모리를 이용해서 처리
	2. callback => vue에서 지원하느 함수 => 자동 호출이 된다
	-----------------------------------------------
	3. 디렉티브 : 제어문
	4. 서버 연동 : axios
	5. 출력 형식 {{}}
	6. 양뱡향 => axios
	7. router : 화면 변경 => Controller
	8. component
	---------------------------------------------
	9. vue-bootstrap
	10. vue3 => vuex
		react => redux (MVC)
		--------------
			react-query : tanStack-query
		  => Framework(nextjs)
		  => javascript => 가독성 : typescript
		  	 let a=10
		  	 a='aaa'
	---------------------------------------------
	
 --%>
 <div class="container">
  <div class="row">
   <input type="text" class="inpu-sm" size=20 v-mode="msg">
   <div class="text-center">
    {{msg}}
   </div>
  </div>
 </div>
 <script>
 //{{}} => 멤버변수 연결 => v-model="변수명" => 양방향통신
 //입력값을 변수에 저장 => 저장된 값을 HTML로 전송
 //{{}} => 반드시 멤버변수만 사용이 가능
 // 이벤트 처리 -> 제어문 => 제어문 처리하는 부분
  let app=Vue.createApp({
	  //state
	  //
	  data(){
		  return {
			  msg:''
		  }
	  },
	  beforeCreate(){
		console.log("Vue 객체 생성 전 : beforeCreate() Call")  
	  },
	  created(){
		console.log("Vue 객체 생성 완료 : created() Call")  
	  },
	  beforeMount(){
		  console.log("화면이 출력하기 전 상태 : beforeMount() Call")  
	  },
	  mounted(){
		  console.log("브라우저에 화면 출력 : mounted() Call")  
		  //가장많이 사용되는 부분
	  },
	  beforeUpdate(){
		  console.log("data에 선언된 변수값이 갱신 전 : beforeUpdate() Call")  
	  },
	  updated(){
		  console.log("data에 선언된 변수값이 갱신 후 : updated() Call")  
	  },
	  beforeDestory(){
		  console.log("화면 변경 전 상태 : beforeDestory() Call")  
	  },
	  
  }).mount(".container")
 </script>
</body>
</html>