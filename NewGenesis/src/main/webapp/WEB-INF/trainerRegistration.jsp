<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Trainer Registration</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/main.css" />
	</head>
<body>
	<div class="container">
		<h1>Trainer Registration</h1>
	<div>
		<form:form action="/trainerRegistration" class="user-form" method="post" modelAttribute="trainer">
    			<div class="form-group">
        			<form:label path="name">Name</form:label>
        			<form:errors path="name"/>
        			<form:input path="name"/>
    			</div>
    			<div class="form-group">
        			<form:label path="email">Email</form:label>
        			<form:errors path="email"/>
        			<form:input type="email" class="form-control" path="email"/>
    			</div>
    			<div class="form-group">
        			<form:label path="address">Address</form:label>
        			<form:errors path="address"/>
        			<form:input type="address" path="address"/>
    			</div>
    			<div class="form-group">
        			<form:label path="city">City</form:label>
        			<form:errors path="city"/>
        			<form:input type="text" path="city"/>
    			</div>
    			<div class="form-group">
        			<form:label path="state">State</form:label>
        			<form:errors path="state"/>
        			<form:input type="text" path="state"/>
    			</div>
    			<div class="form-group">
        			<form:label path="password">Create Password</form:label>
        			<form:errors path="password"/>     
        			<form:input type="password" class="form-control" path="password"/>
    			</div>
    			<div class="form-group">
        			<form:label path="confirmPassword">Confirm Password</form:label>
       			 	<form:errors path="confirmPassword"/>     
        			<form:input type="confirmPassword" class="form-control" path="confirmPassword"/>
        		</div>
        	<div class="user-form">
				<h4>Select which areas you're consider an expert on.</h4>
				Aerobic:<form:checkbox path="fitnessList" value="Aerobic"/><br>
				Anaerobic:<form:checkbox path="fitnessList" value="Anaerobic"/><br>
				Self-Defense:<form:checkbox path="fitnessList" value="Self-Defense"/><br>
				Cross-Fit:<form:checkbox path="fitnessList" value="Cross-Fit"/><br>
				Joint-Flexibility:<form:checkbox path="fitnessList" value="Joint-Flexibility"/><br>
				Nutrition:<form:checkbox path="fitnessList" value="Nutrition"/><br>
				Strength-Training:<form:checkbox path="fitnessList" value="Strength-Training"/><br>
			</div>
			<div class="user-form">
				<h4>Tell us more about your training style</h4>
				<form:label path="aboutMe">About Me...</form:label>
				<form:textarea path="aboutMe" rows="5" cols="30"/>
				<form:errors path="aboutMe"/>
			</div>
			<input class="btn btn-primary" type="submit" value="Submit">
		</form:form>
		</div>
	</div>
</body>
</html>