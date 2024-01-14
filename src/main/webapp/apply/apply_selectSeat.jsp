<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "../include/header.jsp" %>
<% response.setHeader("Refresh", "10"); %>


<div style = "text-align: center;">
	<h1>[여기는 좌석 선택방입니다]</h1>
	<h3>1. 신속히 죄석을 체크한 후 좌석선택 버튼을 클릭하세요.</h3> 
	<h3>초록색 : 선택가능한 좌석 | 오렌지색 : 선택완료된 좌석</h3>

	<hr>
	

	<br>
<c:set var="index" value="1"/>

	<form action="seatApply.apply?roomnumber=${roomnumber}" method="post">
		<table style="border : 2px solid black;border-collapse : collapse; display:inline-block; text-align: center">		
			<tbody>
	
			
			
			<c:forEach var="i" begin="1" end="${seatWH.get(1)}" step="1">
				<tr style="border : 3px solid black; border-collapse : collapse;">	
				<c:forEach var="j" begin="1" end="${seatWH.get(0)}" step="1">	
				
						<c:if test="${closeSeat.contains(String.valueOf(index))}">
							<td style = "background-color: #ffcc00; width: 100px; height:50px; border : 3px solid black; border-collapse : collapse;">${index } <input type="radio"  value="${index }" disabled="disabled"/></td>
						</c:if>
		
						<c:if test="${!closeSeat.contains(String.valueOf(index))}">
							<td style = "background-color: green; width: 100px; height:50px; border : 3px solid black; border-collapse : collapse;">${index } <input type="radio" name = "selectseat" value="${index }"/></td>
						</c:if>
						
						<c:set var="index" value="${index + 1 }"/>
				</c:forEach>	
					</tr>	
		</c:forEach>				
			</tbody>
		</table>

		<br>
		<h4><input type = "submit" value="좌석선택"/>${msg }</h4>
	</form>
</div>




<%@ include file = "../include/footer.jsp" %>

