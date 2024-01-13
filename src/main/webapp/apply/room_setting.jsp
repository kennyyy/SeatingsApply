<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/include/header.jsp" %>

<body class="setBody">

<div class="containerSetRoom">

    <h1 class="abc">오리지날 선생님 자바 랜덤 프로그램을 JSP로 구현</h1>
    <form action="./room_settingTable.jsp" method="post">
  
        <div class="form-group">
            <label for="numCount">방 인원:</label>
            <input type="number" id="numCount" name="numCount" >
        </div>
        <div class="form-group">
            <label for="width">좌석 가로 길이: (최대 길이를 입력해주세요.)</label>
            <input type="number" id="width" name="width">
        </div>
        <div class="form-group">
            <label for="height">좌석 세로 길이: (최대 길이를 입력해주세요.)</label>
            <input type="number" id="height" name="height">
        </div>
        <div class="form-group">
            <label for="RANDOMCYCLE">랜덤 버튼:  (누를때마다 당첨인원이 뽑아짐)</label>
            <input type="number" id="RANDOMCYCLE" name="RANDOMCYCLE" value="null" >
        </div>
        <div class="form-group">
            <label for="CYCLENUM">당첨 인원: (누를때마다 뽑힐 인원)</label>
            <input type="number" id="CYCLENUM" name="CYCLENUM" value="null" >
        </div>
        <input type="submit" value="다음 설정">
    </form>



</div>

</body>

<%@ include file="/include/footer.jsp"%>