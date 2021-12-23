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
	List<ClassInfo> ClassesList = bl.viewAllClasses();
	session.setAttribute("ClassesList", ClassesList);

	List<Department> DepartmentList = bl.viewAllDepartment();
	session.setAttribute("DepartmentList", DepartmentList);
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Teachers</title>
</head>
<body>
	<h1>Add Teachers</h1>
	<br />
	<form action="AddTeachers" method="POST">
		Address: <input type="text" name="Address"> <br /> Gender: <input
			type="text" name="Gender" /> <br /> Name: <input type="text"
			name="Name" /> <br /> Salary: <input type="text" name="Salary" />
		<br> <label>Department Name:</label> <select
			name="departmentName">
			<c:forEach items="${sessionScope.DepartmentList}" var="u">
				<option>${u.name}</option>
			</c:forEach>
		</select><br> <input type="submit" value="Submit" />
	</form>
</body>
</html>