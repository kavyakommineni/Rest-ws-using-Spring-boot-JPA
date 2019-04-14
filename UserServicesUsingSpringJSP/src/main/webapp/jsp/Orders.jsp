<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
<link href="/css/style.css" rel="stylesheet" type="text/css">
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<div class="body"></div>
	
	<br>
	<div class="login">
		<p style="font-size: 25px;">Hi ${name}, here are your orders..!</p>
		<table class="table" style="width: 300px">
		  <thead>
		    <tr>
		      <th scope="col" style="column-width:100px;">Order Id</th>
		      <th scope="col" style="column-width:100px;">Order Cost</th>
		      <th scope="col" style="column-width:100px;">Order Status</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach var = "i" items = "${orderList}">
		         <tr>
		         	<td>${i.id}</td>
		         	<td>${i.cost}</td>
		         	<td>${i.status}</td>
		         </tr>
			</c:forEach>
		  </tbody>
		</table>
		<p style="font-size: 25px;"><a href="/users/Login">Logout</a></p>
	</div>
	
</body>
</html>