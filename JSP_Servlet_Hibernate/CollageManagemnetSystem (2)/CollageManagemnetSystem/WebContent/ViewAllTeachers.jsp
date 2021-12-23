<%@page import="com.pojo.Teacher"%>
<%@page import="com.pojo.Department"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.model.BLManager"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	BLManager bl = new BLManager();
	List<Teacher> TeacherList = bl.viewAllTeachers();
	session.setAttribute("TeacherList", TeacherList);
%>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<table border="1">

		<tr>
			<th>Name</th>
			<th>Address</th>
			<th>Gender</th>
			<th>Salary</th>
			<th>Department Name</th>
			<th>Department HOD</th>
			<th>Department Location</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<tr>
			<c:forEach items="${TeacherList}" var="ListOfTeachers">
				<tr>
					<td>${ListOfTeachers.name}</td>
					<td>${ListOfTeachers.address}</td>
					<td>${ListOfTeachers.gender}</td>
					<td>${ListOfTeachers.salary}</td>
					<td>${ListOfTeachers.department.name}</td>
					<td>${ListOfTeachers.department.hod}</td>
					<td>${ListOfTeachers.department.location}</td>
					<td><a href="EditTeacher?techId=${ListOfTeachers.id}">Edit</a></td>
					<td><a href="DeleteTeacher?techId=${ListOfTeachers.id}"
						onclick="return confirm('Are you sure you want to delete this ?');">
							Delete</a></td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<br />
	<a href="Teachers.jsp">Back</a>
</body>
</html>