<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html class="no-js">

<head>

<meta charset="utf-8">
<title>Employee Portal</title>

<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800"
	rel="stylesheet">

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/normalize.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/templatemo-misc.css">
<link rel="stylesheet" href="css/style.css">

<script src="js/vendor/modernizr-2.6.2.min.js"></script>

</head>
<body>
<%
		//check for authorization
		String roleAuth = "emp";
		Cookie[] cookies = request.getCookies();

		//check cookie empty or exist
		if(cookies.length == 1){
			out.println("<script type=\"text/javascript\">");
			out.println("alert('You are not authorized to view the page.');");
			out.println("location='login.jsp';");
			out.println("</script>");
		}else if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if (c.getName().equals("role")) {
					if (!c.getValue().equals(roleAuth)) {						
						//pop up alert unauthorized location & remove cookies
						out.println("<script type=\"text/javascript\">");						
						out.println("alert('You are not authorized to view the page.');");
						out.println("location='Logout';");
						out.println("</script>");
					}
				}
			}
		}else{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('You are not authorized to view the page.');");
			out.println("location='login.jsp';");
			out.println("</script>");
		}
	%>
	<header class="site-header">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="indexEmp.jsp">Ransom Vehicle Store</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
					<li><a href="indexEmp.jsp">Home</a></li>
<!-- 					<li><a href="#">Manage Vehicle</a></li> -->
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Customer Order <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="employeeViewCustomerOrder.jsp">View
										Customer Order</a></li>
								<li><a href="GetUnassignedSRCust">Customer Handling & Assigning</a></li>
								<li><a href="UpdateCustOrderStatus.jsp">Update Customer
										Order Status</a></li>
							</ul></li>
						<li><a href="employeeViewCustomerPayment.jsp">Customer Payment</a></li>
					</ul>


					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">
							<%
						 	//show username
						 	for (int i = 0; i < cookies.length; i++) {
						 		Cookie c = cookies[i];
						 		if (c.getName().equals("username")) {
						 			out.println("<div>"+ c.getValue() + "</div>");
						 		}
						 	}
					 		%> </a>
							<ul class="dropdown-menu">
								<li><a href="ProfileController">View Profile</a></li>
								<li><a href="Logout">Logout</a></li>
							</ul></li>
						
					</ul>
					<!--  
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Sign Up</a></li>
						<li><a href="login.jsp">Log In</a></li>
					</ul>-->
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</header>
	<!-- /.site-header -->

	<script src="js/vendor/jquery-1.10.1.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/vendor/jquery-1.10.1.min.js"><\/script>')
	</script>
	<script src="js/jquery.easing-1.3.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>
	
	
	
</body>
</html>