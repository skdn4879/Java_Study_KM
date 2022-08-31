<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Terms</title>
<c:import url="../template/bootstrapCss.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<section class="container-fluid col-lg-8 mt-4">
		<div class="row">
			<h1>약관 동의</h1>
		</div>
		<div class="row">
			<form action="./join" method="get" id="termsFrm">
				<div class="form-check">
				  <input class="form-check-input" type="checkbox" value="" id="boxAll">
				  <label class="form-check-label" for="boxAll">
				    전체동의
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input boxes req" type="checkbox" value="" id="box1">
				  <label class="form-check-label" for="box1">
				    이용약관 동의(필수)
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input boxes req" type="checkbox" value="" id="box2">
				  <label class="form-check-label" for="box2">
				    이용 동의(필수)
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input boxes" type="checkbox" value="" id="box3">
				  <label class="form-check-label" for="box3">
				    마케팅 동의(선택)
				  </label>
				</div>
				<div class="form-check">
				  <input class="form-check-input boxes" type="checkbox" value="" id="box4">
				  <label class="form-check-label" for="box4">
				    문자 동의(선택)
				  </label>
				</div>
				<button class="w-20 btn btn-lg btn-primary" type="button" id="nextBtn">회원가입</button>
			</form>
		</div>
	</section>
	
	<c:import url="../template/footer.jsp"></c:import>
	
	<c:import url="../template/bootstrapJs.jsp"></c:import>
	<script type="text/javascript" src="../resources/js/member.js"></script>
	<script type="text/javascript">
		termsCheck();
	</script>
	
</body>
</html>