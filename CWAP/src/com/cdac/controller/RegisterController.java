package com.cdac.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.model.User;
import com.cdac.service.RegistrationService;

@Controller
public class RegisterController {

	@Autowired
	@Qualifier("rs")
	RegistrationService rs;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/doregister", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("user") User user, BindingResult result,
			@RequestParam("confirmPass") String pass, HttpServletRequest req) {

		HttpSession session = req.getSession();

		ModelAndView mv = new ModelAndView();

		session.setAttribute("user", user);

		boolean isUserExist = rs.userExist(user);
		boolean doesMobNoExist = rs.mobileNumberExists(user);
		boolean isMobNoValid = isMobileNumverValid(Long.toString(user.getMobile_no()));

		if (pass.equals(user.getPassword())) {

			if (isMobNoValid) {

				if (!isUserExist) {

					if (!doesMobNoExist) {

						if (rs.registerUser(user)) {

							mv.setViewName("login");
							mv.addObject("successMsg", "Hi " + user.getName() + ", your registration is successful.");

						}

						else
							mv.setViewName("register");
					} else {
						mv.setViewName("register");
						mv.addObject("errorMsg", "Entered mobile number already exits");
					}
				} else {
					mv.setViewName("register");
					mv.addObject("errorMsg", "EmailID already exists");
				}
			} else {
				mv.setViewName("register");
				mv.addObject("errorMsg", "Enter a valid mobile number");
			}
		} else {
			mv.setViewName("register");
			mv.addObject("errorMsg", "Password does not match");
		}
		return mv;
	}

	public static boolean isMobileNumverValid(String mobileNumber) {
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher m = p.matcher(mobileNumber);
		return (m.find() && m.group().equals(mobileNumber));
	}

}
