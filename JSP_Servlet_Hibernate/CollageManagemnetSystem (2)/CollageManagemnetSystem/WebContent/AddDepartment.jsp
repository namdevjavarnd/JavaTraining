<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Department</title>
</head>
<body>
<h1>Add Department</h1><br/>
	<form action="AddDepartment" method="POST">
		Name: <input type="text" name="Name"> <br/>
		HOD: <input type="text" name="HOD"/> <br/>
		Location: <input type="text" name="Location"/> <br/>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>