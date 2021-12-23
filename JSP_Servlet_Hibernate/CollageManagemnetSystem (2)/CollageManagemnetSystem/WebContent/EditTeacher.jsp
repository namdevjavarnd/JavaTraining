<%@page import="com.pojo.Teacher"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.pojo.Department"%>
<%@page import="com.pojo.ClassInfo"%>
<%@page import="com.model.BLManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%
	BLManager bl = new BLManager();
	Teacher teacher = (Teacher) session.getAttribute("teacher");
	session.setAttribute("teacher", teacher);
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Teachers</title>
</head>
<body>
	<h1>Edit Teachers</h1>
	<br />
	<form action="EditTeacher" method="POST">
		<input type="hidden" name="ID" value="${teacher.getId()}"> <br />
		Address: <input type="text" name="Address"
			value="${teacher.getAddress()}"> <br /> Gender: <input
			type="text" name="Gender" value="${teacher.getGender()}" /> <br />
		Name: <input type="text" name="Name" value="${teacher.getName()}" />
		<br /> Salary: <input type="text" name="Salary"
			value="${teacher.getSalary()}" /><br> <label>Department
			Name:</label> <select name="departmentName">
			<option>${teacher.getDepartment().getName()}</option>
		</select><br> <input type="submit" value="Submit" />
	</form>
</body>
</html>