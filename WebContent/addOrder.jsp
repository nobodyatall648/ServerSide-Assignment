<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Order</title>

</head>
<body>
	<jsp:include page="includes/HeaderCustomer.jsp" />

	<h2>
		<u><strong>Add Order</strong></u>
	</h2>

	<form action="GetProductInfo" method="get">
		<table border=0>
			<tr>
				<td>Enter product code:</td>
				<td><input type="text" name="productCode" value="" placeholder="eg: S10_1678" required></td>
				<td><button type="submit">Get Product Info</button></td>
			</tr>			
		</table>		
	</form>
	
	<br>
	<br>
	
	<%@ page import="domain.ProductEntity" %>
	<%
		//only will shows when product code is entered.
		ProductEntity productInfo = (ProductEntity) request.getAttribute("PRODUCT_INFO");
		
		if(productInfo != null){
			out.println("<p>sample data </p>");
			out.println("<p>" + productInfo.getProductcode()  + "</p>");
			out.println("<p>" + productInfo.getProductdescription()  + "</p>");
			out.println("<p>" + productInfo.getProductname()  + "</p>");
			out.println("<p>" + productInfo.getProductscale()  + "</p>");
			
		}
	%>

	<jsp:include page="includes/Footer.jsp" />
</body>
</html>