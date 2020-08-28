<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>

<body>
	<c:if test="${sessionScope.Type_of_user=='attendee'}">
		<h1 align="center">Enrollment</h1>

		<br>
		<h6 align="center" style="color: red;">${errorMsg}</h6>

		<c:choose>

			<c:when test="${alreadyEnrolled eq true }">
				<h3 class="text-warning">You have already registered for this
					course</h3>
			</c:when>

			<c:otherwise>
				<form Class="form-horizontal" action="saveEnrollment" method="post"
					autocomplete="off">
					<fieldset>

						<div class="form-group">

							<label class="control-label col-sm-4" for="name">Enrollment
								Category:</label>
							<div class="col-sm-4">
								<select class="form-control" name="category" id="category"
									required title="Select Category">
									<c:forEach items="${categories}" var="category">
										<option value="${category.id}">${category.name}</option>
									</c:forEach>
								</select> <small class="text-right text-secondary"><i>Course
										fee :${fees}</i> </small>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="laptop">Will
								you bring laptop? </label>
							<div class="col-sm-4">
								<input type="radio" name="laptop" value=true> Yes<br>
								<input type="radio" name="laptop" value=false> No<br>

							</div>

						</div>

						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-8">
								<button type="Submit" class="btn btn-primary" id="submit">Proceed
									for Payment</button>
							</div>
						</div>

					</fieldset>
				</form>
			</c:otherwise>
		</c:choose>
	</c:if>

</body>

</html>