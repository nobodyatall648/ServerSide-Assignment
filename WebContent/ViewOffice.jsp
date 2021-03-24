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
<h1>Office Detail</h1>
	<%
		OfficeEntity off = (OfficeEntity) request.getAttribute("OfficeResult");
	%>
	<form action="OfficeController" method="post">

	
		<table>
			<tr>
				<td>Office Code</td>
				<td>
					<%
					out.println("<input type=\"text\" name=\"ocode\"  value="+off.getOfficecode());
					out.println("<h1 >"+off.getOfficecode()+"</h1>");
					%>
				</td>
			</tr>

			<tr>
				<td>City</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"city\"value="+off.getCity());
					out.println("<h4>"+off.getCity()+"</h4>");
					%>
				</td>
			</tr>

			<tr>
				<td>Phone</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"phone\"value="+off.getPhone());
					out.println("<h4>"+off.getPhone()+"</h4>");
					%>
				</td>
			</tr>
			<tr>
				<td>Address 1</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"add1\" value="+off.getAddressline1());
					out.println("<h4>"+off.getAddressline1()+"</h4>");
					%>
				</td>
			</tr>

			<tr>
				<td>Address 2</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"add2\" value="+off.getAddressline2());
					out.println("<h4>"+off.getAddressline2()+"</h4>");
					%>
				</td>
			</tr>
			<tr>
				<td>State</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"state\" value="+off.getState());
					out.println("<h4>"+off.getState()+"</h4>");
					%>
				</td>
			</tr>

			<tr>
				<td>Country</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"country\"value="+off.getCountry());
					out.println("<h4>"+off.getCountry()+"</h4>");
					%>
				</td>
			</tr>
				<tr>
				<td>Postal Code</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"pcode\" value="+off.getPostalcode());
					out.println("<h4>"+off.getPostalcode()+"</h4>");
					%>
				</td>
			</tr>
				<tr>
				<td>Territory</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"territory\" value="+off.getTerritory());
					out.println("<h4>"+off.getTerritory()+"</h4>");
					%>
				</td>
			</tr>

		</table>
		<input type="submit" name="UPDATE" value="UPDATE" /> <input
			type="submit" name="DELETE" value="DELETE" />
			
		</form>
		<jsp:include page="includes/Footer.jsp" />
</body>
</html>