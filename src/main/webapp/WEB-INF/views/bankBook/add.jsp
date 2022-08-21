<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	/* a{
		text-decoration: none;
		width: 100px;
		height: 40px;
		font-size: 20px;
		margin: 10px 10px 10px 10px;
		background-color: orange;
	} */
</style>

<c:import url="../template/bootstrapCss.jsp"></c:import>

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-8 mt-4">
		<div class="row">
			<form method="post" action="add">
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">BookName</span>
				  <input type="text" class="form-control" placeholder="BookName" aria-label="Username" aria-describedby="basic-addon1" name="bookName" required="required">
				</div>
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">BookRate</span>
				  <input type="text" class="form-control" placeholder="BookRate" aria-label="Username" aria-describedby="basic-addon1" name="bookRate" required="required">
				</div>
				<div class="input-group input-group-lg">
				  <span class="input-group-text">BookContents</span>
				  <textarea class="form-control" aria-label="With textarea" name="bookContents"></textarea>
				</div>
				<input class="btn btn-primary" type="submit" value="통장 생성">
			</form>
		</div>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>
	
</body>
</html>