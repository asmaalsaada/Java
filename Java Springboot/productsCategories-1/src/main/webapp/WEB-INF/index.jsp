<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Product</title>
</head>
<body>
<h1>Add a Product</h1>
<form:form action="/new/pro" method="post" modelAttribute="Product">
	
		<p>
			<form:label path="name">Name : </form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>

		<p>
			<form:label path="description">Description : </form:label>
			<form:errors path="description" />
			<form:textarea type="text" path="description" />
		</p>
		<p>
			<form:label path="price">Price : </form:label>
			<form:errors path="price" />
			<form:input path="price" />
		</p>
		<input type="submit" value="Add New Product" />
	</form:form>
</body>
</html>