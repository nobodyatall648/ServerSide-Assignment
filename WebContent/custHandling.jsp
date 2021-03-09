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
					try{
						List<CustomerEntity> custHandling = (List<CustomerEntity>) request.getAttribute("CUST_LIST_HANDLING");
						
						for(int i=0; i < custHandling.size(); i++){
							out.println("<tr>");
							
							out.println("<td>&nbsp;"+ custHandling.get(i).getCustomernumber() +"&nbsp;</td>");
							out.println("<td>&nbsp;"+ custHandling.get(i).getCustomername() +"&nbsp;</td>");
							out.println("<td>&nbsp;"+ custHandling.get(i).getContactfirstname() + " " + custHandling.get(i).getContactlastname() +"&nbsp;</td>");
							out.println("<td>&nbsp;"+ custHandling.get(i).getPhone() +"&nbsp;</td>");
							
							//append address
							String address = custHandling.get(i).getAddressline1();
							
							if(custHandling.get(i).getAddressline2() != null){
								address += " " + custHandling.get(i).getAddressline2();
							}
							
							out.println("<td>&nbsp;"+ address +"&nbsp;</td>");
							out.println("<td>&nbsp;"+ custHandling.get(i).getCity() +"&nbsp;</td>");
							out.println("<td>&nbsp;"+ custHandling.get(i).getState() +"&nbsp;</td>");
							out.println("<td>&nbsp;"+ custHandling.get(i).getPostalcode() +"&nbsp;</td>");
							out.println("<td>&nbsp;"+ custHandling.get(i).getCountry() +"&nbsp;</td>");
							
							out.println("</tr>");
						}
					}catch(Exception e){

					}
				%>
			</tbody>
		</table>
	
		<form action="AcceptCustomerAssign" method="post">
				
		</form>
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>