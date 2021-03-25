<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ransom Vehicle Store - Place to Get Cool Vehicles</title>
</head>
<body>
	<jsp:include page="includes/HeaderCustomer.jsp" />
	
	<div class="container">
		<div class="jumbotron">
			<h2>
				Hi,
				<%
				Cookie[] cookies = request.getCookies();
				//show username
				for (int i = 0; i < cookies.length; i++) {
					Cookie c = cookies[i];
					if (c.getName().equals("username")) {
						out.println(c.getValue());
					}
				}
			%>
			</h2>
			<div>Welcome to Ransom Vehicle Store! Please take your time to
				start searching for your dream vehicle.</div>
			<p>
				<a style="width: 300px;" class="btn btn-primary btn-lg buttondesign"
					href="ViewProductInfo" role="button">Search Vehicles</a>&nbsp <a
					style="width: 300px;" class="btn btn-primary btn-lg buttondesign"
					href="addOrder.jsp" role="button">Place Order</a>&nbsp <a
					style="width: 300px;" class="btn btn-primary btn-lg buttondesign"
					href="paymentCheckout.jsp" role="button">Make Payment</a>
			</p>
			<hr>
			<div>Track your previous order and payments. Modify your
				profile.</div>
			<p>
				<a style="width: 300px;" class="btn btn-primary btn-lg buttondesign"
					href="GetCustomerOrder" role="button">View Order</a>&nbsp <a
					style="width: 300px;" class="btn btn-primary btn-lg buttondesign"
					href="GetCustomerPayment" role="button">View Payment</a>&nbsp <a
					style="width: 300px;" class="btn btn-primary btn-lg buttondesign"
					href="ProfileController" role="button">Modify Profile</a>
			</p>
		</div>
	</div>
	<jsp:include page="includes/Footer.jsp" />

	
</body>
</html>