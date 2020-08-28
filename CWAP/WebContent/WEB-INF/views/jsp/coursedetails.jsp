<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Program Details</title>
</head>
<body>
	<%-- <c:forEach items="${courseDetails}" var="course">
		<h1>${course.course_name}</h1>
	</c:forEach> --%>
	<div class="row">
		<div class="col-sm-12">
			<h5 align="center" style="color: green;">${successMsg}</h5>
			<h5 align="center" style="color: red;">${errorMsg}</h5>
			<div class="table-responsive">
				<table class="table table-bordered table-hover">
					<c:forEach items="${courseDetails}" var="course">

						<tr>
							<th scope="col"><strong>Course Id</strong></th>
							<td>${course.course_id}</td>
						</tr>
						<tr>
							<th scope="col"><strong>Course Name</strong></th>
							<td>${course.course_name}</td>
						</tr>
						<tr>
							<th scope="col"><strong>Subject</strong></th>
							<td>${course.subjectId}</td>
						</tr>
						<tr>
							<th scope="col"><strong>Tagline</strong></th>
							<td>${course.tagline}</td>
						</tr>
						<tr>
							<th scope="col"><strong>Description</strong></th>
							<td>${course.description}</td>
						</tr>
						<tr>
							<th scope="col"><strong>State Date</strong></th>
							<td>${course.start_date}</td>
						</tr>
						<tr>
							<th scope="col"><strong>End Date</strong></th>
							<td>${course.end_date}</td>
						</tr>
						<tr>
							<th scope="col"><strong>Registration Start Date</strong></th>
							<td>${course.reg_start_date}</td>
						</tr>
						<tr>
							<th scope="col"><strong>Registration End Date</strong></th>
							<td>${course.reg_end_date}</td>
						</tr>

						<%-- <tr>
							<th scope="col">Banner Path</th>
							<td>${course.banner_path }</td>
						</tr> --%>

						<tr>
							<th scope="col">Creator</th>
							<td>${course.creator}</td>
						</tr>

					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-8">
			<a href="myCourses" class="btn btn-default">Back</a>
		</div>
	</div>

</body>
</html>