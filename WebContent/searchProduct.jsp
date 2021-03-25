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
							out.println("<table class=\"table\" border=2>");
							out.println("<thead>");
							out.println("<tr>");

							out.println("<td><strong>&nbsp;Product Code&nbsp;</strong></td>");
							out.println("<td><strong>&nbsp;Product Name&nbsp;</strong></td>");
							out.println("<td><strong>&nbsp;Buy Price&nbsp;</strong></td>");
							out.println("<td><strong>&nbsp;Msrp&nbsp;</strong></td>");
							out.println("<td><strong>&nbsp;Product Description&nbsp;</strong></td>");
							out.println("<td><strong>&nbsp;Product Scale&nbsp;</strong></td>");
							out.println("<td><strong>&nbsp;Product Vendor&nbsp;</strong></td>");
							out.println("<td><strong>&nbsp;Quantity In Stock&nbsp;</strong></td>");
							out.println("<td><strong>&nbsp;Product Line&nbsp;</strong></td>");

							out.println("</tr>");
							out.println("</thead>");

							out.println("<tbody>");

							//prints ret search results
							for (int i = 0; i < searchRsl.size(); i++) {
								out.println("<tr>");

								out.println("<td>&nbsp;" + searchRsl.get(i).getProductcode() + "&nbsp;</td>");
								out.println("<td>&nbsp;" + searchRsl.get(i).getProductname() + "&nbsp;</td>");
								out.println("<td>&nbsp;" + searchRsl.get(i).getBuyprice() + "&nbsp;</td>");
								out.println("<td>&nbsp;" + searchRsl.get(i).getMsrp() + "&nbsp;</td>");
								out.println("<td>&nbsp;" + searchRsl.get(i).getProductdescription() + "&nbsp;</td>");
								out.println("<td>&nbsp;" + searchRsl.get(i).getProductscale() + "&nbsp;</td>");
								out.println("<td>&nbsp;" + searchRsl.get(i).getProductvendor() + "&nbsp;</td>");
								out.println("<td>&nbsp;" + searchRsl.get(i).getQuantityinstock() + "&nbsp;</td>");
								out.println(
										"<td>&nbsp;" + searchRsl.get(i).getProductlineBean().getProductline() + "&nbsp;</td>");

								out.println("</tr>");
							}

							out.println("</tbody>");
							out.println("</table>");
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