<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	welcome:Admin<br>
	User ID = ${pageContext.request.userPrincipal.name}<br>
	
	<c:if test="${not empty pageContext.request.userPrincipal}">
		<p>is Log-in</p>
	</c:if>
	
	<c:if test="${empty pageContext.request.userPrincipal}">
		<p>is Log-out</p>
	</c:if>
	
	<br>
	<a href="/logout">로그 아웃</a><br>
	
</body>
</html>