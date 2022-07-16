<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>
</head>
<body bgcolor="gray">
<c:if test="${msg!=null}"> ${msg} </c:if><br>

<form action="/emp/register" method="post">
<label>Enter Name</label>
<input type="text" required="required" name="name"><br>

<label>Enter Email</label>
<input type="email" required="required" name="email"><br>

<label>Enter Job Role</label>
<input type="text" required="required" name="role"><br>

<label>Enter Your Department name</label>
<input type="text" required="required" name="depName"><br>

<label>Create Password</label>
<input type="password" required="required" name="pass"><br>

<label>Enter Your DoB (dd/mm/yyyy)</label>
<input type="date" required="required" name="dob"><br>

<label>Enter Your Joining Date (dd/mm/yyyy)</label>
<input type="date" required="required" name="joinDate"><br>

<input type="submit" value="Register">
</form>
</body>
</html>