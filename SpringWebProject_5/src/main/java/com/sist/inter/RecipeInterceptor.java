package com.sist.inter;
/*
	자동 로그인
	
	1. Controller 역할, AOP 역할
	2. Task 역할 => 스케쥴러
	3. Interceptor => 중간에 필요한 부분에 기능을 추가
	4. DAO / Service
	----------------------------
	include => tiles
	보안 / betch / 통계 
				  --- 파이썬 (Pandas,Numpy)
				  		| Django
	Front : Vue => 디렉티브 
					v-for v-if v-else v-model
					=> 라이브러리 : jacksion
			=> FrontController : 요청 받아서 HandlerMapping
								 응답
								  |
								  Model을 찾아서 메소드 호출
								  @GetMapping / @PostMapping
								  --------------------------
								  	@RequestMapping
	
	main.do === DispatcherServlet === HandlerMapping
											|
										 모델이 가지고 있는 메소드를 호출하기 전에 원하는 기능을 수행(preHandle) : intercept
 											|
 										  메소드 호출 : request.setAttribute()
 										  			 return ""
 										  	|
 										  ViewResolver
 										  	|  => afterCompletion
 										   JSP
 										  	
 
 */
public class RecipeInterceptor {

}
