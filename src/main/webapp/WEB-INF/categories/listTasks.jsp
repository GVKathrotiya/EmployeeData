<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	list of Tasks
	<a href="/EmployeeData/categorylist">Category List</a>
	<h1><a href="/EmployeeData/addTaskform/${category_id}">Add new Task</a><br><br></h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Category Name</th>
			<th>Category id</th>
			<th>Task Name</th>
			<th>Task Description</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="task" items="${list}">
			<tr>
				<td>${task.task_id}</td>
				<td>${cat_name}</td>
				<td>${task.category_id}</td>
				<td>${task.task_name}</td>
				<td>${task.task_description}</td>
				<td><a href="/EmployeeData/editTask/${task.task_id}">Edit</a></td>
				<td><a href="/EmployeeData/deleteTask/${task.task_id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>