
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">

<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<style>
body, html {
	height: 100%;
	margin: 0;
}

.bg {
	/* background-image:
		url("${pageContext.request.contextPath}/resources/images/c1.jpeg"); */
	/* background-color: #e0e0d1; */
	height: 100%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	height: 100%;
}
</style>

<body class="bg">

	<div class="container">
		<!-- header -->
		<div class="container-fluid">
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="hNavbar" />
			<%-- <tiles:insertAttribute name="hNavWelcome" /> --%>
		</div>


		<!-- BODY -->
		<div class="container-fluid">
			<div class="col-sm-3 sidepane">
				<tiles:insertAttribute name="menu" />
			</div>
			<div class="col-sm-9">
				<tiles:insertAttribute name="body" />
			</div>
		</div>

		<!-- Footer -->
		<div class="container-fluid">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>
</body>
</html>
