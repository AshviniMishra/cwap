package com.cdac.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.model.GeneralObject;
import com.cdac.model.Profile;

public interface ProfileService {

	boolean saveProfile(Profile profile, HttpServletRequest req, HttpServletResponse res);

	public List<GeneralObject> getQualification(HttpServletRequest req, HttpServletResponse res);

	boolean getAdminInfo(HttpServletRequest req, HttpServletResponse res);
}
