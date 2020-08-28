package com.cdac.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.model.Course;

public interface CourseDAO {
	List<Course> getMyCourses(HttpServletRequest req, HttpServletResponse res);

	boolean archiveCourse(int courseId);
}
