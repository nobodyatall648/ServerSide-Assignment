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
	<%@ page import="java.util.List"%>
	
	<form action="GetOrderDetails" method="get">
		<table border=0>
			<tr>
				<td>Choose order number to view more details :</td>
				<td>&nbsp;
					<select name="ordernumber">					
						<%
							//list order numbers
							try{
								List<OrderEntity> orderList = (List<OrderEntity>) request.getAttribute("ORDER_LIST");
								
								for(int i=0; i < orderList.size(); i++){
									out.println("<option value=\"" + orderList.get(i).getOrdernumber() + "\">" + orderList.get(i).getOrdernumber() + "</option>");
								}
							}catch(Exception e){
								
							}
						%>
					</select>
				</td>
				<td>&nbsp;<button type="submit">Get Product Info</button></td>
			</tr>
		</table>
	</form>
	
	<h3><u>Orders</u></h3>
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
			List<OrderEntity> orderList = (List<OrderEntity>) request.getAttribute("ORDER_LIST");
						
			for(int i=0; i < orderList.size(); i++){
				out.println("<tr>");
				
				out.println("<td>&nbsp;" + orderList.get(i).getOrdernumber() + "&nbsp;</td>");
				out.println("<td>&nbsp;" + orderList.get(i).getOrderdate() + "&nbsp;</td>");
				out.println("<td>&nbsp;" + orderList.get(i).getComments() + "&nbsp;</td>");
				out.println("<td>&nbsp;" + orderList.get(i).getStatus() + "&nbsp;</td>");				
				
				out.println("</tr>");
			}
		
			out.println("</tr>");
		%>
	</table>
	
	<br>
	<br>
	
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>