<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<h1><c:out value="${dojo.name}"/></h1>
<table>
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
         
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${dojo.ninjas}" var="dojo">
        <tr>
            
            <td><c:out value="${dojo.firstName}"/></td>
            <td><c:out value="${dojo.lastName}"/></td>
            <td><c:out value="${dojo.age}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>