<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edit Client Profile</title>
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
	<h1>Anything your wish to change about your profile?</h1>
	<div>
		<form:form action="/edit/${client.id}" class="user-form" method="post" modelAttribute="client">
    			<div class="form-group">
        			<form:label path="name">Name</form:label>
        			<form:errors path="name"/>
        			<form:input path="name"/>
    			</div>
    			<div class="form-group">
        			<form:label path="address">Address</form:label>
        			<form:errors path="address"/>
        			<form:input type="address" path="address"/>
    			</div>
    			<div class="form-group">
        			<form:label path="city">Email</form:label>
        			<form:errors path="city"/>
        			<form:input type="city" path="state"/>
    			</div>
    			<div class="form-group">
        			<form:label path="state">Email</form:label>
        			<form:errors path="state"/>
        			<form:input type="state" path="state"/>
    			</div>
    			<div class="user-form">		
					<h4>Select which areas you wish to improve on.</h4>
					Aerobic:<form:checkbox path="fitnessList" value="Aerobic"/>
					Anaerobic:<form:checkbox path="fitnessList" value="Anaerobic"/>
					Self-Defense:<form:checkbox path="fitnessList" value="Self-Defense"/>
					Cross-Fit:<form:checkbox path="fitnessList" value="Cross-Fit"/>
					Joint-Flexibility:<form:checkbox path="fitnessList" value="Joint-Flexibility"/>
					Nutrition:<form:checkbox path="fitnessList" value="Nutrition"/>
					Strength-Training:<form:checkbox path="fitnessList" value="Strength-Training"/>
				</div>
				<div class="user-form">
					<h4>Tell us more about your fitness goals</h4>
					<form:label path="aboutMe">About Me...</form:label>
					<form:textarea path="aboutMe" rows="5" cols="30"/>
					<form:errors path="aboutMe"/>
				</div>
				<input class="btn btn-primary" type="submit" value="Submit">
			</form:form>
	</div>
</body>
</html>