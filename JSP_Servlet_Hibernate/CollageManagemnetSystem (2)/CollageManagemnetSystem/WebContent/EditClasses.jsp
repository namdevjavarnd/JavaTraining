<%@page import="com.pojo.ClassInfo"%>
<%@page import="com.model.BLManager"%>
<%@page import="com.pojo.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	BLManager bl = new BLManager();
	ClassInfo classInfo = (ClassInfo)session.getAttribute("classInfo");
    session.setAttribute("classInfo", classInfo);
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Department</title>
</head>
<body>
<h1>Edit Department</h1><br/>
	<form action="EditClasses" method="POST">
		<input type="hidden" name="ID" value="${classInfo.getId()}"> <br/>
		Name: <input type="text" name="Name" value="${classInfo.getName()}"> <br/>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>