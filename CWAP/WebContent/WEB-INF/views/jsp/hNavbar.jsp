<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<div class="row rounded">
	<div class="navbar navbar-default navnew navbar-static-top">
		<div class="container-fluid rounded" style="background: #dfe8e1;"
			id="myNavbar">
			<div class="col-sm-4">
				<c:if test="${isLoggedIn != null}">
					<h3 class="text-left">Welcome ${sessionScope.firstName}</h3>
				</c:if>
			</div>
			<div class="col-sm-8">
				<c:choose>
					<c:when test="${isLoggedIn != null}">
						<ul class="nav navbar-nav navbar-right">
							<li><a class="navnew" href="logout"><span
									class="glyphicon glyphicon-log-out"></span>Logout</a></li>
						</ul>
					</c:when>

					<c:otherwise>
						<ul class="nav navbar-nav navbar-right">
							<li><a class="navnew" href="home"><span
									class="glyphicon glyphicon-home"></span>Home</a></li>
							<li><a class="navnew" href="login"><span
									class="glyphicon glyphicon-log-in"></span>Login</a></li>
							<li><a class="navnew" href="register"><span
									class="glyphicon glyphicon-user"></span>Register</a></li>
						</ul>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>