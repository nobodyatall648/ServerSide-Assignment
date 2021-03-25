<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Customer Payment</title>
</head>
<body>
	<jsp:include page="includes/HeaderEmployee.jsp" />

	<div class="container">
		<h2>
			<u><strong>View Customer Payment</strong></u>
		</h2>

		<%@ page import="domain.PaymentEntity"%>
		<%@ page import="java.util.List"%>
		<form action="GetCustomerPaymentByEmployee" method="get">
			<table border=0>
				<tr>
					<td>Enter Customer Number :</td>
					<td>&nbsp; <input type="text" name="customernumber"
						required=true></td>
					<td>&nbsp;
						<button type="submit">Search Customer Order</button>
					</td>
				</tr>

			</table>
		</form>

		<%
			try {
				List<PaymentEntity> paymentList = (List<PaymentEntity>) request.getAttribute("PAYMENT_LIST_BYEMP");

				
				if (paymentList.size() > 0) {
					out.println("<br><br><div><strong>Customer Selected: </strong>" + paymentList.get(0).getCustomer().getCustomernumber() + "</div><br><br>");
					
					out.println("<table class='table'>");
					out.println("<thead><tr><th></th>");
					out.println("<th>Check Number</th>");
					out.println("<th>Payment Date</th>");
					out.println("<th>Amount</th></tr></thead>");
					
					for (int i = 0; i < paymentList.size(); i++) {
						out.println("<tbody><tr>");
						out.println("<td>" + (i+1) + "</td>");
						out.println("<td>&nbsp;" + paymentList.get(i).getId().getChecknumber().toString() + "&nbsp;</td>");
						out.println("<td>&nbsp;" + paymentList.get(i).getPaymentdate() + "&nbsp;</td>");
						out.println("<td>&nbsp;RM " + paymentList.get(i).getAmount() + "&nbsp;</td>");

						out.println("</tr>");
					}
					out.println("</tbody>");
					out.println("</table>");
				}
			} catch (Exception e) {

			}
		%>

		<br><br>

	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>