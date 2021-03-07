<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Order</title>
</head>
<body>
	<jsp:include page="includes/HeaderCustomer.jsp" />

	<h2>
		<u><strong>View Order</strong></u>
	</h2>

	<%@ page import="domain.OrderEntity"%>
	<%@ page import="domain.OrderdetailEntity"%>
	<%@ page import="java.util.List"%>

	<form action="GetOrderDetails" method="get">
		<table border=0>
			<tr>
				<td>Choose order number to view more details :</td>
				<td>&nbsp; <select name="ordernumber">
						<%
							//list order numbers
							try {
								List<OrderEntity> orderList = (List<OrderEntity>) session.getAttribute("ORDER_LIST");

								for (int i = 0; i < orderList.size(); i++) {
									out.println("<option value=\"" + orderList.get(i).getOrdernumber() + "\">"
											+ orderList.get(i).getOrdernumber() + "</option>");
								}
							} catch (Exception e) {

							}
						%>
				</select>
				</td>
				<td>&nbsp;
					<button type="submit">Get Product Info</button>
				</td>
			</tr>
		</table>
	</form>

	<h3>
		<u>Orders</u>
	</h3>
	<table border=2>
		<thead>
			<tr>
				<td>&nbsp;Order Number&nbsp;</td>
				<td>&nbsp;Order Date&nbsp;</td>
				<td>&nbsp;Comments&nbsp;</td>
				<td>&nbsp;Status&nbsp;</td>
			</tr>
		</thead>
		<%
			try {
				List<OrderEntity> orderList = (List<OrderEntity>) session.getAttribute("ORDER_LIST");

				out.println("<tbody>");
				for (int i = 0; i < orderList.size(); i++) {
					out.println("<tr>");

					out.println("<td>&nbsp;" + orderList.get(i).getOrdernumber() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + orderList.get(i).getOrderdate() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + orderList.get(i).getComments() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + orderList.get(i).getStatus() + "&nbsp;</td>");

					out.println("</tr>");
				}
				out.println("</tbody>");
				out.println("</tr>");
			} catch (Exception e) {

			}
		%>
	</table>

	<br>

	<%
		try {
			List<OrderdetailEntity> orderDetailList = (List<OrderdetailEntity>) request
					.getAttribute("ORDER_DETAIL_LIST");
			out.println("<h3><u>More Order Details of " + orderDetailList.get(0).getOrder().getOrdernumber()
					+ "</u></h3>");

			out.println("<table border=2>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<td>&nbsp;Product Code&nbsp;</td>");
			out.println("<td>&nbsp;Price Each&nbsp;</td>");
			out.println("<td>&nbsp;QTY Ordered&nbsp;</td>");
			out.println("</tr>");
			out.println("</thead>");

			out.println("<tbody>");
			
			double totalPrice = 0;
			for (int i = 0; i < orderDetailList.size(); i++) {

				out.println("<tr>");

				out.println("<td>&nbsp;" + orderDetailList.get(i).getProduct().getProductcode() + "&nbsp;</td>");
				out.println("<td>&nbsp;" + orderDetailList.get(i).getPriceeach() + "&nbsp;</td>");
				out.println("<td>&nbsp;" + orderDetailList.get(i).getQuantityordered() + "&nbsp;</td>");

				out.println("</tr>");
				
				totalPrice += Double.parseDouble(orderDetailList.get(i).getPriceeach().toString()) * orderDetailList.get(i).getQuantityordered();
			}
			out.println("</tbody>");
			out.println("</table>");
			out.println("<br>");
			
			out.println("<h4>Total Price: RM" + String.format("%.2f", totalPrice) +"</h4>");
			
		} catch (Exception e) {

		}
	%>

	<br>
	<br>

	<jsp:include page="includes/Footer.jsp" />
</body>
</html>