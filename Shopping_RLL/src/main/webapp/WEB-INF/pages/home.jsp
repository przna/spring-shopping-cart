<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	
	<button type="button" class="btn btn-primary" onclick="window.location.href='register'">Add Employee</button>
	<br>
	<br>
	<br> ${NOTIFICATION}
	
		<form action ="search">
		
		<div class="form-group">
		
							<label for="lbleid">Search Employee</label> 
						<input type="text" class="form-control" id="lbleid" name="eid"
							placeholder="Enter EID" />
							</div>
							
		<button type="submit" class="btn btn-primary">Search</button>
</form>
	
	<div>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>EID</th>
					<th>First NAME</th>
					<th>Last NAME</th>
					<th>Gender</th>
					<th>Email</th>
					<th colspan="2">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${emplist}">
					<tr>
						<td><c:out value="${employee.eid}"></c:out></td>
						<td><c:out value="${employee.fname}"></c:out></td>
						<td><c:out value="${employee.lname}"></c:out></td>
						<td><c:out value="${employee.gender}"></c:out></td>
						<td><c:out value="${employee.email}"></c:out></td>
						<td><a href="edit?eid=${employee.eid}">EDIT</a></td>
						<td><a href="delete?eid=${employee.eid}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>