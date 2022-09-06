<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-success">
	<tbody>
		<c:forEach items="${commentList }" var="commentDTO">
			<tr>
				<td>${commentDTO.contents }</td>
				<td>${commentDTO.writer }</td>
				<td>${commentDTO.regDate }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>