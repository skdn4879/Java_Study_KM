<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
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
</style>
<c:import url="../template/bootstrapCss.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-8 mt-4">
		<div class="row">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">UserName</th>
			      <th scope="col">Name</th>
			      <th scope="col">Email</th>
			      <th scope="col">Phone</th>
			    </tr>
			  </thead>
			  <tbody class="table-group-divider">
			    <c:forEach items="${requestScope.memberList }" var="dto">
			    	<tr>
			    		<td>${pageScope.dto.userName }</td>
						<td>${pageScope.dto.name }</td>
						<td>${pageScope.dto.email }</td>
						<td>${pageScope.dto.phone }</td>
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