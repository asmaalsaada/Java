<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Event : ${event.name}</title>
<style>
main{
display:flex;
justify-content:space-between;
align-items:center;
}
section{
width:50%;
}
aside{
justify-content:center;
display-flex:column;
justify-content:center;
}
.msgWall{
border: 2px solid black;
font-size:large;
overflow-y: scroll;
height: 200px;
}

.form{
margin:3rem;
flex-direction: column;
    display: flex;
    flex-wrap: wrap;
    align-content: stretch;
    justify-content: center;
    align-items: flex-end;
}table {
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
	<main>
		<section class="event">
			<h1>${event.name}</h1>
			<p>Host : ${event.host.firstName}  ${event.host.lastName}</p>
			<p>Date : ${event.date}</p>
			<p>Location : ${event.city},${event.state}</p>
			<p>People who are attending : ${event.users.size()}</p>
			<table>
				<thead>
					<tr>
						<th>Name</th>
						<th>Location</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${event.users}" var="u">
						<tr>
							<td><c:out value="${u.firstName}" /> <c:out
									value="${u.lastName}" /></td>
							<td><c:out value="${u.city}" /> <c:out value="${u.state}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
		
		<aside class="messages">
		<h2>Message Wall</h2>
			<div class="msgWall">
				<c:forEach items="${event.comments}" var="m">
					<p>
						<c:out value="${m.user_text.firstName}" />
						commented :
						<c:out value="${m.text}" />
					</p>
					*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+
				</c:forEach>
			</div>
			
			<form:form class="form" action="/events/${event.id}/messages/new " method="POST"
				modelAttribute="Message">
			  	   <form:hidden value = "${userId.id}" path="user_text" />
				<form:label path="text"> Add Comment:
				<br>
			<form:errors path="text" ></form:errors>
					<form:textarea path="text" ></form:textarea>
				</form:label>
				<input type="submit" value="Post a Massege!">
			</form:form>
			
		</aside>
	</main>
</body>
</html>