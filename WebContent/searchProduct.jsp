<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Search</title>
</head>
<body>
	<jsp:include page="includes/HeaderCustomer.jsp" />

	<div class="container">

		<div class="subheader">
			<h2>
				<strong>Search Vehicle by Name</strong>
			</h2>
		</div>
		<div class="panel panel-default paneldesign">
			<div class="panel-body">
				<form action="GetSearchInfo" method="get">
					<table border=0>
						<tr>
							<td><b>Search Vehicle :</b></td>
							<td>&nbsp<input class="inputdesign" type="text"
								name="productName" value="" placeholder="eg: ford" required></td>
							<td><button class="buttondesign" type="submit">Search</button></td>
						</tr>
					</table>
				</form>

				<br> <br>

				<%@ page import="domain.ProductEntity"%>
				<%@ page import="java.util.List"%>
				<%
					try {
						List<ProductEntity> searchRsl = (List<ProductEntity>) request.getAttribute("SEARCH_RSL");

						out.println("<h3>");
						out.println("<u>Search Results: </u>");
						out.println("</h3>");

						if (searchRsl.size() == 0) {
							out.println("<h4>No Result Found.</h4>");
						} else {
							//prints ret search results
							for (int i = 0; i < searchRsl.size(); i++) {
								out.println("<div class='panel panel-primary'>");
			     				out.println("<div class='panel-heading'><h3 class='panel-title'><b>" + searchRsl.get(i).getProductname() + "</b>");
			     				out.println("<span style='float:right;'>&nbsp<b>" + searchRsl.get(i).getProductcode() + "</b></span></h3></div>");
								out.println("<div class='panel-body'>"+ searchRsl.get(i).getProductdescription());	
								out.println("<table style='border: none;'><tr><th style='width:150px'>Scale: </th><td>" + searchRsl.get(i).getProductscale() + "</td></tr><br>");
								out.println("<tr><th>Vendor: </th><td>" + searchRsl.get(i).getProductvendor() + "</td></tr><br>");			
								out.println("<tr><th>Product Line: </th><td>" + searchRsl.get(i).getProductlineBean().getProductline() + "</td></tr>");
								out.println("<tr><th>Available Stock: </th><td>" + searchRsl.get(i).getQuantityinstock() + "</td></tr><br>");
							    out.println("<span style='float:right;'><h2>RM " + searchRsl.get(i).getMsrp() + "</h2>");
							    out.println("<input class='buttondesign' type=\"button\" onclick=\"location.href='GetProductInfo?productCode="+ searchRsl.get(i).getProductcode() + "';\" value=\"Buy Now\" /></span></table></div></div>"); 

							}

						}

					} catch (Exception e) {

					}
				%>
				
			</div>
		</div>
	</div>
	<br><br><br><br><br><br><br>
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>