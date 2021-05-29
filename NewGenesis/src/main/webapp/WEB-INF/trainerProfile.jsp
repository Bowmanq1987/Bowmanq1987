<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Profile page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/main.css" />
</head>
<body>
<%
	Date today = new Date();
	%>
	<div class ="navbar">
		<h1 class="titles">Welcome ${trainer.name}</h1>
			<ul class="navbar menu">
				<li class="main"><a href="/trainerEdit/${trainer.id}">Edit Profile</a></li>
				<li class="main"><a href="/logout" class="btn btn-primary">Logout</a></li>
			</ul>
		</div>
		<div>
			<p><c:out value="${trainer.name}"/></p>
			<p><c:out value="${trainer.address}"/></p>
			<p><c:out value="${trainer.city}"/></p>
			<p><c:out value="${trainer.state}"/></p>
	</div>
	<div>
		<ul>
			<c:forEach items="${trainer.fitnessList}" var="style">
				<li><c:out value="${style}"/></li><br>
			</c:forEach>
		</ul>
	</div>
	<div>
		<p>
			<c:out value ="${trainer.aboutMe}"/>
		</p>
		<h5>Upcoming Workout</h5>
		<p>
			<c:forEach items="${trainer.workout}" var="workout">
			<c:when test="${trainer.workout.workoutDate > today}">
			<c:out value="${trainer.workout.workoutDate}"></c:out>
			</c:when>
			</c:forEach>
		</p>
	</div>
</body>
</html>