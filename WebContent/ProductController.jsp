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
<jsp:include page="includes/HeaderAdmin.jsp" />
<h1>Product Detail</h1>
	<%
		ProductEntity p = (ProductEntity) request.getAttribute("ProductResult");
	%>
	<form action = "productcontroller" method = "post">

	
		<table>
			<tr>
				<td>Product Code</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"id\" value=" + p.getProductcode());
					%>
				</td>
			</tr>

			<tr>
				<td>Product Name</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"fname\" value=" + p.getProductname());
					%>
				</td>
			</tr>

			<tr>
				<td>Product Scale</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"lname\" value=" + p.getProductscale());
					%>
				</td>
			</tr>
			<tr>
				<td>Product Vendor</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"email\" value=" + p.getProductvendor());
					%>
				</td>
			</tr>

			<tr>
				<td>Product Description</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"officecode\" value=" + p.getProductdescription());
					%>
				</td>
			</tr>
			<tr>
				<td>Quantity In Stock</td>
				<td>
					<%
						out.println("<input type=\"text\" name=\"report\" value=" + p.getQuantityinstock().toString());
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