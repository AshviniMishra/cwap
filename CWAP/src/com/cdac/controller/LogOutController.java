package com.cdac.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogOutController {

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		/*
		 * try { if (session != null) { if (session.getAttribute("isLoggedIn"))
		 * } }
		 */
		/*
		 * HttpSession session= req.getSession();
		 * session.removeAttribute("username");
		 * session.removeAttribute("isLoggedIn"); res.setHeader("Cache-Control",
		 * "no-cache, no-store, must-revalidate, max-age=0, post-check=0, pre-check=0"
		 * ); res.setHeader("Pragma","no-cache"); res.setHeader("Expires", "0");
		 * session.invalidate();
		 */
		HttpSession session = req.getSession();
		if( session != null){
			session.invalidate();
		}
		mv.setViewName("login");
		return mv;
	}

}
