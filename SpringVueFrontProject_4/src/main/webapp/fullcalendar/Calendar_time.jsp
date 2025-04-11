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
<script type="text/javascript">
 document.addEventListener('DOMContentLoaded',function(){
	 var calendarEl = document.getElementById('calendar');
	 var calendar = new FullCalendar.Calendar(calendarEl, {
		 initialView:'timeGridWeek', //시간 그리드 뷰 
		 slotMinTime: '09:00:00', //9시부터 //기본값은 00시부터
		 slotMaxTime: '18:00:00', //마지막 시간대
		 slotDuration: '00:15:00', //15분단위 // 기본설정은 30분
		 events:[
			 {title:'팀 회의',start:'2025-04-09T10:00:00'},
			 {title:'프로젝트 마감',start:'2025-04-09T12:30:00'}
		 ]
	 });
	 calendar.render();
 });
</script>
</body>
</html>