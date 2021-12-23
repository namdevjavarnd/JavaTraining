<%@page import="com.model.BLManager"%>
<%@page import="com.pojo.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	BLManager bl = new BLManager();
    Department department = (Department)session.getAttribute("department");
    session.setAttribute("depart", department);
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Department</title>
</head>
<body>
<h1>Edit Department</h1><br/>
	<form action="EditDepartment" method="POST">
		<input type="hidden" name="ID" value="${depart.getId()}"> <br/>
		Name: <input type="text" name="Name" value="${depart.getName()}"> <br/>
		HOD: <input type="text" name="HOD" value="${depart.getHod()}"> <br/>
		Location: <input type="text" name="Location" value="${depart.getLocation()}"/> <br/>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>