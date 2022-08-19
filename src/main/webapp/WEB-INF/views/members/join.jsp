<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Member</title>
<c:import url="../template/bootstrapCss.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-8 mt-4">
		<div class="row">
			<form method="post" action="join">
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">UserName</span>
				  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" name="userName" required="required">
				</div>
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">Password</span>
				  <input type="password" class="form-control" placeholder="Password" aria-label="Username" aria-describedby="basic-addon1" name="password" required="required">
				</div>
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">Name</span>
				  <input type="text" class="form-control" placeholder="Name" aria-label="Username" aria-describedby="basic-addon1" name="name" required="required">
				</div>
				<div class="input-group mb-3">
				  <input type="text" class="form-control" placeholder="Email" aria-label="Recipient's username" aria-describedby="basic-addon2" name="email" required="required">
				  <span class="input-group-text" id="basic-addon2">@example.com</span>
				</div>
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">Phone</span>
				  <input type="text" class="form-control" placeholder="Phone" aria-label="Username" aria-describedby="basic-addon1" name="phone" required="required">
				</div>
				<button class="w-100 btn btn-lg btn-primary" type="submit">Sign Up</button>
			</form>
		</div>
	</section>
    
    <c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>

</body>
</html>