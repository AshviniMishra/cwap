package com.cdac.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.OrganizerDAO;
import com.cdac.model.Course;
import com.cdac.model.GeneralObject;

@Service("os")
public class OrganizerServiceImpl implements OrganizerService{
	@Autowired
	OrganizerDAO odo;
	@Override
	public boolean saveSubject(GeneralObject subject) {
		// TODO Auto-generated method stub
		return (odo.saveSubject(subject));
	}
	@Override
	public boolean saveQualification(GeneralObject qualification) {
		// TODO Auto-generated method stub
		return (odo.saveQualification(qualification));
	}
	@Override
	public boolean saveCategory(GeneralObject category) {
		// TODO Auto-generated method stub
		return (odo.saveCategory(category));
	}
	@Override
	public void getSubjects(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		odo.getSubjects(req,res);
	}
	@Override
	public boolean saveCourse(Course course, Map<String, String> categoryFees,HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return (odo.saveCourse(course,categoryFees,req,res));
	}
	@Override
	public void getCategories(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		odo.getCategories(req,res);
	}
	

}
