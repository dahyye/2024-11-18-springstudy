<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js"></script>
</head>
<body>
<div id='calendar'></div>
</body>
<script>
 document.addEventListener('DOMContentLoaded',function(){
	 var calendarEl = document.getElementById('calendar');
	 var calendar = new FullCalendar.Calendar(calendarEl, {
		 initialView:'dayGridMonth', 
		 locale:'ko',
		 headerToolbar:{
			 start:"",
			 center:"prev title next",
			 end:'dayGridMonth,dayGridWeek,dayGridDay'
		 },
		 selectable:true,
		 droppable:true,
		 editable:true,
		 events:[
			 {title:'기간설정',start:'2025-04-09',end:'2025-04-11', backgroundColor: '#ff0000'}, //기간일정
			 {title:'시간포함',start:'2025-04-13T14:00:00',allDays:false}, //시간 포함 일정
			 {title:'외부링크연결',start:'2025-04-03',url:'https://www.naver.com/'},
		 ]
		 
	 });
	 calendar.render();
 });
</script>
</html>