<%@page import="domain.OfficeEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Office Info</title>
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
<jsp:include page="includes/HeaderAdmin.jsp" />
<div class="container">
<h1>Office Detail</h1>
	<%
		OfficeEntity off = (OfficeEntity) request.getAttribute("OfficeResult");
	%>
	<form action="OfficeController" method="post">

	
		<table class="table">
			<tr>
				<td>Office Code</td>
				<td>
					<%
					out.println("<input type=\"text\" name=\"ocode\" readonly value=\""+off.getOfficecode()+"\">");
					%>
				</td>
			</tr>

			<tr>
				<td>City</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"city\"value=\""+off.getCity()+"\">");
					%>
				</td>
			</tr>

			<tr>
				<td>Phone</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"phone\"value=\""+off.getPhone()+"\">");
					%>
				</td>
			</tr>
			<tr>
				<td>Address 1</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"add1\" value=\""+off.getAddressline1()+"\">");
					%>
				</td>
			</tr>

			<tr>
				<td>Address 2</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"add2\" value=\""+off.getAddressline2()+"\">");
					%>
				</td>
			</tr>
			<tr>
				<td>State</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"state\" value=\""+off.getState()+"\">");
					%>
				</td>
			</tr>

			<tr>
				<td>Country</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"country\"value=\""+off.getCountry()+"\">");
					%>
				</td>
			</tr>
				<tr>
				<td>Postal Code</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"pcode\" value=\""+off.getPostalcode()+"\">");
					%>
				</td>
			</tr>
				<tr>
				<td>Territory</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"territory\" value=\""+off.getTerritory()+"\">");
					%>
				</td>
			</tr>

		</table>
		<input class="buttondesign" type="submit" name="UPDATE" value="UPDATE" /> 
		<input class="buttondesign" type="submit" name="DELETE" value="DELETE" />
			
		</form>
		<br><br>
		</div>
		<jsp:include page="includes/Footer.jsp" />
</body>
</html>