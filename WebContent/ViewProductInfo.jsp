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
		<%
			try {
				List<ProductEntity> pl = (List<ProductEntity>) request.getAttribute("PRODUCT_LIST");
				//List<ProductlineEntity> plList = (List<ProductlineEntity>) request.getAttribute("PRODUCTLINE_LIST");
    
     			for(int i=0; i < pl.size(); i++){
     				out.println("<div class='panel panel-info'>");
     				out.println("<div class='panel-heading'><h3 class='panel-title'><b>" + pl.get(i).getProductname() + "</b>");
     				out.println("<span style='float:right;'>&nbsp<b>" + pl.get(i).getProductcode() + "</b></span></h3></div>");
// 					out.println("RM " + pl.get(i).getBuyprice() + "\n");
					out.println("<div class='panel-body'>"+ pl.get(i).getProductdescription());	
					out.println("<table style='border: none;'><tr><th style='width:150px'>Scale: </th><td>" + pl.get(i).getProductscale() + "</td></tr><br>");
					out.println("<tr><th>Vendor: </th><td>" + pl.get(i).getProductvendor() + "</td></tr><br>");			
					out.println("<tr><th>Product Line: </th><td>" + pl.get(i).getProductlineBean().getProductline() + "</td></tr>");
					out.println("<tr><th>Available Stock: </th><td>" + pl.get(i).getQuantityinstock() + "</td></tr><br>");
// 				    out.println("TextDescription" + pl.get(i).getProductlineBean().getTextdescription() + "");
				    out.println("<span style='float:right;'><h2>RM " + pl.get(i).getMsrp() + "</h2></span></table></div></div>");
     			}
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