<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/include/header.jsp" %>

<body class="setBody">

<div class="containerSetRoom">

    <h1 class="abc">[기본 설정]</h1><br><br>
    <form action="./roomSetting.apply" method="post">
  
        <div class="form-group">
            <label for="numCount"><b>참가할 유저 이름들 입력 : (공백을 기준으로 계속 나열해주세요. 이름 중복 X) ex)홍길동 이길동 김길동 ...</b></label>
            <input type="text" name="users"  required="required">
        </div><br>
        <div class="form-group">
            <label for="width"><b>좌석 가로 길이: (최대 길이를 입력해주세요.)</b></label>
            <input type="number"  name="width" required="required">
        </div><br>
        <div class="form-group">
            <label for="height"><b>좌석 세로 길이: (최대 길이를 입력해주세요.)</b></label>
            <input type="number" name="height" required="required">
        </div><br>

        <div class="form-group">
            <label for="CYCLENUM"><b>당첨 인원: (랜덤뽑기 버튼을 누를때 마다 몇명씩 뽑게 할지 인원을 적어주세요.)</b></label>
            <input type="number"  name="winNum" value="null" required="required">
        </div>
        <input type="submit" value="다음 설정">
    </form>



</div>

</body>

<%@ include file="/include/footer.jsp"%>