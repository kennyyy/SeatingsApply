<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@ include file="../include/header.jsp" %>
	
	<div align="center" class="div_center">
	<form action="updateMem.member" method="post" >
		<h3>회원정보 수정 페이지</h3>
		<hr>
		<table border="3">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" value="${vo.id }" readonly="readonly">
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
					<input type="text" name="name" value="${vo.name}" required>
				</td>
				
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email" value="${vo.email }" placeholder="naver@google.com" required>
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="text" name="address" value="${vo.address }" required>
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>
					<input type="text" name="age" value="${vo.age }" required>
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" ${vo.gender == 'M' ? 'checked' : '' } value="M">남자
					<input type="radio" name="gender" ${vo.gender == 'F' ? 'checked' : '' } value="F">여자
				</td>
			</tr>
			<tr>
				<td>가입날짜</td>
				<td>
					<input type="date" name="regdate" value="${vo.regdate }" readonly>
				</td>
			</tr>
			<tr>
				<td>접근권한</td>
				<td>
					<input type="text" name="master" value="${vo.master }" readonly>
				</td>
			</tr>
			<tr>
				<td>접속가능방개수</td>
				<td>
					<input type="text" name="limitroom" value="${vo.limitroom }" readonly>
				</td>
			</tr>
		</table>
		<br>
		
		<input type="submit" value="수정" class="btn btn-default" onclick="">&nbsp;&nbsp;
		<input type="reset" value="취소" class="btn btn-default" onclick="">    
		
	</form>	
	</div>	
	
	<%@ include file="../include/footer.jsp" %>