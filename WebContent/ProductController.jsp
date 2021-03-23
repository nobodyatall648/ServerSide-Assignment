<%@page import="domain.ProductEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Info</title>
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
<h1>Product Detail</h1>
	<%
		ProductEntity p = (ProductEntity) request.getAttribute("EmployeeResult");
	%>
	<form action = "ProductController" method = "post">

	
		<table>
			<tr>
				<td>Employee Number</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"id\" value=" + emp.getEmployeenumber().toString());
					%>
				</td>
			</tr>

			<tr>
				<td>First Name</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"fname\" value=" + emp.getFirstname());
					%>
				</td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"lname\" value=" + emp.getLastname());
					%>
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"email\" value=" + emp.getEmail());
					%>
				</td>
			</tr>

			<tr>
				<td>Office Code</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"officecode\" value=" + emp.getOffice().getOfficecode());
					%>
				</td>
			</tr>
			<tr>
				<td>Report</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"report\" value=" + emp.getReportsto());
					%>
				</td>
			</tr>

			<tr>
				<td>Job Title</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"job\" value=" + emp.getJobtitle());
					%>
				</td>
			</tr>

		</table>
		<input type="submit" name="UPDATE" value="UPDATE" /> <input
			type="submit" name="DELETE" value="DELETE" />
			
		</form>
		
</body>
</html>