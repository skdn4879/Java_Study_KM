<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update BankBook</title>
<style type="text/css">
	#sendButton{
		background-color: aqua;
		margin: 10px 10px 10px 10px;
		padding: 10px;
		border: none;
		width: 150px;
		font-size: 20px;
		cursor: pointer;
	}
	.boxes{
		margin: 10px 10px 10px 10px;
		font-size: 20px;
	}
	.radioText{
		font-size: 20px;
		margin:10px;
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
	<h1>통장 정보 수정 페이지</h1>
	
	<form method="post" action="update">
		<input type="hidden" name="bookNum" value="${requestScope.bankBookDTO.bookNum }" required="required">
		<input class="boxes" type="text" name="bookName" placeholder="BookName" required="required" value="${requestScope.bankBookDTO.bookName }"><br>
		<input class="boxes" type="text" name="bookRate" placeholder="BookRate" required="required" value="${requestScope.bankBookDTO.bookRate }"><br>
		<span class="radioText">판매중</span><input type="radio" name="bookSale" value="1" checked="checked"><br>
		<span class="radioText">판매금지</span><input type="radio" name="bookSale" value="0" ><br>
		<input id="sendButton" type="submit" value="수정">
	</form>
	
	<a href="/">메인페이지</a>
</body>
</html>