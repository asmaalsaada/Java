<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify!</title>
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
</head>
<body>
	<header>
		<a href="/songs/new">New Song</a> <a href="/search/topTen">Top Ten
			Songs</a>
		<form action="/search" method="post">
			<input type="text" value="search" name="search"> <input
				type="submit" value="search by artist">
		</form>
	</header>
	<section>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${song}" var="song">
					<tr>
						<td><a href="/songs/${song.id}/"><c:out
									value="${song.title}" /></a></td>
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
	</section>
</body>
</html>