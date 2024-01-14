<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "../include/header.jsp" %>
<% response.setHeader("Refresh", "10"); %>    


<div style = "text-align: center;">
	<h1>[여기는 결과방 입니다]</h1>
	<h3>글씨 없는 곳 : 선택 불가능한 좌석</h3>
	<h3>초록색 : 선택가능한 좌석</h3>
	<h3>오렌지색 : 선택완료된 좌석</h3>
	<hr><br><br>
	<c:set var="index" value="1"/>

	<form action="seatApply.apply?roomnumber=${roomnumber}" method="post">
		<table style="border : 2px solid black;border-collapse : collapse; display:inline-block; text-align: center">		
			<tbody>
	
			
			
			<c:forEach var="i" begin="1" end="${seatWH.get(1)}" step="1">
				<tr style="border : 3px solid black; border-collapse : collapse;">	
				<c:forEach var="j" begin="1" end="${seatWH.get(0)}" step="1">	
				
						<c:if test="${closeSeat.contains(String.valueOf(index)) }">
							<td style = "background-color: #ffcc00; width: 100px; height:50px; border : 3px solid black; border-collapse : collapse;">${selectUser.get(String.valueOf(index)) }</td>
						</c:if>
		
						<c:if test="${!closeSeat.contains(String.valueOf(index))}">
							<td style = "background-color: green; width: 100px; height:50px; border : 3px solid black; border-collapse : collapse;"><b>${index }</b></td>
						</c:if>
						
						<c:set var="index" value="${index + 1 }"/>
				</c:forEach>	
					</tr>	
		</c:forEach>				
			</tbody>
		</table>

		<br><br><br>
		<input type="button" value="돌아가기" class="btn btn-default" onclick="location.href='./list.apply'; ">
	</form>
</div>



<%@ include file = "../include/footer.jsp" %>


