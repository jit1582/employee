<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
    </head>
	<body>
		<form name="Employee" method="get" action="EmployeeData/GetInitialEmployeeData">
			<h2>Please click on button to fetch initial employee data</h2>
			<input type="submit" value="Fetch initial employee data"/> 
		</form>
	</body>
</html>