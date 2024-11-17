<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add new Category</h1>
<form:form method="post" action="save_Category">
	<table>
		<tr>
			<td>Name :</td>
			<td><form:input path="category_name" /></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form:form>
