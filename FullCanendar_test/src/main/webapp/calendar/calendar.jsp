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
 document.addEventListener('DOMContentLoaded',function(){
	 var calendarEl = document.getElementById('calendar');
	 var calendar = new FullCalendar.Calendar(calendarEl, {
		 initialView:'dayGridMonth', 
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
		 selectable:true, //달력 셀 선택 활성화
		 select: function(info) {	// 달력 셀을 클릭할 때 모달 열기
	            $('#addEventModal').modal('show'); 
	            $('#start').val(info.startStr); 
	            $('#end').val(info.endStr);
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
	 calendar.render();
 });
</script>

</html>