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
<%
Cookie[] cookies = request.getCookies();
if (cookies != null) {
 Cookie cookie;
 for (int i = 0; i < cookies.length; i++) {
 cookie = cookies[i];
 if (cookie.getName().equals("user")) {
 out.println("Welcome User" + "\n" + cookie.getValue());
 }
 }

 }
%>

<body>

<h1>Admin Section</h1>
<form method="post" action="ViewEmployee">
  

  <div class="container">
  Please Enter Specific Employee Number to View their Detail.
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

		<h1>TO add Employee Please follow the Instruction</h1>
		<button class="open-button" onclick="openForm()">ADD</button>
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

			<button type="submit" class="btn">Submit</button>
			<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
			<button type="reset" class="btn">Reset</button>
		</form>
	</div>
	<script>
		function openForm() {
			document.getElementById("myForm").style.display = "block";
		}

		function closeForm() {
			document.getElementById("myForm").style.display = "none";
		}
	</script>
	
	
	
	
	<h1>Office Section</h1>
<form method="post" action="OfficeController">
  

  <div class="container">
  Please Enter Specific Office Detail to add office.
  <br>
  <br>
    <label ><b>City</b></label>
    <input type="text" placeholder="City" name="city" required>
    <br>
    <label ><b>Phone</b></label>
    <input type="text" placeholder="phone" name="phone" required>
    <br>
    <label ><b>Address line 1</b></label>
    <input type="text" placeholder="address 1" name="add1" required>
    <br>
    <label ><b>Address line 2</b></label>
    <input type="text" placeholder="address 2" name="add2" required>
    <br>
    <label ><b>State</b></label>
    <input type="text" placeholder="State" name="state" required>
    <br>
    <label ><b>Country</b></label>
    <input type="text" placeholder="Country" name="country" required>
    <br>
    <label ><b>Postal Code</b></label>
    <input type="text" placeholder="Postal Code" name="pcode" required>
    <br>
    <label ><b>Territory</b></label>
    <input type="text" placeholder="Territory" name="territory" required>
    <br>
    <button type="submit">Submit</button>
  </div>

</form>

<br>
<br>
<h1>Office Updating and Deleting</h1>
<form method="get" action="OfficeController">
  

  <div class="container">
  Please Enter Office Code to view Detail.
  <br>
  <br>
    <label for="uname"><b>Office Code</b></label>
    <input type="text" placeholder="Office Code" name="ocode" required>
    
    <button type="submit">Submit</button>
  </div>

</form>
<br>
	


</body>
</html>