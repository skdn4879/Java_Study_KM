<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA List</title>
<c:import url="../template/bootstrapCss.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-8 mt-4">
		<div class="row">
			<h2>QNA</h2>
		</div>
		<div class="row">
			<table class="table table-primary">
			  <thead>
			    <tr>
			      <th scope="col">번호</th>
			      <th scope="col">제목</th>
			      <th scope="col">내용</th>
			      <th scope="col">작성자</th>
			      <th scope="col">작성일</th>
			      <th scope="col">조회수</th>
			      <th scope="col">REF</th>
			      <th scope="col">STEP</th>
			      <th scope="col">DEPTH</th>
			    </tr>
			  </thead>
			  <tbody class="table-group-divider">
			    <c:forEach items="${requestScope.list }" var="qnaDTO">
			    	<tr>
			    		<td>${pageScope.qnaDTO.num }</td>
			    		<td><a href="./detail.iu?num=${pageScope.qnaDTO.num }">${pageScope.qnaDTO.title }</a></td>
			    		<td>${pageScope.qnaDTO.contents }</td>
			    		<td>${pageScope.qnaDTO.writer }</td>
			    		<td>${pageScope.qnaDTO.regDate }</td>
			    		<td>${pageScope.qnaDTO.hit }</td>
			    		<td>${pageScope.qnaDTO.ref }</td>
			    		<td>${pageScope.qnaDTO.step }</td>
			    		<td>${pageScope.qnaDTO.depth }</td>
			    	</tr>
			    </c:forEach>
			  </tbody>
			</table>
		</div>
		<c:if test="${not empty sessionScope.member }">
			<div class="row">
				<a class="btn btn-success" href="./add.iu" role="button">QNA 작성</a>
			</div>
		</c:if>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>
	
</body>
</html>