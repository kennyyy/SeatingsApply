<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<div align="center" class="div_center">
	<h1>[글 작성]</h1><br>
	<hr><br>
	<form action="registOth.other" method="post">
		<table border="1" width="800">
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
				<td colspan="2" style= "text-align: right;">
					<input type="submit" value="작성완료" onclick="" style = "display: inline-block; width: 100px; font-size: 15px; ">
					&nbsp;&nbsp;
					<input type="button" value="목록" onclick="location.href='list.other';" style = "margin-right: 30px; ">         
				</td>
			</tr>
		</table>
	</form>
</div>

<%@ include file="../include/footer.jsp" %>