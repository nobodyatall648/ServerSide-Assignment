<%@page import="domain.EmployeeEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Info</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>

<body>
<h1>Employee Detail</h1>
	<%
		EmployeeEntity emp = (EmployeeEntity) request.getAttribute("EmployeeResult");
	%>

	
		<table>

			<tr>
				<td>First Name</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"dob\" value=" + emp.getFirstname());
					%>
				</td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"fname\" value=" + emp.getLastname());
					%>
				</td>
			</tr>

			<tr>
				<td>Office Code</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"lname\" value=" + emp.getOffice().getOfficecode());
					%>
				</td>
			</tr>

			<tr>
				<td>Job Title</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"gender\" value=" + emp.getJobtitle());
					%>
				</td>
			</tr>

		</table>
	

</body>
</html>