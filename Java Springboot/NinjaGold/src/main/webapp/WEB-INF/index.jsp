<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gold Game</title>
 <style>
        section{
            display: flex;
            justify-content: space-evenly;
            align-items: center;
        }
        .farm_box{
            border: 2px solid black;
            width: 200px;
            height: 200px;
            display: flex;
            justify-content: center;
            align-content: center;
            flex-direction: column;
        }
        .cave_box{
            border: 2px solid black;
            width: 200px;
            height: 200px;
            display: flex;
            justify-content: center;
            align-content: center;
            flex-direction: column;
        }
        .house_box{
            border: 2px solid black;
            width: 200px;
            height: 200px;
            display: flex;
            justify-content: center;
            align-content: center;
            flex-direction: column;
        }
        .casino_box{
            border: 2px solid black;
            width: 200px;
            height: 200px;
            display: flex;
            justify-content: center;
            align-content: center;
            flex-direction: column;
        }
        .title{
            float: left;
        }
        article{
            border: 2px solid black;
            width: 80rem;
            height: 200px;
            margin-top: 150px;
            display: justify;
            overflow-y: scroll;
            color: green;
            font-weight: bold;
        }
    </style>
</head>
<body>
 <div class="gold_counter">
        <p>Your gold : <span>  </span></p>
        <c:out value="${gold}"></c:out>
    </div>
    <section>
        <div class="farm_box">
            <h2>Farm</h2>
            <p>(earns 10-20 golds) </p>
            <form action="/process_money" method="POST">
                <input type="hidden" name="inp" value="farm">
                <button type='submit' name="farm_gold">Find Gold!</button>
            </form>
        </div>
        <div class="cave_box">
            <h2>Cave</h2>
            <p>(earns 5-10 golds) </p>
            <form action="/process_money" method="POST">
              
                <input type="hidden" name="inp" value="cave">
                <button type='submit' name="cave_gold">Find Gold!</button>
            </form>
        </div>
        <div class="house_box">
            <h2>House</h2>
            <p>(earns 2-5 golds) </p>
            <form action="/process_money" method="POST">
                
                <input type="hidden" name="inp" value="house">
                <button type='submit' name="house_gold">Find Gold!</button>
            </form>
        </div>
        <div class="casino_box">
            <h2>Casino</h2>
            <p>(earns/loses 0-50 golds) </p>
            <form action="/process_money" method="POST">
  
                <input type="hidden" name="inp" value="casino">
                <button type='submit' name="casino_gold">Find Gold!</button>
            </form>
            
        </div>
    </section>
    <div class="title">
        <p>Activities : </p>
    </div>
    <article >
	<c:forEach items="${activites}" var="item">
	   ${item}<br>
	</c:forEach>
<!-- the time and session// -->
    </article> 
     
</body>
</html>