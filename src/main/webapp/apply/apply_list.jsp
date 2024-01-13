<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ include file = "../include/header.jsp" %>
	<div class="container" style = "text-align: center; padding-top: 100px;">
		<h3>좌석 ROOM 리스트</h3>
		
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
						<input type="button" value="신청 버튼" class="btn btn-default" onclick="location.href='./applyUser.apply?roomnumber=${i.roomnumber}'; ">
						<input type="button" value="입장 버튼" class="btn btn-default" onclick="location.href='./join.apply?roomnumber=${i.roomnumber}'; ">
						<input type="button" value="결과 버튼" class="btn btn-default" onclick="location.href='./resultPage.apply?roomnumber=${i.roomnumber}'; ">
					</td>
				</tr>
				</c:forEach>
				
				
			</tbody>
			
			<!-- <tbody>
				<tr>
					<td colspan="5" align="right">
						<form action="" class="form-inline" >
						  <div class="form-group">
						    <input type="text" name="search" placeholder="제목검색" class="form-control" >
						  	<input type="submit" value="검색" class="btn btn-default">
							<input type="button" value="글 작성" class="btn btn-default" onclick="location.href='write.board'; ">
						  </div>
						</form> 
					</td>
				</tr>
			</tbody> -->
		
		</table>
		
		<hr>
			<h3>선생님이 요청 하신 작업(오리지날 프로그램) 마스터만 보기에 할예정</h3>
			<input type="button" value="선생님 랜덤프로그램 구현" class="btn btn-default" onclick="location.href='./room_setting.jsp'; ">
				
	</div>
<%@ include file = "../include/footer.jsp" %>