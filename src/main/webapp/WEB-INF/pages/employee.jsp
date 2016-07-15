<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee details</title>
        <style>
			table, td, th {
			    border: 1px solid green;
			}
			th {
			    background-color: green;
			    color: white;
			}
			caption {
			    caption-side: bottom;
			}
		</style>

    </head>
	<body>
		<form name="Employee" method="get" action="GetNewEmployeeData">
			<h2>Employee details</h2>
		 
			<c:if test="${not empty employeeList}">
				<table>
				<caption>${employeeInfo}</caption>
					<thead>
						<tr>
							<th><b>Employee Id</b></th>
							<th><b>First Name</b></th>
							<th><b>Last Name</b></th>
							<th><b>Salary</b></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="employee" items="${employeeList}">
						<tr>
							<td>${employee.employeeId}</td>
							<td>${employee.firstName}</td>
							<td>${employee.lastName}</td>
							<td>$ ${employee.salary}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<br>
				<input type="submit" value="Increase Salary" />
			</c:if>
		</form>
	</body>
</html>