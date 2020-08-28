package com.cdac.service;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AttendeeService {

	void getCourses(HttpServletRequest req, HttpServletResponse res);

	String[] splitDescription(int selectedCourse, HttpServletRequest req, HttpServletResponse res);

	LinkedHashMap<Integer, Integer> getCourseCategories(HttpServletRequest req, HttpServletResponse res);

	boolean saveEnrollment(int selectedCategory, boolean laptop, HttpServletRequest req, HttpServletResponse res);

	boolean getCourseList(HttpServletRequest req, HttpServletResponse res);

	int getFee(HttpServletRequest req, HttpServletResponse res);

	boolean isAlreadyEnrolled(HttpServletRequest req, HttpServletResponse res, int selectedCourse);
}
