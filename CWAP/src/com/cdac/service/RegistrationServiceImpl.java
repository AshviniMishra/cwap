package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.RegisterDAO;
import com.cdac.model.User;

@Service("rs")
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	RegisterDAO rdo;
	
	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		return(rdo.registerUser(user));
	}

	@Override
	public boolean userExist(User user) {
		// TODO Auto-generated method stub
		return rdo.userExist(user);
	}
	
	@Override
	public boolean mobileNumberExists( User user ){
		return rdo.mobileNumberExists(user);
	}
	
}


