<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"
	rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js"
	type="text/javascript"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"
	type="text/javascript"></script>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="Stylesheet" type="text/css" />

<script type="text/javascript">
	var i = 1;

	function addCategory() {
		var divs = document.createElement("div");
		divs.setAttribute("class", "col-sm-offset-4 col-sm-3");
		divs.setAttribute("id", "divs_" + ++i);
		var divi = document.createElement("div");
		divi.setAttribute("class", "col-sm-3");
		divi.setAttribute("id", "divi_" + i);
		document.getElementById("container").appendChild(divs);
		document.getElementById("container").appendChild(divi);
		/* var select= document.createElement("select");
		select.setAttribute("class","form-control");
		select.setAttribute("name","category_"+ i);
		select.setAttribute("title","Select Category");
		select.setAttribute("
		required");
		divs.appendChild(select); */
		divs.innerHTML = "<select class='form-control' name='category_" + i + "' required title='Select Category' id='select"+i+"'>"
				+ "<c:forEach var='category' items='${categories}'>"
				+ "	<option value='${category.id}' label='${category.name}' title='${category.description}'>${category.name}</option>"
				+ "</c:forEach>" + "</select>";
		divi.innerHTML = "<input class='form-control' id='fees' name='fees_" + i + "' type='text' placeholder='Fees' required/>"

	}

	function savei() {
		document.getElementById("CategoryNumber").value = i;
	}

	$(function() {
		$("#start_date").datepicker({
			dateFormat : 'yy-mm-dd',
			numberOfMonths : 1,
			minDate : +1,
			onSelect : function(selected) {
				var dt = new Date(selected);
				dt.setDate(dt.getDate() + 1);
				$("#end_date").datepicker("option", "minDate", dt);
			}
		});
		$("#end_date").datepicker({
			dateFormat : 'yy-mm-dd',
			numberOfMonths : 1,
			minDate : +1,
			onSelect : function(selected) {
				var dt = new Date(selected);
				dt.setDate(dt.getDate() - 1);
				$("#start_date").datepicker("option", "maxDate", dt);
			}
		});
	});

	$(function() {
		$("#reg_start_date").datepicker({
			dateFormat : 'yy-mm-dd',
			numberOfMonths : 1,
			minDate : +1,
			onSelect : function(selected) {
				var dt = new Date(selected);
				dt.setDate(dt.getDate() + 1);
				$("#reg_end_date").datepicker("option", "minDate", dt);
			}
		});
		$("#reg_end_date").datepicker({
			dateFormat : 'yy-mm-dd',
			numberOfMonths : 1,
			minDate : +1,
			onSelect : function(selected) {
				var dt = new Date(selected);
				dt.setDate(dt.getDate() - 1);
				$("#reg_start_date").datepicker("option", "maxDate", dt);
			}
		});
	});
</script>
<body>
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h1 align="center">Create Course</h1>
				<br>
				<h5 align="center" style="color: green;">${successMsg}</h5>
				<h5 align="center" style="color: red;">${errorMsg}</h5>
			</div>

			<div class="panel-body">
				<c:if test="${sessionScope.Type_of_user=='organizer'}">
					<form:form Class="form-horizontal" action="saveCourse"
						method="post" commandName="course" autocomplete="off"
						enctype="multipart/form-data">
						<fieldset>

							<div class="form-group">
								<label class="control-label col-sm-4" for="course_name">Course
									Name: </label>
								<div class="col-sm-6">
									<form:input placeholder="Course Name" class="form-control"
										id="course_name" path="course_name" type="text"
										required="required" autofocus="autofocus" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="subjectId">Prerequisite:</label>
								<div class="col-sm-6">
									<form:select class="form-control" path="subjectId"
										required="required">
										<c:forEach var="subject" items="${subjects}">
											<form:option value="${subject.id}" label="${subject.name}">${subject.name}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="tagline">
									Tagline: </label>
								<div class="col-sm-6">
									<form:textarea placeholder="Tagline" class="form-control"
										id="tagline" path="tagline"></form:textarea>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="description">
									Description: </label>
								<div class="col-sm-6">
									<form:textarea placeholder="Description" class="form-control"
										path="description"></form:textarea>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="start_date">
									Start Date: </label>
								<div class="col-sm-6">
									<input placeholder="Start Date" class="form-control"
										id="start_date" name="start_date" type="text" required />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="end_date">
									End Date: </label>
								<div class="col-sm-6">
									<input placeholder="End Date" class="form-control"
										id="end_date" name="end_date" type="text" required />
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-sm-4" for="reg_start_date">
									Registration Start Date: </label>
								<div class="col-sm-6">
									<input placeholder="Registration Start Date"
										class="form-control" id="reg_start_date" name="reg_start_date"
										type="text" required />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="reg_end_date">
									Registration End Date: </label>
								<div class="col-sm-6">
									<input placeholder="Registration End Date" class="form-control"
										id="reg_end_date" name="reg_end_date" type="text" required />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="image">
									Upload Image: </label>
								<div class="col-sm-6">
									<input placeholder="Upload Image" class="form-control"
										id="image" name="image" type="file" accept=".png, .jpg, .jpeg" />
								</div>
							</div>

							<div class="form-group" id="container">
								<label class="control-label col-sm-4" for="category">Enrollment
									Category:</label>
								<div class="col-sm-3">
									<select class="form-control" name="category_1"
										required="required" title="Select Category">
										<c:forEach var="category" items="${categories}">
											<option value="${category.id}" label="${category.name}"
												title="${category.description}">${category.name}</option>
										</c:forEach>
									</select>
								</div>

								<div class="col-sm-3">
									<input class="form-control" id="fees" name="fees_1" type="text"
										placeholder="Fees" required="required" />
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<button type="button" class="btn btn-default btn-sm"
										onclick="addCategory()">
										<span class="glyphicon glyphicon-plus"></span> Add Category
									</button>
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<button type="Submit" class="btn btn-primary" onclick="savei()">Create</button>
								</div>
							</div>
							<input id="CategoryNumber" name="CategoryNumber" type="hidden">
							<br>
						</fieldset>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>