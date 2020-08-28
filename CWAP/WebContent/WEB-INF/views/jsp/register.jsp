<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<div class="row">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 align="center">Registration</h3>
				<br>
				<h6 align="center" style="color: red;">${errorMsg}</h6>
			</div>

			<div class="panel-body">
				<form:form Class="form-horizontal" action="doregister"
					commandName="user" method="post" autocomplete="off">
					<fieldset>
						<div class="form-group">
							<label class="control-label col-sm-4" for="name">Name:</label>
							<div class="col-sm-4">
								<form:input placeholder="Name" class="form-control" path="name"
									id="name" type="text" autofocus="autofocus"
									pattern="[a-z A-z]{1,}" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="email_id">Email:</label>
							<div class="col-sm-4">
								<form:input placeholder="Email ID" class="form-control"
									id="email_id" path="email_id" type="email" required="required"
									pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="password">Password:</label>
							<div class="col-sm-4">
								<form:input placeholder="Password" class="form-control"
									onmouseover="getRule();" onmouseout="getRuleOut();"
									path="password" id="password" type="password"
									pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
									required="required"
									title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" />
								<small style="display: none;" id="rule"
									class="text-danger card card-body">Must contain at
									least one number and one uppercase and lowercase letter, and at
									least 8 or more characters</small>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="confirmPass">Confirm
								Password:</label>
							<div class="col-sm-4">
								<input placeholder="Confirm Password" class="form-control"
									name="confirmPass" id="confirmPass" type="password"
									required="required" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="mobile_no">Mobile:</label>
							<div class="col-sm-4">
								<form:input placeholder="10 digit Mobile No."
									class="form-control" path="mobile_no" id="mobile_no"
									type="text" required="required" pattern="[0-9]{10}"
									maxlength="10" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="type_of_user">Type
								of user: </label>
							<div class="col-sm-4">
								<form:select class="form-control" path="type_of_user"
									id="type_of_user">
									<form:option value="attendee">Attendee</form:option>
									<%-- <form:option value="organizer">Organizer</form:option> --%>
								</form:select>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-8">
								<form:button type="Submit" class="btn btn-primary" id="submit">Register</form:button>
							</div>
						</div>

					</fieldset>

				</form:form>
			</div>
		</div>

	</div>
</body>
<script type="text/javascript">
	function getRule() {
		$('#rule').show();
	}

	function getRuleOut() {
		$('#rule').hide();
	}
</script>
</html>
