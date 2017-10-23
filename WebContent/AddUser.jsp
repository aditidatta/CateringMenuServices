<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New User</title>
</head>
<body>
<form action="AddUser" method="post">
<h1>Add User </h1>
    <c:if test="${not empty message}">
        <h3><strong>${message}</strong></h3>
    </c:if>

    <fieldset>
        <legend>User Details</legend>
        <div>
            <label for="name">Name: </label>
            <input type="text" id="name" name="name"
                   <c:if test="${name ne null}"> value="${name}" </c:if>
                   required>
        </div>

        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <div>
            <p>Gender: </p>
            <input name="gender" id="female" value="F" type="radio"
                <c:if test="${gender ne null && gender eq 'F'.charAt(0)}">
                    checked
                    </c:if>>
            <label for="female">Female</label>
            <br>
            <input name="gender" id="male" value="M" type="radio"
                <c:if test="${gender ne null && gender eq 'M'.charAt(0)}">
                   checked
                </c:if>>
            <label for="male">Male</label>
            <br>
        </div>
    </fieldset>
    <div class="button">
        <button type="submit">Submit</button>
    </div>
</form>

</body>
</html>
