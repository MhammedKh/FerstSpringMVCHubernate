<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>

	<h2>All Student Information</h2>
	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
		</tr>
		<c:forEach var="student" items="${studentList}">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.age}</td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>