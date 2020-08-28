package com.cdac.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.model.GeneralObject;
import com.cdac.service.AttendeeService;
import com.cdac.service.LoginService;
import com.cdac.service.OrganizerService;
import com.cdac.service.ProfileService;
import com.cdac.service.RegistrationService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	@Qualifier("rs")
	RegistrationService rs;
	@Autowired
	@Qualifier("ls")
	LoginService ls;
	@Autowired
	@Qualifier("ps")
	ProfileService ps;
	@Autowired
	@Qualifier("os")
	OrganizerService os;
	@Autowired
	@Qualifier("as")
	AttendeeService as;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start() {

		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "login";
	}

	@RequestMapping(value = "/createSubject", method = RequestMethod.GET)
	public String createSubject() {
		return "createSubject";
	}

	@RequestMapping(value = "/saveSubject", method = RequestMethod.POST)
	public ModelAndView saveSubject(@ModelAttribute GeneralObject subject) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("createSubject");
		if (os.saveSubject(subject)) {
			mv.addObject("successMsg", "subject is successfully created.");
		} else {
			mv.addObject("errorMsg", "Subject could not be created");
		}

		return mv;
	}

	@RequestMapping(value = "/createQualification", method = RequestMethod.GET)
	public String createQualification() {
		return "createQualification";
	}

	@RequestMapping(value = "/saveQualification", method = RequestMethod.POST)
	public ModelAndView saveQualification(@ModelAttribute GeneralObject qualification) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("createQualification");
		if (os.saveQualification(qualification)) {
			mv.addObject("successMsg", "qualification is successfully created.");
		} else {
			mv.addObject("errorMsg", "qualification could not be created");
		}

		return mv;
	}

	@RequestMapping(value = "/createCategory", method = RequestMethod.GET)
	public String createCategory() {
		return "createCategory";
	}

	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public ModelAndView saveCategory(@ModelAttribute GeneralObject category) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("createCategory");
		if (os.saveCategory(category)) {
			mv.addObject("successMsg", "Category is successfully created.");
		}

		else {
			mv.addObject("errorMsg", "Category could not be created");
		}

		return mv;
	}

	@RequestMapping(value = "/downloadImage/{filename}", method = RequestMethod.GET)
	public void download(HttpServletRequest req, HttpServletResponse res) {
		os.getSubjects(req, res);
		os.getCategories(req, res);

	}

	@RequestMapping(value = "/analysisReport", method = RequestMethod.GET)
	public String analysisReport() {

		return "analysisReport";
	}

	@RequestMapping(value = "/archivedCourses", method = RequestMethod.GET)
	public String archivedCourses() {

		return "archivedCourses";
	}

	@RequestMapping(value = "/attendeeData", method = RequestMethod.GET)
	public String attendeeData() {

		return "attendeeData";
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String changePassword() {

		return "changePassword";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {

		return "contactus";
	}

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String payment() {

		return "payment";
	}

	@RequestMapping(value = "/recoverPassword", method = RequestMethod.GET)
	public String recoverPassword() {

		return "recoverPassword";
	}

	@RequestMapping(value = "/upcomingCourses", method = RequestMethod.GET)
	public String upcomingCourses() {

		return "upcomingCourses";
	}

	@RequestMapping(value = "/updateAttendance", method = RequestMethod.GET)
	public String updateAttendance() {

		return "updateAttendance";
	}
}
