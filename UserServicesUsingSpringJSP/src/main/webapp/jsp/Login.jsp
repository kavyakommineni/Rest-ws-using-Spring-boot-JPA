<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<link href="/css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div class="body"></div>
	<div class="header">
	</div>
	<br>
	<div class="login">
		<form:form modelAttribute="user" method="POST" action="/users/loginCheck">
			<form:input type="text" placeholder="userId" name="user" path="name" requierd="required"/><br><br>
			<form:input type="password" placeholder="password" name="password" path="password" required="required"/><br><br>
			<input type="submit" value="Login">
			<a href="/users/Register">Register</a>
		</form:form>
				
	</div>
</body>
</html>