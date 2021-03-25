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
				<strong>&nbspView Payment</strong>
			</h2>
		</div>
		<div class="panel panel-default paneldesign">
			<div class="panel-body">
				<%@ page import="domain.PaymentEntity"%>
				<%@ page import="java.util.List"%>
				<h3>
					<u><strong>Payment History</strong></u>
				</h3>
				<table class="table" border=2>
					<thead>
						<tr>
							<td><strong>&nbsp;Payment Date&nbsp;</strong></td>
							<td><strong>&nbsp;Check Number&nbsp;</strong></td>
							<td><strong>&nbsp;Amount&nbsp;</strong></td>

						</tr>
					</thead>


					<%
						try {
							List<PaymentEntity> paymentList = (List<PaymentEntity>) session.getAttribute("PAYMENT_LIST");

							out.println("<tbody>");
							for (int i = 0; i < paymentList.size(); i++) {
								out.println("<tr>");
								out.println("<td>&nbsp;" + paymentList.get(i).getPaymentdate() + "&nbsp;</td>");
								out.println("<td>&nbsp;" + paymentList.get(i).getId().getChecknumber().toString() + "&nbsp;</td>");	
								out.println("<td>&nbsp;RM " + paymentList.get(i).getAmount() + "&nbsp;</td>");

								out.println("</tr>");
							}
							out.println("</tbody>");
							out.println("</tr>");
						} catch (Exception e) {

						}
					%>
				</table>



			</div>
		</div>
	</div>
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>