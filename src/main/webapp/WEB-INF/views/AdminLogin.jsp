<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<form action="/admin/login" method="post">
<label>Enter UserName</label>
<input type="text" name="userName" required="required"><br>
<label>Enter Password</label>
<input type="password" name="pass" required="required"><br>
<input type="submit" value="Login">
</form>
</div>
</body>
</html>