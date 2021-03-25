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
	
	<%
		int maxPageNum = (int) request.getAttribute("MAX_PAGE_NUM");
		int viewPage = (int) request.getAttribute("VIEW_PAGE");
		out.println("<h4><b>Current View Page: " + viewPage + "</b></h4>");
		out.println("<br>");
		
		out.println("<form action=\"ViewProductInfo\" method=\"get\">");
		out.println("Pages: ");
		out.println("<select name=\"page\">");
		for(int i=1; i <= maxPageNum; i++){
			out.println("<option value=" + i + ">" + i +"</option>");
		}
		
		out.println("</select>");
		out.println("<button type=\"submit\">Go to Page</button>");
		out.println("</form>");
		out.println("<br>");
	%>
	<form action = "Product" method ="get">
	<table class="table" border=2>
		<thead>
			<tr>
				<td><strong>&nbsp;Product Code&nbsp;</strong></td>
				<td><strong>&nbsp;Product Name&nbsp;</strong></td>
				<td><strong>&nbsp;Buy Price&nbsp;</strong></td>
				<td><strong>&nbsp;Msrp&nbsp;</strong></td>
				<td><strong>&nbsp;Product Description&nbsp;</strong></td>				
				<td><strong>&nbsp;Product Scale&nbsp;</strong></td>
				<td><strong>&nbsp;Product Vendor&nbsp;</strong></td>
				<td><strong>&nbsp;Quantity In Stock&nbsp;</strong></td>
				<td><strong>&nbsp;Product Line&nbsp;</strong></td>
				<td><strong>&nbsp;TextDescription&nbsp;</strong></td>
			</tr>
		</thead>
		 
		<%
			try {
				List<ProductEntity> pl = (List<ProductEntity>) request.getAttribute("PRODUCT_LIST");
				//List<ProductlineEntity> plList = (List<ProductlineEntity>) request.getAttribute("PRODUCTLINE_LIST");
     			out.println("<tbody>");
				
     			for(int i=0; i < pl.size(); i++){
     				out.println("<td>&nbsp;" + pl.get(i).getProductcode() + "&nbsp;</td>");
     				out.println("<td>&nbsp;" + pl.get(i).getProductname() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + pl.get(i).getBuyprice() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + pl.get(i).getMsrp() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + pl.get(i).getProductdescription() + "&nbsp;</td>");					
					out.println("<td>&nbsp;" + pl.get(i).getProductscale() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + pl.get(i).getProductvendor() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + pl.get(i).getQuantityinstock() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + pl.get(i).getProductlineBean().getProductline() + "&nbsp;</td>");
				    out.println("<td>&nbsp;" + pl.get(i).getProductlineBean().getTextdescription() + "&nbsp;</td>");		
					out.println("</tr>");
     			}
				out.println("</tbody>");
			} catch (Exception e) {

			}
		%>
	</table>
	</form>
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