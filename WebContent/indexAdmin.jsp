<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Management Portal</title>
</head>
<body>
	<jsp:include page="includes/HeaderAdmin.jsp" />

	<div class="container">
		<div class="jumbotron">
		
			<h2>Hi, 
			<%
				Cookie[] cookies = request.getCookies();
				//show username
				for (int i = 0; i < cookies.length; i++) {
					Cookie c = cookies[i];
					if (c.getName().equals("username")) {
						out.println(c.getValue());
					}
				}
			%></h2>
			<div>This is the Employee Management Portal. Manage your employees.</div>
			<p>
				<a style="width:300px;" class="btn btn-primary btn-lg buttondesign" href="#" role="button">Add Employee</a>&nbsp
				<a style="width:300px;" class="btn btn-primary btn-lg buttondesign" href="#" role="button">Remove Employee</a>&nbsp
				<a style="width:300px;" class="btn btn-primary btn-lg buttondesign" href="#" role="button">Assign Employee</a>
			</p>	
		</div>
	</div>
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>