<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>홈페이지</h1>
	<c:if test="${empty sessionScope.member }">
		<a href = "/members/login">로그인</a>
		<a href = "/members/join">회원가입</a>
	</c:if>
	<c:if test="${not empty sessionScope.member }">
		<h3>${sessionScope.member.name }님 환영합니다.</h3>
		<a href = "/members/logout">로그아웃</a>
		<a href = "/members/search">회원 검색</a>
		<hr>
		<a href="/bankbook/list">통장 목록</a>
	</c:if>
	
</body>
</html>
