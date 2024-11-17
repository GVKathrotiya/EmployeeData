<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Category</h1>
<form:form method="POST" action="/EmployeeData/editsave">
	<table>
		<tr>
			<td></td>
			<td><form:hidden path="category_id" /></td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><form:input path="category_name" /></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Edit Save" /></td>
		</tr>
	</table>
</form:form>
