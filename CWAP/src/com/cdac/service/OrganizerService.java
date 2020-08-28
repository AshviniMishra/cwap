package com.cdac.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.model.Course;
import com.cdac.model.GeneralObject;

public interface OrganizerService {

	boolean saveSubject(GeneralObject subject);
	void getSubjects(HttpServletRequest req, HttpServletResponse res);

	boolean saveQualification(GeneralObject qualification);

	boolean saveCategory(GeneralObject category);
	void getCategories(HttpServletRequest req, HttpServletResponse res);
	
	boolean saveCourse(Course course, Map<String, String> categoryFees, HttpServletRequest req, HttpServletResponse res);
	

	

}
