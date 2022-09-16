<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>

<c:import url="../template/bootstrapCss.jsp"></c:import>
<c:import url="../template/jQueryJs.jsp"></c:import>
<c:import url="../template/summerNote.jsp"></c:import>

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-8 mt-4">
		<div class="row">
			<h2>${requestScope.board } 수정</h2>
		</div>
		<div class="row">
			<form method="post" action="update.iu" enctype="multipart/form-data">
				<div class="input-group mb-3">
				  <span class="input-group-text" id="basic-addon1">Title</span>
				  <input type="text" class="form-control" placeholder="Title" aria-label="Username"
				   aria-describedby="basic-addon1" name="title" required="required" value="${requestScope.boardDTO.title }">
				</div>
				<div class="input-group mb-3">
				  <input type="hidden" class="form-control" placeholder="Num" aria-label="Username"
				   aria-describedby="basic-addon1" name="num" required="required" value="${requestScope.boardDTO.num }">
				</div>
				<div class="input-group input-group-lg">
				  <span class="input-group-text">Contents</span>
				  <textarea class="form-control" aria-label="With textarea" name="contents" id="contents">${requestScope.boardDTO.contents }</textarea>
				</div>
				
				<c:forEach items="${boardDTO.boardFileDTOs }" var="fileDTO">
					<div class="input-group mb-3">
					  <span class="form-control">${fileDTO.oriName }</span>
					  <button type="button" class="btn btn-danger fileDelete" data-file-num="${fileDTO.fileNum }">삭제</button>
					</div>
				</c:forEach>
				
				<div id="addFiles">
					<button type="button" class="btn btn-danger" id="fileAdd">파일 추가</button>
				</div>
				
				<input class="btn btn-primary mt-4" type="submit" value="${requestScope.board } 수정">
			</form>
		</div>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>
	<script type="text/javascript" src="/resources/js/board_file.js"></script>
	<script type="text/javascript">
		setCount(${boardDTO.boardFileDTOs.size()});
	</script>
	<script type="text/javascript">
		$("#contents").summernote();
	</script>
	
</body>
</html>