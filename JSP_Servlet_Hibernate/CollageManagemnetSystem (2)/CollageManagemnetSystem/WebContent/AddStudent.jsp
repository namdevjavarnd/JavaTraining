<%@page import="com.pojo.Teacher"%>
<%@page import="com.pojo.ClassInfo"%>
<%@page import="com.model.BLManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%
BLManager bl = new BLManager();
List<ClassInfo> ClassesList = bl.viewAllClasses();
session.setAttribute("ClassesList", ClassesList);

List<Teacher> TeacherList = bl.viewAllTeachers();
session.setAttribute("TeacherList", TeacherList);
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<h1>Add Student</h1>
	<br />
	<form action="AddStudent" method="POST">
		Student Name: <input type="text" name="StudentName"> <br />
		Register Number: <input type="text" name="RegisterNumber"> <br />
		<label>Class Name:</label> <select name="className">
			<c:forEach items="${sessionScope.ClassesList}" var="u">
				<option>${u.name}</option>
			</c:forEach>
		</select><br> <label>Teacher Id:</label> <select name="teacherId">
			<c:forEach items="${sessionScope.TeacherList}" var="u">
				<option>${u.id}</option>
			</c:forEach>
		</select><br> <input type="submit" value="Submit" />
	</form>
</body>
</html>