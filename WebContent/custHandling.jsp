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
				</tr>
			</thead>
			
			<tbody>
				<%
					try{
						List<CustomerEntity> custHandling = (List<CustomerEntity>) request.getAttribute("CUST_LIST_HANDLING");
						
						for(int i=0; i < custHandling.size(); i++){
							out.println("<tr>");
							
							out.println("<td>"+ custHandling.get(i).getCustomernumber() +"</td>");
							out.println("<td>"+ custHandling.get(i).getCustomername() +"</td>");
							out.println("<td>"+ custHandling.get(i).getContactfirstname() + " " + custHandling.get(i).getContactlastname() +"</td>");
							out.println("<td>"+ custHandling.get(i).getPhone() +"</td>");
							out.println("<td>"+ custHandling.get(i).getCustomername() +"</td>");
							
							//append address
							String address = custHandling.get(i).getAddressline1();
							
							if(custHandling.get(i).getAddressline2() != null){
								address += " " + custHandling.get(i).getAddressline2();
							}
							
							out.println("<td>"+ address +"</td>");
							out.println("<td>"+ custHandling.get(i).getCity() +"</td>");
							out.println("<td>"+ custHandling.get(i).getState() +"</td>");
							out.println("<td>"+ custHandling.get(i).getPostalcode() +"</td>");
							out.println("<td>"+ custHandling.get(i).getCountry() +"</td>");
							
							out.println("</tr>");
						}
					}catch(Exception e){
						
					}
				%>
			</tbody>
		</table>
	</form>
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>