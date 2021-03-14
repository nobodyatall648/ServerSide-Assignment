<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Customer Order</title>
</head>
<body>
	<jsp:include page="includes/HeaderEmployee.jsp" />

	<h2>
		<u><strong>View Customer Order</strong></u>
	</h2>

	<%@ page import="domain.OrderEntity"%>
	<%@ page import="domain.OrderdetailEntity"%>
	<%@ page import="java.util.List"%>

	<form action="GetCustomerOrderByEmployee" method="get">
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
			List<OrderEntity> orderList = (List<OrderEntity>) session.getAttribute("ORDER_LISTBYEMP");

			if (orderList.size() > 0) {

				out.println("<br>");
				out.println("<strong>Customer Selected: " + orderList.get(0).getCustomernumber() + "</strong>");
				out.println("<br>");
				out.println("<form action=\"GetOrderDetailsByEmployee\" method=\"get\">");
				out.println("<table border=0>");
				out.println("<tr>");
				out.println("<td>Choose order number to view more details :</td>");
				out.println("<td>&nbsp; <select name=\"ordernumber\">");
				//list order numbers	

				for (int i = 0; i < orderList.size(); i++) {
					out.println("<option value=\"" + orderList.get(i).getOrdernumber() + "\">"
							+ orderList.get(i).getOrdernumber() + "</option>");
				}

				out.println("</select>");
				out.println("</td>");
				out.println("<td>&nbsp;");
				out.println("<button type=\"submit\">Get Orders Info</button>");
				out.println("</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</form>");
			}
		} catch (Exception e) {

		}
	%>



	<%
		try {
			List<OrderEntity> orderList = (List<OrderEntity>) session.getAttribute("ORDER_LISTBYEMP");

			if (orderList.size() > 0) {
				out.println("<h3><u>Order Status</u></h3>");
				out.println("<table border=2>");
				out.println("<thead>");
				out.println("<tr>");
				out.println("<td>&nbsp;Order Number&nbsp;</td>");
				out.println("<td>&nbsp;Order Date&nbsp;</td>");
				out.println("<td>&nbsp;Comments&nbsp;</td>");
				out.println("<td>&nbsp;Required Date&nbsp;</td>");
				out.println("<td>&nbsp;Shipped Date&nbsp;</td>");
				out.println("<td>&nbsp;Status&nbsp;</td>");
				out.println("</tr>");
				out.println("</thead>");

				out.println("<tbody>");
				for (int i = 0; i < orderList.size(); i++) {
					out.println("<tr>");

					out.println("<td>&nbsp;" + orderList.get(i).getOrdernumber() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + orderList.get(i).getOrderdate() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + orderList.get(i).getComments() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + orderList.get(i).getRequireddate() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + orderList.get(i).getShippeddate() + "&nbsp;</td>");
					out.println("<td>&nbsp;" + orderList.get(i).getStatus() + "&nbsp;</td>");

					out.println("</tr>");
				}
				out.println("</tbody>");
				out.println("</tr>");
			}
		} catch (Exception e) {

		}
	%>
	</table>

	<br>

	<%
		try {
			List<OrderdetailEntity> orderDetailList = (List<OrderdetailEntity>) request
					.getAttribute("ORDER_DETAIL_LISTBYEMP");
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

				totalPrice += Double.parseDouble(orderDetailList.get(i).getPriceeach().toString())
						* orderDetailList.get(i).getQuantityordered();
			}
			out.println("</tbody>");
			out.println("</table>");
			out.println("<br>");

			out.println("<h4>Total Price: RM" + String.format("%.2f", totalPrice) + "</h4>");

		} catch (Exception e) {

		}
	%>

	<br>
	<br>

	<jsp:include page="includes/Footer.jsp" />
</body>
</html>