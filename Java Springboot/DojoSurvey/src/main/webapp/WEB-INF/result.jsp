<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:out value="${5+6}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Results</title>
    <style>
    *{
        margin: 0 auto;
        padding: 0 auto;
    }
    .container{
        border: 2px solid black;
        width: 300px;
        height: 300px;
    }
    button{
        margin-top: 60px;
        margin-left: 230px;
    }
    h1{
        text-decoration: underline;
    }
    </style>

</head>
<body>
    <div class="container">
        <h1>Submitted info</h1>
        <p>Name : <c:out value="${name}"/></p>
        <p>Dojo Location : <c:out value="${dojoLoc}"/></p>
        <p>Favorite Language : <c:out value="${favLan}"/></p>
        <p>Comment : <c:out value="${textBox}"/></p>
        
        <form method="get" action="/back">
    <button type="submit">Go Back</button>
</form>
    </div>
</body>
</html>