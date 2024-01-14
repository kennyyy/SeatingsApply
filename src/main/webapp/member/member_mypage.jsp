<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ include file="../include/header.jsp" %>
	
	<div align="center" class="div_center">
	<h3>[MyPage]</h3>
	<br>
	<hr>
	<br>
	<p>
		<b style="color: purple;">[${sessionScope.user_name }] 님의 정보를 관리
	</p>

	<a href="update.member">[회원정보변경]</a>&nbsp;

	<a href="delete.member">[회원탈퇴]</a>
	</div>	
	
	<%@ include file="../include/footer.jsp" %>