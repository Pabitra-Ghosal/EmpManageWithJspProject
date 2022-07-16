<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile page</title>
</head>
<body>
<c:if test="${msg!=null}"> ${msg} </c:if><br><br>

<h2>Welcome </h2>
<label>Profile Settings</label><br>
<label><a href="/emp/update">Update</a>profile</label><br>
<label><a href="/emp/delete">Delete</a>profile</label>
</body>
</html>
