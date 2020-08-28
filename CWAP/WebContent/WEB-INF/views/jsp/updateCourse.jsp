<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="panel panel-default">

		<div class="panel-heading">
			<h1 align="center">Update Course</h1>
			<br>
			<h5 align="center" style="color: green;">${successMsg}</h5>
			<h5 align="center" style="color: red;">${errorMsg}</h5>
		</div>
		<c:if test="${sessionScope.Type_of_user=='organizer'}">
			<div class="panel-body">
				<form Class="form-horizontal" action="updateCourse" method="post"
					autocomplete="off" enctype="multipart/form-data">
					<fieldset>

						<div class="form-group">
							<label class="control-label col-sm-4" for="course_name">Course
								Name: </label>
							<div class="col-sm-6">
								<!-- <input placeholder="Course Name" class="form-control"
							id="course_name" name="course_name" type="text" required
							autofocus/> -->

								<select class="form-control" name="course_name" required>
									<c:forEach var="courseName" items="${courses}">
										<option value="${courseName.course_name}"
											label="${courseName.course_name }">${courseName.course_name}</option>
									</c:forEach>
								</select>

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="subjectId">Subject:</label>
							<div class="col-sm-6">
								<select class="form-control" name="subjectId" required>
									<c:forEach var="subject" items="${subjects}">
										<option value="${subject.name}" label="${subject.name}">${subject.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="tagline">
								Tagline: </label>
							<div class="col-sm-6">
								<textarea placeholder="Tagline" class="form-control"
									id="tagline" name="tagline"></textarea>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="description">
								Description: </label>
							<div class="col-sm-6">
								<textarea placeholder="Description" class="form-control"
									name="description"></textarea>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="start_date">
								Start Date: </label>
							<div class="col-sm-6">
								<input placeholder="Start Date" class="form-control"
									id="start_date" name="start_date" type="date" required />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="end_date"> End
								Date: </label>
							<div class="col-sm-6">
								<input placeholder="End Date" class="form-control" id="end_date"
									name="end_date" type="date" required />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="reg_start_date">
								Registration Start Date: </label>
							<div class="col-sm-6">
								<input placeholder="Registration Start Date"
									class="form-control" id="reg_start_date" name="reg_start_date"
									type="date" required />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="reg_end_date">
								Registration End Date: </label>
							<div class="col-sm-6">
								<input placeholder="Registration End Date" class="form-control"
									id="reg_end_date" name="reg_end_date" type="date" required />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="image"> Upload
								Image: </label>
							<div class="col-sm-6">
								<input placeholder="Upload Image" class="form-control"
									id="image" name="image" type="file" accept=".png, .jpg, .jpeg" />
							</div>
						</div>

						<div class="form-group" id="container">
							<label class="control-label col-sm-4" for="category">Enrollment
								Category:</label>
							<div class="col-sm-3">
								<select class="form-control" name="category_1" required
									title="Select Category">
									<c:forEach var="category" items="${categories}">
										<option value="${category.id}" label="${category.name}"
											title="${category.description}">${category.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-3">
								<input class="form-control" id="fees" name="fees_1" type="text"
									placeholder="Fees" required />
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
								<button type="Submit" class="btn btn-default" onclick="savei()">Create</button>
							</div>
						</div>
						<input id="CategoryNumber" name="CategoryNumber" type="hidden">
						<br>

					</fieldset>
				</form>
			</div>
			<div class="panel-footer">Panel Footer</div>

		</c:if>
	</div>
</body>

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
		select.setAttribute("required");
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
</script>

</html>