<%@page import="com.pojo.Student"%>
<%@page import="com.pojo.Department"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.model.BLManager"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
BLManager bl = new BLManager();
List<Student> StudentList = bl.viewAllStudent();
System.out.print("StudentList::" + StudentList);
request.setAttribute("StudentList", StudentList);
%>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<table border="1">

		<tr>
			<th>Student Name</th>
			<th>Student Register Number</th>
			<th>Class Name</th>
			<th>Teacher Id</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${StudentList}" var="ListOfStudent">
			<tr>
				<td>${ListOfStudent.student}</td>
				<td>${ListOfStudent.regNo}</td>
				<td>${ListOfStudent.classInfo.name}</td>
				<td>${ListOfStudent.teacher.id}</td>
				<td><a href="EditStudent?stdId=${ListOfStudent.id}">Edit</a></td>
				<td><a href="DeleteStudent?stdId=${ListOfStudent.id}"
					onclick="return confirm('Are you sure you want to delete this ?');">
						Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="Student.jsp">Back</a>
</body>
</html>