package com.cdac.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.model.GeneralObject;
import com.cdac.model.Profile;
import com.cdac.service.ProfileService;

@Controller
public class ProfileController {
	@Autowired
	@Qualifier("ps")
	ProfileService ps;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile() {
		return "profile";
	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)

	public ModelAndView editProfile(Model model, HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		List<GeneralObject> qualificationObject = ps.getQualification(req, res);
		HttpSession session = req.getSession();
		session.setAttribute("qualificationObject", qualificationObject);
		model.addAttribute("profile", new Profile());
		mv.setViewName("editProfile");
		return mv;
	}

	@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
	public ModelAndView saveProfile(@ModelAttribute("profile") Profile profile, BindingResult result,
			HttpServletRequest req, HttpServletResponse res) {

		HttpSession session = req.getSession();

		ModelAndView mv = new ModelAndView();

		if (ps.saveProfile(profile, req, res)) {
			mv.setViewName("profile");
			mv.addObject("successMsg",
					"Hi " + session.getAttribute("firstName") + ", your profile is successfully saved.");
		} else {
			mv.setViewName("editProfile");
			mv.addObject("errorMsg", "Profile could not be saved");
		}
		return mv;
	}
}
