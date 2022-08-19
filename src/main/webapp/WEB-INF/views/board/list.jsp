<%@page import="kr.co.practice.board.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<h1>게시글 리스트</h1>
	
	<h3>총 게시글 수 : ${requestScope.boardCount }</h3>
	
	<h3>오늘의 모든 이용자 방문 횟수 :${requestScope.visitedCookie } </h3>
	
	<table border="1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list }" var="dto">
				<tr>
					<td>${pageScope.dto.boardNum }</td>
					<td><a href="./detail?boardNum=${pageScope.dto.boardNum }">${pageScope.dto.title }</a></td>
					<td>${pageScope.dto.writer }</td>
					<td>${pageScope.dto.writeDate }</td>
					<td>${pageScope.dto.viewCount }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
		<c:forEach begin="0" end="${requestScope.pageCount - 1}" step="1" var="pageNum" >
			<a href="./list?start=${pageNum * 5 }">${pageNum + 1}</a>
		</c:forEach>
	<hr>
	<br>
	<a href="/">메인페이지</a>
	<hr>
	<br>
	<a href="./add">글 작성</a>
</body>
</html>