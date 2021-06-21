<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<a href="/languages">Dashboard</a>
<c:out value="${5+4}"></c:out>
<h1><c:out value="${language.name}"/></h1>
<p>Language: <c:out value="${language.creator}"/></p>
<p>Number of pages: <c:out value="${language.version}"/></p>
<a href="/languages/edit/${language.id}">Edit</a>
<a href="/languages/${language.id}">Delete</a>
<form action="/languages/${language.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
