<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:out value="${5+6}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
</head>
<body>
<form action='/form' method='POST'>   
            <p>Your Name :<input type="text" name="name"> </p>
            <p>Dojo Location :
            <select name="dojoLoc">
                <option value="ramallah">Ramallah</option>
                <option value="hebron">Hebron</option>
                <option value="nablus">Nablus</option>
            </select> </p>
            <p>Favorite Language : 
            <select name="favLan">
                <option value="Java">Java</option>
                <option value="python">Python</option>
                <option value="javascript">JavaScript</option>
            </select> </p>
            <label for="">Comment :</label> <br>
            <textarea name="textBox" cols="50" rows="5" ></textarea>
            <button type="submit">Button</button>
        </form>
</body>
</html>