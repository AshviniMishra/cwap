package com.cdac.dao;

import com.cdac.model.User;

public interface RegisterDAO {
	public boolean registerUser(User user);

	public boolean userExist(User user);
	
	public boolean mobileNumberExists( User user );
}
