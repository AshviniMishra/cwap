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
	<div class="container-fluid text-center">

		<div class="col-sm-10">
			<h1>${course.course_name}</h1>
			<div align="center" class="shadow p-3 mb-5 bg-white rounded">
				<img src="<c:url value="/resources/images/${course.banner_path}"/>"
					class="img-responsive img-thumbnail" style="width: 50%"
					align="middle" alt="Image">
			</div>
			<h3>
				<b>${course.start_date} to ${course.end_date}</b>
			</h3>
			<h4>
				<p class="text-info">${course.tagline}</p>
			</h4>
			<div align="justify">
				<c:forEach var="para" items="${description}">
					<p>${para}</p>
				</c:forEach>
			</div>
			<c:if test="${sessionScope.Type_of_user=='attendee'}">
				<%-- <c:if test="${course.is_archived eq false }"> --%>
				<c:if test="${alreadyEnrolled ne true }">
						<a href="enroll?selectedCourse=${course.course_id}"
							class="btn btn-info">Enroll for the Course</a>
					</c:if>
			<%-- 	</c:if> --%>
				<!-- <a href="payment" class="btn btn-info">Proceed for Payment</a> -->
			</c:if>
		</div>
	</div>
	<br>
</body>
</html>