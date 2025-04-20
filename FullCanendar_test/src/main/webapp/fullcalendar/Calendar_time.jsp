<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>일정 관리 홈</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <style>
    body {
      background-color: #f8f9fa;
      font-family: 'Segoe UI', sans-serif;
    }
    .ribbon {
      background: #e4e4e4;
      padding: 10px;
      border-bottom: 1px solid #ccc;
      margin-bottom: 20px;
    }
    .calendar-area {
      display: flex;
      gap: 20px;
    }
    .side-panel {
      width: 25%;
    }
    .main-calendar {
      flex-grow: 1;
    }
    .panel-box {
      background: white;
      border: 1px solid #ddd;
      border-radius: 6px;
      margin-bottom: 20px;
      padding: 15px;
    }
    .panel-title {
      font-size: 16px;
      font-weight: bold;
      margin-bottom: 10px;
    }
  </style>
</head>
<body>

  <!-- Ribbon Toolbar -->
  <div class="ribbon">
    <div class="btn-toolbar">
      <div class="btn-group">
        <button class="btn btn-default"><span class="glyphicon glyphicon-calendar"></span> 일정</button>
        <button class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span> 등록/수정</button>
      </div>
      <div class="btn-group">
        <button class="btn btn-default"><span class="glyphicon glyphicon-bell"></span> 알림 설정</button>
        <button class="btn btn-default"><span class="glyphicon glyphicon-cog"></span> 설정</button>
      </div>
    </div>
  </div>

  <!-- Main Layout -->
  <div class="container">
    <div class="calendar-area">

      <!-- Left: D-Day + Small Calendar -->
      <div class="side-panel">
        <div class="panel-box">
          <div class="panel-title">D-Day</div>
          <ul class="list-unstyled">
            <li>✔ 프로젝트 마감 - D-2</li>
            <li>✔ 시험 - D-5</li>
          </ul>
        </div>

        <div class="panel-box">
          <div class="panel-title">작은 달력</div>
          <div style="height: 200px; background: #f1f1f1; text-align: center; line-height: 200px;">달력 컴포넌트</div>
        </div>
      </div>

      <!-- Right: Full Calendar -->
      <div class="main-calendar">
        <div class="panel-box">
          <div class="panel-title">전체 일정 보기</div>
          <div style="height: 400px; background: #f1f1f1; text-align: center; line-height: 400px;">FullCalendar 영역</div>
        </div>
      </div>

    </div>

    <!-- Bottom: 일정 목록 -->
    <div class="panel-box">
      <div class="panel-title">선택한 날짜 일정</div>
      <ul class="list-group">
        <li class="list-group-item">오전 10:00 - 회의 (개인)</li>
        <li class="list-group-item">오후 2:00 - 팀 회의 (그룹)</li>
      </ul>
    </div>
  </div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>