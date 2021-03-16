<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ransom Vehicle Store - Place to Get Cool Vehicles</title>
</head>
<body>
	<jsp:include page="includes/HeaderCustomer.jsp" />
	<div class="container">
		<div class="subheader">
			<h2>
				<strong>&nbspPayment Checkout</strong>
			</h2>
		</div>
		<div class="panel panel-default paneldesign">
			<div class="panel-body">
				<%@ page import="domain.Cart"%>
				<%@ page import="java.util.List"%>
				<%@ page import="domain.OrderEntity"%>
				<%@ page import="java.util.Date"%>
				<%
					//IF NOT YET PLACED ORDER
						try {
						if (session.getAttribute("PLACED_ORDER") == null) {

							//if cart is empty
							if (session.getAttribute("CART") == null) {
								out.println("<div><h3><strong><u>Cart List Section</u></strong></h3></div>");
								out.println("<p>It is empty here! Try adding some products.</p>");
							}

							//retrieve customer number from cookies
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
								out.println("<div><h3><strong><u>Cart List Section</u></strong></h3></div>");
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
									out.println("<td>&nbsp;" + String.format("%.2f", cartList.get(i).getPriceEst())
											+ "&nbsp;</td>");
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
								out.println("<tr>");
								out.println(
										"<td><textarea class='textareadesign' name=\"comments\" rows=\"4\" cols=\"50\"></textarea></td>");
								out.println("</tr>");
								out.println("</table>");

								out.println("<br>");
								out.println("<input type=\"hidden\" name=\"customernumber\" value=\"" + customernumber + "\">");
								out.println("<button class='buttondesign' type=\"submit\">Place Order</button>");
								out.println("</form>");
							} else {
								out.println("<div class='cartsubheader'><h3><strong>&nbspCart List</strong></h3></div>");
								out.println("<p>It is empty here! Try adding some products.</p>");
							}
						} else {
							//IF PLACED ORDER

							if (session.getAttribute("CART") == null || session.getAttribute("CART").equals("")) {
								out.println("<div><h3><strong><u>Cart List Section</u></strong></h3></div>");
								out.println("<p>It is empty here! Try adding some products.</p>");
							} else {
								List<Cart> cartList = (List<Cart>) session.getAttribute("CART");
								OrderEntity orderEntity = (OrderEntity) session.getAttribute("ORDER_ENTITY");

								//cart list management
								if (cartList.size() != 0) {
									out.println("<div><h3><strong><u>Cart List Section</u></strong></h3></div>");
									out.println("<table class='table table-bordered tableborderdesign'>");

									out.println("<thead style=\"font-weight: bold\">");
									out.println("<tr>");
									out.println("<td>&nbsp;Product Code&nbsp;</td>");
									out.println("<td>&nbsp;Customer Number&nbsp;</td>");
									out.println("<td>&nbsp;Required Date&nbsp;</td>");
									out.println("<td>&nbsp;Price Each (RM)&nbsp;</td>");
									out.println("<td>&nbsp;Quantity&nbsp;</td>");
									out.println("</tr>");
									out.println("</thead>");

									//loop result in cart
									out.println("<tbody>");

									double totalPrice = 0;

									for (int i = 0; i < cartList.size(); i++) {
										out.println("<tr>");
										out.println("<td>&nbsp;" + cartList.get(i).getProductCode() + "&nbsp;</td>");
										out.println("<td>&nbsp;" + cartList.get(i).getCustomerNumber() + "&nbsp;</td>");
										out.println("<td>&nbsp;" + cartList.get(i).getRequiredDate() + "&nbsp;</td>");
										out.println("<td>&nbsp;" + String.format("%.2f", cartList.get(i).getPriceEst())
												+ "&nbsp;</td>");
										out.println("<td>&nbsp;" + cartList.get(i).getQty() + "&nbsp;</td>");
										out.println("</tr>");
										totalPrice += cartList.get(i).getPriceEst() * cartList.get(i).getQty();
									}

									out.println("</tbody>");
									out.println("</table>");

									//comments section
									out.println("<table border=0>");
									out.println("<tr><td><b>Comments: </b></td> <br></tr>");
									if (orderEntity.getComments() != null && !"".equals(orderEntity.getComments().trim())) {
										out.println("<tr><td><p>" + orderEntity.getComments() + "</p></td></tr>");
									} else {
										out.println("<tr><td><p>" + "No comments provided." + "</p></td></tr>");
									}
									out.println("</table>");
									out.println("<br>");
									out.println("<hr>");

									//total price for payment
									out.println("<form action=\"PaymentCheckout\" method=\"post\">");
									out.println("<div><h3><strong><u>Payment Section</u></strong></h3></div>");
									out.println("<div class='row'> <div class='col-xs-7'>");
									out.println("<h3><b>Total Price to be Paid:</b> RM" + String.format("%.2f", totalPrice)
											+ "</h3>");
									out.println("</div><br>");

									//place order and payment
									String customernumber = "";
									Cookie[] cookies = request.getCookies();
									for (int i = 0; i < cookies.length; i++) {
										Cookie c = cookies[i];
										if (c.getName().equals("uid")) {
											customernumber = c.getValue();
										}
									}

									out.println("<div class='col-xs-5'>");

									out.println("<table border=0>");

									out.println("<tr>");
									out.println("<td>Check Number </td>");
									out.println(
											"<td>&nbsp; : <input class= 'inputdesign' type=\"text\" name=\"checkNumber\" placeholder='eg: HQ336336' value=\"\" required> </td>");
									out.println("</tr>");

									out.println("<tr>");
									out.println("<td>Payment Date </td>");
									out.println(
											"<td>&nbsp; : <input id= 'paymentDate' class= 'inputdesign' type=\"date\" name=\"paymentDate\" readonly='readonly' value=\"\" required> </td>");
									out.println("</tr>");

									out.println("</table>");
									out.println("<input type=\"hidden\" name=\"totalPrice\" value=\"" + totalPrice + "\">");
									out.println(
											"<input type=\"hidden\" name=\"customernumber\" value=\"" + customernumber + "\">");
									out.println(
											"<br><button style='margin-left:175px;' class='buttondesign' type=\"submit\">Make Payment</button>");
									out.println("</form>");
									out.println("</div></div><br>");

								} else {
									out.println("<p>It is empty here! Try adding some products.</p>");
								}
							}
						}
					} catch (Exception e) {
					}
				%>

			</div>
		</div>
	</div>
	<jsp:include page="includes/Footer.jsp" />

	<script>
		Date.prototype.toDateInputValue = (function() {
			var local = new Date(this);
			local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
			return local.toJSON().slice(0, 10);
		});

		document.getElementById('paymentDate').value = new Date()
				.toDateInputValue();
	</script>
</body>
</html>