<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Add</title>

<c:import url="../template/bootstrapCss.jsp"></c:import>

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-8 mt-4">
		<div class="row">
			<h2>공지사항 작성</h2>
		</div>
		<div class="row">
			<form method="post" action="add.iu">
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">Title</span>
				  <input type="text" class="form-control" placeholder="Title" aria-label="Username"
				   aria-describedby="basic-addon1" name="title" required="required">
				</div>
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">Writer</span>
				  <input type="text" class="form-control" placeholder="Writer" aria-label="Username"
				   aria-describedby="basic-addon1" name="writer" required="required" value="${sessionScope.member.userName }" readonly="readonly">
				</div>
				<div class="input-group input-group-lg">
				  <span class="input-group-text">Contents</span>
				  <textarea class="form-control" aria-label="With textarea" name="contents"></textarea>
				</div>
				<input class="btn btn-primary" type="submit" value="공지사항 작성">
			</form>
		</div>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>
	
</body>
</html>