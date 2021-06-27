<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
<h1>Add a Category</h1>
<form:form action="/new/cat" method="post" modelAttribute="Category">
	
		<p>
			<form:label path="name">Name : </form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<input type="submit" value="Add New Category" />
	</form:form>
</body>
</html>