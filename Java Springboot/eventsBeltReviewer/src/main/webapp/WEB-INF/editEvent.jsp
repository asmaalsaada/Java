<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>Event Planner</title>
</head>
<body>

	<h2>
		Edit <strong>${ event.name }</strong>
	</h2>
	<form:form action="/events/${ event.id }/edit" method="post"
		modelAttribute="event">
		<input type="hidden" name="_method" value="put">
		<form:hidden value="${ userId }" path="host" />
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
		<input type="submit" value="Update Event" />
	</form:form>

</body>
</html>