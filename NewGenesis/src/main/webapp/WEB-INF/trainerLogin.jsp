<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Trainer Login</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/main.css" />
</head>
<body>
		<div class="container">
				<h1>Login Information</h1>
				<h3>Success is being able to reach back and help someone else.</h3>
				<form method ="Post" action ="/trainerLogin">
				<label for="loginemail">Email</label>
				<input type ="text" id="loginemail" name ="loginemail">
				<label for="loginpassword">Password</label>
				<input type ="text" id="loginpassword" name ="loginpassword">
				<button>Login</button>
				</form>
			</div>
</body>
</html>