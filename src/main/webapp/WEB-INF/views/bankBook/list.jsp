<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BankBook List</title>
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
	/* a{
		text-decoration: none;
		width: 100px;
		height: 40px;
		font-size: 20px;
		margin: 10px 10px 10px 10px;
		background-color: orange;
	} */
	.bookAnchor{
		text-decoration: none;
		background-color: white;
	}
</style>

<c:import url="../template/bootstrapCss.jsp"></c:import>

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-8 mt-4">
		<div class="row">
			<table class="table table-primary">
			  <thead>
			    <tr>
			      <th scope="col">Number</th>
			      <th scope="col">Name</th>
			      <th scope="col">Rate</th>
			      <th scope="col">Sale</th>
			      <th scope="col">Contents</th>
			    </tr>
			  </thead>
			  <tbody class="table-group-divider">
			    <c:forEach items="${requestScope.bankbookList }" var="dto">
			    	<tr>
			    		<td>${pageScope.dto.bookNum }</td>
			    		<td><a href="./detail?bookNum=${pageScope.dto.bookNum }">${pageScope.dto.bookName }</a></td>
			    		<td>${pageScope.dto.bookRate }</td>
			    		<c:if test="${pageScope.dto.bookSale == 1 }"><td>판매중</td></c:if>
						<c:if test="${pageScope.dto.bookSale == 0 }"><td>판매금지</td></c:if>
			    		<td>${pageScope.dto.bookContents }</td>
			    	</tr>
			    </c:forEach>
			  </tbody>
			</table>
		</div>
	</section>
	
	<a class="btn btn-success" href="./add" role="button">통장 생성</a>
	
	<c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>
	
</body>
</html>