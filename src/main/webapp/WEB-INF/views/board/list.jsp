<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Page</title>

<c:import url="../template/bootstrapCss.jsp"></c:import>

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-8 mt-4">
		<div class="row">
			<h2>${requestScope.board } List</h2>
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
			    </tr>
			  </thead>
			  <tbody class="table-group-divider">
			    <c:forEach items="${requestScope.list }" var="dto">
			    	<tr>
			    		<td>${pageScope.dto.num }</td>
			    		<td><a href="./detail.iu?num=${pageScope.dto.num }">${pageScope.dto.title }</a></td>
			    		<td>${pageScope.dto.contents }</td>
			    		<td>${pageScope.dto.writer }</td>
			    		<td>${pageScope.dto.regDate }</td>
			    		<td>${pageScope.dto.hit }</td>
			    	</tr>
			    </c:forEach>
			  </tbody>
			</table>
		</div>
		
		<c:if test="${not empty sessionScope.member }">
			<div class="row">
				<a class="btn btn-success" href="./add.iu" role="button">${requestScope.board } 작성</a>
			</div>
		</c:if>
		
	</section>
	
	<nav aria-label="Page navigation example">
	  <ul class="pagination justify-content-center">
	    <li class="page-item">
	      <a class="page-link" href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <c:forEach begin="${pager.startNum }" end="${pager.lastNum }" step="1" var="i">
	    	<li class="page-item"><a class="page-link" href="./list.iu?page=${i }">${i }</a></li>
	    </c:forEach>
	    <li class="page-item">
	      <a class="page-link" href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
	
	<c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>
	
</body>
</html>