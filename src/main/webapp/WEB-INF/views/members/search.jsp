<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Members Search</title>
<style type="text/css">
	#searchButton{
		background-color: aqua;
		margin: 10px 10px 10px 10px;
		padding: 10px;
		border: none;
		width: 150px;
		font-size: 20px;
		cursor: pointer;
	}
	
	#searchBox{
		margin: 10px 10px 10px 10px;
		font-size: 20px;
	}
</style>
<c:import url="../template/bootstrapCss.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-4 mt-4">
		<div class="row">
			<form method="post" action="search">
				<div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Search Word" aria-label="Recipient's username" aria-describedby="button-addon2" required="required" name="search">
				  <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Search</button>
				</div>
			</form>
		</div>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>
</body>
</html>