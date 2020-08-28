package com.cdac.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.model.User;

public interface LoginService {

	

	boolean loginUser(HttpServletRequest req, HttpServletResponse res);

	User validateUser(String username, String pass);

}
