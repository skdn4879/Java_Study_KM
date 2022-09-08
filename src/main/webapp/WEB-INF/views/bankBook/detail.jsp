<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BankBook Detail</title>
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
			    <tr>
			    	<td>${requestScope.bookDetail.bookNum }</td>
			    	<td>${requestScope.bookDetail.bookName }</td>
			    	<td>${requestScope.bookDetail.bookRate }</td>
			    	<c:if test="${requestScope.bookDetail.bookSale == 1 }"><td>판매중</td></c:if>
					<c:if test="${requestScope.bookDetail.bookSale == 0 }"><td>판매금지</td></c:if>
			    	<td>${requestScope.bookDetail.bookContents }</td>
			    </tr>
			  </tbody>
			</table>
		</div>
		<div class="row">
			<a class="btn btn-primary" href="./update?bookNum=${requestScope.bookDetail.bookNum }" role="button">통장 정보 수정</a>
			<a class="btn btn-danger" href="./delete?bookNum=${requestScope.bookDetail.bookNum }" role="button">통장 정보 삭제</a>
		</div>
	</section>
	

	
	<!-- Comment -->
	
	<section class="container-fluid col-lg-8 mt-4">
		<div class = "row">
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">Writer</span>
			  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" name="writer" id="writer">
			</div>
			<div class="input-group mb-3">
			  <span class="input-group-text" id="basic-addon1">Contents</span>
			  <input type="text" class="form-control" placeholder="Contents" aria-label="Username" aria-describedby="basic-addon1" name="contents" id="contents">
			</div>
			<button class="btn btn-success" type="button" id="commentSendBtn" data-booknum="${requestScope.bookDetail.bookNum }">댓글 작성</button>
		</div>
	</section>
	
	<section class="container-fluid col-lg-8 mt-4">
		<div class="row" id="commentList">
			
		</div>
		<button class="btn btn-primary" id="moreBtn">더보기</button>
	</section>
	
	<!-- Comment -->
	
	<button id="commentUpdateBtn" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap" style="display: none;">Open modal for @getbootstrap</button>

	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Update Comment</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <form>
	          <input type="hidden" name="num" id="num">
	          <div class="mb-3">
	            <label for="recipient-name" class="col-form-label">Writer:</label>
	            <input type="text" class="form-control" id="updateWriter" name="writer">
	          </div>
	          <div class="mb-3">
	            <label for="message-text" class="col-form-label">Contents:</label>
	            <textarea class="form-control" id="updateContents" name="contents"></textarea>
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary" id="sendUpdateBtn" data-bs-dismiss="modal">Update</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>
	<script type="text/javascript" src="/resources/js/bankBookComment.js"></script>
</body>
</html>