package com.cdac.model;

public class Profile {
	String username;
	String gender;
	String address;
	String hobbies;
	String skills;
	String specialization;
	int qualId;

	public int getQualId() {
		return qualId;
	}

	@Override
	public String toString() {
		return "Profile [username=" + username + ", gender=" + gender + ", address=" + address + ", hobbies=" + hobbies
				+ ", skills=" + skills + ", specialization=" + specialization + ", qualId=" + qualId + ", organization="
				+ organization + ", designation=" + designation + "]";
	}

	public void setQualId(int qualId) {
		this.qualId = qualId;
	}

	String organization;
	String designation;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
