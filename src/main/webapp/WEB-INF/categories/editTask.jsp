<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add new Task</h1>
<form:form method="post" action="/EmployeeData/saveEditTask">
	<table>
	<tr>
			<td>Task id :</td>
			<td><form:hidden path="task_id" /></td>
		</tr>
		<tr>
			<td>Task Name :</td>
			<td><form:input path="task_name" /></td>
		</tr>
		<tr>
			<td>Task description :</td>
			<td><form:input path="task_description" /></td>
		</tr>
		<tr>
			<td>Task id :</td>
			<td><form:input path="category_id" value="${category_id}" /> </td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form:form>