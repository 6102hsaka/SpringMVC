<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC</title>

<link href="<c:url value="/resources/css/mystyle.css" />"
	rel="stylesheet" />
<script src="<c:url value="/resources/js/myscript.js" />"></script>

</head>

<body>

	<header> SpringWeb MVC </header>

	<div class="container">


		<div id="show-div">
			<h4>Employees Detail</h4>
			<table id="show-tbl">

				<thead>

					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>Salary</th>
					<th>Department Id</th>

				</thead>
				<tbody>
					<c:forEach items="${emps}" var="emp">
						<tr>
							<td>${emp.id}</td>
							<td>${emp.name}</td>
							<td>${emp.salary}</td>
							<td>${emp.departmentId}</td>
							<td><a href="deleteUrl?id=${emp.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="user-action-div">
			<button onclick="insert()">Insert Employee Detail</button>
			<button onclick="update()">Update Employee Detail</button>
		</div>


		<!-- Form for Inserting Employee Data-->
		<div id="insert-div">
			<p>Enter Employee Details</p>
			<form:form action="insertUrl" method="post" modelAttribute="employee">
				<table>
					<tr>
						<td><form:label path="id">Employee Id</form:label></td>
						<td><form:input path="id" required="required" /></td>
					</tr>
					<tr>
						<td><form:label path="name">Employee Name</form:label></td>
						<td><form:input path="name" required="required" /></td>
					</tr>
					<tr>
						<td><form:label path="salary">Salary</form:label></td>
						<td><form:input path="salary" required="required" /></td>
					</tr>
					<tr>
						<td><form:label path="departmentId">Department</form:label></td>
						<td><form:select path="departmentId">
								<c:forEach items="${depts}" var="dept">
									<form:option value="${dept.id}">${dept.name}</form:option>
								</c:forEach>
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

		<!-- Form for updating Employee Data-->
		<div id="update-div">
			<p>Enter Employee Details</p>
			<form:form action="updateUrl" method="post" modelAttribute="employee">
				<table>
					<tr>
						<td><form:label path="id">Employee Id</form:label></td>
						<td><form:input path="id" required="required" /></td>
					</tr>
					<tr>
						<td><form:label path="name">Employee Name</form:label></td>
						<td><form:input path="name" required="required" /></td>
					</tr>
					<tr>
						<td><form:label path="salary">Salary</form:label></td>
						<td><form:input path="salary" required="required" /></td>
					</tr>
					<tr>
						<td><form:label path="departmentId">Department</form:label></td>
						<td><form:select path="departmentId">
								<c:forEach items="${depts}" var="dept">
									<form:option value="${dept.id}">${dept.name}</form:option>
								</c:forEach>
							</form:select></td>
					</tr>
					<tr>
						<td>
							<button type="reset">Reset</button>
						</td>
						<td>
							<button type="submit">Update</button>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>