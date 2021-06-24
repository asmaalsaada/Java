<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
</head>
<body>
	<h1>New License</h1>
	
	<form:form action="/new/license" method="post" modelAttribute="License">
	<form:select path="person">//should be instance from 2nd model with relation
	<c:forEach items="${Person}" var="per"> //name of passed attribute
	<form:option value="${per.id}"> ${per.firstName} ${per.lastName}></form:option>
	</c:forEach>
	</form:select>
		<p>
			<form:label path="state">State</form:label>
			<form:errors path="state" />
			<form:input path="state" />
		</p>

		<p>
			<form:label path="expirationDate">Expiration Date</form:label>
			<form:errors path="expirationDate" />
			<form:input type="date" path="expirationDate" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>