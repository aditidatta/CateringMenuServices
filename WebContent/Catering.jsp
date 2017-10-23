<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <ul>
                <li><a href="CaterLogout">Logout</a></li>
            </ul>
        </nav>

        <article>
            <h3>Choose a menu..</h3>
            <c:forEach var="menu" items="${menus}" varStatus="loop">
                <ul>
                    <li><a href="ViewMenu?id=${menu.id}">${menu.name}</a> [<a href="DeleteMenu?id=${menu.id}">Delete</a>]</li>
                </ul>
            </c:forEach>
            <br>
            <br>
            <form action="AddMenu">
                <input type="submit" value="Create New Menu" />
            </form>
            <!--<p><a href="AddMenu">Create New Menu</a></p>-->
            <br>
        </article>
    </div>
</body>
</html>
