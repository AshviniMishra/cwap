package com.cdac.service;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.AttendeeDAO;
import com.cdac.model.Course;

@Service("as")
public class AttendeeServiceImpl implements AttendeeService {
	@Autowired
	AttendeeDAO ado;
	
	@Autowired
	HttpSession session;

	@Override
	public void getCourses(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		ado.getCourses(req, res);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String[] splitDescription(int selectedCourse, HttpServletRequest req, HttpServletResponse res) {
		/* HttpSession session = req.getSession(); */
		for (Course course : (List<Course>) session.getAttribute("courses")) {
			if (course.getCourse_id() == selectedCourse) {
				session.setAttribute("course", course);
				String description[] = course.getDescription().split("\n");
				return description;
			}
		}
		return null;
	}

	@Override
	public LinkedHashMap<Integer, Integer> getCourseCategories(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return (ado.getCourseCategories(req, res));
	}

	@Override
	public boolean saveEnrollment(int selectedCategory, boolean laptop, HttpServletRequest req,
			HttpServletResponse res) {
		return (ado.saveEnrollment(selectedCategory, laptop, req, res));

	}

	@Override
	public boolean getCourseList(HttpServletRequest req, HttpServletResponse res) {
		return ado.getCourseList(req, res);
	}

	@Override
	public int getFee(HttpServletRequest req, HttpServletResponse res) {
		return ado.getFee(req, res);
	}

	@Override
	public boolean isAlreadyEnrolled(HttpServletRequest req, HttpServletResponse res, int selectedCourse) {
		return ado.isAlreadyEnrolled(req, res, selectedCourse);
	}
}
