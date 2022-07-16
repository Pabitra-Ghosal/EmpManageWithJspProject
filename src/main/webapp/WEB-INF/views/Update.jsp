<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update employee</title>
</head>
<body>
<form action="/emp/edit" method="post">
<label>Employee Id</label>
<input type="text" readonly name="empid" value="${empDto.empid}"><br>

<label>Update Name</label>
<input type="text" required="required" name="name" value="${empDto.name}"><br>

<label>Update Email</label>
<input type="email" required="required" name="email" value="${empDto.email}"><br>

<label>Update Job Role</label>
<input type="text" required="required" name="role"  value="${empDto.role}"><br>

<label>Update Department name</label>
<input type="text" required="required" name="depName"  value="${empDto.depName}"><br>

<label>Update Password</label>
<input type="password" required="required" name="pass" value="${empDto.pass}"><br>

<label>Update DoB (dd/mm/yyyy)</label>
<input type="date" required="required" name="dob" value="${empDto.dob}"><br>

<label>Update Joining Date (dd/mm/yyyy)</label>
<input type="date" required="required" name="joinDate" value="${empDto.joinDate}"><br>

<input type="submit" value="Update">
</form>
</body>
</html>