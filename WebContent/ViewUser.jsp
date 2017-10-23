<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
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
        <h1>Event Manager</h1>
    </header>

    <nav>
        <ul>
            <li><a href="Logout">Logout</a></li>
        </ul>
        <ul>
            <li><a href="ListEvents"> Back to Events </a></li>
        </ul>
    </nav>

    <article>
        <h1><c:out value="${user.name}"/> [ <a href="EditUser?id=${user.CIN}">Edit</a> ] </h1>
        <p><strong>CIN: </strong> <c:out value="${user.CIN}"/></p>
        <p><strong>Gender: </strong> <c:out value="${user.gender}"/></p>
    </article>

    <footer>Supported browsers: Mozilla Firefox & Chrome</footer>

</div>

</body>
</html>