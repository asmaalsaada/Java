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
<title>Add to Product</title>
</head>
<body>
<h1> <c:out value="${Product.name}"/>    </h1>
<h2> Categories : </h2>
	<c:forEach items="${Product.categories}" var="cat">	 
		<h3> - <c:out value="${cat.name}" /></h3> 
	</c:forEach>
	<form:form action="/pro/sero" method="POST"
					modelAttribute="CategoryProduct">
					<form:input type="hidden" path="product" value="${Product.id}" />
					<h3>Add Category : </h3>
					<form:select  path="category">
						<c:forEach items="${Categories}" var="c">
							<form:option value="${ c.id }">${ c.name }</form:option>
						</c:forEach>
					</form:select>
					<button >add!</button>
				</form:form>
</body>
</html>