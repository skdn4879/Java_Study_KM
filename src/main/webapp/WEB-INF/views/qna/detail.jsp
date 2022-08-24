<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA Detail</title>
<c:import url="../template/bootstrapCss.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-8 mt-4">
		<div class="row">
			<h2>QNA 상세</h2>
		</div>
		<div class="row">
			<table class="table table-info">
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
			    <tr>
			    	<td>${requestScope.boardDTO.num }</td>
			    	<td>${requestScope.boardDTO.title }</td>
			    	<td>${requestScope.boardDTO.contents }</td>
			    	<td>${requestScope.boardDTO.writer }</td>
			    	<td>${requestScope.boardDTO.regDate }</td>
			    	<td>${requestScope.boardDTO.hit }</td>
			    	<td>${requestScope.boardDTO.ref }</td>
			    	<td>${requestScope.boardDTO.step }</td>
			    	<td>${requestScope.boardDTO.depth }</td>
			    </tr>
			  </tbody>
			</table>
		</div>
		<c:if test="${sessionScope.member.userName == requestScope.boardDTO.writer }">
			<div class="row">
				<a class="btn btn-success" href="./update.iu?num=${requestScope.boardDTO.num }" role="button">QNA 수정</a>
				<a class="btn btn-danger" href="./delete.iu?num=${requestScope.boardDTO.num }" role="button">QNA 삭제</a>
			</div>
		</c:if>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>

</body>
</html>