<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style type="text/css">
	
	#loginButton{
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
	
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-4 mt-4">
		<div class="row">
			<form method="post" action="login" id="frm">
			    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
			
			    <div class="form-floating">
			      <input type="text" class="form-control" id="inputId" placeholder="ID" name="userName">
			      <label for="inputId">UserName</label>
			    </div>
			    <div class="form-floating">
			      <input type="password" class="form-control" id="inputPw" placeholder="Password" name="password">
			      <label for="inputPw">Password</label>
			    </div>
			
				<span id="comment"></span>

			    <button id="btn" class="w-100 btn btn-lg btn-primary" type="button">Sign in</button>
			    <p class="mt-5 mb-3 text-muted">© 2017–2022</p>
			  </form>
		</div>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script src="/resources/js/member.js"></script>
	<script>
		loginCheck();
	</script>
</body>
</html>