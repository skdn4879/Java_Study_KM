<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<style type="text/css">
	#listTable{
		border: 1px;
		margin: 10px 10px 10px 10px;
		padding: 10px;
		text-align: center;
	}
	.listTd{
		border: 1px;
		border-color: gray;
		border-style: solid;
		margin: 10px 10px 10px 10px;
		padding: 10px;
		font-size: 20px;
	}
	.listHead{
		background-color: aqua;
	}
</style>
</head>
<body>
	<h1>회원 목록</h1>
	<table id="listTable">
		<thead>
			<tr>
				<td class="listTd listHead">UserName</td>
				<td class="listTd listHead">Name</td>
				<td class="listTd listHead">Email</td>
				<td class="listTd listHead">Phone</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.memberList }" var="dto">
				<tr>
					<td class="listTd">${pageScope.dto.userName }</td>
					<td class="listTd">${pageScope.dto.name }</td>
					<td class="listTd">${pageScope.dto.email }</td>
					<td class="listTd">${pageScope.dto.phone }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<a href="/">메인페이지</a>
</body>
</html>