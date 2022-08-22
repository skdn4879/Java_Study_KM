<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>

<c:import url="../template/bootstrapCss.jsp"></c:import>

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<%-- <section class="container-fluid col-lg-8 mt-4">
		<div class="row">
			<h2>My Info</h2>
		</div>
		<div class="row">
			<table class="table table-info">
			  <thead>
			    <tr>
			      <th scope="col">UserName</th>
			      <th scope="col">Name</th>
			      <th scope="col">Email</th>
			      <th scope="col">Phone</th>
			    </tr>
			  </thead>
			  <tbody class="table-group-divider">
			    <tr>
			    	<td>${requestScope.memberDetail.userName }</td>
					<td>${requestScope.memberDetail.name }</td>
					<td>${requestScope.memberDetail.email }</td>
					<td>${requestScope.memberDetail.phone }</td>
			    </tr>
			  </tbody>
			</table>
		</div>
		<div class="row">
			<h2>My Account Info</h2>
		</div>
		<div class="row">
			<table class="table table-info">
			  <thead>
			    <tr>
			      <th scope="col">AccountNumber</th>
			      <th scope="col">BookName</th>
			      <th scope="col">BookRate</th>
			      <th scope="col">AccountDate</th>
			    </tr>
			  </thead>
			  <tbody class="table-group-divider">
			  	<c:forEach items="${requestScope.memberAccountList }" var="accountDto">
			  		<tr>
			  			<td>${pageScope.accountDto.accountNum }</td>
			  			<td>${pageScope.accountDto.bankBookDTO.bookName }</td>
			  			<td>${pageScope.accountDto.bankBookDTO.bookRate }</td>
			  			<td>${pageScope.accountDto.accountDate }</td>
			  		</tr>
			  	</c:forEach>
			  </tbody>
			</table>
		</div>
	</section> --%>
	
	<%-- <section class="container-fluid col-lg-8 mt-4">
		<div class="row">
			<h2>My Info</h2>
		</div>
		<div class="row">
			<table class="table table-info">
			  <thead>
			    <tr>
			      <th scope="col">UserName</th>
			      <th scope="col">Name</th>
			      <th scope="col">Email</th>
			      <th scope="col">Phone</th>
			    </tr>
			  </thead>
			  <tbody class="table-group-divider">
			    <tr>
			    	<td>${map.dto.userName }</td>
					<td>${map.dto.name }</td>
					<td>${map.dto.email }</td>
					<td>${map.dto.phone }</td>
			    </tr>
			  </tbody>
			</table>
		</div>
		<div class="row">
			<h2>My Account Info</h2>
		</div>
		<div class="row">
			<table class="table table-info">
			  <thead>
			    <tr>
			      <th scope="col">AccountNumber</th>
			      <th scope="col">BookName</th>
			      <th scope="col">BookRate</th>
			      <th scope="col">AccountDate</th>
			    </tr>
			  </thead>
			  <tbody class="table-group-divider">
			  	<c:forEach items="${map.list }" var="accountDto">
			  		<tr>
			  			<td>${pageScope.accountDto.accountNum }</td>
			  			<td>${pageScope.accountDto.bankBookDTO.bookName }</td>
			  			<td>${pageScope.accountDto.bankBookDTO.bookRate }</td>
			  			<td>${pageScope.accountDto.accountDate }</td>
			  		</tr>
			  	</c:forEach>
			  </tbody>
			</table>
		</div>
	</section> --%>
	
	<section class="container-fluid col-lg-8 mt-4">
		<div class="row">
			<h2>My Info</h2>
		</div>
		<div class="row">
			<table class="table table-info">
			  <thead>
			    <tr>
			      <th scope="col">UserName</th>
			      <th scope="col">Name</th>
			      <th scope="col">Email</th>
			      <th scope="col">Phone</th>
			    </tr>
			  </thead>
			  <tbody class="table-group-divider">
			    <tr>
			    	<td>${requestScope.memberDto.userName }</td>
					<td>${requestScope.memberDto.name }</td>
					<td>${requestScope.memberDto.email }</td>
					<td>${requestScope.memberDto.phone }</td>
			    </tr>
			  </tbody>
			</table>
		</div>
		<div class="row">
			<h2>My Account Info</h2>
		</div>
		<div class="row">
			<table class="table table-info">
			  <thead>
			    <tr>
			      <th scope="col">AccountNumber</th>
			      <th scope="col">BookName</th>
			      <th scope="col">AccountDate</th>
			    </tr>
			  </thead>
			  <tbody class="table-group-divider">
			  	<c:forEach items="${requestScope.memberDto.bankAccountDTOs }" var="accountDto">
			  		<tr>
			  			<td>${pageScope.accountDto.accountNum }</td>
			  			<td>${pageScope.accountDto.bankBookDTO.bookName }</td>
			  			<td>${pageScope.accountDto.accountDate }</td>
			  		</tr>
			  	</c:forEach>
			  </tbody>
			</table>
		</div>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>
</body>
</html>