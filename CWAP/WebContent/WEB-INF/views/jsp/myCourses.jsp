<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-12">

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="text-center">My Courses</h3>
				</div>
				<div class="panel-body">
					<c:forEach var="course" items="${myCourses}">
						<%-- <c:if test="${course.is_archived == false}"> --%>
						<div class="col-xs-3 img-thumbnail" style="height: 390px;">
							<h3 class="text-center">
								<img
									src='<c:url value = "/resources/images/${course.banner_path}"/>'
									class="img-responsive img-thumbnail" style="width: 100%"
									alt="Image"> ${course.course_name}
							</h3>

							<h4>
								<b>${course.start_date} to ${course.end_date}</b>
							</h4>
							<div align="justify">
								<p>${course.tagline}</p>
							</div>
							<pre>${course.description}</pre>

							<div class="col-sm-6">
								<a href="course?selectedCourse=${course.course_id}">Details</a>
							</div>

						</div>
						<%-- </c:if> --%>
					</c:forEach>


					<%-- 				<table class="table table-bordered table-hover">
					<thead class="thead-dark">
						<tr>
							<th scope="col">#</th>
							<th scope="col">Course ID</th>
							<th scope="col">Course Name</th>
							<th scope="col">Details</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Map<String, Object>> courseSummary = (List<Map<String, Object>>) request.getAttribute("courseSummary");
							for (int i = 0; i < courseSummary.size(); i++) {
								Map<String, Object> row = (Map<String, Object>) courseSummary.get(i);
						%>
						<tr>
							<th scope="row"><%=row.get("s_no")%></th>
							<td><%=row.get("course_id")%></td>
							<td><%=row.get("course_name")%></td>
							<%
								session.setAttribute("courseId", row.get("course_id"));
							%>
							<td><a href="getCourseDetails?courseId=<%=(int)row.get("course_id")%>">Click
									Here</a></td>
						</tr>
						<%
							}
						%>
					</tbody>
					<!-- <tfoot>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tfoot> -->
				</table> --%>
				</div>
			</div>



		</div>
	</div>
</div>
