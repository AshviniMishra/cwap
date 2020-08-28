package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.model.User;
import com.cdac.service.RegistrationService;
import com.google.gson.Gson;

@RestController
public class ServiceClass {

	@Autowired
	@Qualifier("rs")
	RegistrationService rs;

	Gson gson = new Gson();

	@RequestMapping("/hello")
	public String hello() {
		String response = "This service is up and running";
		return gson.toJson(response);
	}

	@RequestMapping(value = "/RESTRegister", method = RequestMethod.POST)
	public String register(@RequestBody User user) {

		String response = "";

		ModelAndView mv = new ModelAndView();

		boolean isUserExist = rs.userExist(user);
		boolean doesMobNoExist = rs.mobileNumberExists(user);

		if (!isUserExist) {

			if (!doesMobNoExist) {

				if (rs.registerUser(user)) {
					response = "Registration is successfull";
					System.out.println(response);

				} else {
					response = "Registration unsuccessfull";
					System.out.println(response);
				}
			} else {
				mv.setViewName("register");
				mv.addObject("errorMsg", "Entered mobile number already exits");
			}
		} else {
			mv.setViewName("register");
			mv.addObject("errorMsg", "EmailID already exists");
		}
		return gson.toJson(response);
	}
}
