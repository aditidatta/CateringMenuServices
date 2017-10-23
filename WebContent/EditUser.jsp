<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<form action="EditUser" method="post">
    <h1>Edit User ${user.name}</h1>

    <fieldset>
        <legend>User Details</legend>
        <div>
            <label for="name">Name: </label>
            <input type="text" id="name" name="name" value="${user.name}" required>
        </div>
        <div>
            <p>Gender: </p>
            <input name="gender" id="female" value="F" type="radio"
            <c:if test="${user.gender eq 'F'.charAt(0)}">
                   checked
            </c:if>>
            <label for="female">Female</label>
            <br>
            <input name="gender" id="male" value="M" type="radio"
            <c:if test="${user.gender eq 'M'.charAt(0)}">
                   checked
            </c:if>>
            <label for="male">Male</label>
            <br>
        </div>
    </fieldset>
    <input type="hidden" name="id" value="${user.CIN}">
    <div class="button">
        <button type="submit">Submit</button>
    </div>
</form>

</body>
</html>
