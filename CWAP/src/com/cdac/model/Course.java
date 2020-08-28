package com.cdac.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Course {

	int course_id;
	String course_name;
	int subjectId;
	String tagline;
	String description;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	LocalDate start_date;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	LocalDate end_date;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	LocalDate reg_start_date;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	LocalDate reg_end_date;
	String banner_path;
	String creator;

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public LocalDate getReg_start_date() {
		return reg_start_date;
	}

	public void setReg_start_date(LocalDate reg_start_date) {
		this.reg_start_date = reg_start_date;
	}

	public LocalDate getReg_end_date() {
		return reg_end_date;
	}

	public void setReg_end_date(LocalDate reg_end_date) {
		this.reg_end_date = reg_end_date;
	}

	public String getBanner_path() {
		return banner_path;
	}

	public void setBanner_path(String banner_path) {
		this.banner_path = banner_path;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", subjectId=" + subjectId
				+ ", tagline=" + tagline + ", description=" + description + ", start_date=" + start_date + ", end_date="
				+ end_date + ", reg_start_date=" + reg_start_date + ", reg_end_date=" + reg_end_date + ", banner_path="
				+ banner_path + ", creator=" + creator + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((banner_path == null) ? 0 : banner_path.hashCode());
		result = prime * result + course_id;
		result = prime * result + ((course_name == null) ? 0 : course_name.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + ((reg_end_date == null) ? 0 : reg_end_date.hashCode());
		result = prime * result + ((reg_start_date == null) ? 0 : reg_start_date.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + subjectId;
		result = prime * result + ((tagline == null) ? 0 : tagline.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (banner_path == null) {
			if (other.banner_path != null)
				return false;
		} else if (!banner_path.equals(other.banner_path))
			return false;
		if (course_id != other.course_id)
			return false;
		if (course_name == null) {
			if (other.course_name != null)
				return false;
		} else if (!course_name.equals(other.course_name))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (reg_end_date == null) {
			if (other.reg_end_date != null)
				return false;
		} else if (!reg_end_date.equals(other.reg_end_date))
			return false;
		if (reg_start_date == null) {
			if (other.reg_start_date != null)
				return false;
		} else if (!reg_start_date.equals(other.reg_start_date))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		if (subjectId != other.subjectId)
			return false;
		if (tagline == null) {
			if (other.tagline != null)
				return false;
		} else if (!tagline.equals(other.tagline))
			return false;
		return true;
	}

}
