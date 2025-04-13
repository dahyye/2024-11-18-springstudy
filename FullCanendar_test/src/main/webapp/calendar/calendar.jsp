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