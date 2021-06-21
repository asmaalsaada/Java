<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

    <%@ page isErrorPage="true" %> 
<c:out value="${5+6}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main</title>
<style type="text/css">
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
</style>
</head>
<body>

<h1>All Books</h1>
<table>
    <thead>
        <tr>
         
            <th>Name</th>
            <th>Version</th>
            <th>Creator</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${language}" var="lang">
        <tr>
            <td> <a href="/languages/${lang.id}/"><c:out value="${lang.name}"/></a></td>
            <td> <c:out value="${lang.version}"/></td>
            <td> <c:out value="${lang.creator}"/></td>
            <td> <a href="/languages/${lang.id}">delete</a>||<a href="/languages/edit/${lang.id}">edit</a></td>
       </tr>
        </c:forEach>
    </tbody>
</table>
<h1>New Language</h1>
<form:form action="/languages" method="post" modelAttribute="Language">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input type="text" path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:input type="text" path="creator"/>
    </p>
    <p>
        <form:label path="version">Version</form:label>
        <form:errors path="version"/>     
        <form:input type="text" path="version"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>