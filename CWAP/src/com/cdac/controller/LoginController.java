package com.cdac.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.service.LoginService;
import com.cdac.service.ProfileService;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("ls")
	LoginService ls;

	@Autowired
	@Qualifier("ps")
	ProfileService ps;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public ModelAndView dologin(@RequestParam("username") String username, @RequestParam("password") String pass,
			HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		ps.getAdminInfo(req, res);
		req.setAttribute("username", username);
		req.setAttribute("pass", pass);
		// User user = ls.validateUser(username, pass);
		if (ls.loginUser(req, res)) {
			ps.getQualification(req, res);
			mv.setViewName("profile");
		}

		else {
			mv.setViewName("login");
			mv.addObject("errorMsg", "username or password is incorrect");
		}

		return mv;
	}
}
