<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<div align="center" class="div_center">

	<h3>Modify</h3>
	<hr>
	<form action="update.other" method="post">
			<input type="hidden" name="bno" value="${vo.bno }">
			
			<table border="3" width="500">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${vo.writer }" readonly></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td>
					<input type="text" name="title" value="${vo.title }">
				</td>
			</tr>
			<tr>
				<td>글내용</td>
				<td>
					<textarea rows="10" style="width: 95%;" name="content">${vo.content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정하기" onclick="">&nbsp;&nbsp;
					<input type="button" value="목록" onclick="location.href='list.other';">        
				</td>
			</tr>
		</table>
	</form>
</div>

<%@ include file="../include/footer.jsp" %>