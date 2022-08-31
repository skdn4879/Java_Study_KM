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
			<form method="post" action="join" enctype="multipart/form-data" id="joinFrm">
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">UserName</span>
				  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" name="userName" required="required" id="userName">
				</div>
				<div id="msgUserName"></div>
				
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">Password</span>
				  <input type="password" class="form-control" placeholder="Password" aria-label="Username" aria-describedby="basic-addon1" name="password" required="required" id="password">
				  
				</div>
				<div id="msgPassword"></div>
				
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">Password Check</span>
				  <input type="password" class="form-control" placeholder="Password Check" aria-label="Username" aria-describedby="basic-addon1" required="required" id="passwordCheck">
				  
				</div>
				<div id="msgPasswordCheck"></div>
				
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">Name</span>
				  <input type="text" class="form-control addOn" placeholder="Name" aria-label="Username" aria-describedby="basic-addon1" name="name" required="required" id="name">
				  
				</div>
				<div class="msgAddOn" id="msgName"></div>
				
				<div class="input-group mb-3">
				  <input type="text" class="form-control addOn" placeholder="Email" aria-label="Recipient's username" aria-describedby="basic-addon2" name="email" required="required" id="email">
				  <span class="input-group-text" id="basic-addon2">@example.com</span>
				  
				</div>
				<div class="msgAddOn" id="msgEmail"></div>
				
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">Phone</span>
				  <input type="text" class="form-control addOn" placeholder="Phone" aria-label="Username" aria-describedby="basic-addon1" name="phone" required="required" id="phone">
				  
				</div>
				<div class="msgAddOn" id="msgPhone"></div>
				
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">Photo</span>
				  <input type="file" class="form-control" aria-label="Username" aria-describedby="basic-addon1" name="photo">
				</div>
				<button class="w-100 btn btn-lg btn-primary" type="button" id="btnSign">Sign Up</button>
			</form>
		</div>
	</section>
    
    <c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>
	<script src="../resources/js/join.js"></script>

</body>
</html>