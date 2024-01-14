<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ include file = "../include/header.jsp" %>
	<div class="container" style = "text-align: center; padding-top: 50px; border-radius: 30px; box-shadow:2px 3px 5px 0px">
		<h1>[좌석 ROOM 리스트]</h1>

		<h3>1. 입장신청버튼을 누르신 후 </h3>
		<h3>2. 입장버튼을 눌러 주세요.</h3>
	
		<table class="table table-bordered" border="1" style = "display:inline-block; ">
			<thead>
				<tr>
					<th>방 번호</th>
					<th>방장이름</th>
					<th>방 생성 시간</th>
					<th>현재 인원 / 총인원</th>
					<th>신청하기/입장하기/결과보기</th>
				</tr>
			</thead>
	
			<tbody>
				
				<c:forEach var="i" items="${ovo }" varStatus="status">
				<tr>
					<td>${i.roomnumber }</td>
					<td>${i.mid }</td>
					<td>${i.deadline }</td>
					<td>${ nowUserRoomsNum[status.index] == null ? 0 : nowUserRoomsNum[status.index] } / ${i.numcount }</td>
					<td>
						<input type="button" value="입장신청" class="btn btn-default btn-cus" onclick="location.href='./applyUser.apply?roomnumber=${i.roomnumber}'; ">
						<input type="button" value="입장" class="btn btn-default btn-cus" onclick="location.href='./join.apply?roomnumber=${i.roomnumber}'; ">
						<input type="button" value="결과보기" class="btn btn-default btn-cus" onclick="location.href='./resultPage.apply?roomnumber=${i.roomnumber}'; ">
					</td>
				</tr>
				</c:forEach>
				
				
			</tbody>
		
		</table>
		
			<br><br>
			<h3>선생님이 요청 하신 작업(오프라인 랜덤 뽑기) (마스터계정만 보임)</h3>
			<h3 style="padding-bottom: 20px;"><input type="button" value="선생님 자바 랜덤자리배치 프로그램을 JSP로 구현" class="btn btn-default" onclick="location.href='./room_setting.jsp'; "></h3>
				
	</div>
<%@ include file = "../include/footer.jsp" %>