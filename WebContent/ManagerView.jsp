<%@page import="domain.EmployeeEntity"%>
<%@page import="java.util.List"%>
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
		List<EmployeeEntity> emp = (List<EmployeeEntity>) request.getAttribute("EmployeeList");
	%>
	

	
		<table>
		        <tr>
				<th>Employee Number</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Office Code</th>
				<th>Report</th>
				<th>Job Title</th>
				
				</tr>
				<%for(int i=0;i<emp.size();i++){ %>
				<tr>
				<td>
					<%
						out.println( emp.get(i).getEmployeenumber());
					%>
					
					</td>
					<td>
					<%
						out.println( emp.get(i).getFirstname());
					%>
					</td>
					<td>
					<%
						out.println( emp.get(i).getLastname());
					%>
					</td>
					<td>
					<%
						out.println( emp.get(i).getEmail());
					%>
					</td>
					<td>
					<%
						out.println( emp.get(i).getOffice().getOfficecode());
					%>
					</td>
					<td>
					<%
						out.println( emp.get(i).getReportsto());
					%>
					</td>
					<td>
					<%
						out.println( emp.get(i).getJobtitle());
					%>
					</td>
				</tr>
				<%} %>


		</table>
			
		
		
</body>
</html>