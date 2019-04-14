<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="body"></div>
	<div class="header">
	</div>
	<br>
	<div class="login">
	
		<form:form modelAttribute="customer" method="POST" action="/users/addUser">
			<form:input type="text" placeholder="userId" name="user" path="id" required="required"/><br><br>
			<form:input type="text" placeholder="username" name="user" path="name" required="required"/><br><br>
			<form:input type="text" placeholder="address" name="address" path="address" required="required"/><br><br>
			<form:input type="password" placeholder="password" name="password" path="password" required="required"/><br><br>
			<input type="submit" value="Register">
			<a href="/users/Login">Login</a>
		</form:form>
	</div>
</body>
</html>