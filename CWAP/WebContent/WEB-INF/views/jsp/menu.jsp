<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<c:choose>
					<c:when test="${isLoggedIn != null}">
						<div class="col-sm-2 sidenav">
							<ul class="nav nav-pills nav-stacked">
								<c:if test="${Type_of_user=='attendee'}">
									<li><a href="">FAQs</a></li>
									<!-- <li><a href="#menu">Menu</a></li> -->
									<li><a href="profile">Profile</a></li>
									<li><a href="myCourses">My Courses</a></li>
									<li><a href="courses">Courses</a></li>
									<li><a href="archivedCourse">Archived Courses</a></li>
									<li><a href="contact">Contact Us</a></li>
								</c:if>

								<c:if test="${Type_of_user=='organizer'}">
									<li class=""><a href="#menu">Menu</a></li>
									<!-- <li><a href="profile">Profile</a></li> -->
									<li><a href="createCourse">Create Course</a></li>
									<li><a href="updateCourse">Update Course</a></li>
									<li><a href="createSubject">Create Subject</a></li>
									<li><a href="createCategory">Create Enrollment
											Category</a></li>
									<li><a href="createQualification">Create Qualification</a></li>
									<li><a href="analysisReport">Analysis Report</a></li>
									<li><a href="attendeeData">List Attendee data</a></li>
									<li><a href="updateAttendance">Update Attendance</a></li>
									<li><a href="courses">Courses</a></li>
									<li><a href="archivedCourse">Archived Courses</a></li>
									<li><a href="contact">Contact</a></li>
								</c:if>
								
							</ul>
						</div>
					</c:when>
					<c:otherwise>
						<div class="col-sm-2 sidenav">
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">FAQs</a></li>
								<li><a href="courses">Courses</a></li>
								<li><a href="contact">Contact</a></li>
							</ul>
						</div>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>
</body>
</html>