<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
</head>
<body>
	

					<h1><c:out value="${person.firstName}" /></h1>
					<p>License Number : <c:out value="${person.license.number}" /></p>
					<p>State :<c:out value="${person.license.state}" /></p>
					<p>Expiration Date :<c:out value="${person.license.expirationDate}" /></p>
					<a href="/persons/new">New Person</a>
				
</body>
</html>