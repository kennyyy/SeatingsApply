<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<div align="center" class="div_center">
	<h3>Write</h3>
	<hr>
	<form action="registOth.other" method="post">
		<table border="3" width="800">
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="writer" value="${sessionScope.user_id }" size="10" required readonly>
				</td>
			</tr>
			<tr>
				<td>글제목</td>
				<td>
					<input type="text" name="title" required>
				</td>
			</tr>
			<tr>
				<td>글내용</td>
				<td>
					<textarea rows="10" style="width: 95%;" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성완료" onclick="">
					&nbsp;&nbsp;
					<input type="button" value="목록" onclick="location.href='list.other';">         
				</td>
			</tr>
		</table>
	</form>
</div>

<%@ include file="../include/footer.jsp" %>