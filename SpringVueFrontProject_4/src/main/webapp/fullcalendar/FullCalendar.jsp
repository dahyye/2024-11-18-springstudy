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
<script type="text/javascript">
 document.addEventListener('DOMContentLoaded',function(){
	 var calendarEl = document.getElementById('calendar');
	 var calendar = new FullCalendar.Calendar(calendarEl, {
		 initialView:'dayGridMonth', //캘린더가 load될 때, 초기 보기설정 
		 //dayGridMonth 가 default 설정
		 //dayGridYear는 현재 날짜를 기준으로 2025 1월부터 12월까지의 달력이 한꺼번에 출력
		 //dayGridMonth는 현재 달을 기준으로 1달씩 출력
		 
		 /*
		 초기날짜를 따로 설정을 안하면 현재날짜가 기본설정으로 들어가있다
		 날짜데이터는 ISO8601인코딩으로 날짜 문자열을 포함하여 Data로 구문분석이 가능하도록 되어 있다
		 2024-06-07T12:30:00-14:00
		 */
		 //height:'auto', //캘린더전체높이를 auto로 설정 -> 자동설정하면 스크롤바는 사용되지 않아
		 //contentHeight: 'auto', //한 칸(본문)의 높이
		 aspectRatio:1.5, //캘린더 가로세로 비율 1 -> 정사각,  1.5 -> 가로가 길다  2 -> 가로가 2배길어
		 events:[
			 {title:'기간설정',start:'2025-04-09',end:'2025-04-11'}, //기간일정
			 {title:'시간포함',start:'2025-04-13T14:00:00',allDays:false}, //시간 포함 일정
			 {title:'외부링크연결',start:'2025-04-03',url:'https://www.naver.com/'},
		 ]
		 
		 events:'/api/events' //서버에서 일정 JSON데이터 로드
		 
		 events: function(fetchInfo, successCallback, failureCallback {
			 $.ajax({
				 url:'/api/getEvents',
				 dataType:'json',
				 data: {
					 start:fetchInfo.startStr,
					 end:fetchInfo.endStr
				 },
				 success: function(response){
					 
				 }
			 })
		 })
		 
	 });
	 calendar.render();
 });
</script>
</html>