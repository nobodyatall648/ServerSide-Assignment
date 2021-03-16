<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ransom Vehicle Store - Place to Get Cool Vehicles</title>
</head>
<body>
	<jsp:include page="includes/HeaderCustomer.jsp" />
	<%
		//get success checkout parameter from checkout page
		try {
			if (request.getParameter("success") == null) {

			} else {
				out.println(
						"<div id='success_payment' class='alert alert-success alert-dismissible' role='alert'>");
				out.println(
						"<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button>");
				out.println("Successfully performed checkout!</div>");

			}
		} catch (Exception e) {

		}
	%>
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
					href="ViewProductInfo.jsp" role="button">Search Vehicles</a>&nbsp <a
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

	<script>
		//timeout for success checkout
		window.setTimeout(function() {
			$("#success_payment").fadeTo(300, 0).slideUp(500, function() {
				$(this).remove();
			});
		}, 3000);
	</script>
</body>
</html>