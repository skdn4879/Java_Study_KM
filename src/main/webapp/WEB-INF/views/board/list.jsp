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
		
		<div class="row mb-3">
			<form method="get" action="./list.iu" class="row row-cols-lg-auto g-3 align-items-center">
				<!-- Controller에서 list를 받는것은 get뿐이므로, 생략가능 -->
			  <div class="col-12">
			    <label class="visually-hidden" for="search">검색어</label>
			    <!-- 라벨의 for와 input의 id를 같게하면 같은 영역으로 인식되서 편리하다. -->
			    <div class="input-group">
			      <input type="text" class="form-control" id="search" name="search">
			    </div>
			  </div>
			
			  <div class="col-12">
			    <label class="visually-hidden" for="kind">Kind</label>
			    <select name="kind" class="form-select" id="kind">
			      <option value="contents">Contents</option>
			      <option value="title">Title</option>
			      <option value="writer">Writer</option>
			    </select>
			  </div>
			
			  <div class="col-12">
			    <button type="submit" class="btn btn-primary">Submit</button>
			  </div>
			</form>
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
			    		<td>
			    		<!-- NoticeDTO에는 depth가 없으므로 예외처리 -->
			    		<c:catch>
			    			<!-- 답글의 깊이에 따라 들여쓰기 -->
			    			<%-- for(int i = begin; i <= end; i++) --%>
			    			<c:forEach begin="1" end="${dto.depth }" step="1">--</c:forEach>
			    		</c:catch>
			    		<a href="./detail.iu?num=${pageScope.dto.num }">${pageScope.dto.title }</a>
			    		</td>
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
			<div class="row mt-4 mb-4">
				<a class="btn btn-success" href="./add.iu" role="button">${requestScope.board } 작성</a>
			</div>
		</c:if>
		
	</section>
	
	<nav aria-label="Page navigation example">
	  <ul class="pagination justify-content-center">
	  	<c:if test="${pager.pre }">
	  		<li class="page-item">
		      <a class="page-link" href="./list.iu?page=${pager.startNum - 1 }&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
	  	</c:if>
	    
	    <c:forEach begin="${pager.startNum }" end="${pager.lastNum }" step="1" var="i">
	    	<li class="page-item"><a class="page-link" href="./list.iu?page=${i }&kind=${pager.kind}&search=${pager.search}">${i }</a></li>
	    </c:forEach>
	    
	    <%-- <c:choose>
	    	<c:when test="${pager.next }">
	    		<li class="page-item">
	    	</c:when>
	    	<c:otherwise>
	    		<li class="page-item disabled">
	    	</c:otherwise>
	    </c:choose> --%>
	    <li class="page-item ${pager.next ? '' : 'disabled' }">
	      <a class="page-link" href="./list.iu?page=${pager.lastNum + 1 }&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
	
	<c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>
	<script src="/resources/js/board.js"></script>
</body>
</html>