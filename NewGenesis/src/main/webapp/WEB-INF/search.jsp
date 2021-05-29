<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>
<%@ page language="java"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Available trainers</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/main.css" />
</head>
<body>
	<div class ="navbar">
		<h1 class="titles">Welcome ${client.name}</h1>
			<ul class="navbar menu">
				<li class="main"><a href="/findTrainer">Find a Trainer</a></li>
				<li class="main"><a href="/edit/${client.id}">Edit Profile</a></li>
				<li class="main"><a href="/logout" class="btn btn-primary">Logout</a></li>
			</ul>
	</div>
	<h1 class="titles">Available Trainers near you</h1>
	<table class="table table-dark table-hover">
		<thead>
				<tr>
					<th>Trainer Name</th>
					<th>Trainer Bio</th>
					<th>Schedule Session</th>
					<th>Match</th>
				</tr>
				<tbody>
					<c:forEach items="${trainer}" var="trainer">
						<tr>
							<td>${trainer.name}</td>
							<td>${trainer.aboutMe}</td>
							<td><a href="/createWorkout/${trainer.id}">Schedule Workout Session</a></td>
							<td><c:forEach items="${trainer.fitnessList}" var="style">
								<c:out value="${style}"/>
							</c:forEach>
				</c:forEach>
			</tbody>
			</table>
</body>
</html>