<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Management</title>
<style>
.form-container .btn:hover, .open-button:hover {
	opacity: 1;
}
.form-popup {
	overflow-x: hidden;
	overflow-y: auto;
	height: 400px;
	display: none;
	position: fixed;
	top: 60%;
	left: 50%;
	-webkit-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}

/* Add styles to the form container */
.form-container {
	max-width: 500px;
	padding: 10px;
	background-color: white;
}
.form-container .btn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	margin-bottom: 10px;
	opacity: 0.8;
}
</style>
</head>


<body>
<jsp:include page="includes/HeaderAdmin.jsp" />

<h1>Admin Section</h1>
<br>
<h1>Please refer database to include data</h1>
<form method="post" action="ViewEmployee">
  

  <div class="container">
  Please Enter Specific Employee Number to View their Detail for delete and update.
  <br>
  <br>
    <label for="uname"><b>Employee Number</b></label>
    <input type="text" placeholder="EmployeeNumber" name="employeenum" required>
    
    <button type="submit">Submit</button>
  </div>

</form>
<br>
<br>
<br>

		<h1>To add Employee Please follow the Instruction</h1>
		
	<div class="form-popup" id="myForm">
		<form action="admincontroller" class="form-container" method="post">
			<h1>Add Employee</h1>
			<fieldset>
				<legend>Add Employee Details:</legend>
				<br> Employee Number <input type="text" name="id" /> <br> First Name:
				<input type="text" name="fname" /> <br> Last Name: <input
					type="text" name="lname" /> <br>Email : <input type="text"
					name="email" /> <br> Office Code: <input type="text" name="officecode" />
				<br> Report: <input type="text" name="report" />
				<br> Job: <input type="text" name="job" />

			</fieldset>

			<button type="submit" >Submit</button>
			<button type="button" >Close</button>
			<button type="reset" >Reset</button>
		</form>
	</div>
	

<jsp:include page="includes/Footer.jsp" />
</body>
</html>