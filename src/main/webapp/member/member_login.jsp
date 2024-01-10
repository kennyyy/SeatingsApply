<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ include file="../include/header.jsp" %>
	
		<div align="center" class="div_center">
		
			<h3>Log In</h3>
			<hr>
			<form action="loginMem.member" method="post">
			<table border="3">
				<tr>
					<td><input type="text" name="id" placeholder="아이디"></td>
				</tr>
				<tr>
					<td><input type="password" name="pw" placeholder="비밀번호"></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="로그인" class="btn btn-default">&nbsp;&nbsp;
			<input type="button" value="회원가입" class="btn btn-default" onclick="location.href='join.member';">
			</form>
			${msg }<br>
	</div>
	
	<%@ include file="../include/footer.jsp" %>