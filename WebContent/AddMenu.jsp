<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Menu</title>
</head>
<body>
<form action="AddMenu" method="post">
<h1>Add New Menu</h1>
<fieldset>
<legend>Menu Info</legend>
<div>
<label for="name">Name:</label>
<input type="text" id="name" name="name" required>
</div>
</fieldset>
<div class="button">
<button type="submit">Submit</button>
</div>

</form>
</body>
</html>