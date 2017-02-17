<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>

	<h2>All University Information</h2>
	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>address</th>
		</tr>
		<c:forEach var="university" items="${universityList}">
			<tr>
				<td>${university.id}</td>
				<td>${university.name}</td>
				<td>${university.address}</td>
			</tr>

		</c:forEach>

	</table>
</body>
</html>