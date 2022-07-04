<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
	border: 1px solid black;
	text-align: left;
	vertical-align: middle;
}

th, td {
	padding: 8px;
}

thead {
	background-color: #333;
	color: white;
}

thead th {
	width: 25%;
}

tbody tr:nth-child(odd) {
	background-color: #fff;
}

tbody tr:nth-child(even) {
	background-color: #eee;
}
</style>
</head>
<body>
<h1>Directory - Registered Students</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Department</th>
				<th>Country</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${registeredStudents}" var="student">
				<tr>
					<td>${student.name}</td>
					<td>${student.department}</td>
					<td>${student.country}</td>
					<td>
						<!-- update student detail --> <a href="update?id=${student.id}">update</a>
						<!-- delete student --> <a href="delete?id=${student.id}">delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<a href="./..">Back to Home</a>
	</p>
</body>
</html>