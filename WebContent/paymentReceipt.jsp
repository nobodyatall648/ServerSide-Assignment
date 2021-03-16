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
				<strong>&nbspPayment Receipt</strong>
				<button class="btn btn-default printbutton" type="button"
					name="printbtn" onclick="window.print();">
					<i class="fa fa-print fa-2x"></i>
				</button>
			</h2>
		</div>
		<div class="panel panel-default paneldesign">
			<div class="panel-body">
			<!-- print button -->
		
			
				<%@ page import="java.util.List"%>
				<%@ page import="domain.OrderEntity"%>
				<%@ page import="domain.OrderdetailEntity"%>
				<%@ page import="domain.PaymentEntity"%>
				<%@ page import="java.util.Date"%>
				<%
				try{
					List<OrderdetailEntity> orderDetailEntity = (List<OrderdetailEntity>) session.getAttribute("ORDERDETAIL_ENTITY");
					OrderEntity orderEntity = (OrderEntity) session.getAttribute("ORDER_ENTITY");
					PaymentEntity paymentEntity = (PaymentEntity) session.getAttribute("PAYMENT_ENTITY");

					//customer details
					out.println("<h3><b>Customer Number:</b>" + orderEntity.getCustomernumber().toString() + "</h3>");

					//order details
					out.println("<hr><div><h3><strong><u>Order Details</u></strong></h3></div>");
					out.println("<table class='table' >");
					out.println("<tr>");
					out.println("<th>Order Number </th><td>: " + orderEntity.getOrdernumber() + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<th>Order Date </th><td>: " + orderEntity.getOrderdate() + "</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<th>Order Required Date</th><td>: " + orderEntity.getRequireddate() + "</td></tr>");
					out.println("<tr><th>Comments</th>");
					if (orderEntity.getComments() != null && !"".equals(orderEntity.getComments().trim())) {
						out.println("<td>: " + orderEntity.getComments() + "</td></tr>");
					} else {
						out.println("<td>: " + "No comments provided." + "</td></tr></table>");
					}
					
					//product details
					if (orderDetailEntity.size() != 0) {
						
						out.println("<hr><h3><b><u>Product Information</u></b></h3>");
						out.println("<table class='table'>");
						out.println("<tbody>");
						for (int i = 0; i < orderDetailEntity.size(); i++) {
							
							out.println("<tr>");
							out.println("<th>Product Code </th>");
 							out.println("<td>&nbsp: " + orderDetailEntity.get(i).getProduct().getProductcode() + "</td>");
							out.println("</tr>");

							out.println("<tr>");
							out.println("<th>Product Name </th>");
							out.println("<td>&nbsp: " + orderDetailEntity.get(i).getProduct().getProductname() + "</td>");
							out.println("</tr>");

						}

						out.println("</tbody>");
						out.println("</table>");

						//payment details
						out.println("<hr><div><h3><strong><u>Payment Details</u></strong></h3></div>");
						out.println("<table class='table' >");
						out.println("<tr>");
						out.println("<th>Total Price Paid </th><td>: " + paymentEntity.getAmount() + "</td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<th>Date Paid </th><td>: " + paymentEntity.getPaymentdate() + "</td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<th>Check Number</th><td>: " + paymentEntity.getId().getChecknumber().toString() + "</td></tr>");

						//redirect user to home page and send success message to user
						out.println(
								"<br><button onclick='redirectHome()' class='buttondesign' type=\"submit\">Redirect back to home page</button>");

					}
				}catch (Exception e){
					e.printStackTrace();
				}
				%>
			</div>
		</div>
	</div>
</body>
<script>
	function redirectHome() {
		window.location.replace("/index.jsp?success=1");

	}
</script>
</html>