<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String sysdate = sdf.format(date);
%>
<%@ include file="../include/header.jsp" %>
	
	<div align="center" class="div_center">
		<h3>회원가입</h3>
		<hr>
		<form action="joinMem.member" method="post" name="reg_mem">
			<table border="3">
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="id" required pattern="[A-Za-z0-9]{5,}">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="pw" placeholder="5자이상입력" required>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="name" required>
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="email" name="email" placeholder="naver@google.com" required>
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="address">
					</td>
				</tr>
				<tr>
					<td>나이</td>
					<td>
						<input type="text" name="age">
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<input type="radio" name="gender" value="M">남성
						<input type="radio" name="gender" value="F" checked>여성
					</td>
				</tr>
				<tr>
					<td>가입날짜</td>
					<td>
						<input type="text" name="regdate" value=<%=sysdate %> readonly>
				</tr>
				<tr>
					<td>접근권한</td>
					<td>
						<input type="text" name="master" value="U" readonly>
					</td>
				</tr>
				<tr>
					<td>접속가능방개수</td>
					<td>
						<input type="text" name="limitroom" value="3" readonly>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="회원가입" class="btn btn-default">
			<input type="reset" value="취소" class="btn btn-default" onclick="">  
			 <div>${msg }</div>
		</form>	
	</div>	
	
	<%@ include file="../include/footer.jsp" %>