package com.cdac.service;

import com.cdac.model.User;


public interface RegistrationService {
	public boolean registerUser(User user);

	public boolean userExist(User user);
	
	public boolean mobileNumberExists( User user );
	
}

