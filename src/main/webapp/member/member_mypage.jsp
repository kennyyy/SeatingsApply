<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ include file="../include/header.jsp" %>
	
	<div align="center" class="div_center">
	<h3>MYPAGE</h3>
	<hr>
	<p>
	${sessionScope.user_id}<b sytle="color: purple: red">"${sessionScope.user_name }"님의 정보를 관리합니다.
	</p>

	<a href="update.user">[회원정보변경]</a>&nbsp;

	<a href="delete.user">[회원탈퇴]</a>
	</div>	
	
	<%@ include file="../include/footer.jsp" %>