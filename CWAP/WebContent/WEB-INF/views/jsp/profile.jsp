<%@ page import="java.util.HashMap"%>
<%@ page import="com.cdac.model.AdminInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
</head>
<body>
	<div class="row">
		<c:choose>
			<c:when test="${isLoggedIn != null}">

				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 align="center">Profile</h3>
						<h5 align="center" style="color: green;">${successMsg}</h5>
						<h5 align="center" style="color: red;">${errorMsg}</h5>
					</div>

					<div class="panel-body">
						<c:if test="${Type_of_user=='attendee'}">
							<div class="table-responsive col-sm-12">
								<table class="table table-bordered table-striped">

									<tr>
										<th scope="col"><strong>Username:</strong></th>
										<td>${profile.username}</td>
									</tr>
									<tr>
										<th scope="col"><strong>Gender:</strong></th>
										<td>${profile.gender}</td>
									</tr>
									<tr>
										<th scope="col"><strong>Address:</strong></th>
										<td>${profile.address}</td>
									</tr>
									<tr>
										<th scope="col"><strong>Hobbies:</strong></th>
										<td>${profile.hobbies}</td>
									</tr>
									<tr>
										<th scope="col"><strong>Skills:</strong></th>
										<td>${profile.skills}</td>
									</tr>
									<tr>
										<th scope="col"><strong>Specialization:</strong></th>
										<td>${profile.specialization}</td>
									</tr>
									<tr>
										<th scope="col"><strong>Qualification:</strong></th>
										<td><c:forEach var="qualification" items="${quals}">
												<c:if test="${qualification.id==profile.qualId}">${qualification.name}</c:if>
											</c:forEach></td>
									</tr>
									<tr>
										<th scope="col"><strong>Organization:</strong></th>
										<td>${profile.organization}</td>
									</tr>
									<tr>
										<th scope="col"><strong>Designation:</strong></th>
										<td>${profile.designation}</td>
									</tr>
								</table>
								<a href="editProfile" class="btn btn-primary"> <span
									class="glyphicon glyphicon-edit"></span> Edit
								</a>
							</div>

						</c:if>

						<c:if test="${Type_of_user ne 'attendee' }">
							<%
								AdminInfo adminfo = (AdminInfo) session.getAttribute("adminfo");
											HashMap<String, Object> mp = (HashMap<String, Object>) adminfo.getInfo();
							%>
							<table class="table table-bordered table-hover">
								<tr>
									<th>Total Registration :-</th>
									<td><%=mp.get("reg_no")%></td>

									<th>Total Enrollments :-</th>
									<td><%=mp.get("enrol")%></td>
								</tr>

								<tr>
									<th>Total Payment Attempts :-</th>
									<td>0</td>

									<th>Total Successful Payments :-</th>
									<td>0</td>
								</tr>
							</table>
						</c:if>
					</div>
				</div>

			</c:when>
		</c:choose>
	</div>
</body>
</html>
