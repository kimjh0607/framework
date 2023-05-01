<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm</title>
</head>
<body>
	<h1>로그인</h1>
	<c:url value="j_spring_security_check" var="loginUrl"/>
	<form action="${loginUrl}" method="post"> <!-- 변수로써도되고 직접넣을수도있음 --> 
		<c:if test="${param.error!=null}">
			<p>Login Error<br>${error_message}</p>
		</c:if>
		ID: <input type="text" name="j_username" /><br>
		PW: <input type="text" name="j_password"/><br>
		<input type="submit" value="LOGIN"/><br>
	</form> 
</body>
</html>