<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration and Login Page</title>
    <style>
    main{
    }
    section{
    display:flex;
    justify-content:space-evenly;
    align-items:center;}
    .register{
    border :2px solid black;
    }
    
    </style>
</head>
<body>
<main>
<header>
        <h1>Welcome</h1>
        </header>
        <section>
    <div class="register">
    <h2>Register</h2>
    <p><form:errors path="user.*"/></p>
        <p><c:out value="${error}" /></p>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label path="firstName"  >First Name:</form:label>
            <form:input type="firstName"  path="firstName"/>
        </p>
        <p>
            <form:label path="lastName"  >last Name:</form:label>
            <form:input type="lastName"  path="lastName"/>
        </p>
        <p>
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </p>
        <div class="location">
        <p>
            <form:label path="city"  >Location :</form:label>
            <form:input type="city"  path="city"/>
        </p>
        
        <form:select path="state"> <!-- instead of state table we have a 5 states drop menu-->
         <form:option value="CA" label="CA" path="state"/>  
        <form:option value="WA" label="AW" path="state"/>  
        <form:option value="AZ" label="AZ" path="state"/>  
        <form:option value="OH" label="OH" path="state"/>
        <form:option value="NY" label="NY" path="state"/>  
        </form:select>
        </div>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password  path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password  path="passwordConfirmation"/>
        </p>
        
        <input type="submit" value="Register!"/>
    </form:form>
    </div>
    <div class="login">
    <h2>Login</h2>
    <p><c:out value="${error}" /></p>
    <form method="post" action="/login">
        <p>
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <input type="submit" value="Login!"/>
    </form>  
    </div>
    </section>
    </main>
</body>
</html>