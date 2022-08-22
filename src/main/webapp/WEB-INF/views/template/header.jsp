<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<header class="container-fluid">
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/bankbook/list">상품리스트</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/board/list">공지사항</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/members/search">회원검색</a>
                </li>
                
               <c:choose>
               		<c:when test="${not empty sessionScope.member }">
	                <li class="nav-item">
	                    <a class="nav-link" href="/members/myPage?userName=${sessionScope.member.userName }">마이페이지</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="/members/logout">로그아웃</a>
	                </li>
	            	</c:when>
	                
	                <%-- <c:when test="${empty sessionScope.member }"> --%>
	                <c:otherwise>
	                <li class="nav-item">
	                    <a class="nav-link" href="/members/login">로그인</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="/members/join">회원가입</a>
	                </li>
	                </c:otherwise>
	                <%-- </c:when> --%>
	                
                </c:choose>
                
                </ul>
            </div>
            </div>
        </nav>
    </header>