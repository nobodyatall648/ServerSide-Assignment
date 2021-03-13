<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Product Info</title>
</head>
<body>
	<jsp:include page="includes/HeaderCustomer.jsp" />
	<div class="container">
	<div class="subheader">
	<h2>
		<strong>View Product Info</strong>
	</h2>
	</div>
	
	<div class="panel panel-default paneldesign">
			<div class="panel-body">
	
	<%@ page import="domain.ProductEntity"%>
	<%@ page import="domain.ProductlineEntity"%>
	<%@ page import="java.util.List"%>
	
	<h3>
		<u><strong>Product Info</strong></u>
	</h3>
	
	<table class="table" border=2>
		<thead>
			<tr>
				<td><strong>&nbsp;Product Code&nbsp;</strong></td>
				<td><strong>&nbsp;Buy Price&nbsp;</strong></td>
				<td><strong>&nbsp;Msrp&nbsp;</strong></td>
				<td><strong>&nbsp;Product Description&nbsp;</strong></td>
				<td><strong>&nbsp;Product Name&nbsp;</strong></td>
				<td><strong>&nbsp;Product Scale&nbsp;</strong></td>
				<td><strong>&nbsp;Product Vendor&nbsp;</strong></td>
				<td><strong>&nbsp;Quantity In Stock&nbsp;</strong></td>
				<td><strong>&nbsp;Product Line&nbsp;</strong></td>
				<td><strong>&nbsp;Html Description&nbsp;</strong></td>
				<td><strong>&nbsp;Image&nbsp;</strong></td>
				<td><strong>&nbsp;TextDescription&nbsp;</strong></td>
			</tr>
		</thead>
		 
		<%
			try {
				List<ProductEntity> productList = (List<ProductEntity>) request.getAttribute("PRODUCT_LIST");
				//List<ProductlineEntity> productlineList = (List<ProductlineEntity>) request.getAttribute("PRODUCTLINE_LIST");
     			out.println("<tbody>");
				for (int i = 0; i < productList.size(); i++) {
					
					//for (int j = 0; j < productlineList.size(); j++){
					out.println("<tr>");

					out.println("<td>&nbsp;" + productList.get(i).getProductcode() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + productList.get(i).getBuyprice() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + productList.get(i).getMsrp() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + productList.get(i).getProductdescription() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + productList.get(i).getProductname() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + productList.get(i).getProductscale() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + productList.get(i).getProductvendor() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + productList.get(i).getQuantityinstock() + "&nbsp;</td>");
					//out.println("<td>&nbsp;" + productlineList.get(j).getProductline() + "&nbsp;</td>");
				    //out.println("<td>&nbsp;" + productlineList.get(j).getHtmldescription() + "&nbsp;</td>");
					//out.println("<td>&nbsp;" + productlineList.get(j).getImage() + "&nbsp;</td>");
					//out.println("<td>&nbsp;" + productlineList.get(j).getTextdescription() + "&nbsp;</td>");
					
					out.println("</tr>");
					//}
				}
				out.println("</tbody>");
			} catch (Exception e) {

			}
		%>
	</table>


	
	<br>
	<br>
	<br>
	</div>	
	</div>
	</div>
	<br>
	<br>
	<br>
	
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>