<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "../include/header.jsp" %>
<%  response.setHeader("Refresh", "5"); 
%>    




<div style="text-align: center;">
	<h1>[여기는 대기방 입니다]</h1>
	
	<br>
	<h3>1. 방인원이 꽉차면 버튼이 생깁니다.</h3>
	<h3>2. 버튼이 보이면 버튼을 클릭하여 제일 빨리 좌석을 선택하러 가주세요. (선착순입니다.)</h3>
	<h3>버튼이 생기는 조건 : 방인원이 꽉차야 한다.</h3>
	
	<hr>
	<br>
	<h1>현재인원 : ${applyUesr} / ${numCount}</h1><br>
	<c:forEach var="i" items="${iswinList }">
	
		<c:if test="${user_id == i.userid}">
			<h3>버튼생성!!! 누구 보다 빠르게 자리를 선점하세요.</h3>
			<input  style=" background-color: skyblue; border-radius: 30px;
  							color: white; font-size:40px; cursor:pointer;
 							border: none; 
 							width: 300px;  height: 200px;"
 							 type = "button" value="입장" class="btn btn-default" onclick="location.href='selectseat.apply?roomnumber=${i.roomnumber}'; ">
		</c:if>
	</c:forEach>
</div>




<%@ include file = "../include/footer.jsp" %>