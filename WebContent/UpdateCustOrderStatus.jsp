<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer Order Status</title>
</head>
<body>
	<jsp:include page="includes/HeaderEmployee.jsp" />
	<div class="container">
	<h2>
		<u><strong>Update Customer Order Status</strong></u>
	</h2>

	<form action="GetCustOrdersForUpdateStatus" method="GET">
		<table border=0>
			<tr>
				<td>Enter Customer Number:</td>
				<td>&nbsp; <input type="text" name="custnum" required>&nbsp;
				</td>
			</tr>
			<tr><td bgcolor="#FFFFFF" style="line-height:10px;" colspan=3>&nbsp;</td></tr>
			<tr>
				<td><select name="filter">
						<option value="all">Show All Customer Orders</option>
						<option value="filter_ship">Filter Shipped Customer
							Orders</option>
				</select></td>
			</tr>
		</table>
		<br>
		<button class="buttondesignemp" type="submit">List Orders</button>
	</form>

	<%@ page import="domain.CustomerEntity"%>
	<%@ page import="domain.OrderEntity"%>
	<%@ page import="domain.OrderdetailEntity"%>
	<%@ page import="java.util.List"%>

	<%
		try {
			List<OrderEntity> orderList = (List<OrderEntity>) session.getAttribute("ORDERLIST");
			CustomerEntity custEntity = (CustomerEntity) session.getAttribute("CUSTLIST");

			if (orderList.size() > 0) {
				out.println("<br>");
				out.println("<strong>Customer Selected: " + custEntity.getCustomernumber() + "</strong>");
				out.println("<br>");
				
			} else {
				out.println("<br>");
				out.println("<strong>Customer Selected: " + custEntity.getCustomernumber() + "</strong>");
				out.println("<br>");

				out.println("<h4>No Order Made or All Order Has Been Shipped.</h4>");
			}
		} catch (Exception e) {

		}
	%>

	<%
		try {
			List<OrderEntity> orderList = (List<OrderEntity>) session.getAttribute("ORDERLIST");

			if (orderList.size() > 0) {
				out.println("<h3><u>Order Status</u></h3>");
				out.println("<table border=2>");
				out.println("<thead>");
				out.println("<tr>");
				out.println("<td>&nbsp;Order Number&nbsp;</td>");
				out.println("<td>&nbsp;Order Date&nbsp;</td>");
				out.println("<td>&nbsp;Comments&nbsp;</td>");
				out.println("<td>&nbsp;Status&nbsp;</td>");
				out.println("</tr>");
				out.println("</thead>");

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
				out.println("</table>");
				
				//status updates
				String [] updateStatus = {"In Process", "Disputed", "On Hold", "Cancelled", "Resolved", "Shipped"};
				out.println("<br>");
				
				out.println("<form action=\"UpdateOrderStatus\" method=\"post\">");
				out.println("<table border=3>");
				out.println("<thead>");
				out.println("<tr>");
				out.println("<td>&nbsp; Select Order Number &nbsp;</td>");
				out.println("<td>&nbsp; Update Order Status &nbsp;</td>");
				out.println("</tr>");
				out.println("</thead>");
				
				out.println("<tbody>");
				out.println("<tr>");
				out.println("<td>");
				out.println("&nbsp; <select name=\"ordernum\">");
				for (int i = 0; i < orderList.size(); i++) {
					out.println("<option value=\"" + orderList.get(i).getOrdernumber() + "\">"
							+ orderList.get(i).getOrdernumber() + "</option>");
				}
				out.println("</select> &nbsp;</td>");
				out.println("<td> &nbsp; <select name=\"status\">");				
				for(int i=0; i < updateStatus.length ; i++){
					out.println("<option value=\""+ updateStatus[i] + "\">"+ updateStatus[i] +"</option>");
				}
				out.println("</select>");
				out.println(" &nbsp; </td>");
				out.println("</tbody>");
				out.println("</table>");
				out.println("<br>");
				out.println("<button type=\"submit\">Update Order Status</button>");
				out.println("</form>");
				
				
			}
		} catch (Exception e) {

		}
	%>

	<br>
	<br>
	</div>
	<br><br><br><br><br><br><br><br><br><br>
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>