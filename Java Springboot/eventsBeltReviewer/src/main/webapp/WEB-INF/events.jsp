<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>
<style>
.form {
	display: flex;
	flex-wrap: wrap;
	align-items: flex-start;
	justify-content: center;
	align-content: flex-start;
	flex-direction: column;
}

table {
	border: 2px solid black;
	border-collapse: collapse;
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border-left: 2px solid black;
	text-align: left;
	padding: 8px;
}

th {
	background-color: #f2f2f2;
	border-bottom: 2px solid black;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<h1>
		Welcome,
		<c:out value="${userId.firstName}" />
	</h1>
	<a href="/logout">Logout</a>
	<h2>Here are some of the events in your state</h2>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action/Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${evntsInState}" var="e">
				<tr>
					<td><a href="/events/${e.id}/"><c:out value="${e.name}" /></a></td>
					<td><c:out value="${e.date}" /></td>
					<td><c:out value="${e.city}" /> , <c:out value="${e.state}" /></td>
					<td><c:out value="${e.host.firstName}" /></td>
					<td><c:choose>
							<c:when test="${e.host.id == userId.id}">
								<a href="/events/${e.id}/edit"> Edit </a> |
						<form action="/events/${e.id}/delete" method="post">
						<input type="hidden" name="_method" value="delete" />
									<input type="hidden" name="_method" value="delete"> <input
										type="submit" value="Delete">
								</form>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${e.users.contains(userId) }">
										<span>Joined <a href="events/${e.id}/cancel">Cancel
												Join!</a></span>
									</c:when>
									<c:otherwise>
										<a href="/events/${e.id}/join/">Join Event!</a>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Here are some events in other states</h2>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>State</th>
				<th>Host</th>
				<th>Action/Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${evntsNotInState}" var="e">
				<tr>
					<td><a href="/events/${e.id}/"><c:out value="${e.name}" /></a></td>
					<td><c:out value="${e.date}" /></td>
					<td><c:out value="${e.city}" /></td>
					<td><c:out value="${e.state}" /></td>
					<td><c:out value="${e.host.firstName}" /></td>
					<td><c:choose>
							<c:when test="${e.host.id == userId.id}">
								<a href="/events/${e.id}/edit"> Edit </a> |
						<form action="/events/${e.id}/delete" method="post">
									<input type="hidden" name="_method" value="delete"> <input
										type="submit" value="Delete">
								</form>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${e.users.contains(userId) }">
										<span>Joined <a href="events/${e.id}/cancel">Cancel
												Join!</a></span>
									</c:when>
									<c:otherwise>
										<a href="/events/${e.id}/join/">Join Event!</a>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h3>Create an Event!</h3>
	<form:form class="form" method="POST" action="/events/new"
		modelAttribute="Event">
		<form:hidden value="${userId.id} " path="host" />
		<p>
			<form:label path="name">Name:</form:label>
			<form:input type="name" path="name" />
			<form:errors path="name" />
		</p>

		<p>
			<form:label path="city">Location :</form:label>
			<form:input type="city" path="city" />
			<form:errors path="city" />

			<form:select path="state">
				<!-- instead of state table we have a 5 states drop menu-->
				<form:option value="CA" label="CA" path="state" />
				<form:option value="WA" label="AW" path="state" />
				<form:option value="AZ" label="AZ" path="state" />
				<form:option value="OH" label="OH" path="state" />
				<form:option value="NY" label="NY" path="state" />
			</form:select>
		</p>
		<p>
			<form:label path="date">Date:</form:label>
			<form:input type="date" path="date" />
			<form:errors path="date" />
		</p>
		<input type="submit" value="Create Event" />
	</form:form>

</body>
</html>