package com.cdac.dao;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AttendeeDAO {
	void getCourses(HttpServletRequest req, HttpServletResponse res);

	LinkedHashMap<Integer, Integer> getCourseCategories(HttpServletRequest req, HttpServletResponse res);

	boolean saveEnrollment(int selectedCategory, boolean laptop, HttpServletRequest req, HttpServletResponse res);

	boolean getCourseList(HttpServletRequest req, HttpServletResponse res);

	int getFee(HttpServletRequest req, HttpServletResponse res);

	boolean isAlreadyEnrolled(HttpServletRequest req, HttpServletResponse res, int selectedCourse);
}
