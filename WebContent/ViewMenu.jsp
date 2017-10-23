<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Welcome to Catering Menu Management System</title>
    <style>
        div.container {
            width: 100%;
            border: 1px solid gray;
        }

        header, footer {
            padding: 1em;
            color: white;
            background-color: black;
            clear: left;
            text-align: center;
        }

        nav {
            float: left;
            max-width: 160px;
            margin: 0;
            padding: 1em;
        }

        nav ul {
            list-style-type: none;
            padding: 0;
        }

        nav ul a {
            text-decoration: none;
        }

        article {
            margin-left: 170px;
            border-left: 1px solid gray;
            padding: 1em;
            overflow: hidden;
        }

        article ul {
            list-style-type: disc;
            padding: 0;
        }

        article li {
            margin-left: 40px;
            list-style-type: disc;
            color: darkolivegreen;
            width: 200px;
        }

        td {
            width: 200px;
        }
    </style>
</head>
<body>
<div class="container">
    <header>
        <img src="img/logo.png" alt="logo" width="130" height="90"/>
        <h1>Catering Menu Management System</h1>
    </header>

    <nav>
        <ul>
            <li><a href="Catering"><< Home <<</a></li>
        </ul>

        <c:forEach var="menu" items="${menus}" varStatus="loop">
            <ul>
                <li><a href="ViewMenu?id=${menu.id}">${menu.name}</a></li>
            </ul>
        </c:forEach>
        <ul>
            <li><a href="CaterLogout">Logout</a></li>
        </ul>
    </nav>

    <article>
        <h3>Dishes available in ${menu.name}..</h3>
        <c:if test="${fn:length(dishes) eq 0}">
            <p>No Dishes Found</p>
        </c:if>
        <table>
        <c:forEach var="dish" items="${dishes}" varStatus="loop">
            <tr>
                <td>
                    <h4><a href="ViewDish?id=${dish.id}">${dish.name}</a> [<a href="DeleteDish?dishId=${dish.id}?menuId=${menu.id}">Delete</a>]</h4>
                    <ul>
                        <c:forEach var="ing" items="${dish.ingredients}">
                            <li>${ing.key.name}</li>
                        </c:forEach>
                    </ul>
                </td>
                <td align="right"><strong>$ ${dish.price}</strong>></td>
            </tr>
        </c:forEach>
        </table>
        <br>
        <br>
        <form action="AddDish">
            <input type="hidden" name="menuId" value="${menu.id}">
            <input type="submit" value="Add New Dish" />
        </form>
        <!-- <p><a href="AddDish?menuId=${menu.id}">Add New Dish</a></p> -->
        <br>
    </article>

</div>
</body>
</html>
