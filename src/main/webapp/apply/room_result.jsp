<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "../include/header.jsp" %>
<%
	request.setAttribute("seat", (String[])request.getParameterValues("seat"));

%>

<div style = "text-align: center;">
	<h1>[최종 결과 확인]</h1>
	<br>
	<h3>초록색 : 빈자리</h3>
	<h3>주황색 : 내 자리</h3>
	<br>
	<c:set var="index" value="1"/>

	
		<table style="border : 2px solid black;border-collapse : collapse; display:inline-block; text-align: center">		
			<tbody>
			<c:forEach var="i" begin="1" end="${height}" step="1" varStatus="staus">
				<tr style="border : 3px solid black; border-collapse : collapse;">	
				<c:forEach var="j" begin="1" end="${width}" step="1">	
				
						<c:if test="${seat[index-1] != '' }">
							<td style = "background-color: #ffcc00; width: 100px; height:50px; border : 3px solid black; border-collapse : collapse;">${seat[index-1] }</td>
						</c:if>
		
						<c:if test="${seat[index-1] == '' }">
							<td style = "background-color: green; width: 100px; height:50px; border : 3px solid black; border-collapse : collapse;"><b>빈자리</b></td>
						</c:if>
						
						<c:set var="index" value="${index + 1 }"/>
				</c:forEach>	
					</tr>	
		</c:forEach>				
			</tbody>
		</table>

		<br><br><br>
		<input type="button" value="돌아가기" class="btn btn-default" onclick="location.href='./list.apply'; ">
</div>



<%@ include file = "../include/footer.jsp" %>


