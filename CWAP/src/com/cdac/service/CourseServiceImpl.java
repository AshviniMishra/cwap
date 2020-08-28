package com.cdac.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.CourseDAO;
import com.cdac.model.Course;

@Service("cs")
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDAO cdo;

	@Override
	public List<Course> getMyCourses(HttpServletRequest req, HttpServletResponse res) {
		return cdo.getMyCourses(req, res);
	}

	@Override
	public boolean archiveCourse(int courseId) {
		return cdo.archiveCourse(courseId);
	}
}
