<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "../include/header.jsp" %>
<%  response.setHeader("Refresh", "5"); 
	request.setAttribute("userid", "USER6");
%>    




<div style="text-align: center;">
	<h3>여기는 대기방 입니다.</h3>
	<br>
	
	<hr>
	<br>
	<h3>방인원이 꽉차면 버튼이 생깁니다.</h3>
	<h3>버튼이 보이면 버튼을 클릭하여 좌석을 선택하러 가주세요.</h3><br>
	<c:forEach var="i" items="${iswinList }">
	
		<c:if test="${userid == i.userid}">
			<input type="button" value="입장" class="btn btn-default" onclick="location.href='selectseat.apply?roomnumber=${i.roomnumber}'; ">
		</c:if>
	</c:forEach>
</div>




<%@ include file = "../include/footer.jsp" %>