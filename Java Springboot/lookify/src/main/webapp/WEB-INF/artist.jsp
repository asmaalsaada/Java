<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
<title>Artist</title>

</head>
<body>
	Song by Artist
	<c:out value="${search}" />
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>actions</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${res2}" var="song">
				<tr>
					<td><c:out value="${song.title}" /></td>
					<td><c:out value="${song.rating}" /></td>
					<td>
						<form action="/songs/${song.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete"> <input
								type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>






</body>
</html>