<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
</head>
<body>
<h1>New License</h1>
	
	<form:form action="/ninjas/new" method="post" modelAttribute="Ninja">
	<form:select path="dojo">//should be instance from 2nd model with relation
	<c:forEach items="${dojos}" var="pe"> //name of passed attribute
	<form:option value="${pe.id}"> ${pe.name} ></form:option>
	</c:forEach>
	</form:select>
		

		<p>
			<form:label path="firstName">First Name </form:label>
			<form:errors path="firstName" />
			<form:input type="text" path="firstName" />
		</p>
		<p>
			<form:label path="lastName">last Name</form:label>
			<form:errors path="lastName" />
			<form:input path="lastName" />
		</p>
		<p>
			<form:label path="age">Age </form:label>
			<form:errors path="age" />
			<form:input type="number" path="age" />
		</p>
		<input type="submit" value="Creat Ninja" />
	</form:form>
</body>
</html>