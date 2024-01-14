<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ include file="../include/header.jsp" %>
	
		<div align="center" class="div_center">
		
			<h1>[로그인]</h1>
			<br><br>
			<form action="loginMem.member" method="post">
			<table border="1">
				<tr>
					<td><input type="text" name="id" placeholder="아이디" style="border: none;"></td>
				</tr>
				<tr>
					<td><input type="password" name="pw" placeholder="비밀번호" style="border: none;"></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="로그인" class="btn btn-default" style="width: 150px;">
			</form>
			${msg }<br>
	</div>
	
	<%@ include file="../include/footer.jsp" %>