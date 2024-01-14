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


	<h2>[사용법]</h2>
	
	<h4>1. 랜덤을 돌려 학생들이 자리를 선택할 순서를 정해줍니다.</h4>
	<h4>2. 뽑힌 순서대로 학생이 앉고 싶은 자리를 말해주면, 강사님은 자리에 이름을 적어 줍니다.</h4>
	<h4>3. 이름을 다 적었으면 좌석 확정을 눌러 결과를 확인합니다.</h4>
	<h4>[주의사항] : 랜덤 뽑기를 다하고 이름들을 적을 것. 도중에 이름을 적을시 새로고침 리셋됨.</h4>
</div>

</body>

<%@ include file="/include/footer.jsp"%>