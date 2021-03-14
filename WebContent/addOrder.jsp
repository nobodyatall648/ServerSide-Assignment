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
	<div class="container">

		<div class="subheader">
			<h2>
				<strong>&nbspAdd Order</strong>
			</h2>
		</div>
		<div class="panel panel-default paneldesign">
			<div class="panel-body">
				<form action="GetProductInfo" method="get">
					<table border=0>
						<tr>
							<td><b>Enter product code :</b></td>
							<td>&nbsp<input class="inputdesign" type="text"
								name="productCode" value="" placeholder="eg: S10_1678" required></td>
							<td><button class="buttondesign" type="submit">Get
									Product Info</button></td>
						</tr>
					</table>
				</form>

				<br> <br>

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
							out.println("<h3><b><u>Product Info</u></b></h3>");
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
							out.println("<h3><b><u>Order Placing Details</u></b></h3>");

							//add to cart
							String customernumber = "";
							Cookie[] cookies = request.getCookies();
							for (int i = 0; i < cookies.length; i++) {
								Cookie c = cookies[i];
								if (c.getName().equals("uid")) {
									customernumber = c.getValue();
								}
							}							

							out.println("<form action=\"CartController\" method=\"post\">");
							out.println("<table border=0>");

							out.println("<tr>");
							out.println("<td>Quantity </td>");
							out.println(
									"<td>&nbsp; : <input class= 'inputdesign' type=\"text\" name=\"qty\" value=\"\" required> </td>");
							out.println("</tr>");

							out.println("<tr>");
							out.println("<td>Required Date </td>");
							out.println(
									"<td>&nbsp; : <input class= 'inputdesign' type=\"date\" name=\"requiredDate\" value=\"\" required> </td>");
							out.println("</tr>");

							out.println("</table>");
							out.println("<input type=\"hidden\" name=\"productCode\" value=\"" + productInfo.getProductcode()
									+ "\">");
							out.println("<input type=\"hidden\" name=\"customernumber\" value=\"" + customernumber + "\">");
							out.println("<br><button class='buttondesign' type=\"submit\">Add to Cart</button>");
							out.println("</form>");
						}
					} catch (Exception e) { //catching NullPointerException in getAttribute() during the 1st time vising addOrder.jsp

					}
				%>


				<!-- floating shopping cart button right down corner -->
				<button id="shoppingcart" class="btn btn-default buttondesign"
					type="button" name="cartbtn" onclick="showCart()">
					<i class="fa fa-shopping-cart fa-3x"></i>
				</button>

				<!-- this div is not displayed now. if shopping cart button is clicked, then display set to block -->
				<div id="divCart" style="display: none;">
					<div class="panel panel-default cartpanel">
						<div class="panel-body">

							<!-- cart exit button -->
							<button id="exitbtn" class="btn btn-default" type="button"
								name="cartbtn" onclick="hideCart()">
								<i class="fa fa-times"></i>
							</button>
							<%
								try {
									String customernumber = "";
									Cookie[] cookies = request.getCookies();
									for (int i = 0; i < cookies.length; i++) {
										Cookie c = cookies[i];
										if (c.getName().equals("uid")) {
											customernumber = c.getValue();
										}
									}
									List<Cart> cartList = (List<Cart>) session.getAttribute("CART");
									
									//cart list management
									if (cartList.size() != 0) {
										out.println("<div class='cartsubheader'><h3><strong>&nbspCart List</strong></h3></div>");
										out.println("<form action=\"CartController\" method=\"get\">");
										out.println("<table class='table table-bordered' >");

										out.println("<thead style=\"font-weight: bold\">");
										out.println("<tr>");
										out.println("<td>&nbsp;Product Code&nbsp;</td>");
										out.println("<td>&nbsp;Customer Number&nbsp;</td>");
										out.println("<td>&nbsp;Required Date&nbsp;</td>");
										out.println("<td>&nbsp;Price Each (RM)&nbsp;</td>");
										out.println("<td>&nbsp;Quantity&nbsp;</td>");
										out.println("<td>&nbsp;Remove?&nbsp;</td>");
										out.println("</tr>");
										out.println("</thead>");

										//looping showing result lei geh
										out.println("<tbody>");

										double totalPrice = 0;

										for (int i = 0; i < cartList.size(); i++) {
											out.println("<tr>");
											out.println("<td>&nbsp;" + cartList.get(i).getProductCode() + "&nbsp;</td>");
											out.println("<td>&nbsp;" + cartList.get(i).getCustomerNumber() + "&nbsp;</td>");
											out.println("<td>&nbsp;" + cartList.get(i).getRequiredDate() + "&nbsp;</td>");
											out.println(
													"<td>&nbsp;" + String.format("%.2f", cartList.get(i).getPriceEst()) + "&nbsp;</td>");
											out.println("<td>&nbsp;" + cartList.get(i).getQty() + "&nbsp;</td>");
											out.println("<td>&nbsp;<input type=\"checkbox\" name=\"productCode\" value=\""
													+ cartList.get(i).getProductCode() + "\">&nbsp;</td>");
											out.println("</tr>");
											totalPrice += cartList.get(i).getPriceEst() * cartList.get(i).getQty();
										}

										out.println("</tbody>");
										out.println("</table>");
										out.println("<br>");
										out.println("<button class='buttondesign' type=\"submit\">Remove from Cart</button>");
										out.println("</form>");

										out.println("<br>");

										out.println("<h4>Total Price Estimated: RM" + String.format("%.2f", totalPrice) + "</h4>");

										out.println("<br>");
										//place order
										out.println("<form action=\"AddOrder\" method=\"post\">");

										out.println("<table border=0>");
										out.println("<tr>");
										out.println("<td>Comments : </td> <br>");
										out.println("</tr>");

										out.println("</table>");

										out.println("<br>");
										out.println("<input type=\"hidden\" name=\"customernumber\" value=\"" + customernumber + "\">");
										out.println("<button class='buttondesign' type=\"submit\">Place Order</button>");
										out.println("</form>");
									}
									else{
										out.println("<div class='cartsubheader'><h3><strong>&nbspCart List</strong></h3></div>");
										out.println("<p>It is empty here! Try adding some products.</p>");
									}
								} catch (Exception e) {
								}
							%>
						</div>
					</div>
				</div>
				<br> <br>

			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="includes/Footer.jsp" />

	<script>
		function showCart() {
			document.getElementById('divCart').style.display = "block";
		}

		function hideCart() {
			document.getElementById('divCart').style.display = "none";
		}
	</script>
</body>
</html>