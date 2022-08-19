<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add BankBook</title>
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
	<h1>통장 추가 페이지</h1>
	
	<form method="post" action="add">
		<input class="boxes" type="text" name="bookName" placeholder="BookName" required="required"><br>
		<input class="boxes" type="text" name="bookRate" placeholder="BookRate" required="required"><br>
		<textarea rows="10" cols="50" name="bookContents" placeholder="BookContents"></textarea><br>
		<input id="sendButton" type="submit" value="생성">
	</form>
	
	<a href="/">메인페이지</a>
</body>
</html>