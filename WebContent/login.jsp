<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
</head>

<body>
	<jsp:include page="includes/HeaderCustomer.jsp" />
	<div class="container">
		<h1 style="text-align: center;">Ransom Vehicle Store</h1>
		<div class="login-form ">
			<form action="LoginController" method="post">
				<h2 class="text-center">Log in to your account</h2>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Username"
						name="name" required="required">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="Password"
						name="pass" required="required">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block loginbtn">Log
						in</button>
				</div>
				<div class="clearfix">
					<div class="text-center">
						<a href="#">Create an Account</a>
					</div>
				</div>
			</form>

		</div>
		<br> <br>
	</div>
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>