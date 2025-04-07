<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	사용자 (변경 요청)
		|
	Controller (DispatcherServlet)
		|
	사용자 요청에 따라 변경
	  (Model => @Controller, @RestController)
	  	|
	Controller
		|
	   JSP
	  
	 MVVM
	 사용자 (변경 요청)
	 	|
	   View(HTML)
	    |
	   사용자 요청 따라 변경
	    |
	 ViewModel : 변수값 변경
	 	|
	 Model : 변경된 데이터를 View(HTML)
	    |
	   View
	   
	   
	
	1. 프로젝트 생성 순서
	 Back-end
	 pom.xml : 라이브러리 추가
	 버전 변경 : 스프링 5 => 1.8이상
	 web.xml : 서블릿 등록(DispatcherServlet, 한글변환)
	 
	 => model / vo / dao / service/ mapper
	 => application-context.xml
	 => application-datasource.xml
	 ---------------------------------요구사항(입문)
	 => application-security.xml
	 => application-websocket   
	   
	
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>