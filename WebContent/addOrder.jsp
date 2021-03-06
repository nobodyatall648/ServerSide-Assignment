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
				<td>Enter product code :</td>
				<td>&nbsp<input type="text" name="productCode" value=""
					placeholder="eg: S10_1678" required></td>
				<td><button type="submit">Get Product Info</button></td>
			</tr>
		</table>
	</form>

	<br>
	<br>

	<%@ page import="domain.ProductEntity"%>
	<%@ page import="domain.Cart"%>
	<%@ page import="java.util.List"%>
	<%
		//only will shows when product code is entered.
		try {
			ProductEntity productInfo = (ProductEntity) request.getAttribute("PRODUCT_INFO");
			boolean noRsl = (Boolean) request.getAttribute("NORESULT");

			if (noRsl == true) {
				out.println("<h4><strong>no record found.</strong></h4>");
			} else if (productInfo != null) {
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

				out.println("<br>");
				out.println("<h3><u>Order Placing Details</u></h3>");

				//add to cart
				String customernumber = "114"; //demo

				out.println("<form action=\"CartController\" method=\"post\">");
				out.println("<table border=0>");

				out.println("<tr>");
				out.println("<td>Quantity </td>");
				out.println("<td>&nbsp; : <input type=\"text\" name=\"qty\" value=\"\" required> </td>");
				out.println("</tr>");
				
				/*
				out.println("<tr>");
				out.println("<td>Comments </td>");
				out.println("<td>&nbsp; : <input type=\"text\" name=\"comments\" value=\"\" required> </td>");
				out.println("</tr>");
				*/
				out.println("<tr>");
				out.println("<td>Required Date </td>");
				out.println("<td>&nbsp; : <input type=\"date\" name=\"requiredDate\" value=\"\" required> </td>");
				out.println("</tr>");

				out.println("</table>");
				out.println("<input type=\"hidden\" name=\"productCode\" value=\"" + productInfo.getProductcode()
						+ "\">");
				out.println("<input type=\"hidden\" name=\"customernumber\" value=\"" + customernumber + "\">");
				out.println("<button type=\"submit\">Add to Cart</button>");
				out.println("</form>");
			}
		} catch (Exception e) { //catching NullPointerException in getAttribute() during the 1st time vising addOrder.jsp

		}
	%>

	<%
		try {
			List<Cart> cartList = (List<Cart>) session.getAttribute("CART");
			//cart list management
			if (cartList.size() != 0) {
				out.println("<h3><u>Cart List</u></h3>");
				out.println("<form action=\"CartController\" method=\"get\">");
				out.println("<table border=2>");

				out.println("<thead style=\"font-weight: bold\">");
				out.println("<tr>");
				out.println("<td>&nbsp;Product Code&nbsp;</td>");
				out.println("<td>&nbsp;Customer Number&nbsp;</td>");
				out.println("<td>&nbsp;Required Date&nbsp;</td>");
				//out.println("<td>&nbsp;Comments&nbsp;</td>");
				out.println("<td>&nbsp;Quantity&nbsp;</td>");
				out.println("<td>&nbsp;Remove?&nbsp;</td>");
				out.println("</tr>");
				out.println("</thead>");

				//looping showing result lei geh
				out.println("<tbody>");

				for (int i = 0; i < cartList.size(); i++) {
					out.println("<tr>");
					out.println("<td>&nbsp;" + cartList.get(i).getProductCode() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + cartList.get(i).getCustomerNumber() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + cartList.get(i).getRequiredDate() + "&nbsp;</td>");
					//out.println("<td>&nbsp;" + cartList.get(i).getComments() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + cartList.get(i).getQty() + "&nbsp;</td>");
					out.println("<td>&nbsp;<input type=\"checkbox\" name=\"productCode\" value=\""+ cartList.get(i).getProductCode() + "\">&nbsp;</td>");
					out.println("</tr>");
				}

				out.println("</tbody>");				
				out.println("</table>");
				out.println("<br>");
				out.println("<button type=\"submit\">Remove Cart</button>");
				out.println("</form>");
				
				out.println("<br>");
				out.println("<br>");
				//place order
				out.println("<form action=\"AddOrder\" method=\"post\">");
				
				out.println("<table border=0>");
				out.println("<tr>");
				out.println("<td>Comments </td>");
				out.println("<td>&nbsp; : <input type=\"text\" name=\"comments\" value=\"\" required> </td>");
				out.println("</tr>");
				out.println("</table>");
				
				out.println("<br>");
				out.println("<button type=\"submit\">Place Order</button>");
				out.println("</form>");
			}
		} catch (Exception e) {
		}
	%>
	<br>
	<br>

	<jsp:include page="includes/Footer.jsp" />
</body>
</html>