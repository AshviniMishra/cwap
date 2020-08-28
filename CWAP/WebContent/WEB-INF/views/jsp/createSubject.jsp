<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 align="center">Create Subject</h3>
				<br>
				<h5 align="center" style="color: green;">${successMsg}</h5>
				<h5 align="center" style="color: red;">${errorMsg}</h5>
			</div>
			<div class="panel-body">
				<c:if test="${sessionScope.Type_of_user=='organizer'}">
					<form Class="form-horizontal" action="saveSubject" method="post"
						autocomplete="off">
						<fieldset>
							<div class="form-group">

								<label class="control-label col-sm-4" for="name">Subject
									Name: </label>
								<div class="col-sm-4">
									<input placeholder="Subject Name" class="form-control"
										id="name" name="name" type="text" required autofocus />
								</div>
							</div>

							<div class="form-group">

								<label class="control-label col-sm-4" for="description">Subject
									Description: </label>
								<div style="height: auto;" class="col-sm-4">
									<input placeholder="Subject Description" class="form-control"
										name="description" type="text" />
								</div>

							</div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<button type="Submit" class="btn btn-primary">Create</button>
								</div>
							</div>
							<br>

						</fieldset>
					</form>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>