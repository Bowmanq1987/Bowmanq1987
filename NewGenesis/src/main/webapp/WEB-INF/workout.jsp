<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Create a Workout</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/main.css" />
</head>
<body>
	<%
	Date today = new Date();
	%>
	<div class ="navbar">
		<h1 class="titles">Welcome <c:out value="${client.name}"/></h1>
			<ul class="navbar menu">
				<li class="main"><a href="/findTrainer">Find a Trainer</a></li>
				<li class="main"><a href="/edit/${client.id}">Edit Profile</a></li>
				<li class="main"><a href="/logout" class="btn btn-primary">Logout</a></li>
			</ul>
	</div>
	<div class="container">
		<h4>${client.name} and ${trainer.name}</h4>
		<h5>Previous Workouts</h5>
		<p>
			<c:forEach items="${client.personalTrainers}" var="clientWorkout">
			<c:when test="${clientWorkout.contains(trainer.id)}">
			<c:when test="${clientWorkout.workoutDate.before(today)}">
			<c:out value="${clientWorkout.workoutDate}"></c:out>
			</c:when>
			</c:when>
			</c:forEach>
		</p>
			<h5>Upcoming Workout</h5>
		<p>
			<c:forEach items="${client.personalTrainers}" var="clientWorkout">
			<c:when test="${clientWorkout.contains(trainer.id)}">
			<c:when test="${clientWorkout.workoutDate.after(today)}">
			<c:out value="${clientWorkout.workoutDate}"></c:out>
			</c:when>
			</c:when>
			</c:forEach>
		</p>
		</div>
	<div class="date-form">
		<h4>Schedule a New Workout</h4>
		<form:form action="/createWorkout/${trainer.id}"  modelAttribute="workouts">
		<form:label path="workoutDate" >Date</form:label>
        <form:errors path="workoutDate"/>     
        <form:input type="date" path="workoutDate"/>
       				<input class="btn btn-primary" type="submit" value="Submit">
         </form:form>
	</div>

</body>
</html>