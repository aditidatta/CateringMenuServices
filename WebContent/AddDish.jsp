<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add New Dish</title>
</head>
<body>
<form action="AddDish" method="post">
    <h1>Add New Dish to ${menu.name}</h1>
    <fieldset>
        <legend>Dish Info</legend>
        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
    </fieldset>

    <fieldset>
        <legend>Ingredients</legend>
        <div>
            <c:forEach var="i" items="${ingredients}">
                <label for="${i.name}">${i.name}:</label>
                <input type="text" id="${i.name}" name="${i.name}" required>
                <br>
            </c:forEach>
        </div>
    </fieldset>

    <input type="hidden" name="menuId" value="${menu.id}">
    <div class="button">
        <button type="submit">Submit</button>
    </div>

</form>
</body>
</html>