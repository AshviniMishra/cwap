<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h5 align="center" style="color: green;">${successMsg}</h5>
			<h5 align="center" style="color: red;">${errorMsg}</h5>
			<h3 class="text-center">Upcoming Courses</h3>
		</div>
	</div>

	<div id="div" class="row panel-body">
		<c:choose>
			<c:when test="${display_archived eq false}">
				<div>
					<c:forEach var="course" items="${courses}">
						<%-- <c:if test="${course.is_archived == false}"> --%>
						<div class="col-xs-3 img-thumbnail img-responsive"
							style="height: 380px" id="courseJs">
							<h3>
								<a href="course?selectedCourse=${course.course_id}"> <img
									src='<c:url value = "/resources/images/${course.banner_path}"/>'
									class="img-responsive img-thumbnail" style="width: 100%"
									alt="Image"> ${course.course_name}
								</a>
							</h3>
							<h4>
								<b>${course.start_date} to ${course.end_date}</b>
							</h4>
							<div align="justify">
								<p>${course.tagline}</p>
							</div>
							<pre>${course.description}</pre>

							<c:if test="${Type_of_user=='attendee'}">
								<div class="col-sm-6">
									<a href="enroll?selectedCourse=${course.course_id }">Enroll</a>
								</div>
							</c:if>

							<div class="col-sm-6">
								<a href="course?selectedCourse=${course.course_id}">Details</a>
							</div>

							<c:if test="${isLoggedIn != null }">
								<c:if test="${Type_of_user ne 'attendee'}">
									<div class="col-sm-6">
										<a href="archive?courseId=${course.course_id }"
											onclick="archiveCourse();">Archive Course</a>
									</div>
								</c:if>
							</c:if>

						</div>
						<%-- </c:if> --%>
					</c:forEach>
				</div>
			</c:when>

			<c:when test="${display_archived eq true }">

				<div class="row jumbotron">
					<h3 class="text-center">Archived Courses</h3>
					<c:forEach var="course" items="${courses }">
						<%-- <c:if test="${course.is_archived eq true}"> --%>
						<div
							class="col-lg-3 col-md-4 col-xs-6 img-thumbnail img-responsive"
							style="height: 420px">
							<h3>
								<a href="course?selectedCourse=${course.course_id}"> <img
									src='<c:url value = "/resources/images/${course.banner_path}"/>'
									class="img-responsive img-thumbnail" style="width: 100%"
									alt="Image"> ${course.course_name}
								</a>
							</h3>

							<h4>
								<b>${course.start_date} to ${course.end_date}</b>
							</h4>
							<div align="justify">
								<p>${course.tagline}</p>
							</div>
							<pre>${course.description}</pre>

							<%-- <c:if test="${Type_of_user=='attendee'}">
								<div class="col-sm-6">
									<a href="enroll">Enroll</a>
								</div>
							</c:if> --%>

							<div class="col-sm-12">
								<a href="course?selectedCourse=${course.course_id}">Details</a>
							</div>

							<%-- <c:if test="${Type_of_user ne 'attendee' }">
								<div class="col-sm-6">
									<a href="archive?courseId=${course.course_id }">Archive
										Course</a>
								</div>
							</c:if> --%>

						</div>

						<%-- </c:if> --%>
					</c:forEach>
				</div>
			</c:when>

		</c:choose>
	</div>
</body>
<script>
	function archiveCourse() {
		alert("fucntion called");
		$('#courseJs').hide();
	}
</script>
</html>