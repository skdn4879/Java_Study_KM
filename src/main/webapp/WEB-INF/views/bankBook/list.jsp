<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List Page!</h1>
	<table border="1">
		<tr>
			<td>BookName</td>
			<td>BookRate</td>
		</tr>
		
		<c:forEach items="${requestScope.list}" var="list">
			<tr>
				<td>${list.bookName}</td>
				<td>${list.bookRate}</td>
			</tr>
		</c:forEach>
		
		
	
	</table>
	
	
</body>
</html>