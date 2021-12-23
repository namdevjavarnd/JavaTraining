<%@page import="com.pojo.ClassInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.model.BLManager"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	BLManager bl = new BLManager();
	List<ClassInfo> ClassesList = bl.viewAllClasses();
	request.setAttribute("ClassesList", ClassesList);
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View ALL Classes</title>
</head>
<body>
	<h1>All Classes</h1>
	<table border="1">
		<tr>
			<th>ClassId</th>
			<th>Name</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${ClassesList}" var="ListOfClasses">
			<tr>
				<td>${ListOfClasses.id}</td>
				<td>${ListOfClasses.name}</td>
				<td><a href="EditClasses?classId=${ListOfClasses.id}">Edit</a></td>
				<td><a href="DeleteClasses?classId=${ListOfClasses.id}"
					onclick="return confirm('Are you sure you want to delete this ?');">
						Delete</a></td>
			</tr>
		</c:forEach>
	</table><br>
	<a href="Classes.jsp">Back</a>
</body>
</html>