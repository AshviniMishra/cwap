package com.cdac.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.service.AttendeeService;
import com.cdac.service.OrganizerService;

@Controller
public class EnrolmentController {
	@Autowired
	@Qualifier("os")
	OrganizerService os;

	@Autowired
	@Qualifier("as")
	AttendeeService as;

	@RequestMapping(value = "/enroll", method = RequestMethod.GET)
	public ModelAndView enroll(@RequestParam("selectedCourse") int selectedCourse, HttpServletRequest req,
			HttpServletResponse res) {

		HttpSession session = req.getSession();
		String description[] = as.splitDescription(selectedCourse, req, res);

		os.getCategories(req, res);
		as.getCourses(req, res);
		as.getCourses(req, res);
		as.getFee(req, res);

		session.setAttribute("alreadyEnrolled", as.isAlreadyEnrolled(req, res, selectedCourse));

		ModelAndView mv = new ModelAndView();

		mv.addObject("description", description);
		mv.setViewName("enroll");

		return mv;
	}

	@RequestMapping(value = "/saveEnrollment", method = RequestMethod.POST)
	public ModelAndView saveEnrollment(@RequestParam("category") int selectedCategory,
			@RequestParam("laptop") boolean laptop, HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Inside save enrollment method");
		ModelAndView mv = new ModelAndView();
		if (as.saveEnrollment(selectedCategory, laptop, req, res))
			mv.setViewName("payment");
		else {
			mv.setViewName("enroll");
			mv.addObject("errorMsg", "Enrollment was not successful");
		}
		return mv;
	}

}
