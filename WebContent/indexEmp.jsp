<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management Portal</title>
</head>
<body>
	<jsp:include page="includes/HeaderEmployee.jsp" />
	<div class="container">
		<div class="jumbotron">
		
			<h2>Hi, 
			<%
				Cookie[] cookies = request.getCookies();
				//show username
				for (int i = 0; i < cookies.length; i++) {
					Cookie c = cookies[i];
					if (c.getName().equals("username")) {
						out.println(c.getValue());
					}
				}
			%></h2>
			<div>This is the Employee Management Portal. Manage your customers and their orders.</div>
			<p>
				<a style="width:300px;" class="btn btn-primary btn-lg buttondesign" href="employeeViewCustomerOrder.jsp" role="button">View Customer Order</a>&nbsp
				<a style="width:300px;" class="btn btn-primary btn-lg buttondesign" href="GetUnassignedSRCust" role="button">Customer Handling & Assigning</a>&nbsp
				<a style="width:300px;" class="btn btn-primary btn-lg buttondesign" href="UpdateCustOrderStatus.jsp" role="button">Update Customer Order Status</a>
			</p><hr>	
			<div>Manage your vehicles. View your customer's payments.</div>
			<p>
				<a style="width:300px;" class="btn btn-primary btn-lg buttondesign" href="#" role="button">Manage Vehicles</a>
				<a style="width:300px;" class="btn btn-primary btn-lg buttondesign" href="employeeViewCustomerPayment.jsp" role="button">View Customer Payment</a>
			</p>	
		</div>
	</div>
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>