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
				out.println("<div style='margin-left:1000px;'>");
				out.println("<a class=\"btn btn-danger editBtn\">Edit Off</a>");
				out.println("</div>");
				
					for (int i = 0; i < cookies.length; i++) {
						Cookie c = cookies[i];
						if (c.getName().equals("role")) {
							//IF ROLE IS CUSTOMER
							if (c.getValue().equals("cust")) {
				%>
				<%@ page import="domain.CustomerEntity"%>
				<%
					try {
									CustomerEntity customerEntity = (CustomerEntity) session.getAttribute("CUSTOMER_ENTITY");

									out.println("<form action=\"ProfileController\" method=\"post\">");
									//personal details
									out.println("<hr><div><h3><strong><u>Personal Details</u></strong></h3></div>");
									out.println("<table class='table' style='table-layout:fixed'>");
									out.println("<tr><th>Customer Number</th><td>");
									out.println(customerEntity.getCustomernumber());
									out.println("</td></tr>");
									out.println("<tr><th>Customer Name</th><td>");
									out.println("<input type=\"text\" class=\"form-control editField\" name=\"custName\" value=\"" + customerEntity.getCustomername() + "\" readonly> ");
									out.println("</td></tr>");
									out.println("<tr><th>First Name</th><td>");
									out.println("<input type=\"text\" class=\"form-control editField\" name=\"custFirstName\" value=\"" + customerEntity.getContactfirstname() + "\" readonly> ");
									out.println("</td></tr>");
									out.println("<tr><th>Last Name</th><td>");
									out.println("<input type=\"text\" class=\"form-control editField\" name=\"custLastName\" value=\"" + customerEntity.getContactlastname() + "\" readonly> ");
									out.println("</td></tr>");
									out.println("<tr><th>Phone Number</th><td>");
									out.println("<input type=\"text\" class=\"form-control editField\" name=\"custPhone\" value=\"" + customerEntity.getPhone() + "\" readonly> ");
									out.println("</td></tr>");
									out.println("<tr><th>Credit Limit</th><td>");
									out.println("<input type=\"text\" class=\"form-control editField\" name=\"custCreditLimit\" value=\"" + customerEntity.getCreditlimit() + "\" readonly> ");
									out.println("</td></tr>");
									out.println("</table>");
									
									//address information
									out.println("<hr><div><h3><strong><u>Address Details</u></strong></h3></div>");
									out.println("<table class='table' style='table-layout:fixed'>");
									out.println("<tr><th>Address Line 1</th><td>");
									out.println("<input type=\"text\" class=\"form-control editField\" name=\"custAddr1\" value=\"" + customerEntity.getAddressline1() + "\" readonly> ");
									out.println("</td></tr>");
									out.println("<tr><th>Address Line 2</th><td>");
									out.println("<input type=\"text\" class=\"form-control editField\" name=\"custAddr2\" value=\"" + customerEntity.getAddressline2() + "\" readonly> ");
									out.println("</td></tr>");
									out.println("<tr><th>Postal Code</th><td>");
									out.println("<input type=\"text\" class=\"form-control editField\" name=\"custPostal\" value=\"" + customerEntity.getPostalcode() + "\" readonly> ");
									out.println("</td></tr>");
									out.println("<tr><th>City</th><td>");
									out.println("<input type=\"text\" class=\"form-control editField\" name=\"custCity\" value=\"" + customerEntity.getCity() + "\" readonly> ");
									out.println("</td></tr>");
									out.println("<tr><th>State</th><td>");
									out.println("<input type=\"text\" class=\"form-control editField\" name=\"custState\" value=\"" + customerEntity.getState() + "\" readonly> ");
									out.println("</td></tr>");
									out.println("<tr><th>Country</th><td>");
									out.println("<input type=\"text\" class=\"form-control editField\" name=\"custCountry\" value=\"" + customerEntity.getCountry() + "\" readonly> ");
									out.println("</td></tr>");
									out.println("</table><hr>");
	
									//submit button
									out.println("<input type=\"hidden\" name=\"custNum\" value=\"" + customerEntity.getCustomernumber() + "\">");
									out.println("<button style='margin-left:1000px; display:none' type=\"submit\" class=\"btn btn-default submitBtn buttondesign\">Submit</button>");
									out.println("</form>");

								} catch (Exception e) {

								}
				%>
				<%@ page import="domain.EmployeeEntity"%>
				<%
					//IF ROLE IS EMPLOYEE
							} else if (c.getValue().equals("emp")) {

								try {
									
									EmployeeEntity employeeEntity = (EmployeeEntity) session.getAttribute("EMPLOYEE_ENTITY");

									out.println("<form action=\"ProfileController\" method=\"post\">");
									out.println("<hr><div><h3><strong><u>Personal Details</u></strong></h3></div>");
									out.println("<table class='table' style='table-layout:fixed'>");
									out.println("<tr><th>Employee Number</th><td>");
									out.println(employeeEntity.getEmployeenumber());
									out.println("</td></tr>");
									out.println("<tr><th>First Name</th><td>");
									out.println("<input type=\"text\" class=\"form-control editField\" name=\"empFirstName\" value=\"" + employeeEntity.getFirstname() + "\" readonly> ");
									out.println("</td></tr>");
									out.println("<tr><th>Last Name</th><td>");
									out.println("<input type=\"text\" class=\"form-control editField\" name=\"empLastName\" value=\"" + employeeEntity.getLastname() + "\" readonly> ");
									out.println("</td></tr>");
									out.println("<tr><th>Email</th><td>");
									out.println("<input type=\"text\" class=\"form-control editField\" name=\"empEmail\" value=\"" + employeeEntity.getEmail() + "\" readonly> ");
									out.println("</td></tr>");
									out.println("</table><hr>");
											
									out.println("<input type=\"hidden\" name=\"empNum\" value=\"" + employeeEntity.getEmployeenumber() + "\">");
									out.println("<button style='margin-left:1000px; display:none' type=\"submit\" class=\"btn btn-default submitBtn buttondesignemp\">Submit</button>");
									out.println("</form>");

								} catch (Exception e) {
								
								}
							}
						}
					}
				%>
			</div>
		</div>
	</div>
	<jsp:include page="includes/Footer.jsp" />
	<script>
	$(document).ready(function () {
	    $('.editBtn').click(function () {
		    //if edit button is turned on
	        if ($('.editField').is('[readonly]')) {
	            $('.editField').prop('readonly', false);
	            $('.editBtn').html('Edit On');
	            $('.editBtn').css("background", "green"); 
	            $('.submitBtn').css("display", "block");
	        } else { 
		        //if edit button is turned off
	            $('.editField').prop('readonly', true);
	            $('.editBtn').html('Edit Off');
	            $('.editBtn').css("background", "#df4759");
	            $('.submitBtn').css("display", "none");
	        }
	    });

	});
	</script>
</body>
</html>