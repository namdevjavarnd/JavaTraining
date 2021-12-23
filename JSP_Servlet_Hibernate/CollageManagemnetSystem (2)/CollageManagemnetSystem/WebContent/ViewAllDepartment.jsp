<%@page import="com.pojo.Department"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.model.BLManager"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	BLManager bl = new BLManager();
	List<Department> DepartmentList = bl.viewAllDepartment();
	System.out.print("DepartmentList::" + DepartmentList);
	request.setAttribute("DepartmentList", DepartmentList);
%>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<table border="1">

		<tr>
			<th>DepartmentId</th>
			<th>DepartmentName</th>
			<th>HOD</th>
			<th>Location</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${DepartmentList}" var="ListOfDepartment">
			<tr>
				<td>${ListOfDepartment.id}</td>
				<td>${ListOfDepartment.name}</td>
				<td>${ListOfDepartment.hod}</td>
				<td>${ListOfDepartment.location}</td>
				<td><a href="EditDepartment?deptId=${ListOfDepartment.id}">Edit</a></td>
				<td><a href="DeleteDepartment?deptId=${ListOfDepartment.id}"
					onclick="return confirm('Are you sure you want to delete this ?');">
						Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="Department.jsp">Back</a>
</body>
</html>