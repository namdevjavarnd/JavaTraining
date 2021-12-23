<%@page import="com.pojo.Student"%>
<%@page import="com.model.BLManager"%>
<%@page import="com.pojo.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
BLManager bl = new BLManager();
Student student = (Student) session.getAttribute("student");
session.setAttribute("student", student);
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Student</title>
</head>
<body>
	<h1>Edit Student</h1>
	<br />
	<form action="EditStudent" method="POST">
		<input type="hidden" name="ID" value="${student.getId()}"> <br />
		Student Name: <input type="text" name="StudentName"
			value="${student.getStudent()}"> <br /> Register Number: <input
			type="text" name="RegisterNumber" value="${student.getRegNo()}">
		<br /> <label>Class Name:</label> <select name="className">
			<option>${student.getClassInfo().getName()}</option>
		</select><br> <label>Teacher Id:</label> <select name="teacherId">
			<option>${student.getTeacher().getId()}</option>
		</select><br> <input type="submit" value="Submit" />
	</form>
</body>
</html>