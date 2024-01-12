<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

<%@ include file="../include/header.jsp" %>

	<div class="container">
		<h3>MyBoard</h3>
		
		<table class="table table-dark table-hover">	
			<thead>
				<tr>
					<th scope="col">글번호</th>
					<th scope="col">작성자</th>
					<th scope="col">글제목</th>
					<th scope="col">작성일</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
					
			<tbody>
				<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.bno }</td>
					<td>${vo.writer}</td>
					<td><a href="content.other?bno=${vo.bno }">${vo.title}</a></td>
					<td><fmt:formatDate value="${vo.regdate }" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/></td>
					<td>${vo.hit }</td>
				</tr>
				</c:forEach>
			</tbody>
			
			<tbody>
				<tr>
					<td colspan="5" align="right">
						<form action="" class="form-inline" >
						  <div class="form-group">
						    <input type="text" name="search" placeholder="제목검색" class="form-control" >
						  	<input type="submit" value="검색" class="btn btn-default">
							<input type="button" value="글작성" class="btn btn-default" onclick="location.href='write.other';">
						  </div>
						</form> 
					</td>
				</tr>
			</tbody>
		<hr>
		</table>
	</div>

<%@ include file="../include/footer.jsp" %>