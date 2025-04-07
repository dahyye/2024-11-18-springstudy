<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	MVC => 서버에서 (Model/View를 나눠서 작업)
				  ====== ====
				  	|
				  요청처리
				  데이터관리
				  => DAO/Manager/Service/Vo
	
	=> Vue : MVVM
		M(model) : 데이터 저장 / 데이터를 관리
					data(){
						멤버 변수 설정 => VO
						=================
						숫자형
						no:1, no:10 ... => 초기값 부여
						문자형
						name:'', name:""
						-------------------------------------자바에서 전송
						객체형	
						vo:{} => JSON
						---------------------------------vo와 매칭이 안된다
														 JSON으로 변경 후 전송
														 @RestController
						배열형
						food_list:[]
						---------------------------------List => 
						함수형 
						display:function(){}
					}
		V(view) : 화면 출력 
				  => 데이터 출력 : {{data에 선언된 변수만}} -> 괄호가 2개가 들어가야 한다
				  		** React는 괄호가 1개 
				  		** DJango : 파이썬 => 출력할 때 괄호를 2개사용하기 때문에 충돌방지를 어떻게 할 지 생각해야 한다
				  		** JSP :  $ {  => EL
				  		==> 제어문 지원 : 디렉티브
				  			=> 태그안에서 처리 => 
				  			
				  		==> 반복문 / 조건문 / 화면 출력 여부
				  			v-for
				  			v-if / v-if~v-else
				  			v-if ~ v-elseif ... v-else
				  			v-show / v-hide
				  		==> 양방향 통신
				  			v-model / v-bind => : 속성안에 처리
				  		==> 이벤트 처리
				  		 	v-on:click => @click="함수명"
				  		 	v-on:changd => @change="함수명"
				  	
		VM(viewModel) : 상태 관리 ( 데이터가 변경이 되는 경우 )  
						=> View에 알려준다 => 갱신
					=> 생명주기
					  beforeCreate : vue 객체 생성 전
					  created : vue 객체 생성
					  beforeMount : window.onload 전
					  mounted : onload => $  {function()}
					  	=> 서버연결 => 서버에서 전송한 데이터를 받는다
					  beforeUpdate
					  updated
					  	=> 데이터 변경시에 처리
					  beforeDestory
					  destoryed
					  	=> 화면 변경이 된 경우
					  	
					  형식
					  let app=Vue.createApp({
					  	data()
					  	{
					  	}
					  	,
					  	mounted:function()
					  	{
					  	},
					  	..
					  	..
					  	methods:{
					  		사용자 정의 메소드 => 버튼같은것
					  	},
					  	component:{
					  	},
					  	filter:{
					  		=> 10000 => 10,000
					  	},	
					  	watch / computed
					  }).mount("제어하는 HTML영역지정")
						=> id => #
						=> class => .
			
			HTML => ViewModel => View => 가상돔 = 실제 돔
					---------			  | 필수(면접에 많이 나온다)
					 | 데이터 갱싱				자바에서 속도를 빠르게 하고 싶을 때 buffer 이용
					 						가상돔이 buffer랑 관련이 있다					
			
			
			동작 방법 => 저장은 가상돔에 저장
			-------				---------- 실제 돔과 비교 (변경된 부분만 전송)
									diff
			
				1. MVVM / 가상돔						
				-----------------
				=> VueJS에서 DOM이벤트 감지
				=> 이벤트가 감지 서버로부터 데이터 요청
							 ------------------ axios
				=> 결과값을 받아서 View에 데이터를 바인딩 한다 -> 화면이 변경
				=> 영역지정
			
			=> 데이터형
				숫자형 : number => int / double
				문자형 : string => '',""
				객체형 : {}
				배열형 : []
				논리형 : boolean => true/false
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
 <div class="container">
  <div class="row" id="a">
   {{a_msg}}<p><!--  {{}} 안의 값은 data에 선언된 변수, methods에 선언된 메소드만 사용이 가능하다 -->
   <input type="button" value="변경" v-on:click="btnClick()">
  </div>
  <div class="row" id="b">
   {{b_msg}}
  </div>
  <script>
   let app=Vue.createApp({
	   //Model => 데이터가 변경이 되면 HTML에 전송
		data(){
			return {
				/* 멤버변수 위치 */
				a_msg:'Hello Vue(a)'
			}
		}
	   
	   methods:{
		   btnClick:function(){
			   this.a_msg='갱신된 값'
		   }		   
	   }
	   //ViewModel => 데이터 변경 / 서버에서 데이터를 읽어온다
   }).mount(".container")
   
  </script>
 </div>
</body>
</html>