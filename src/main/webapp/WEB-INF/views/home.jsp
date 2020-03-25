<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC</title>
<body>
	<div class="container">
		<div id="insert-div">
		<p>Enter Employee Details</p>
			<form:form action="insertUrl" method="post" modelAttribute="employee" enctype="multipart/form-data">
				<table>
					<tr>
						<td><form:label path="Eid">Employee Id</form:label></td>
						<td><form:input path="Eid" /></td>
					</tr>
					<tr>
						<td><form:label path="eName">Employee Name</form:label></td>
						<td><form:input path="eName" /></td>
					</tr>
					<tr>
						<td><form:label path="salary">Salary</form:label></td>
						<td><form:input path="salary" /></td>
					</tr>
					<tr>
						<td><form:label path="department">Department</form:label></td>
						<td><form:select path="department">
								<form:option value="None" label="Select" />
								<form:options items="${depts}"/>
							</form:select></td>
					</tr>
					<tr>
						<td>
							<button type="reset">Reset</button>
						</td>
						<td>
							<button type="submit">Insert</button>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>