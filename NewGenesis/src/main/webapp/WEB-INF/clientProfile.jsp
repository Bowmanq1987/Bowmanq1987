<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Profile Page</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
		<link rel="stylesheet" href="/css/main.css" />
</head>
<body>
	<div class ="navbar">
		<h1 class="titles">Welcome <c:out value="${client.name}"/></h1>
			<ul class="navbar menu">
				<li class="main"><a href="/findTrainer">Find a Trainer</a></li>
				<li class="main"><a href="/edit/${client.id}">Edit Profile</a></li>
				<li class="main"><a href="/logout" class="btn btn-primary">Logout</a></li>
			</ul>
	</div>
	<div class="container">
		<p><c:out value="${client.name}"/></p>
		<p><c:out value="${client.address}"/></p>
		<p><c:out value="${client.city}"/></p>
		<p><c:out value="${client.state}"/></p>
	</div>
	<div class="container">
		<ul>
			<c:forEach items="${client.fitnessList}" var="style">
				<li><c:out value="${style}"/></li><br>
			</c:forEach>
		</ul>
	</div>
	<div class="container">
		<p>
			<c:out value ="${client.aboutMe}"/>
		</p>
	</div>
</body>
</html>