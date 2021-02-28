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
				<td>Enter product code : </td>
				<td>&nbsp<input type="text" name="productCode" value="" placeholder="eg: S10_1678" required></td>
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
		boolean noRsl = (boolean) request.getAttribute("NORESULT");
		
		if(noRsl == true){
			out.println("<h4><strong>no record found.</strong></h4>");
		}else if(productInfo != null){
			out.println("<h3><u>Product Info</u></h3>");
			out.println("<table border=0>");
			out.println("<tr>");
			out.println("<td>Product Code </td>");
			out.println("<td>&nbsp: " + productInfo.getProductcode() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Product Name </td>");
			out.println("<td>&nbsp: " + productInfo.getProductname() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Product Line </td>");
			out.println("<td>&nbsp: " + productInfo.getProductlineBean().getProductline() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Product Vendor </td>");
			out.println("<td>&nbsp: " + productInfo.getProductvendor() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Quantity in Stock </td>");
			out.println("<td>&nbsp: " + productInfo.getQuantityinstock() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Manufacturer Suggest Retail Price </td>");
			out.println("<td>&nbsp: " + productInfo.getMsrp() + "</td>");
			out.println("</tr>");
			
			out.println("</table>");
			
		}
	%>

	<jsp:include page="includes/Footer.jsp" />
</body>
</html>