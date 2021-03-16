<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Handling & Assigning</title>
</head>
<body>
	<jsp:include page="includes/HeaderEmployee.jsp" />
	
	<div class="container">
	<h2>
		<u><strong>Customer Handling & Assigning</strong></u>
	</h2>

	<%@ page import="domain.CustomerEntity"%>
	<%@ page import="java.util.List"%>

	<h3>Customer Handling</h3>
	<table border=3>
		<thead>
			<tr>
				<td>&nbsp;Customer Number&nbsp;</td>
				<td>&nbsp;Customer Name&nbsp;</td>
				<td>&nbsp;Contact Name&nbsp;</td>
				<td>&nbsp;Phone&nbsp;</td>
				<td>&nbsp;Address&nbsp;</td>
				<td>&nbsp;City&nbsp;</td>
				<td>&nbsp;State&nbsp;</td>
				<td>&nbsp;Postal Code&nbsp;</td>
				<td>&nbsp;Country&nbsp;</td>
			</tr>
		</thead>

		<tbody>
			<%
				try {
					List<CustomerEntity> custHandling = (List<CustomerEntity>) request.getAttribute("CUST_LIST_HANDLING");

					for (int i = 0; i < custHandling.size(); i++) {
						out.println("<tr>");

						out.println("<td>&nbsp;" + custHandling.get(i).getCustomernumber() + "&nbsp;</td>");
						out.println("<td>&nbsp;" + custHandling.get(i).getCustomername() + "&nbsp;</td>");
						out.println("<td>&nbsp;" + custHandling.get(i).getContactfirstname() + " "
								+ custHandling.get(i).getContactlastname() + "&nbsp;</td>");
						out.println("<td>&nbsp;" + custHandling.get(i).getPhone() + "&nbsp;</td>");

						//append address
						String address = custHandling.get(i).getAddressline1();

						if (custHandling.get(i).getAddressline2() != null) {
							address += " " + custHandling.get(i).getAddressline2();
						}

						out.println("<td>&nbsp;" + address + "&nbsp;</td>");
						out.println("<td>&nbsp;" + custHandling.get(i).getCity() + "&nbsp;</td>");
						out.println("<td>&nbsp;" + custHandling.get(i).getState() + "&nbsp;</td>");
						out.println("<td>&nbsp;" + custHandling.get(i).getPostalcode() + "&nbsp;</td>");
						out.println("<td>&nbsp;" + custHandling.get(i).getCountry() + "&nbsp;</td>");

						out.println("</tr>");
					}
				} catch (Exception e) {

				}
			%>
		</tbody>
	</table>

	<br>
	<h3>Choose Customer to Become as Sales Representative</h3>
	<form action="AcceptCustomerAssign" method="post">
		<table border=3>
			<thead>
				<tr>
					<td>&nbsp;Customer Number&nbsp;</td>
					<td>&nbsp;Customer Name&nbsp;</td>
					<td>&nbsp;Contact Name&nbsp;</td>
					<td>&nbsp;Phone&nbsp;</td>
					<td>&nbsp;Address&nbsp;</td>
					<td>&nbsp;City&nbsp;</td>
					<td>&nbsp;State&nbsp;</td>
					<td>&nbsp;Postal Code&nbsp;</td>
					<td>&nbsp;Country&nbsp;</td>
					<td>&nbsp;Choose&nbsp;</td>
				</tr>
			</thead>

			<tbody>
				<%
					try {
						List<CustomerEntity> custNOSR = (List<CustomerEntity>) request.getAttribute("CUST_LIST_NOSR");

						for (int i = 0; i < custNOSR.size(); i++) {
							out.println("<tr>");

							out.println("<td>&nbsp;" + custNOSR.get(i).getCustomernumber() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + custNOSR.get(i).getCustomername() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + custNOSR.get(i).getContactfirstname() + " "
									+ custNOSR.get(i).getContactlastname() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + custNOSR.get(i).getPhone() + "&nbsp;</td>");

							//append address
							String address = custNOSR.get(i).getAddressline1();

							if (custNOSR.get(i).getAddressline2() != null) {
								address += " " + custNOSR.get(i).getAddressline2();
							}

							out.println("<td>&nbsp;" + address + "&nbsp;</td>");
							out.println("<td>&nbsp;" + custNOSR.get(i).getCity() + "&nbsp;</td>");
							
							String state = "";
							
							if(custNOSR.get(i).getState() == null){
								state="  -  ";
							}else{
								state=custNOSR.get(i).getState();
							}
							out.println("<td>&nbsp;" + state + "&nbsp;</td>");
							out.println("<td>&nbsp;" + custNOSR.get(i).getPostalcode() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + custNOSR.get(i).getCountry() + "&nbsp;</td>");
							out.println("<td>&nbsp;<input type=\"radio\" name=\"custnum\" value=\"" + custNOSR.get(i).getCustomernumber() +"\" required></td>");

							out.println("</tr>");
						}
						
						String salesRep = (String) request.getAttribute("SALESREP");
						out.println("<input type=\"hidden\" name=\"salesRep\" value=\""+ salesRep +"\">");
					} catch (Exception e) {

					}
				%>
			</tbody>
		</table>
		<br>
		<button type="submit">Become customer SalesRep</button>
	</form>
	
	<br>
	<br>
	</div>
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>