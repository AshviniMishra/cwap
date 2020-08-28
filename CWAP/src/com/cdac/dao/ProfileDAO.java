package com.cdac.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.model.GeneralObject;
import com.cdac.model.Profile;

public interface ProfileDAO {
	public boolean saveProfile(Profile profile, HttpServletRequest req, HttpServletResponse res);

	public List<GeneralObject> getQualification(HttpServletRequest req, HttpServletResponse res);

	public boolean getAdminInfo(HttpServletRequest req, HttpServletResponse res);

}
