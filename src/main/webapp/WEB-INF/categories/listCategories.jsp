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
	list of Categories
	<a href="empform">Add new Category</a><br><br>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Category Name</th>
			<th>Tasks</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="cat" items="${list}">
			<tr>
				<td>${cat.category_id}</td>
				<td>${cat.category_name}</td>
				<td><a href="view_tasks/${cat.category_id}/${cat.category_name}">View Tasks</a>
				<td><a href="editcat/${cat.category_id}">Edit</a></td>
				<td><a href="deletecat/${cat.category_id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>