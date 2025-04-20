<%@page import="io.opentelemetry.exporter.logging.SystemOutLogRecordExporter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<%@page import="java.util.*"%>
<%@page import="com.sist.vo.*"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.14/index.global.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.fc-col-header-cell-cushion, .fc-daygrid-day-number {
    text-decoration: none;
}

.fc-scrollgrid-sync-inner > .fc-col-header-cell-cushion,
.fc-day-mon .fc-daygrid-day-number,
.fc-day-tue .fc-daygrid-day-number,
.fc-day-wed .fc-daygrid-day-number,
.fc-day-thu .fc-daygrid-day-number,
.fc-day-fri .fc-daygrid-day-number {
    color: black;
}

.fc-day-sun .fc-col-header-cell-cushion,
.fc-day-sun a{
    color : red;
}

.fc-day-sat .fc-col-header-cell-cushion,
.fc-day-sat a {
    color : blue;
}
</style>
</head>
<body>
<div id='calendar'></div>
<div class="modal fade" id="addEventModal" tabindex="-1" aria-labelledby="addEventModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addEventModalLabel">일정 추가</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="eventForm">
                    <div class="mb-3">
                        <label for="subject" class="form-label">일정</label>
                        <input type="text" class="form-control" id="subject" required>
                    </div>
                    <div class="mb-3">
                        <label for="title" class="form-label">일정상세</label>
                        <input type="text" class="form-control" id="title" required>
                    </div>
                    <div class="mb-3">
                        <label for="start" class="form-label">시작 일자</label>
                        <input type="date" class="form-control" id="start" required>
                    </div>
                    <div class="mb-3">
                        <label for="end" class="form-label">종료 일자</label>
                        <input type="date" class="form-control" id="end" required>
                    </div>
                    <button type="submit" class="btn btn-primary">저장</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>
let Alldata = {};
 document.addEventListener('DOMContentLoaded',function(){
	 var calendarEl = document.getElementById('calendar');
	 var calendar = new FullCalendar.Calendar(calendarEl, {
		 initialView:'dayGridMonth', 
		 expandRows: true, //화면에 맞게 높이 재설정
		 locale:'ko',
		 headerToolbar:{
			 /*
			 start:"",
			 center:"prev title next",
			 end:'dayGridMonth,dayGridWeek,dayGridDay'
			*/ 
			 left: 'prev,next today',
		     center: 'title',
		     right: 'dayGridMonth,timeGridWeek,timeGridDay'
			 
		 },
		 eventAdd: function(obj) { // 이벤트가 추가되면 발생하는 이벤트
             
         	sDate = 
                 obj.event._instance.range["start"].getFullYear() + 
                 '-'+(obj.event._instance.range["start"].getMonth() +1) +
                 '-' +  obj.event._instance.range["start"].getDate();
         	
         	eDate =
         		  obj.event._instance.range["end"].getFullYear() + 
                   '-'+(obj.event._instance.range["end"].getMonth() +1) +
                   '-' +  (obj.event._instance.range["end"].getDate() -1);
         	
         	 Alldata = {
                 "start": sDate,
                 "end": eDate,
                 "title": obj.event._def["title"],
                 "allday": obj.event._def["allDay"],
                 "defId": obj.event._instance["defId"],
                 "instanceId": obj.event._instance["instanceId"]
             };

             let allEvent = calendar.getEvents();
             console.log(allEvent);

              let jsondata = JSON.stringify(Alldata);
              console.log("jsondata : " + jsondata);

              
         },
		 selectable:true, // 달력 일자 드래그 설정가능    달력 셀 선택 활성화
		 dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
		 select: function(info) {	// 달력 셀을 클릭할 때 모달 열기
	            $('#addEventModal').modal('show'); 
	            $('#start').val(info.startStr); 
	            $('#end').val(info.endStr);
	            let title = prompt('일정을 입력하세요');
	            if(title){
	            	calendar.addEvent({
	            		title:title,
	            		start:info.start,
	            		end:info.end,
	            		allDay:info.allDay
	            	})
	            }
	            calendar.unselect()
	            	
	            		            	
	        },
		 droppable:true,
		 editable:true,
		 events:[
			 <%List<CalendarVO> list = (List<CalendarVO>)request.getAttribute("list");%>
	            <% System.out.println(list); %>
	            <%if (list != null) 
	            {%>
	            	<%for (CalendarVO vo : list)
	            	{%>
			 			{
							 title : '<%=vo.getCalendarTitle()  %>',
							 start:'<%=vo.getCalendarStart()%>',
							 end: '<%=vo.getCalendarEnd()%>',
							 Color: '#' + Math.round(Math.random() * 0xffffff).toString(16)
						 },
			 		<%}
	       		 }%>
				 ]
		 
	 });
	 //캘린더 렌더링
	 calendar.render();
 });
 
 function allSave() {
 	
	console.log(allData); */
	document.getElementById("submenu").style.display = "block";

	 
     $.ajax({
         url: "calendar/insert.do",
         type: "post",
         data: {addEvent : JSON.stringify(Alldata)},

		 success:function(data, textStatus, xhr){
			 console.log(data);
			 
		 },
		 error:function(xhr, status, error){
			 console.log(error);
		 }
		
		 

     });
}
</script>

</html>