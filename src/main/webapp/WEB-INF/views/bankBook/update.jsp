<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<form method="post" action="update">
				<input type="hidden" name="bookNum" value="${requestScope.bankBookDTO.bookNum }" required="required">
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">BookName</span>
				  <input type="text" class="form-control" placeholder="BookName" aria-label="Username" aria-describedby="basic-addon1" name="bookName" required="required" value="${requestScope.bankBookDTO.bookName }">
				</div>
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">BookRate</span>
				  <input type="text" class="form-control" placeholder="BookRate" aria-label="Username" aria-describedby="basic-addon1" name="bookRate" required="required" value="${requestScope.bankBookDTO.bookRate }">
				</div>
				<div class="form-check">
				  <input class="form-check-input" type="radio" name="bookSale" id="flexRadioDefault2" checked value="1">
				  <label class="form-check-label" for="flexRadioDefault2">
				    판매중
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input" type="radio" name="bookSale" id="flexRadioDefault1" value="0">
				  <label class="form-check-label" for="flexRadioDefault1">
				    판매금지
				  </label>
				</div>
				<div class="input-group input-group-lg">
				  <span class="input-group-text">BookContents</span>
				  <textarea class="form-control" aria-label="With textarea" name="bookContents">${requestScope.bankBookDTO.bookContents }</textarea>
				</div>
				<input class="btn btn-primary" type="submit" value="통장 정보 수정">
			</form>
		</div>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>
	
</body>
</html>