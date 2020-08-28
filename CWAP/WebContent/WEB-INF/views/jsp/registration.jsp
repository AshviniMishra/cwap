<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Registration</title>
</head>
<body>

	<h1 align="center">Registration</h1>

	<br>
	<h6 align="center" style="color: red;">${errorMsg}</h6>

	<form Class="form-horizontal" action="register" method="post"
		autocomplete="off">
		<fieldset>

			<div class="form-group">

				<label class="control-label col-sm-4" for="name">Name:</label>
				<div class="col-sm-4">
					<input placeholder="Name" class="form-control" name="name"
						id="name" type="text" autofocus pattern="[a-z A-z]{1,}" />
				</div>
			</div>

			<div class="form-group">


				<label class="control-label col-sm-4" for="email_id">Email:</label>
				<div class="col-sm-4">
					<input placeholder="Email ID" class="form-control" id="email_id"
						name="email_id" type="email" required
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" />
				</div>

			</div>

			<div class="form-group">

				<label class="control-label col-sm-4" for="password">Password:</label>
				<div class="col-sm-4">
					<input placeholder="Password" class="form-control" name="password"
						id="password" type="password" value="" required />
				</div>
			</div>
			<div class="form-group">

				<label class="control-label col-sm-4" for="confirmPass">Confirm
					Password:</label>
				<div class="col-sm-4">
					<input placeholder="Confirm Password" class="form-control"
						name="confirmPass" id="confirmPass" type="password" value=""
						required onblur="checkPass()" />
				</div>
			</div>
			<div class="form-group">

				<label class="control-label col-sm-4" for="mobile_no">Mobile:</label>
				<div class="col-sm-4">
					<input placeholder="10 digit Mobile No." class="form-control"
						name="mobile_no" id="mobile_no" type="text" required
						pattern="[0-9]{10}" />
				</div>
			</div>
			<div class="form-group">

				<label class="control-label col-sm-4" for="type_of_user">Type
					of user: </label>
				<div class="col-sm-4">
					<select class="form-control" name="type_of_user" id="type_of_user">
						<option value="attendee">Attendee</option>
						<option value="organizer">Organizer</option>
					</select>
				</div>

			</div>

			<!-- 	<span id="errormsg"></span> -->

			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-8">
					<button type="Submit" class="btn btn-default" id="submit">Register</button>
				</div>
			</div>

		</fieldset>


	</form>

	<!-- 
	<script >
	
	

	function checkPass() {
	$('#password').val('pass');
	$("#confirmPass").val('confirmpass');

	if (pass == confirmpass) {

	} else {
	$('#errormsg')
	.val('password must match with confirm password');

	}
	}
	</script> -->

</body>
</html>

