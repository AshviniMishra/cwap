package com.cdac.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.cdac.model.Course;

@Service
public interface CourseService {
	List<Course> getMyCourses(HttpServletRequest req, HttpServletResponse res);

	boolean archiveCourse(int courseId);
}
