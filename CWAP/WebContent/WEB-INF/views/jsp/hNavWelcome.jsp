<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<div>
	<c:if test="${isLoggedIn != null}">
		<h3 class="text-left">Welcome ${sessionScope.firstName}</h3>
	</c:if>
</div>