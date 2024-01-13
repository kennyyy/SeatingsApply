<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "../include/header.jsp" %>
<% response.setHeader("Refresh", "5"); %>    


<div style = "text-align: center;">
	<h3>여기는 결과방 입니다.</h3>
	<h5>현재 사람들이 선택한 좌석</h5>
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


