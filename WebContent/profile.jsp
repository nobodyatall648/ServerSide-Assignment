<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ransom Vehicle Store - Place to Get Cool Vehicles</title>
</head>
<body>
	<%
		Cookie [] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie c = cookies[i];
			if (c.getName().equals("role")) {
				//IF ROLE IS CUSTOMER 
				if (c.getValue().equals("cust")) {
	%>
	<jsp:include page="includes/HeaderCustomer.jsp" />
	<%
		//IF ROLE IS EMPLOYEE
		} else if (c.getValue().equals("emp")) {
	%>
	<jsp:include page="includes/HeaderEmployee.jsp" />
	<%
		}
			}
		}
	%>

	<div class="container">
		<div class="subheader">
			<h2>
				<strong>&nbspProfile Details</strong>
			</h2>
		</div>
		<div class="panel panel-default paneldesign">
			<div class="panel-body">
				<%
					for (int i = 0; i < cookies.length; i++) {
						Cookie c = cookies[i];
						if (c.getName().equals("role")) {
							//IF ROLE IS CUSTOMER
							if (c.getValue().equals("cust")) {
				%>
				<%@ page import="domain.CustomerEntity"%>
				
					<table class="table" border=2>
					<%
						try {
							
							CustomerEntity customerEntity = (CustomerEntity) session.getAttribute("CUSTOMER_ENTITY");
				
							out.println("<tr>");
							out.println("<td>&nbsp;" + customerEntity.getCustomername() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + customerEntity.getContactfirstname() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + customerEntity.getContactlastname() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + customerEntity.getCountry() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + customerEntity.getCustomernumber() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + customerEntity.getAddressline1() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + customerEntity.getAddressline2() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + customerEntity.getPostalcode() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + customerEntity.getState() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + customerEntity.getCity() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + customerEntity.getCreditlimit() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + customerEntity.getPhone() + "&nbsp;</td>");

							out.println("</tr>");
							
							out.println("</tbody>");
							out.println("</tr>");
						} catch (Exception e) {

						}
					%>
				</table>
				
				<%
					//IF ROLE IS EMPLOYEE
					} else if (c.getValue().equals("emp")) {
				%>
				<%@ page import="domain.EmployeeEntity"%>
				
					<table class="table" border=2>
					<%
						try {
							
							EmployeeEntity employeeEntity = (EmployeeEntity) session.getAttribute("EMPLOYEE_ENTITY");
				
							out.println("<tr>");
							out.println("<td>&nbsp;" + employeeEntity.getEmployeenumber() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + employeeEntity.getEmail() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + employeeEntity.getFirstname() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + employeeEntity.getLastname() + "&nbsp;</td>");
							out.println("<td>&nbsp;" + employeeEntity.getJobtitle() + "&nbsp;</td>");
	
							out.println("</tr>");
							
							out.println("</tbody>");
							out.println("</tr>");
						} catch (Exception e) {

						}
					%>
				</table>
				<%
					}
						}
					}
				%>

				

			
			</div>
		</div>
	</div>
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>