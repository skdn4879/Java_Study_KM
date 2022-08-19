<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BankBook Detail</title>
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
	a{
		text-decoration: none;
		width: 100px;
		height: 40px;
		font-size: 20px;
		margin: 10px 10px 10px 10px;
		background-color: orange;
	}
</style>
</head>
<body>
	<h1>통장 상세정보</h1>
	
	<table id="listTable">
		<thead>
			<tr>
				<td class="listTd listHead">Number</td>
				<td class="listTd listHead">Name</td>
				<td class="listTd listHead">Rate</td>
				<td class="listTd listHead">Sale</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="listTd">${requestScope.bookDetail.bookNum }</td>
				<td class="listTd">${requestScope.bookDetail.bookName }</td>
				<td class="listTd">${requestScope.bookDetail.bookRate }</td>
				<td class="listTd">${requestScope.bookDetail.bookSale }</td>
			</tr>
		</tbody>
	</table>
	
	<hr>
	<br>
	<a href="./update?bookNum=${requestScope.bookDetail.bookNum }">통장 정보 수정</a>
	<a href="./delete?bookNum=${requestScope.bookDetail.bookNum }">통장 정보 삭제</a>
	<hr>
	<br>
	<a href="/">메인페이지</a>
</body>
</html>