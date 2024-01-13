<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/include/header.jsp" %>

<body class="setBody">

<div class="containerSetRoom">

    <h1 class="abc">방 생성</h1>
    <form action="roomForm.roomSet" method="post">
<%--        <div class="form-group">--%>
<%--            <label class="setLabel" for="roomNumber">방 번호:</label>--%>
<%--            <input type="text" id="roomNumber" name="roomNumber" value="${'5'}" readonly>--%>
<%--&lt;%&ndash;            해당 밸류 값은 &ndash;%&gt;--%>
<%--        </div>--%>
        <div class="form-group">
            <label class="setLabel" for="mid">방장 ID:</label>
            <input type="text" id="mid" name="mid" value="${'Master1'}" readonly>
<%--            value 값은 나중에 세션으로 받아서 보여주면 됩니다. --%>
        </div>
        <div class="form-group">
            <label for="numCount">방 인원:</label>
            <input type="number" id="numCount" name="numCount" required>
        </div>
        <div class="form-group">
            <label for="deadLine">마감 날짜:</label><br>
            <input type="date" id="deadLine" name="deadLine" required>
        </div>
        <div class="form-group">
            <label for="closingTime">마감 시간:</label>
            <input type="time" id="closingTime" name="closingTime" required>
        </div>
        <div class="form-group">
            <label for="width">좌석 가로 길이: (최대 길이를 입력해주세요.)</label>
            <input type="number" id="width" name="width" required>
        </div>
        <div class="form-group">
            <label for="height">좌석 세로 길이: (최대 길이를 입력해주세요.)</label>
            <input type="number" id="height" name="height" required>
        </div>
        <div class="form-group">
            <label for="RANDOMCYCLE">랜덤 주기: (초 단위) (미개발 상태)</label>
            <input type="number" id="RANDOMCYCLE" name="RANDOMCYCLE" value="null" readonly>
        </div>
        <div class="form-group">
            <label for="CYCLENUM">주기당 당첨 인원: (미개발 상태)</label>
            <input type="number" id="CYCLENUM" name="CYCLENUM" value="null" readonly>
        </div>
        <input type="submit" value="다음 설정">
    </form>

<%--    날짜 선택을 오늘이 최소값으로 설정.--%>
    <script>
        // 오늘 날짜를 가져와서 YYYY-MM-DD 형식으로 변환
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();

        today = yyyy + '-' + mm + '-' + dd;

        // min 속성에 오늘 날짜 할당
        document.getElementById("deadLine").setAttribute("min", today);
    </script>

    <script>
        // 오늘 날짜와 현재 시간 가져오기
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();
        var hours = String(today.getHours()).padStart(2, '0');
        var minutes = String(today.getMinutes()).padStart(2, '0');

        var currentDate = yyyy + '-' + mm + '-' + dd;
        var currentTime = hours + ':' + minutes;

        // 마감 날짜와 시간 input 태그 객체 가져오기
        var deadLine = document.getElementById("deadLine");
        var closingTime = document.getElementById("closingTime");

        // 마감 날짜가 변경되었을 때의 이벤트 핸들러 설정
        deadLine.onchange = function() {
            if(deadLine.value === currentDate) {
                // 마감 날짜가 오늘 날짜일 경우, 마감 시간을 현재 시간으로 설정하고,
                // 현재 시간 이후만 선택 가능하게 함
                closingTime.value = currentTime;
                closingTime.min = currentTime;
            } else {
                // 그 외의 경우, 마감 시간 선택 제한 해제
                closingTime.min = "00:00";
            }
        }

        // 1분마다 현재 시간을 체크하고 업데이트하는 코드
        setInterval(function() {
            var now = new Date();
            var nowHours = String(now.getHours()).padStart(2, '0');
            var nowMinutes = String(now.getMinutes()).padStart(2, '0');
            var nowTime = nowHours + ':' + nowMinutes;

            // 마감 날짜가 오늘 날짜이고, 마감 시간이 현재 시간보다 이전일 경우
            if(deadLine.value === currentDate && closingTime.value < nowTime) {
                closingTime.value = nowTime; // 마감 시간을 현재 시간으로 업데이트
            }
            closingTime.min = nowTime; // 마감 시간의 최소값을 현재 시간으로 설정
        }, 60000); // 60000밀리초(1분)마다 함수를 실행
    </script>

</div>

</body>

<%@ include file="/include/footer.jsp"%>