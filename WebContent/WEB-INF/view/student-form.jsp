<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
label {
	display: inline-block;
	width: 80px;
	font-size: 18px;
	margin-right: 20px;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<h1>Register a new student!</h1>
	<h2>Enter the details below.</h2>
	<form action="save" method="post">
		<input type="hidden" name="id" value="${student.id}">
		<label for="name">Name:</label> <input type="text" name="name"
			value="${student.name}"><br> <label for="department">Department:</label>
		<input type="text" name="department" value="${student.department}"><br>
		<label for="country">Country:</label> <input type="text"
			name="country" value="${student.country}"><br> <input
			type="submit" value="Submit">
	</form>
	<p>
		<a href="registeredStudents">Back to Student List</a>
	</p>
</body>
</html>